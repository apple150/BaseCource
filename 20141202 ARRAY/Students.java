/*	
 * 	ЗАДАНИЕ № 26  		Students
 * 	02.12.2014
 * 	
 * 	Создать список оценок учеников с помощью ArrayList, 
 * 	заполнить случайными оценками. 
 * 	Удалить неудовлетворительные оценки из списка  
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class Students {

	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	/**
	 * Сравнитель для ArrayList<Integer>
	 */
	static Comparator<Integer> compareArrayListInteger = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };	
	
	public static void main(String[] args) {
		System.out.println("Демонстрация работы с ARRAYLIST\n");
		List<Integer> arrayList = new ArrayList<Integer>();
		int count=20, item=0; 
		for (int i=0; i<count; i++) {
			item=GetRandomItem(1, 10);
			arrayList.add(item);
		}
		System.out.println("Начальное значение массива:\t"+arrayList+"  - "+arrayList.size()+" элементов");
		Collections.sort(arrayList, compareArrayListInteger);
		//arrayList.sort(compareArrayListInteger);  //Сортировка		
		System.out.println("Отсортированный массив:\t\t"+arrayList+"  - "+arrayList.size()+" элементов\n");
		
		for (int i=0; i<arrayList.size(); i++) {
			if (arrayList.get(i) < 4) { arrayList.remove(i); i--;} 
		}
		System.out.println("Массив где значения больше 3-х:\t"+arrayList+"  - "+arrayList.size()+" элементов");
	}
}
