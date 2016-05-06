/*	
 * 	ЗАДАНИЕ № 11  		Углубленный уровень		ReadStAX
 * 	27.12.2014
 * 	Напишите программу которая будет разбирать xml-файл сделанный
 * 	в предыдущих заданиях и выводить его на экран в текстовом виде.
 * 	Каждая точка должна выводиться на отдельной строке
 * 	в виде двух чисел, разделенных запятой 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ReadStAX {

	public static void main(String[] args) {
		String nameFile="Point.xml";		
		
		boolean isPointList = false;
		boolean isPoint = false;
		boolean isX = false;
		boolean isY = false;
		String unitOfMeasure="";
		String X="";
		String Y="";
		
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(nameFile));
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == reader.START_ELEMENT) {
					if (reader.getLocalName().equals("pointList")) {
						isPointList=true;
					} else if (reader.getLocalName().equals("point")) { 							
						isPoint=true;
						unitOfMeasure= reader.getAttributeValue(0);
						/*
						System.out.println("Attribut: "+reader.getAttributeCount());
						System.out.println("Attribut: "+reader.getAttributeLocalName(0));
						System.out.println("Attribut: "+reader.getAttributeValue(0));
						*/
					} else if (reader.getLocalName().equals("x")) {
						isX = true;
					} else if (reader.getLocalName().equals("y")) {
						isY = true;
					}					
				} else if (res == reader.CHARACTERS) {
					if (isPointList && isPoint) {
						if (isX) {
							X=reader.getText(); isX=false;																					
						} else if (isY) {
							Y=reader.getText(); isY=false;							
						}
					}
				} else if (res == reader.END_ELEMENT) {
					if (reader.getLocalName().equals("point")) { 					
						System.out.println("x: "+X+unitOfMeasure+",\t  y: "+Y+" "+unitOfMeasure);
						isPoint = false; X="";  Y="";						
					} else if (reader.getLocalName().equals("pointList")) {
						isPointList = false;
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
