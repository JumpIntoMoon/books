package com.zq.books.model;

import java.io.Serializable;
import java.time.Instant;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-19 17:37
 **/
public class BookFlowProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //图书id
    private Long bookId;

    //借书人id
    private Long userId;

    //书主人id
    private Long bookOwnerId;

    //书架id
    private Long bookshelfId;

    //图书id
    private Long flowId;

    private String remark;

    private Instant createTime;

    private Instant updateTime;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
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
