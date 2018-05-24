package com.zq.books.web.api;

import com.zq.books.model.Book;
import com.zq.books.model.BookshelfRelation;
import com.zq.books.model.User;
import com.zq.books.model.BookInfo;
import com.zq.books.util.BookUtil;
import com.zq.books.util.ReturnUtil;
import com.zq.books.vo.DelBookVO;
import com.zq.books.web.service.BookManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-13 15:39
 **/
@Api(tags = {"图书管理接口"})
@RestController
@RequestMapping("book")
public class BookManagerAPI {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private BookManagerService bookManagerService;

    /**
     * 获取我的书架书籍列表
     *
     * @return
     */
    @ApiOperation(value = "查询图书列表", notes = "查询图书列表")
    @ApiImplicitParam(name = "bookInfo",
            value = "BookInfo 实体对象，必需属性：bookshelfId（书架id），userId（用户id）",
            required = true, paramType = "body", dataType = "BookInfo")
    @PostMapping("getBooksOnShelf")
    public Object getBooksOnShelf(@RequestBody BookInfo bookInfo) {
        return ReturnUtil.result(bookManagerService.getBooksOnShelf(bookInfo));
    }

    /**
     * 上传书籍到书架
     *
     * @param bookInfo
     * @return
     */
    @ApiOperation(value = "上传图书到书架", notes = "上传图书到书架")
    @ApiImplicitParam(
            name = "bookInfo",
            value = "BookInfo实体对象，必需属性：bookshelfId（书架id），userId（用户id），bookId（图书id）",
            required = true, paramType = "body", dataType = "BookInfo")
    @PostMapping("uploadBook")
    public Object uploadBook(@RequestBody BookInfo bookInfo) {
        BookshelfRelation relation = bookManagerService.getBookshelfRelation(bookInfo);
        if (relation != null) {
            return ReturnUtil.result("该书籍已在书架上！");
        }
        return ReturnUtil.result(bookManagerService.addToBookshelf(bookInfo));
    }

    /**
     * 从书架删除书籍
     *
     * @param delBookVO
     * @return
     */
    @ApiOperation(value = "从书架删除图书", notes = "从书架删除图书")
    @ApiImplicitParam(name = "delBookVO", value = "待删除书籍对象", required = true, paramType = "body", dataType = "DelBookVO")
    @PostMapping("markDeleted")
    public Object markDeleted(@RequestBody DelBookVO delBookVO) {
        return ReturnUtil.result(bookManagerService.deleteFromBookshelf(delBookVO));
    }

    /**
     * @param isbn
     * @return
     */
    @ApiOperation(value = "扫描图书获取信息", notes = "扫描图书获取信息")
    @ApiImplicitParam(name = "isbn", value = "书籍isbn", required = true, paramType = "path", dataType = "String")
    @PostMapping("getBookOnDouban/{isbn}")
    public Object getBookOnDouban(@PathVariable String isbn) {
        Map<String, Object> res = restTemplate.getForEntity("https://api.douban.com/v2/book/isbn/" + isbn, Map.class).getBody();
        if (res.containsKey("code")) {
            return ReturnUtil.fail("获取图书信息失败");
        }
        Long doubanId = res.get("id") == null ? null : Long.valueOf(res.get("id").toString());
        if (doubanId != null) {
            Book book = bookManagerService.getBookByDoubanId(doubanId);
            if (book == null) {
                book = bookManagerService.saveBook(BookUtil.transToBook(res));
            }
            //persistence book
            return ReturnUtil.result(book);
        }
        return ReturnUtil.fail("未获取到图书信息");
    }

    @ApiOperation(value = "获取最新上传的图书", notes = "获取最新上传的图书（不包括本人上传的图书）")
    @ApiImplicitParam(name = "user", value = "User实体对象，必需属性：id（用户ID）", required = true, paramType = "body", dataType = "UserInfo")
    @PostMapping("getLatestUpload")
    public Object getLatestUpload(@RequestBody User user) {
        if (user.getId() != null) {
            return bookManagerService.getLatestUpload(user);
        }
        return ReturnUtil.fail("查询最新图书列表失败！");
    }


}
