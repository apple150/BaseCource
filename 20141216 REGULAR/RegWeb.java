/*
 * 	������� � 3		����������� �������		RegEmail 	
 * 	17.12.2014
 * 	�������� ���������, ����������� ����� web-�������,  
 * 	����������� �� � � ������� web-������
 * 	����������� ������ �������� ��� 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegWeb {
	public static void main(String[] args) {
		String st = "�����1 http://www.newsland.com/, �����2 http://www.motorka.org/, �����3 http://www.procuber.ru/,  �����4 http://www.apple.com/ �����5";
		System.out.println("������:  "+st+'\n');
		String patterItem="http://([0-9a-zA-Z_^.]+[a-zA-Z]{2,3})";
		System.out.println("�������: "+patterItem+'\n');
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group()+"\t\t"+m.group(1));
		}
	}	
}
