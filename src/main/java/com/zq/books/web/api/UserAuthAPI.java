package com.zq.books.web.api;

import com.alibaba.fastjson.JSONObject;
import com.zq.books.constants.MsgPusherConstant;
import com.zq.books.model.User;
import com.zq.books.model.WXUser;
import com.zq.books.model.UserInfo;
import com.zq.books.util.ReturnUtil;
import com.zq.books.util.WXUtil;
import com.zq.books.vo.WXInfoVo;
import com.zq.books.web.service.BookManagerService;
import com.zq.books.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-13 16:54
 **/
@Api(tags = {"用户注册/登录接口"})
@RestController
@RequestMapping("auth")
public class UserAuthAPI {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParam(name = "user", value = "User实体对象，必需属性：name（用户名），password（密码）,phone（电话号码）", required = true, paramType = "body", dataType = "UserInfo")
    @PostMapping("register")
    public Object register(@RequestBody UserInfo user) {
        if (userService.findByName(user.getName()) != null) {
            return ReturnUtil.fail("用户名已被使用");
        }
        User addedUser = userService.add(user);
        if (addedUser != null) {
            return ReturnUtil.success("注册成功");
        } else {
            return ReturnUtil.fail("注册失败，请重新注册");
        }
    }

    /**
     * 自有账号登录
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户自有账号登录", notes = "用户自有账号登录")
    @ApiImplicitParam(name = "user", value = "User实体对象，必需属性：name（用户名），password（密码）", required = true, paramType = "body", dataType = "UserInfo")
    @PostMapping("login")
    public Object login(@RequestBody User user) {
        User checkUser = userService.findByName(user.getName());
        if (checkUser != null) {
            //check password
            if (user.getPassword().equals(checkUser.getPassword())) {
                checkUser.setPassword(null);
                return ReturnUtil.result(checkUser);
            } else {
                return ReturnUtil.fail("登录失败，密码错误");
            }
        }
        return ReturnUtil.fail("登录失败，用户名不存在");
    }

    /**
     * 微信授权登录
     *
     * @param code
     * @return
     */
    @ApiOperation(value = "微信授权登录", notes = "微信授权登录")
    @ApiImplicitParam(name = "code", value = "前端获取的授权code", required = true, paramType = "path", dataType = "String")
    @PostMapping("wxLogin/{code}")
    public Object wxLogin(@PathVariable String code, HttpSession httpSession) {
        JSONObject jsonObject = WXUtil.getOpenId(code);
        if (jsonObject != null) {
            String openId = (String) jsonObject.get("openid");
            String sessionKey = (String) jsonObject.get("session_key");
            if (StringUtils.isNotEmpty(openId)) {
                //缓存用户3rdsession
                String userSessionKey = String.valueOf(System.currentTimeMillis());
                String userSessionValue = sessionKey + openId;
                httpSession.setAttribute(userSessionKey, userSessionValue);
                httpSession.setAttribute(MsgPusherConstant.WEBSOCKET_CLIENT_ID, openId);
                //创建自有用户
                User user = userService.getWxRelation(openId);
                if (user == null) {
                    user = new User();
                    user.setOpenId(openId);
                    userService.addWxRelation(user);
                }
                //创建微信用户
                WXUser wxUser = userService.findWxByOpenId(openId);
                if (wxUser == null) {
                    wxUser = userService.addWxUser(openId);
                }
                WXInfoVo wxInfoVo = new WXInfoVo();
                wxInfoVo.setUserId(user.getId());
                wxInfoVo.setBookshelfId(BookManagerService.bookshelfId);
                wxInfoVo.setWxUser(wxUser);
                wxInfoVo.setSessionKey(userSessionKey);
                return ReturnUtil.result(wxInfoVo);
            }

        }
        return ReturnUtil.fail("微信未授权");
    }

    @ApiOperation(value = "获取短信验证码", notes = "获取短信验证码")
    @ApiImplicitParam(name = "phone", value = "电话号码", required = true, paramType = "path", dataType = "String")
    @PostMapping("getSmsAuthCode/{phone}")
    public Object getSmsAuthCode(@PathVariable String phone) {
        //生成验证码
        //发送验证码
        return ReturnUtil.success("验证码已发送至您的手机");
    }

    @ApiOperation(value = "短信验证", notes = "短信验证")
    @ApiImplicitParam(name = "smsAuthCode", value = "验证码", required = true, paramType = "path", dataType = "String")
    @PostMapping("smsAuth/{smsAuthCode}")
    public Object smsAuth(@PathVariable String smsAuthCode) {
        if ("1234".equals(smsAuthCode)) {
            return ReturnUtil.success("验证成功");
        }
        return ReturnUtil.fail("验证失败");
    }

    @GetMapping("loginFail")
    public Object loginFail() {
        return ReturnUtil.fail("session 已过期，请重新登录");
    }

}
