/*	
 * 	ЗАДАНИЕ № 6  		Углубленный уровень		Loger
 * 	20.12.2014
 * 	Создать простейший логгер выводящий сообщения об ошибках в текстовый файл.
 * 	Объект логгера должен быть создан с помощью ШП Singleton. 
 * 	У объекта должен быть обязательным один метод получающий на вход
 * 	текст сообщения (об ошибке ...) и записывающий его в файл вместе с 
 * 	информацией о дате и времени проишествия
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Logger {
	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	/**
	 * МЕТОД  ПРЯМОГО  ВЫБОРА 
	 */
	public static void SortVibor(String m[]) {
		int minIndex=0;
		for (int i=0; i<m.length; i++) {
			minIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[minIndex].toString().compareTo(m[j].toString()) > 0 ) {
					minIndex = j;
				}
			}
			String temp = m[minIndex];
			m[minIndex] = m[i];
			m[i] = temp;	
		}
	}	

	/**
	 * МЕТОД  ПЕЧАТИ  В  LOG-ФАЙЛ
	 */
	public static void PrintArray(String m[], MySingle ms) {
		ms.WriteStr("\t\tРЕЖИМ ВЫВОДА МАССИВА", 0);
		int count=0;
		for (int i=0; i<m.length; i++) {
			count++;
			/*
			try {
				ms.WriteStr("Вывели из массива название: "+m[i], count);
			} catch (Exception ex) {
				ms.WriteStr("Значение елемента = NULL", count);
			}*/
			
			if (m[i]==null) {
				ms.WriteStr("Значение елемента = NULL", count);
			} else {
				ms.WriteStr("Вывели из массива название: "+m[i], count);
			}
		}			
	}
		
	public static void main(String[] args) {
		MySingle ms = MySingle.GetMySingle(); //2-го объекта создать не получится
		ms.OpenFile();
		List<String> arrayShip = new ArrayList<String>();
		String [] mas = {"VICTORIA", "BRITANIA", "COLUMBIA", "ATLANTIC", "PILIGRIM", "NAUTILUS", "A.LINKOLN", "DRESDEN", "INVISIBLE", "INFLEXIBLE", "SIDNEY", "SHARNHORST", "GNEYSENAU", "NASSAU", "GOOD HOPE", "UTLANDIA", "GLASGOW", "ORLANDO"};
		String temp="";
		int item=0, count=0;
		ms.WriteStr("\t\tРЕЖИМ ЗАПОЛНЕНИЯ МАССИВА", 0);
		for (int i=0; i<mas.length; i++) {
			item=GetRandomItem(i,(mas.length-i));
			temp=mas[item];			
			arrayShip.add(temp); //Добавляем в массив случайные значения кораблей с их грузом и массой
			count++;
			ms.WriteStr("Добавили в массив новое название: "+temp, count);
			//Операции для того чтобы неповторялись значения массива
			mas[item]=mas[i];
			mas[i]=temp;
		}
		
		ms.WriteStr("\t\tРЕЖИМ ВЫВОДА МАССИВА", 0);
		count=0;
		for (int i=0; i<mas.length; i++) {
			count++;
			ms.WriteStr("Вывели из массива название: "+mas[i], count);
		}
		
		ms.WriteStr("\t\tСОРТИРОВКА МАССИВА", 0);
		SortVibor(mas);
		
		ms.WriteStr("\t\tРЕЖИМ ВЫВОДА МАССИВА", 0);
		count=0;
		for (int i=0; i<mas.length; i++) {
			count++;
			ms.WriteStr("Вывели из массива название: "+mas[i], count);		
		}		
		
		mas[3]=null;
		PrintArray(mas, ms);
		
		ms.CloseFile();		
	}
}
