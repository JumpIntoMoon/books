package com.zq.books.vo;

import java.util.List;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-16 9:03
 **/
public class DelBookVO {
    private Long userId;
    private Long bookshelfId;
    private List<Long> bookIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}
