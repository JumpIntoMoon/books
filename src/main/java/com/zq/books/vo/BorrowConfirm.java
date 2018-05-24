package com.zq.books.vo;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-20 10:42
 **/
public class BorrowConfirm {
    //图书id
    private Long bookId;

    //借书人id
    private Long userId;

    //书主人id
    private Long bookOwnerId;

    //书架id
    private Long bookshelfId;

    //书架id
    private Long ownerBookshelfId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookOwnerId() {
        return bookOwnerId;
    }

    public void setBookOwnerId(Long bookOwnerId) {
        this.bookOwnerId = bookOwnerId;
    }

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public Long getOwnerBookshelfId() {
        return ownerBookshelfId;
    }

    public void setOwnerBookshelfId(Long ownerBookshelfId) {
        this.ownerBookshelfId = ownerBookshelfId;
    }
}
