package com.example.mongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * @author wh
 * @description 基础通用mongodb dao
 * @date 2019/5/17
 */
public abstract class BaseMongodbDao<T> {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 通过反射获取泛型类型
     * @return
     */
    protected abstract Class<T> getEntityClass();

    /**
     * 根据id查询文档-collection
     */
    public T findCllectionByid(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoTemplate.findOne(query,this.getEntityClass());
    }


}
