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

public class ReadStAXconf {

	public static void main(String[] args) {
		String nameFile="";
		nameFile="Config.xml";
		//nameFile="Point.xml";
		
		boolean isUrl = false;
		boolean isName = false;
		boolean isPass = false;
		
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(nameFile));
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == reader.START_ELEMENT) {
					if (reader.getLocalName().equals("url"))
						isUrl=true;
					else if (reader.getLocalName().equals("user"))
						isName=true;
					else if (reader.getLocalName().equals("pass"))
						isPass=true;					
				} else if (res == reader.CHARACTERS) {
					if (isUrl) {
						System.out.println("Url: "+reader.getText());
						isUrl=false;
					} else if (isName) {
						System.out.println("Username: "+reader.getText());
						isName = false;
					} else if (isPass) {
						System.out.println("Password: "+reader.getText());
						isPass = false;
					}
				} 				
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}

	}
}
