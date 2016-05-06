/*	
 * 	ЗАДАНИЕ № 12  		Углубленный уровень		ReadStAX
 * 	27.12.2014
 * 	Напишите программу преобразующую xml-файл сделанный
 * 	в предыдущих заданиях в html, в каждой ячейке дополнительно к координате
 * 	должны выводиться еденицы измернеия
 * 	Результат должен быть записан в файл на диске 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TransformXML {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        File f = new File("Point.xml");
        try {
            doc = builder.parse(f);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Element root = doc.getDocumentElement();
                
        System.out.println(root.getTagName());
                
        NodeList nList = root.getChildNodes();
        for (int i = 0; i < nList.getLength(); i++) {        
            if (nList.item(i) instanceof Element) {            
                System.out.println("  " + nList.item(i).getNodeName());
                NodeList nList2 = ((Element) nList.item(i)).getChildNodes();
                for (int j = 0; j < nList2.getLength(); j++) {
                    if (nList2.item(j) instanceof Element) {
                        NamedNodeMap attr = nList.item(i).getAttributes();
                        String atr = attr.getNamedItem("unit").getNodeValue();
                        System.out.println("    "+ nList2.item(j).getNodeName() + ": "+ nList2.item(j).getTextContent() + " " + atr);                                                          
                    }
                }
                System.out.println(); 
            }
        } 
        File file = new File("Rezult.html");
        DataOutputStream a;
        try {        
            a = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            System.out.print("File Not Found");
            return;
        }
        File stylesheet = new File("Template.xsl");
        StreamSource styleSource = new StreamSource(stylesheet);
        try {         
            Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
            //t.transform(new DOMSource(root), new StreamResult(System.out));            
            t.transform(new DOMSource(root), new StreamResult(a));
        } catch (TransformerConfigurationException e) { 
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {                
            e.printStackTrace();
        }		
	}
}
