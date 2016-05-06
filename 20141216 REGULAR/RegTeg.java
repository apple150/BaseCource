/*
 * 	ЗАДАНИЕ № 3		Углубленный уровень		RegularTeg 	
 * 	16.12.2014
 * 	Написать программу, выполняющую поиск в строке 
 * 	всех тегов абзацев, в т.ч. тех, у которых есть параметры,
 * 	Например: <p id="p1"> и замену их на простые теги абзацев <p> 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTeg {

	public static void main(String[] args) {
		String st = "Привет текст1 <p id=\"p1\">  текст2 <p id=\"p1\" class=\"a1\"> текст3 <P ALIGN=RIGHT> текст4  ";
		//st="<P ALIGN=RIGHT><A STYLE=\"font: normal oblique 12pt\" HREF=\"#START\">В начало страницы.</A></P>";
		//System.out.println("Строка:  "+st);
		
		String patterItem="<[Pp][^>]*>";
		System.out.println("Паттерн: "+patterItem);
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group());
		}		
		System.out.println('\n'+st);
		System.out.println(st.replaceAll(patterItem, "<P>"));
		
		/*
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			//System.out.println(m.start()+"  "+m.end());
			System.out.println(m.group());			
		}
		System.out.println(st.replaceAll(patterItem, "<p>"));
		*/
		/*
		st="http://www.tut.by/  http://www.tut.by/";		
		//st = "http://www.newstut.by/";
		patterItem="www\\.(\\w+)\\.by";
		System.out.println('\n'+st);
		p=Pattern.compile(patterItem);
		m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group(1));
		}
		String st2 = "http://www.news.tut.by";
		m.reset(st2);
		while (m.find()) {
			System.out.println(m.group(1));
		}
		*/	
	}

}
