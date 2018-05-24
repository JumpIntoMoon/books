package com.zq.books.util;

import com.zq.books.model.Book;

import java.util.Map;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-15 13:04
 **/
public class BookUtil {
    public static Book transToBook(Map<String, Object> res) {
        Book book = new Book();
        book.setDoubanId(Long.valueOf(res.get("id").toString()));
        book.setIsbn(res.get("isbn13").toString());
        book.setTitle(res.get("title").toString());
        book.setAuthorJson(res.get("author").toString());
        book.setImage(res.get("image").toString());
        book.setRating(res.get("rating").toString());
        book.setPublisher(res.get("publisher").toString());
        book.setTranslatorJson(res.get("translator").toString());
        book.setPrice(res.get("price").toString());
        book.setAuthorIntro(res.get("author_intro").toString());
        book.setSummary(res.get("summary").toString());
        //book.setState(res.get("").toString());
        //book.setDeposite(res.get("").toString());
        //book.setJhiCost(res.get("").toString());
        //book.setReturnPeriod(res.get("").toString());
        //book.setCityName(res.get("").toString());
        return book;
    }
}
