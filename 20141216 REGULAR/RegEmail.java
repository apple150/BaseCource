/*
 * 	ЗАДАНИЕ № 3		Углубленный уровень		RegEmail 	
 * 	17.12.2014
 * 	Написать программу, выполняющую проверку  
 * 	на корректность e-mail адреса
 * 	т.е. является он таковым или нет 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEmail {

	public static void main(String[] args) {
		String st = "Текст1 Apple150@mail.ru, Текст2 ircst@mnsk.rw.by Текст3 ";
		System.out.println("Строка:  "+st+'\n');
		String patterItem="[0-9a-zA-Z_]+@[0-9a-zA-Z_^.]+[a-zA-Z]{2,3}";
		System.out.println("Паттерн: "+patterItem+'\n');
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
