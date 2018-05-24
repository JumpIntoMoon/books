package com.zq.books.model;

import java.io.Serializable;
import java.time.Instant;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-14 17:27
 **/
public class BookshelfRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long bookId;
    private Long bookshelfId;
    private Instant createTime;
    private Instant updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }
}
