package com.zq.books.vo;

import java.time.Instant;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-20 7:05
 **/
public class BookFlowProcessVO {

    private Long id;

    //图书id
    private Long bookId;

    //借书人id
    private Long userId;

    //书主人id
    private Long bookOwnerId;

    //书架id
    private Long bookshelfId;

    private Long flowId;

    private String remark;

    private Instant createTime;

    private Instant updateTime;

    private String name;

    private String description;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
