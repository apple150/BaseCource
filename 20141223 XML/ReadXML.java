/*	
 * 	ЗАДАНИЕ № 10  		Углубленный уровень		ReadXML
 * 	22.12.2014
 * 	Напишите программу которая будет разбирать xml-файл сделанный
 * 	в предыдущих заданиях с помощью DOM и выводить его на экран
 * 	в текстовом виде. Каждая точка должна выводиться на отдельной строке
 * 	в виде двух чисел, разделенных запятой 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		File f = new File("Point.xml");
		Document doc = null;
		try {
			doc = (Document) builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element root = (Element) doc.getDocumentElement();
		//String nameUzel=root.getTagName();
		//System.out.println(nameUzel);
		
		NodeList nList = (NodeList) root.getChildNodes();
		for (int i=0; i<nList.getLength(); i++) {
			if (nList.item(i) instanceof Element) {
				//String nameA=nList.item(i).getNodeName();
				//System.out.println(nameA);
				
				NamedNodeMap attr = nList.item(i).getAttributes();
				//System.out.println(attr.getLength());
				
				String unitOfMeasure = attr.item(0).getNodeValue();
				//System.out.println(ii);
				
				String rez="";
				NodeList nArray = (NodeList) nList.item(i).getChildNodes();
				for (int y=0; y<nArray.getLength(); y++) {
					if (nArray.item(y) instanceof Element) {							
						//String nameB=nArray.item(y).getNodeName();
						//System.out.println(nameB);
						
						//Обращение непосредственно к значению x или y
						NodeList nArray11 = (NodeList) nArray.item(y).getChildNodes();
						String nameZ=nArray11.item(0).getNodeValue();
						//System.out.println(nameZ);
						
						//String rez= nameB+unitOfMeasure+", "+nameZ+unitOfMeasure;
						if (rez=="") rez="x: "+nameZ+" "+unitOfMeasure;
						else rez=rez+",\t y: "+nameZ+" "+unitOfMeasure;
					}
				}
				System.out.println(rez);
				rez="";
			}
		}		
	}
}
