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
	/**
	 * МЕТОД  ПРЯМОГО  ВЫБОРА 
	 */
	public static void SortVibor(Locale m[]) {
		int minIndex=0;
		for (int i=0; i<m.length; i++) {
			minIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[minIndex].toString().compareTo(m[j].toString()) > 0 ) {
					minIndex = j;
				}
			}
			Locale temp = m[minIndex];
			m[minIndex] = m[i];
			m[i] = temp;	
		}
	}
	
	public static void main(String[] args) {
		String itemLocal="";
		Locale loc = new Locale("ru", "RU");		
		if (args.length>0) {
			for (int i=0; i<args.length; i++) {
				itemLocal=args[i].toString();
				System.out.println("Locale из args: "+itemLocal);
				if ((itemLocal.compareTo("en")==0)||(itemLocal.compareTo("ru")==0)||(itemLocal.compareTo("zz")==0)) {
					loc = new Locale(itemLocal);
					ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
					System.out.println('\t'+rb.getString("greeting"));
					System.out.println('\t'+rb.getString("question"));
					System.out.println("");
				}
			}
		} else {
			System.out.println("По умолчанию АНГЛИЙСКАЯ Local ");
			loc = new Locale(itemLocal);
			ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
			System.out.println('\t'+rb.getString("greeting"));
			System.out.println('\t'+rb.getString("question"));			
		}
		
		System.out.println("АНГЛИЙСКАЯ Lokal");
		loc = new Locale("en", "UK");		
		ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));
		System.out.println('\t'+rb.getString("question"));		
		
		System.out.println("\nРУССКАЯ Lokal");
		loc = new Locale("ru", "RU");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));		
		System.out.println('\t'+rb.getString("question"));
		
		System.out.println("\nБЕЛОРУССКАЯ Lokal");
		loc = new Locale("be", "BY");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));		
		System.out.println('\t'+rb.getString("question"));

		System.out.println("\nУКРАИНСКАЯ Lokal");
		loc = new Locale("uk", "UA");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));		
		System.out.println('\t'+rb.getString("question"));
		
		/*
		System.out.println("");
		System.out.println("Существующие локали");
		Locale [] mas = Locale.getAvailableLocales();		
		System.out.println("Отсортиованная локаль");
		SortVibor(mas);
		for (int i=0; i<mas.length; i++) {
			System.out.println(mas[i].toString());
		}
		*/
	}
}
