package com.zq.books.web.service;

import com.zq.books.model.User;
import com.zq.books.mapper.BookFlowProcessMapper;
import com.zq.books.model.BookFlowProcess;
import com.zq.books.model.BookInfo;
import com.zq.books.vo.BookFlowProcessVO;
import com.zq.books.vo.BorrowConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-19 17:45
 **/
@Service
public class BookFlowProcessService {

    @Autowired
    private BookManagerService bookManagerService;

    @Autowired
    private BookFlowProcessMapper bookFlowProcessMapper;

    public BookFlowProcess getBorrower(BookFlowProcess bookFlowProcessVO) {
        return bookFlowProcessMapper.findOne(bookFlowProcessVO);
    }

    /**
     *
     * @param bookFlowProcessVO
     * @return
     */
    public BookFlowProcess borrow(BookFlowProcessVO bookFlowProcessVO) {
        BookFlowProcess bookFlowProcess = new BookFlowProcess();
        bookFlowProcess.setBookId(bookFlowProcessVO.getBookId());
        bookFlowProcess.setUserId(bookFlowProcessVO.getUserId());
        bookFlowProcess.setBookOwnerId(bookFlowProcessVO.getBookOwnerId());
        bookFlowProcess.setBookshelfId(bookFlowProcessVO.getBookshelfId());
        bookFlowProcess.setFlowId((long) 1);
        bookFlowProcessMapper.add(bookFlowProcess);
        return bookFlowProcessMapper.findOne(bookFlowProcess);
    }

    public List getBorrowers(User user) {
        return bookFlowProcessMapper.getList(user);
    }

    public int rejectBorrow(BookFlowProcessVO bookFlowProcessVO) {
        bookFlowProcessVO.setFlowId((long) 4);
        return bookFlowProcessMapper.updateStatus(bookFlowProcessVO);
    }

    public Object getFlowDetail(BookFlowProcessVO bookFlowProcessVO) {
        return bookFlowProcessMapper.getFlowDetail(bookFlowProcessVO);
    }

    public int borrowAgree(BookFlowProcessVO bookFlowProcessVO) {
        bookFlowProcessVO.setFlowId((long) 2);
        return bookFlowProcessMapper.updateStatus(bookFlowProcessVO);
    }

    public int borrowConfirm(BorrowConfirm borrowConfirm) {
        //借书，添加到借书人书架
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookId(borrowConfirm.getBookId());
        bookInfo.setUserId(borrowConfirm.getUserId());
        bookInfo.setBookshelfId(borrowConfirm.getBookshelfId());
        bookManagerService.addToBookshelf(bookInfo);
        //
        BookFlowProcessVO bookFlowProcessVO = new BookFlowProcessVO();
        bookFlowProcessVO.setBookId(borrowConfirm.getBookId());
        bookFlowProcessVO.setUserId(borrowConfirm.getUserId());
        bookFlowProcessVO.setBookOwnerId(borrowConfirm.getBookOwnerId());
        bookFlowProcessVO.setBookshelfId(borrowConfirm.getOwnerBookshelfId());
        bookFlowProcessVO.setFlowId((long) 4);
        return bookFlowProcessMapper.updateStatus(bookFlowProcessVO);
    }
}
