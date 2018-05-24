package com.zq.books.web.api;

import com.zq.books.model.User;
import com.zq.books.util.ReturnUtil;
import com.zq.books.vo.BookFlowProcessVO;
import com.zq.books.vo.BorrowConfirm;
import com.zq.books.web.service.BookFlowProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-19 16:47
 **/
@Api(tags = {"借书流程"})
@RestController
@RequestMapping("flow")
public class BookFlowAPI {

    @Autowired
    private BookFlowProcessService bookFlowProcessService;

    @PostMapping("hi")
    public void hi() {
        System.out.println("111");
    }

    /**
     * 申请借书
     * @param bookFlowProcessVO
     * @return
     */
    @ApiOperation(value = "申请借书", notes = "申请借书")
    @ApiImplicitParam(name = "bookFlowProcessVO", value = "BookFlowProcessVO实体，必需属性：bookId;userId;bookOwnerId;bookshelfId;", required = true, paramType = "body", dataType = "BookFlowProcessVO")
    @PostMapping("borrowApply")
    public Object borrow(@RequestBody BookFlowProcessVO bookFlowProcessVO) {
        return ReturnUtil.result(bookFlowProcessService.borrow(bookFlowProcessVO));
    }

    /**
     * 查看流程详情
     * @param bookFlowProcessVO
     * @return
     */
    @ApiOperation(value = "查看流程详情", notes = "查看流程详情")
    @ApiImplicitParam(name = "bookFlowProcessVO", value = "BookFlowProcessVO 实体，必需属性：flowId", required = true, paramType = "body", dataType = "BookFlowProcessVO")
    @PostMapping("getFlowDetail")
    public Object getFlowDetail(@RequestBody BookFlowProcessVO bookFlowProcessVO) {
        return ReturnUtil.result(bookFlowProcessService.getFlowDetail(bookFlowProcessVO));
    }

    /**
     * 拒绝借书申请
     * @param bookFlowProcessVO
     * @return
     */
    @ApiOperation(value = "拒绝借书申请", notes = "拒绝借书申请")
    @ApiImplicitParam(name = "bookFlowProcessVO", value = "BookFlowProcessVO 实体，必需属性：bookId,bookshelfId,userId,bookOwnerId", required = true, paramType = "body", dataType = "BookFlowProcessVO")
    @PostMapping("borrowReject")
    public int rejectBorrow(@RequestBody BookFlowProcessVO bookFlowProcessVO) {
        return bookFlowProcessService.rejectBorrow(bookFlowProcessVO);
    }

    /**
     * 同意借书申请
     * @param bookFlowProcessVO
     * @return
     */
    @ApiOperation(value = "同意借书申请", notes = "同意借书申请")
    @ApiImplicitParam(name = "bookFlowProcessVO", value = "BookFlowProcessVO 实体，必需属性：bookId,bookshelfId,userId,bookOwnerId", required = true, paramType = "body", dataType = "BookFlowProcessVO")
    @PostMapping("borrowAgree")
    public int borrowAgree(@RequestBody BookFlowProcessVO bookFlowProcessVO) {
        return bookFlowProcessService.borrowAgree(bookFlowProcessVO);
    }

    /**
     * 查询申请列表
     * @return
     */
    @ApiOperation(value = "查询申请列表", notes = "查询申请列表")
    @ApiImplicitParam(name = "user", value = "User 实体，必需属性：id", required = true, paramType = "body", dataType = "BookFlowProcessVO")
    @PostMapping("getBorrowers")
    public Object getBorrowers(@RequestBody User user) {
        return bookFlowProcessService.getBorrowers(user);
    }

    /**
     * 申请借书确认
     * @return
     */
    @ApiOperation(value = "申请借书确认", notes = "申请借书确认")
    @ApiImplicitParam(name = "borrowConfirm", value = "BorrowConfirm 实体，必需属性：图书id：bookId;借书人id：userId;书主人id：bookOwnerId;书架id：bookshelfId;书架id： ownerBookshelfId;", required = true, paramType = "body", dataType = "BorrowConfirm")
    @PostMapping("borrowConfirm")
    public Object borrowConfirm(@RequestBody BorrowConfirm borrowConfirm) {
        return bookFlowProcessService.borrowConfirm(borrowConfirm);
    }
}
