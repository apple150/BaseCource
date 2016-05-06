/*
 * 	ЗАДАНИЕ № 1		Углубленный уровень		Port и Ship 	
 * 	11.12.2014
 * 	Разгрузка кораблей в порту
 * 	Каждый разгружаемый корабль это поток
 * 	Кораблей должно быть не меньше 10-ти
 * 	В порту есть место для 3-х
 * 	Вывод на консоль или в файл 
 * 	Необходимо использовать функцию wait() на странице 7
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
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
		System.out.println("Существующие локали");
		Locale [] mas = Locale.getAvailableLocales();		
		//System.out.println(mas.toString());
		for (int i=0; i<mas.length; i++) {
			System.out.println(mas[i].toString());
		}
	}
}
