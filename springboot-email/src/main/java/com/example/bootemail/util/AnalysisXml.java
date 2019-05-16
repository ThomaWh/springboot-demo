package com.example.bootemail.util;

import com.example.bootemail.mapper.TareaCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author wh
 * @description 解析xml
 * @date 2019/5/15
 */
public class AnalysisXml {

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

    public static void main(String[] args) {
        /*Map<String , Country> map = new HashMap<>();
        Map<String , Map> mapMap = new HashMap<>();*/

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("D:\\test-cn.xml");
            NodeList l = document.getElementsByTagName("CountryRegion");
            System.out.println("一共有" + l.getLength() + "个国家");
            for (int i = 0; i < l.getLength(); i++) {

                //1级层面
                Node n = l.item(i);
                String code = n.getAttributes().getNamedItem("Code").getNodeValue();
                String name = n.getAttributes().getNamedItem("Name").getNodeValue();
                System.out.println("--1-"+code);
                System.out.println("--1-"+name);
                //tareaCode.updateEnname(code,name);
                //System.out.println(n);
                printNode(n,null,1);
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
                                    String preId1 = n.getAttributes().getNamedItem("Code").getNodeValue();
                                    System.out.println("**--2-"+codeTwo);
                                    System.out.println("**--2-"+nameTwo);
                                    System.out.println("**--2---"+preId1);
                                    printNode(ns,n,3);
                                }
                            }
                            continue;
                        }
                        printNode(n2,n,2);
                        //2级层面
                        String code2 = n2.getAttributes().getNamedItem("Code").getNodeValue();
                        String name2 = n2.getAttributes().getNamedItem("Name").getNodeValue();
                        String preId1 = n.getAttributes().getNamedItem("Code").getNodeValue();
                        System.out.println("--2-"+code2);
                        System.out.println("--2-"+name2);
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
                                printNode(n3,n2,3);
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
