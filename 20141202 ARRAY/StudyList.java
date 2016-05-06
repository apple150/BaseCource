/*	
 * 	ЗАДАНИЕ № 28  		StudyList
 * 	04.12.2014
 * 	
 * 	Создать список оценок учеников с помощью ArrayList, 
 * 	заполнить случайными оценками. 
 * 	Найти самую высокую оценку с помощью ИТЕРАТОРА   
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class StudyList {

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
    
	/**
	 *	Фунция анализирует массив на макисальное повторение в них чисел 
	 */
	static public void AnalizMaxRepeatNumber(List<Integer> arrayList) {
		int previous=-1, maxCount=0, number=0, i=0, count=0;
		Iterator<Integer> iterator = arrayList.iterator();   //МЕТОД  ФАБРИКА  создает  итератор
		while (iterator.hasNext()) {
			i=iterator.next().intValue();
			if (previous==-1) previous=i; 
			if (i == previous) { 
				count++;
				if (count > maxCount) {
					maxCount=count;
					number=i;
				}				
			} else {
				count=1; previous=i;
			} 			
			
		}
		System.out.println("Максимально повторилось число :\t"+number+"\t"+maxCount+" раз");				
	}
    
	/**
	 *	Фунция анализирует массив на макисальное значение числа 
	 */
	static public void AnalizMaxNumber(List<Integer> arrayList) {
		int max=0, i=0, count=0;
		Iterator<Integer> iterator = arrayList.iterator();   //МЕТОД  ФАБРИКА  создает  итератор 
		while (iterator.hasNext()) {
			i=iterator.next().intValue();
			if (i > max) { 
				max=i; count=1; 
			} else if (i == max) count++; 			 
		}
		System.out.println("MAX:\t"+max+"\tКол-во таких оценок\t("+count+")");		
	}
	
	public static void main(String[] args) {
		System.out.println("Демонстрация работы с ARRAYLIST с итератором\n");
		List<Integer> arrayList = new ArrayList<Integer>();
		int count=20, item=0; 
		for (int i=0; i<count; i++) {
			item=GetRandomItem(1, 10);
			arrayList.add(item);
		}
		System.out.println("Начальное значение массива:\t"+arrayList+"  - "+arrayList.size()+" элементов");
		AnalizMaxNumber(arrayList);			//Фунция анализирует массив на макисальное значение числа
		AnalizMaxRepeatNumber(arrayList);	//Фунция анализирует массив на макисальное повторение в них чисел
		
		Collections.sort(arrayList, compareArrayListInteger);
		//Arrays.sort(arrayList);
		System.out.println("\nОтсортированный массив:\t\t"+arrayList+"  - "+arrayList.size()+" элементов\n");
		AnalizMaxNumber(arrayList); 		//Фунция анализирует массив на макисальное значение числа
		AnalizMaxRepeatNumber(arrayList); 	//Фунция анализирует массив на макисальное повторение в них чисел
	}
}
