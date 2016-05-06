/*	
 * 	ЗАДАНИЕ № 15		LastItems		(ПЕРЕДЕЛКА 		ArrayMax3)
 * 	15.11.2014
 * 	Определите максимальный элемент в массиве, затем 2-ое по величине значение 
 * 	и 3-е по величине значение, за 1 проход. 
 * 	
 * 	ЭТО БОЛЕЕ КОРРЕКТНАЯ  РЕАЛИЗАЦИЯ (в процедуре Find_1)
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class LastItems {

	/**
	 * ВЫВОД  МАССИВА  НА КОНСОЛЬ
	 */
	public static void PrintArray(int marks[], int count, String st) {
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		System.out.print(st+"  ");
		for (int i=0; i<marks.length; i++) {
			//if (i==0) System.out.print("["+i+"]-"+marks[i]);
			//else System.out.print(",["+i+"]-"+marks[i]);
			if (i==0) System.out.print(i+"-"+marks[i]);
			else System.out.print(", "+i+"-"+marks[i]);			
		}
		if (count==0) System.out.println("");
		else System.out.println("  ("+count+")");
	}
	
	/**
	 * ЗАПОЛНЯЕМ  МАССИВ  СЛУЧАЙНЫМИ  ЗНАЧЕНИЯМИ В ДИАПАЗОНЕ ОТ 1-interval
	 */
	public static void InitialArray(int marks[], int interval) {
		//ЗАПОЛНЯЕМ  МАССИВ
		for (int i=0; i<20; i++) {
			//marks[i] = (int)(Math.random()*10 + 1);
			marks[i] = (int)(Math.random()*interval + 1);
		}
	}

	/**
	 * КОПИРУЕМ  ЭЛЕМЕНТЫ  МАССИВА В ДРУГОЙ  РАВНОЗНАЧНЫЙ  МАСCИВ
	 */
	public static void CopyArray(int marks[], int marks_new[]) {
		//ЗАПОЛНЯЕМ  МАССИВ
		for (int i=0; i<20; i++) {
			marks_new[i] = marks[i];
		}
	}
	
	
	/**
	 * 1-ый вариант поиска без сортировок
	 */	
	public static void Find_1(int m[]) {
		//ПОИСК  НЕОБХОДИМЫХ  ЗНАЧЕНИЙ 1-ый вариант  (ОТСОРТИРОВАННЫЙ  МАССИВ  НЕ  ТРЕБУЕТСЯ)
		int first=0, second=0, third=0;
		/*// OLD VERSION
		for (int i=0; i<m.length; i++) {
			if (m[i]>=first) first=m[i];
			else if (m[i]>=second) second=m[i]; 
			else if (m[i]>=third) third=m[i];			
		}*/
		for (int i=0; i<m.length; i++) {
			if (m[i] > first) {
				if (third!=0) third=second;
				if (second!=0) second=first;
				first=m[i];
			} else if ((m[i] > second) && (m[i] < first)) {			
				if (third!=0) third=second;				
				second=m[i]; 
				//System.out.println("second-"+second);
			} else if ((m[i] > third) && (m[i] < second)) {
				third=m[i];			
				//System.out.println("third-"+third);
			}
		}		
		System.out.println("1-ый  ВАРИАНТ");
		PrintArray(m, 0, "МАССИВ-1:"); 	//ВЫВОДИМ МАССИВ 1
		System.out.println("РЕЗУЛЬТАТ: item_1-"+first+", item_2-"+second+", item_3-"+third);		
	}

	/**
	 * МЕТОД  ПРЯМОГО  ВЫБОРА 
	 */
	public static void SortVibor(int m[]) {
		//СОРТИРОВКА  МЕТОДОМ  ПРЯМОГО  ВЫБОРА
		int maxIndex=0;
		for (int i=0; i<m.length; i++) {
			maxIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[maxIndex] < m[j]) {
					maxIndex = j;
				}
			}
			int temp = m[maxIndex];
			m[maxIndex] = m[i];
			m[i] = temp;						
		}		
		PrintArray(m, 0, "ОТСОРТИР:");
	}
		
	/**
	 * 2-ый вариант поиска с предварительной сортировкой
	 */	
	public static void Find_2(int m[]) {
		System.out.println("2-ой  ВАРИАНТ");
		PrintArray(m, 0, "МАССИВ-2:"); 	//ВЫВОДИМ МАССИВ 2
		SortVibor(m);
		//ПОИСК  НЕОБХОДИМЫХ  ЗНАЧЕНИЙ 2-ой вариант  (НЕОБХОДИМ  ОТСОРТИРОВАННЫЙ МАССИВ)
		int item=0;
		int count=0;
		System.out.print("РЕЗУЛЬТАТ: ");
		for (int i=0; i<m.length; i++) {
			if (item!=m[i]) {
					count++;
				item=m[i];
				if (i==0) System.out.print("item_"+count+"-"+item);
				else System.out.print(", item_"+count+"-"+item);
					if (count==3) break;
			}
		}		
	}
	
	/**
	 * СТАРТ  ПРОГРАММЫ
	 */
	public static void main(String[] args) {
		int SizeOfArray = 25; //Колличество элементов в массиве
		int interval = 50;    //Интервал случайных значений от 1 до 50
		System.out.println("	   РАЗМЕР МАССИВА:     "+SizeOfArray+" ЭЛЕМЕНТОВ");
		System.out.println("	   ИНТЕРВАЛ  ЗНАЧЕНИЙ: 1-"+interval);
		int[] m1, m2; 		//ОБЪЯВЛЯЕМ  2 МАССИВА
			m1= new int[SizeOfArray];	//СОЗДАЕМ МАСИВ 1
			m2= new int[SizeOfArray];	//СОЗДАЕМ МАСИВ 2
			
			InitialArray(m1, interval); //Заполняем массив случайными числами в интервале от 1 до 50
			CopyArray(m1, m2);	//КОПИРУЕМ  ЗНАЧЕНИЯ ИЗ МАССИВА 1 В  МАССИВ 2
						
		Find_1(m1); //1-ый вариант поиска без сортировок
		System.out.println("");		
		Find_2(m2); //2-ой вариант поиска с предварительной сортировокой			
	}

}
