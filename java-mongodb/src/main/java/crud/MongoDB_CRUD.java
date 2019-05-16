package crud;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import utils.MongoDBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 * @description mongodb CRUD操作
 * @date 2019/5/16
 */
public class MongoDB_CRUD {
    /**
     * 插入一个文档
     */
    @Test
    public void insertOne(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnection("mydb");
        //获取数据集合(也就是sql里面的表)
        MongoCollection<Document> userMongoCollection = mongoDatabase.getCollection("user");
        //创建文档对象,添加数据 --》行
        Document document = new Document("爱好","唱跳rap").append("scool","gali");
        document.append("name","张三");
        document.append("age",11);
        document.append("address","深圳");
        userMongoCollection.insertOne(document);
    }

    /**
     * 插入多个文档
     */
    @Test
    public void insertMany(){
        MongoDatabase mongoDatabase = MongoDBUtil.getConnection("mydb");
        MongoCollection<Document> mongoDatabaseCollection = mongoDatabase.getCollection("user");
        List<Document> documents = new ArrayList<Document>();
        for (int i = 1 ; i < 11 ; i++){
            documents.add(new Document("name","蔡徐坤"+i).append("age",i).append("address","深圳"+i));
        }
        mongoDatabaseCollection.insertMany(documents);
    }

    /**
     * 删除文档
     */
    @Test
    public void delete(){
        MongoDatabase mongoDatabase = MongoDBUtil.getConnection("mydb");
        MongoCollection<Document> mongoDatabaseCollection = mongoDatabase.getCollection("user");
        //删除条件
        Bson bson = Filters.eq("name", "张三");
        //删除单个
        //DeleteResult deleteResult = mongoDatabaseCollection.deleteOne(bson);
        //删除多个
        DeleteResult deleteResult = mongoDatabaseCollection.deleteMany(bson);
        System.out.println(deleteResult);
    }

    /**
     * 修改文档
     */
    @Test
    public void update(){
        MongoDatabase mongoDatabase = MongoDBUtil.getConnection("mydb");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //条件
        Bson bson = Filters.eq("name", "张三");
        Document document = new Document("$set",new Document("age",100));
        //修改单个
        //UpdateResult updateResult = collection.updateOne(bson, document);
        //修改多个
        UpdateResult updateResult = collection.updateMany(bson,document);
        long matchedCount = updateResult.getMatchedCount();
        System.out.println("------------:"+updateResult);
        //修改成功返回的行数
        long modifiedCount = updateResult.getModifiedCount();
        System.out.println("**************"+modifiedCount);
    }

    /**
     * 查询文档
     */
    @Test
    public void find(){
        MongoDatabase mongoDatabase = MongoDBUtil.getConnection("mydb");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()){
            Document document = iterator.next();
            Object o = document.get("name");
            System.out.println(document);
            System.out.println(o);
        }
    }

    /**
     * 根据条件查询
     */
    @Test
    public void findByCondition(){
        MongoDatabase mongoDatabase = MongoDBUtil.getConnection("mydb");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        Bson eq = Filters.eq("name", "张三");
        FindIterable<Document> documents = collection.find(eq);
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()){
            Document document = iterator.next();
            System.out.println(document);
        }
    }
}
