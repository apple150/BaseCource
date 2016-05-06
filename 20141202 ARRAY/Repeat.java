/*	
 * 	ЗАДАНИЕ № 27  		Repeat
 * 	02.12.2014
 * 	
 * 	Создать коллекцию, наполнить ее случайными числами. Удалить	повторяющиеся числа. 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class Repeat {
	
	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	

	/**
	 * Сравнитель для LinkedList<Integer>
	 */
	static Comparator<Integer> compareLinkedListInteger = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };		
	
	public static void main(String[] args) {
		System.out.println("Демонстрация работы с LINKEDLIST\n");
		List<Integer> linkedList = new LinkedList<Integer>();
		int count=20, item=0; 
		for (int i=0; i<count; i++) {
			item=GetRandomItem(1, 10);
			linkedList.add(item);
		}
		System.out.println("Начальное значение массива:\t"+linkedList+"  - "+linkedList.size()+" элементов");
		
		for (int i=0; i<linkedList.size(); i++) {
			for (int j=i+1; j<linkedList.size(); j++) {
				if (linkedList.get(i) == linkedList.get(j)) { linkedList.remove(j); j--;}
			} 
		}
		System.out.println("Массив с уникал. значениями:\t"+linkedList+"  - "+linkedList.size()+" элементов\n");
		//linkedList.sort(compareLinkedListInteger);		 //Сортировка
		Collections.sort(linkedList, compareLinkedListInteger);
		System.out.println("Отсортированный массив:\t\t"+linkedList+"  - "+linkedList.size()+" элементов\n");
		
	}	
}
