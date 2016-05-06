/*
 * 	ЗАДАНИЕ № 2		Углубленный уровень		RegHex 	
 * 	16.12.2014
 * 	Написать программу, выполняющую поиск в строке 
 * 	шестнадцатеричных чисел, записанных по правилам JAVA 
 * 	с помощью регулярных выражений и вывести их на страницу 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegHex {
	public static void main(String[] args) {
		//String st = "ТЕСТ 0x1234, 0xAAaa, 0x12aa, 0xAb12, 0x11AB, 0xAB11, 0xFF13, 0x5fB3A, 0x11, 0x85BF";
		String st = "ТЕСТ - 0x1234, 0xAAAA, 0xaA12, 0x12aA, 0x1a2b3c, 0Xa1b2c3, 0xFFFFCC, <TD BGCOLOR=0xCCFFCC>&nbsp</TD>";
		System.out.println(st);
		String patterItem="";
		//patterItem="(0x\\d+)|(0x[abcdefABCDEF]+)|(0x\\d+[abcdefABCDEF]+)|(0x[abcdefABCDEF]+\\d+)|(0x\\d+[abcdefABCDEF]+\\d+[abcdefABCDEF]+)";
		//patterItem="(0x\\d*[abcdefABCDEF]*\\d*[abcdefABCDEF]*\\d*[abcdefABCDEF]*\\d*[abcdefABCDEF]*)";
		//patterItem="(0x(\\d*)|([abcdefABCDEF]*))";
		//patterItem="0[Xx][\\dA-Fa-f]+";
		patterItem="0[Xx][0-9A-Fa-f]+";		
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}