/*
 * 	ЗАДАНИЕ № 17		Mirror		(Дополнительно)
 * 	18.11.2014
 * 	Создаем двухмерный массив и зеркалим его по диагонали
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Mirror {

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
	 * ЗАПОЛНЯЕМ  МАССИВ  ЗНАЧЕНИЯМИ от 1-... 25 (в массиве 5x5)
	 */
	public static void InitialArrayEasy(int m[][]) {
		//ЗАПОЛНЯЕМ  МАССИВ
		int count=0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {
				count++;
				m[i][j] = count;
			}
		}
	}
		
	/**
	 * ПОЦЕДУРА  ПЕРЕСТАНОВКИ  ЗЕРКАЛОМ (ДИАГОНАЛЬ ВЕРХНИЙ ЛЕВЫЙ УГОЛ - НИЖНИЙ ПРАВЫЙ УГОЛ  \)
	 */
	public static void Perestanovka(int m[][]) {
		int temp=0, iTemp=0, jTemp=0;
		for (int i=0; i<m.length-1; i++) {
			for (int j=i+1; j < m[i].length; j++) {
				iTemp=m.length-1-i;  jTemp=m[i].length-1-j;
				temp=m[iTemp][jTemp];
				m[iTemp][jTemp]=m[i][j];
				m[i][j]=temp;
			}
		}
	}	

	/**
	 * ПОЦЕДУРА  ПЕРЕСТАНОВКИ  ЗЕРКАЛОМ (ДИАГОНАЛЬ ВЕРХНИЙ ПРАВЫЙ УГОЛ - НИЖНИЙ ЛЕВЫЙ УГОЛ  /)
	 */
	public static void PerestanovkaNew(int m[][]) {		
		int temp=0, iTemp=0, jTemp=0;
		for (int i=0; i<m.length-1; i++) {
			for (int j=0; j < m[i].length-i-1; j++) {
				iTemp=m.length-1-i;  jTemp=m[i].length-1-j;				
				temp=m[iTemp][jTemp];
				m[iTemp][jTemp]=m[i][j];
				m[i][j]=temp;
			}
		}
	}	
	
	/**
	 * СТАРТ  ПРОГРАММЫ
	 */
	public static void main(String[] args) {		
		int size = 7;
		int interval = 20;    //Интервал случайных значений от 1 до 50

		int[][] m = new int[size][size]; 		//ОБЪЯВЛЯЕМ  МАССИВ
		//InitialArray(m, interval);            //Заполняем массиив случайными числами 
		InitialArrayEasy(m);					//Заполняем массив числами от 1 до 25 (в массивке 5x5)
		System.out.println("РАЗМЕР МАССИВА - "+size+"x"+size);
		System.out.println("ДИАПАЗОН ЦИФР  ОТ 1-"+interval);
		System.out.println("ЗЕРКАЛИМ ПО ДИАГОНАЛИ ОТ ВЕРХНЕГО ЛЕВОГО УГЛА ДО НИЖНЕГО ПРАВОГО ");
		Print(m);	//Распечатываем массив
		System.out.println("");

		Perestanovka(m); 	//ПЕРЕСТАНОВКИ  ЗЕРКАЛОМ (ДИАГОНАЛЬ ВЕРХНИЙ ЛЕВЫЙ УГОЛ - НИЖНИЙ ПРАВЫЙ УГОЛ \ )
		Print(m); 			//Распечатываем зазекркаленный массив 
		System.out.println("");
		System.out.println("ЗЕРКАЛИМ ПО ДИАГОНАЛИ ОТ ВЕРХНЕГО ПРАВОГО УГЛА ДО НИЖНЕГО ЛЕВОГО");
		InitialArrayEasy(m);	//Заполняем массив числами от 1 до 25 (в массивке 5x5)
		Print(m);				//Распечатываем массив
		System.out.println("");
		PerestanovkaNew(m); //ПЕРЕСТАНОВКИ  ЗЕРКАЛОМ (ДИАГОНАЛЬ ВЕРХНИЙ ПРАВЫЙ УГОЛ - НИЖНИЙ ЛЕВЫЙ УГОЛ / )
		Print(m);			//Распечатываем зазекркаленный массив
	}
}
