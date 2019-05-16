package utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 * @description mongodb连接数据库工具类
 * @date 2019/5/16
 */
public class MongoDBUtil {
    /**
     * 获取mongodb数据库连接对象
     * @param dataBaseName 数据库名称
     * @return 数据库连接对象
     */
    public static MongoDatabase getConnection(String dataBaseName){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBaseName);
        return mongoDatabase;
    }

    /**
     * 获取mongodb数据库连接对象
     * @param dataBaseName 数据库名称
     * @param userName 用户名
     * @param password 数据库名称
     * @return 数据库连接对象
     */
    public static MongoDatabase getConnection(String dataBaseName , String userName , String password){
        List<ServerAddress> adds = new ArrayList<ServerAddress>();
        //设置连接ip , port
        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        adds.add(serverAddress);

        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        //mongodb连接的用户名,数据库名,密码
        MongoCredential mongoCRCredential = MongoCredential.createMongoCRCredential(userName, dataBaseName, password.toCharArray());
        credentials.add(mongoCRCredential);

        MongoClient mongoClient = new MongoClient(adds,credentials);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBaseName);
        return mongoDatabase;
    }
}
