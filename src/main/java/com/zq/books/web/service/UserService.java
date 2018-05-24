package com.zq.books.web.service;

import com.zq.books.mapper.UserMapper;
import com.zq.books.model.User;
import com.zq.books.model.WXUser;
import com.zq.books.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-14 14:21
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User add(UserInfo user) {
        userMapper.add(user);
        return findById(user.getId());

    }

    public WXUser addWxUser(String openId) {
        WXUser wxUser = new WXUser();
        wxUser.setOpenId(openId);
        userMapper.addWxUser(wxUser);
        return findWxById(wxUser.getId());
    }

    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        return userMapper.findOne(user);
    }

    public WXUser findWxById(Long id) {
        WXUser user = new WXUser();
        user.setId(id);
        return userMapper.findOneWx(user);
    }

    public WXUser findWxByOpenId(String openId) {
        WXUser wxuser = new WXUser();
        wxuser.setOpenId(openId);
        return userMapper.findWxByOpenId(wxuser);
    }

    public User findByName(String name) {
        User user = new User();
        user.setName(name);
        return userMapper.findByName(user);

    }

    public User getWxRelation(String openId) {
        User user = new User();
        user.setOpenId(openId);
        return userMapper.findByOpenId(user);
    }

    public int addWxRelation(User user) {
        return userMapper.addWxRelation(user);
    }
}
