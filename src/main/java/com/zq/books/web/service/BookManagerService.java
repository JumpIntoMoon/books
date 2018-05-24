package com.zq.books.web.service;

import com.zq.books.mapper.BookMapper;
import com.zq.books.mapper.BookshelfRelationMapper;
import com.zq.books.model.Book;
import com.zq.books.model.BookInfo;
import com.zq.books.model.BookshelfRelation;
import com.zq.books.model.User;
import com.zq.books.vo.DelBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-14 17:17
 **/
@Service
public class BookManagerService {

    public static Long bookshelfId = (long) 1;
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookshelfRelationMapper bookshelfRelationMapper;

    public Book findById(Long id) {
        Book book = new Book();
        book.setId(id);
        return bookMapper.findOne(book);
    }

    public Object getBooksOnShelf(BookInfo bookInfo) {
        return bookshelfRelationMapper.getBooksOnShelf(bookInfo);
    }

    public Object addToBookshelf(BookInfo bookInfo) {
        return bookshelfRelationMapper.add(bookInfo);
    }

    public Object deleteFromBookshelf(DelBookVO delBookVO) {
        Map map = new HashMap();
        map.put("userId", delBookVO.getUserId());
        map.put("bookshelfId", delBookVO.getBookshelfId());
        map.put("bookIds", delBookVO.getBookIds());
        return bookshelfRelationMapper.deleteMultiply(map);
    }

    public Book saveBook(Book book) {
        bookMapper.add(book);
        return findById(book.getId());
    }

    public BookshelfRelation getBookshelfRelation(BookInfo bookInfo) {
        return bookshelfRelationMapper.getBookshelfRelation(bookInfo);
    }

    public List<BookInfo> getLatestUpload(User user) {
        return bookshelfRelationMapper.getLatestUpload(user);
    }

    public Book getBookByDoubanId(Long doubanId) {
        Book book = new Book();
        book.setDoubanId(doubanId);
        return bookMapper.findOneByDoubanId(book);
    }
}
