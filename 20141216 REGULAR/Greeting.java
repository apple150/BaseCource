/*
 * 	������� � 1		����������� �������		Port � Ship 	
 * 	11.12.2014
 * 	��������� �������� � �����
 * 	������ ������������ ������� ��� �����
 * 	�������� ������ ���� �� ������ 10-��
 * 	� ����� ���� ����� ��� 3-�
 * 	����� �� ������� ��� � ���� 
 * 	���������� ������������ ������� wait() �� �������� 7
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Greeting {
	public static void main(String[] args) {
		/*
		System.out.println("");
		Locale [] mas = Locale.getAvailableLocales();		
		System.out.println(mas.toString());
		*/
		//Locale loc = new Locale("ru", "RU");
		Locale loc = new Locale("en", "UK");
		//ArrayList mas[] = new Locale.getAvailableLocales();
		
		ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println(rb.getString("greeting"));
		System.out.println(rb.getString("question"));
		
		System.out.println("");
		
		loc = new Locale("ru", "RU");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println(rb.getString("greeting"));		
		System.out.println(rb.getString("question"));
		
		System.out.println("");
		
		loc = new Locale("be", "BY");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println(rb.getString("greeting"));		
		System.out.println(rb.getString("question"));
		
		System.out.println("");
		System.out.println("������������ ������");
		Locale [] mas = Locale.getAvailableLocales();		
		//System.out.println(mas.toString());
		for (int i=0; i<mas.length; i++) {
			System.out.println(mas[i].toString());
		}
	}
}
