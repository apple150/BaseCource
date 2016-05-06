/*
 * 	ЗАДАНИЕ № 3		Углубленный уровень		RegEmail 	
 * 	17.12.2014
 * 	Написать программу, выполняющую поиск web-адресов,  
 * 	распечатать их и у каждого web-адреса
 * 	распечатать полное доменное имя 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegWeb {
	public static void main(String[] args) {
		String st = "Текст1 http://www.newsland.com/, Текст2 http://www.motorka.org/, Текст3 http://www.procuber.ru/,  Текст4 http://www.apple.com/ Текст5";
		System.out.println("Строка:  "+st+'\n');
		String patterItem="http://([0-9a-zA-Z_^.]+[a-zA-Z]{2,3})";
		System.out.println("Паттерн: "+patterItem+'\n');
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group()+"\t\t"+m.group(1));
		}
	}	
}
