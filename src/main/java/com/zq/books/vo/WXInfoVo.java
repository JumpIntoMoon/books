package com.zq.books.vo;

import com.zq.books.model.WXUser;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-15 18:27
 **/
public class WXInfoVo {
    private Long userId;
    private Long bookshelfId;
    private String sessionKey;
    private WXUser wxUser;

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public WXUser getWxUser() {
        return wxUser;
    }

    public void setWxUser(WXUser wxUser) {
        this.wxUser = wxUser;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
