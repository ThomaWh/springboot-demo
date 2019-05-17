package com.example.mongodb.controller;

import com.example.mongodb.entity.Book;
import com.example.mongodb.service.MongodbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/5/17
 */
@RestController
@RequestMapping("/mongodbController")
public class MongodbController {

    private Logger logger = LoggerFactory.getLogger(MongodbController.class);

    @Autowired
    private MongodbService mongodbService;

    @PostMapping("/saveObj")
    public String saveObj(@RequestBody Book book){
        System.out.println(book);
        logger.info("saveObj");
        return mongodbService.saveObj(book);
    }


    @GetMapping("/findAll")
    public List<Book> findAll(){
        return mongodbService.findAll();
    }

    @PostMapping("/update")
    public Object update(@RequestBody Book book){
        return mongodbService.update(book);
    }

    @GetMapping("/remove")
    public Object remove(@RequestBody Book book){
        return mongodbService.remove(book);
    }

    @GetMapping("/removeAll")
    public Object remove(String id){
        return mongodbService.remove(id);
    }
}
