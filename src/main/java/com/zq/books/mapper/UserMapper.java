package com.zq.books.mapper;

import com.zq.books.model.User;
import com.zq.books.model.WXUser;
import com.zq.books.model.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-14 14:24
 **/
@Component
public interface UserMapper {

    int add(UserInfo user);

    User findOne(User user);

    User findByOpenId(User user);

    User findByName(User user);

    int addWxUser(WXUser user);

    WXUser findOneWx(WXUser user);

    int addWxRelation(User user);

    WXUser findWxByOpenId(WXUser user);
}
