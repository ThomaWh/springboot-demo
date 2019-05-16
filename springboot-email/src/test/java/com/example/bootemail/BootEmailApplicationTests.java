package com.example.bootemail;

import com.alibaba.fastjson.JSONObject;
import com.example.bootemail.mapper.TareaCode;
import com.example.bootemail.model.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootEmailApplicationTests {
    /*@Autowired
    EmaliService emaliService;*/
    Email email = new Email("wang9982341@163.com" ,
            "925346457@qq.com" ,
            "澳门首家赌场上线啦" ,"恭喜您注册成为性感荷官，在线发牌",
            "E:\\WEB-INF\\ThinkInJava.pdf");

    /*@Test
    public void emailTest() {
        emaliService.send(email);

    }*/

    /*@Test
    public void accessory() {
        emaliService.sendAccessory(email);
    }*/

    @Test
    public void abb(){
        Email email = new Email("a","b","c","d","e");
        String jsonString = JSONObject.toJSONString(email);
        System.out.println(jsonString);
        Email email1 = JSONObject.parseObject(jsonString, Email.class);
        System.out.println(email1);
        int i = 3;
        String s = Integer.toBinaryString(i);
        i =  2<<i;
        System.out.println(i);
        //System.out.println(int a = <<i);
    }

    /**
     * 群发邮件测试
     */
    //@Test
   /* public void sendAllEmail(){
        emaliService.sendGroupEmail(email);
    }*/


    @Autowired
    TareaCode tareaCode;
    private static void printNode(Node n, Node parent, int level ) {
        parent = parent==null? n:parent;
        System.out.println("insert into world_country(id,name, pid, level)values( "
                + "\""+n.getAttributes().getNamedItem("Code").getNodeValue()+"\","
                + "\""+ n.getAttributes().getNamedItem("Name").getNodeValue()+"\","
                + "\""+ parent.getAttributes().getNamedItem("Code").getNodeValue() +"\","
                + level
                +");"
        );
    }

    @Test
    public void updateEnname(){
         /*Map<String , Country> map = new HashMap<>();
        Map<String , Map> mapMap = new HashMap<>();*/
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("D:\\LocList.xml");
            NodeList l = document.getElementsByTagName("CountryRegion");
            System.out.println("一共有" + l.getLength() + "个国家");
            for (int i = 0; i < l.getLength(); i++) {
                //1级层面
                Node n = l.item(i);
                String code = n.getAttributes().getNamedItem("Code").getNodeValue();
                String name = n.getAttributes().getNamedItem("Name").getNodeValue();
                System.out.println("--1-"+code);
                System.out.println("--1-"+name);
                String preId1 = tareaCode.findIdByCode(code);
                tareaCode.updateEnname(code,name);
                //System.out.println(n);
                //printNode(n,null,1);
                NodeList childNodes = n.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    Node n2 = childNodes.item(k);
                    if("State".equals(n2.getNodeName())){
                        if(n2.getAttributes().getNamedItem("Name")==null){
                            NodeList childNodesS = n2.getChildNodes();
                            for(int z = 0; z < childNodesS.getLength(); z++) {
                                Node ns = childNodesS.item(z);
                                if("City".equals(ns.getNodeName())){
                                    //没有州or省的情况 2级层面
//                    				System.out.println("这个国家没有州");
                                    String codeTwo = ns.getAttributes().getNamedItem("Code").getNodeValue();
                                    String nameTwo = ns.getAttributes().getNamedItem("Name").getNodeValue();
                                    //String preId1 = n.getAttributes().getNamedItem("Code").getNodeValue();
                                    System.out.println("**--2-"+codeTwo);
                                    System.out.println("**--2-"+nameTwo);
                                    System.out.println("**--2---"+preId1);
                                    if(null != preId1){
                                        tareaCode.updateTwoEnname(codeTwo,nameTwo,preId1);
                                    }

                                    //printNode(ns,n,3);
                                }
                            }
                            continue;
                        }
                        printNode(n2,n,2);
                        //2级层面
                        String codeTwo = n2.getAttributes().getNamedItem("Code").getNodeValue();
                        String nameTwo = n2.getAttributes().getNamedItem("Name").getNodeValue();
                        //String preId1 = n.getAttributes().getNamedItem("Code").getNodeValue();
                        if(null != preId1){
                            tareaCode.updateTwoEnname(codeTwo,nameTwo,preId1);
                        }
                        //tareaCode.updateTwoEnname(codeTwo,nameTwo,preId1);
                        System.out.println("--2-"+codeTwo);
                        System.out.println("--2-"+nameTwo);
                        System.out.println("--2---"+preId1);
                        NodeList childNodes2 = n2.getChildNodes();
                        for(int u = 0; u < childNodes2.getLength(); u++) {
                            Node n3 = childNodes2.item(u);
                            if("City".equals(n3.getNodeName())){
                                /*System.out.println(n3);
                                System.out.println(n2);*/
                                //3级层面
                                String code3 = n3.getAttributes().getNamedItem("Code").getNodeValue();
                                String name3 = n3.getAttributes().getNamedItem("Name").getNodeValue();
                                String preId2 = n2.getAttributes().getNamedItem("Code").getNodeValue();
                                System.out.println("--3-"+code3);
                                System.out.println("--3-"+name3);
                                System.out.println("--3---"+preId2);
                                System.out.println("***********************"+preId1);
                                preId2 = tareaCode.findIdMyCodeTwo(codeTwo,preId1);
                                System.out.println("---------3----------"+preId2);
                                if(null != preId2){
                                    tareaCode.updateThreeEnname(code3,name3,preId2);
                                }

                                //printNode(n3,n2,3);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
