package com.zq.books.mapper;

import com.zq.books.model.BookInfo;
import com.zq.books.model.BookshelfRelation;
import com.zq.books.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-14 17:30
 **/
@Component
public interface BookshelfRelationMapper {
    int add(BookInfo bookInfo);

    int deleteMultiply(Map map);

    List<BookInfo> getBooksOnShelf(BookInfo bookInfo);

    BookshelfRelation getBookshelfRelation(BookInfo bookInfo);

    List<BookInfo> getLatestUpload(User user);
}
