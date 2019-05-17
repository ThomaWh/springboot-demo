package com.example.mongodb.service;

import com.example.mongodb.entity.Book;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/5/17
 */
@Service
public class MongodbService {
    /**
     * 问题:当CRUD操作没有指定collection时,是怎么对集合进行操作
     * 答案:根据所传参数ClassName , 首字母小写与mongodb collentionName 进行匹配
     * Criteria用于进行设置过滤条件 where and or ...
     */

    private Logger logger = LoggerFactory.getLogger(MongodbService.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存对象(新增对象)
     * @param book
     * @return
     */
    public String saveObj(Book book){
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        //save()存在就更新,不存在就新增
        mongoTemplate.save(book);
        return " 添加成功";
    }

    /**
     * 查询所有
     * @return
     */
    public List<Book> findAll(){
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        return bookList;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Book getBookById(String id){
        logger.info("-------------------------->[getBookById]");
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, Book.class);
    }

    /**
     * 更新
     * @return
     */
    public Object update(Book book){
        logger.info("----------------------------->[update]");
        Criteria criteri = Criteria.where("name").is((book.getName()));
        Query query = new Query(criteri);
        Update update = new Update().set("name",book.getName())
                .set("price",book.getPrice())
                .set("ingo",book.getInfo())
                .set("updateTime",book.getUpdateTime());
        //updateFirst()更新查询结果返回集的第一条(当criteri满足多个时,默认修改第一条)
        //UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Book.class);

        //updateMulti()更新查询结果返回集的全部(只要满足criteri全部修改),当指定了collectionName时，就匹配db中与之对应的collection进行更新
        //UpdateResult updateResult1 = mongoTemplate.updateMulti(query, update,Book.class,"Book");

        //upsert 更新对象不存在则去添加
        UpdateResult upsert = mongoTemplate.upsert(query, update, Book.class);
        System.out.println("updateResult:"+upsert);
        return upsert;
    }

    /**
     * 删除
     */
    public Object remove(Book book){
        //实质还是根据id去进行remove
        DeleteResult remove = mongoTemplate.remove(book);
        return remove;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public Object remove(String id){
        System.out.println(id);
        Criteria criteria = Criteria.where("name").is(id);
        Query query = new Query(criteria);
        return mongoTemplate.remove(query,Book.class);
    }

}
