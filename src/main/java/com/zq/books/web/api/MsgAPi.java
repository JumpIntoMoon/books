package com.zq.books.web.api;

import com.zq.books.model.User;
import com.zq.books.model.UserInfo;
import com.zq.books.util.ReturnUtil;
import com.zq.books.vo.MessageVO;
import com.zq.books.websocket.MyHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-20 15:11
 **/
@Api(tags = {"发送私信接口"})
@RestController
@RequestMapping("msg")
public class MsgAPi {

    @Autowired
    MyHandler handler;

    @ApiOperation(value = "发送私信", notes = "发送私信")
    @ApiImplicitParam(name = "messageVO", value = "UMessageVO实体对象，必需属性：", required = true, paramType = "body", dataType = "MessageVO")
    @PostMapping("sendMessage")
    public Object sendMessage(@RequestBody MessageVO messageVO) {
        boolean hasSend = handler.sendMessageToUser(messageVO.getOpenId(), new TextMessage("发送一条消息"));
        System.out.println(hasSend);
        return "isSent : " + hasSend;
    }

}
