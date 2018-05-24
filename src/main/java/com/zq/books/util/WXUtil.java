package com.zq.books.util;

import com.alibaba.fastjson.JSONObject;
import com.zq.books.model.WXUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-13 17:14
 **/
public class WXUtil {
    static Logger logger = LoggerFactory.getLogger(WXUtil.class);

    /**
     * 获取openId
     *
     * @param code
     */
    public static JSONObject getOpenId(String code) {
        JSONObject jsonObject = null;
        ResourceBundle resource = ResourceBundle.getBundle("weixinConfig");
        try {
            if (StringUtils.isBlank(code)) {
            } else {
                String requestUrl = resource.getString("url")
                        .replace("APPID", resource.getString("appId"))
                        .replace("SECRET", resource.getString("appSecret"))
                        .replace("JSCODE", code)
                        .replace("authorization_code", resource.getString("grant_type"));
                logger.info(requestUrl);
                // 发起GET请求获取凭证
                jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return jsonObject;

    }

    /**
     * 得到微信用户信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public WXUser getUserInfo(String accessToken, String openId) {

        WXUser wxUser = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 获取用户信息
        JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                wxUser = new WXUser();
                // 用户的标识
                wxUser.setOpenId(jsonObject.getString("openid"));
                // 昵称
                wxUser.setNickname(jsonObject.getString("nickname"));
                // 用户的性别（1是男性，2是女性，0是未知）
                wxUser.setSex(jsonObject.getInteger("sex"));
                // 用户所在国家
                wxUser.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                wxUser.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                wxUser.setCity(jsonObject.getString("city"));
                // 用户头像
                wxUser.setHeadImgUrl(jsonObject.getString("headimgurl"));
            } catch (Exception e) {
                if (0 == wxUser.getSubscribe())
                    logger.error("用户{}已取消关注", wxUser.getOpenId());
                else {
                    int errorCode = jsonObject.getInteger("errcode");
                    String errorMsg = jsonObject.getString("errmsg");
                    logger.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode,
                            errorMsg);
                }
            }
        }
        return wxUser;
    }

}
