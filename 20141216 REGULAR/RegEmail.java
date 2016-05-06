/*
 * 	������� � 3		����������� �������		RegEmail 	
 * 	17.12.2014
 * 	�������� ���������, ����������� ��������  
 * 	�� ������������ e-mail ������
 * 	�.�. �������� �� ������� ��� ��� 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEmail {

	public static void main(String[] args) {
		String st = "�����1 Apple150@mail.ru, �����2 ircst@mnsk.rw.by �����3 ";
		System.out.println("������:  "+st+'\n');
		String patterItem="[0-9a-zA-Z_]+@[0-9a-zA-Z_^.]+[a-zA-Z]{2,3}";
		System.out.println("�������: "+patterItem+'\n');
		Pattern p=Pattern.compile(patterItem);
		Matcher m = p.matcher(st);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
