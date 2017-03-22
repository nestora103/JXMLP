package com.gubenkoDM.xmlParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DmitriX on 22.03.2017.
 */
public class XmlParser {
    public void parse() {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("xmlFile.xml");
            //получаем документ как элемент
            Element root=document.getDocumentElement();
            //получаем элемент friendNote c нужным индексом
//            Element elem=(Element)root.getElementsByTagName("friendNote").item(1);
//            //получаем из выбранного friendNote запись name
//            Node node=elem.getElementsByTagName("name").item(0);
//            //получаем содержимое выбранной записи name
//            System.out.println(node.getTextContent());

            NodeList friendNoteElem=root.getElementsByTagName("friendNote");
            for (int i=0;i<friendNoteElem.getLength();++i) {
                Element el = (Element) friendNoteElem.item(i);
                System.out.println(el.getTagName() +":" + el.getTextContent());
            }


            NodeList nameElem=root.getElementsByTagName("name");
            for (int i=0;i<nameElem.getLength();++i) {
                Element el = (Element) nameElem.item(i);
                System.out.println(el.getTagName() +":" + el.getTextContent());
            }

            System.out.println(" ");

            NodeList friendGroup=root.getElementsByTagName("friendGroup");
            for (int i=0;i<friendGroup.getLength();++i) {
                Element el = (Element) friendGroup.item(i);
                //String preStr=el.getTextContent();
                String str=el.getTextContent().replaceAll(" \\n ","").replaceAll(" ","");
                //String str1=str.replaceAll("\\n\\n","\n");
                String strArr[]=str.split("\\n");
                System.out.println(el.getTagName()+":");
                for (String aStrArr : strArr) {
                    if (!aStrArr.isEmpty()){
                        System.out.println(aStrArr);
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
