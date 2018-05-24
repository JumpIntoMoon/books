package com.zq.books.mapper;

import com.zq.books.model.Book;
import org.springframework.stereotype.Component;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-14 16:46
 **/
@Component
public interface BookMapper {
    int add(Book book);

    Book findOne(Book book);

    Book findOneByDoubanId(Book book);
}
