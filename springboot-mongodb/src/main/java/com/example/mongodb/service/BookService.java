package com.example.mongodb.service;

import com.example.mongodb.dao.BaseMongodbDao;
import com.example.mongodb.entity.Book;

/**
 * @author wh
 * @description
 * @date 2019/5/17
 */
public class BookService extends BaseMongodbDao<Book> {
    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
    /*进行业务操作*/
}
