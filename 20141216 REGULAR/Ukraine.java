/*
 * 	������� � 4		����������� �������		Ukraine 	
 * 	18.12.2014
 * 	�������� ���������, ��������� ����� 
 * 	153.5 � �������� ���� ��� �������  
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.text.NumberFormat;
import java.util.Locale;

public class Ukraine {
	public static void main(String[] args) {
		double itemDouble = 153.5;
		System.out.println(itemDouble);
		Locale loc = new Locale("uk", "UA");
		//Locale loc = new Locale("ru", "RU");
		//Locale loc = Locale.getDefault();
		NumberFormat rubFormat = NumberFormat.getCurrencyInstance(loc);
		System.out.println(rubFormat.format(itemDouble));
	}
}
