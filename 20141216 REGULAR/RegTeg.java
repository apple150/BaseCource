/*
 * 	������� � 3		����������� �������		RegularTeg 	
 * 	16.12.2014
 * 	�������� ���������, ����������� ����� � ������ 
 * 	���� ����� �������, � �.�. ���, � ������� ���� ���������,
 * 	��������: <p id="p1"> � ������ �� �� ������� ���� ������� <p> 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTeg {

	public static void main(String[] args) {
		String st = "������ �����1 <p id=\"p1\">  �����2 <p id=\"p1\" class=\"a1\"> �����3 <P ALIGN=RIGHT> �����4  ";
		//st="<P ALIGN=RIGHT><A STYLE=\"font: normal oblique 12pt\" HREF=\"#START\">� ������ ��������.</A></P>";
		//System.out.println("������:  "+st);
		
		String patterItem="<[Pp][^>]*>";
		System.out.println("�������: "+patterItem);
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
