/*	
 * 	ЗАДАНИЕ № 17		LocalMin	(Дополнительно)
 * 	18.11.2014
 * 	Задача поиска локальных минимумов в 2-х мерном массиве
 * 	т.е. значение должно быть меньше всех находящихся вокруг 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class LocalMin {

	/**
	 * Процедура вывода массива на экран
	 */
	public static void Print(int  m[][]) {
		//ВЫВОД  МАСССИВА  НА  ЭКРАН
		for (int i = 0; i < m.length; i++) {
			//if (i>0) System.out.println("");
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j]<10) System.out.print("   "+m[i][j]);
				else System.out.print("  "+m[i][j]);				
			}
			System.out.println("");
		}
	}

	/**
	 * ЗАПОЛНЯЕМ  МАССИВ  СЛУЧАЙНЫМИ  ЗНАЧЕНИЯМИ В ДИАПАЗОНЕ ОТ 1-interval
	 */
	public static void InitialArray(int m[][], int interval) {
		//ЗАПОЛНЯЕМ  МАССИВ
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {
				m[i][j] = (int)(Math.random()*interval + 1);
			}
		}
	}
	
	/**
	 * OLD ПОЦЕДУРА  ПОИСКА ЛОКАЛЬНЫХ МИНИМУМОВ
	 */
	public static void FindMinOld(int m[][]) {
		int MaxStr=m.length-1; //максимальное кол-во  строк
		int MaxItem=m[0].length-1; //максимальное кол-во элементов в строке
		int CurrentItem=0;
		int item=0;
		int sum=0;
		int count=0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {				
				sum=0;
				CurrentItem=m[i][j]; //текущий элемент
				if ((i==0)||(i==MaxStr)) sum++;
				if ((j==0)||(j==MaxItem)) sum++;
				
				if (i==0) { //Если первая строка массива	
					//В ЭТОМ БЛОКЕ  БУДЕМ  ИСКАТЬ БОКОВЫЕ И ТОЛЬКО НИЖНИЙ ЭЛЕМЕНТ
					if (j==0) { //1-ый элемент строки
						if (j+1<=MaxItem) {if (CurrentItem < m[i][j+1]) sum++;}
						if (i+1<=MaxStr)  {if (CurrentItem < m[i+1][j]) sum++;}	//ОДИНАКОВЫЙ I		
					} else if (j==MaxItem) { //Последний элемент строки							
						if (j-1>=0) {if (CurrentItem < m[i][j-1]) sum++; }
						if (i+1<=MaxStr) {if (CurrentItem<m[i+1][j]) sum++; } //ОДИНАКОВЫЙ I						
					} else {
						if (j+1<=MaxItem) {if (CurrentItem < m[i][j+1]) sum++;}
						if (j-1>=0) {if (CurrentItem < m[i][j-1]) sum++; }
						if (i+1<=MaxStr) {if (CurrentItem<m[i+1][j]) sum++; } //ОДИНАКОВЫЙ I
					}
				} else if (i==MaxStr) { //Если последняя строка массива		
					//В ЭТОМ БЛОКЕ  БУДЕМ  ИСКАТЬ  БОКОВЫЕ И  ТОЛЬКО ВЕРХНИЙ  ЭЛЕМЕНТ
					if (j==0) {
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}												
					} else if (j==MaxItem) {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}												
					} else {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}												
					}
				} else { //Если строки в сердине массива
					//В ЭТОМ БЛОКЕ  БУДЕМ  ИСКАТЬ БОКОВЫЕ А ТАКЖЕ ВЕРХНИЙ И НИЖНИЙ ЭЛЕМЕНТ 
					if (j==0) {
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}
						if (i+1<=MaxStr) {
							item=m[i+1][j]; if (CurrentItem<item) sum++;							
						}												
					} else if (j==MaxItem) {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}
						if (i+1<=MaxStr) {
							item=m[i+1][j]; if (CurrentItem<item) sum++;							
						}																		
					} else {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}
						if (i+1<=MaxStr) {
							item=m[i+1][j]; if (CurrentItem<item) sum++;							
						}						
					}
				}
				if (sum==4) {					
					System.out.println("Локальный MIN ["+(i+1)+"]["+(j+1)+"] = "+CurrentItem);
					count++;
				}				
			}
		}		
		System.out.println("ВСЕГО - "+count+" локальных минимумов");
	}

	/**
	 * NEW ОПТИМИЗИРОВАННАЯ ПОЦЕДУРА  ПОИСКА ЛОКАЛЬНЫХ МИНИМУМОВ
	 */
	public static void FindMinNew(int m[][]) {
		int MaxStr=m.length-1; 		//максимальное кол-во  строк ДЛЯ УДОБСТВА
		int MaxItem=m[0].length-1; 	//максимальное кол-во элементов в строке ДЛЯ УДОБСТВА				
		int sum=0;
		int count=0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {				
				sum=0;				
				
				if ((i==0)||(i==MaxStr)) sum++;	//КРАЙНИЕ  ГОРИЗОНТАЛЬНЫЕ  СТРОКИ
				if ((j==0)||(j==MaxItem)) sum++; //КРАЙНИЕ  ВЕРТИКАЛЬНЫЕ  СТРОКИ

				if (j+1<=MaxItem) 	{ if (m[i][j] < m[i][j+1]) 	sum++;	} //ЗНАЧЕНИЕ  В СТРОКЕ + 1
				if (j-1>=0) 		{ if (m[i][j] < m[i][j-1]) 	sum++; 	} //ЗНАЧЕНИЕ  В СТРОКЕ - 1
				if (i+1<=MaxStr) 	{ if (m[i][j] < m[i+1][j]) 	sum++; 	} //ЗНАЧЕНИЕ  ПОД ТЕКУЩИМ + 1
				if (i-1>=0) 		{ if (m[i][j] < m[i-1][j]) 	sum++; 	} //ЗНАЧЕНИЕ  НАД ТЕКУЩИМ + 1

				if (sum==4) {					
					System.out.println("Локальный MIN ["+(i+1)+"]["+(j+1)+"] = "+m[i][j]);
					count++;
				}				
			}
		}		
		System.out.println("ВСЕГО - "+count+" локальных минимумов");
	}
		
	public static void main(String[] args) {
		//ОБЪЯВЛЕНИЕ  И  СОЗДАНИЕ  МАСИИВА   (Максимально видел 10 локальных минимумов но возможно 13 в массиве 5x5)
		int size = 5;
		int interval = 50;    //Интервал случайных значений от 1 до 50
		int[][] m = new int[size][size]; 		//ОБЪЯВЛЯЕМ  МАССИВ
		InitialArray(m, interval);
		System.out.println("РАЗМЕР МАССИВА - "+size+"x"+size);
		System.out.println("ДИАПАЗОН ЗНАЧЕНИЙ  ОТ 1-"+interval);
		Print(m);
		//System.out.println("ВВЫОДИМ ЛОКАЛЬНЫЕ  МИНИМУМЫ");
		FindMinNew(m);
	}
}
