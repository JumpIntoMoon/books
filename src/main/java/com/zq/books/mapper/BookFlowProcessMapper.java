package com.zq.books.mapper;

import com.zq.books.model.BookFlowProcess;
import com.zq.books.model.BookFlowProcessInfo;
import com.zq.books.model.User;
import com.zq.books.vo.BookFlowProcessVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-19 17:47
 **/
@Component
public interface BookFlowProcessMapper {
    int add(BookFlowProcess bookFlowProcess);

    List getList(User user);

    int updateStatus(BookFlowProcessVO bookFlowProcessVO);

    BookFlowProcess findOne(BookFlowProcess bookFlowProcessVO);

    BookFlowProcessInfo getFlowDetail(BookFlowProcessVO bookFlowProcessVO);
}
