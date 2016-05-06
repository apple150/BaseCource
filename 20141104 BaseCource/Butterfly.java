/**
 * 	ЗАДАНИЕ № 17  		Butterfly
 * 	18.11.2014
 * 	Создать двухмерный квадратный массив, и заполнить его «бабочкой»,
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Butterfly {

	/**
	 * Процедура вывода массива на экран
	 */
	public static void Print(int  m[][]) {
		//ВЫВОД  МАСССИВА  НА  ЭКРАН
		for (int i = 0; i < m.length; i++) {
			if (i>0) System.out.println("");
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(" "+m[i][j]);				
			}
		}		
		System.out.println(""); System.out.println("");
	}

	/**
	 * Процедура создания и заполнения ПРОСТОГО массива
	 */
	public static void ProcEasyArray(int  size) {
		int m[][] = new int[size] [size] ;
		//ЗАПОЛНЕНИЕ  МАССИВА  ЗНАЧЕНИЕМ 1
		System.out.println("ПРОСТОЕ  ЗАПОЛНЕНИЕ  МАССИВА");
		/*
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = 1;
			}
		}*/
		Print(m);		
	}
	
	/**
	 * Процедура создания и заполнения массива БАБОЧКОЙ
	 */
	public static void ProcButterflyArray(int  size) {
		int m[][] = new int[size] [size] ;
		//ЗАПОЛНЕНИЕ  МАССИВА  БАБОЧКОЙ  1-ая итерация
		System.out.println("ЗАПОЛНЕНИЕ  МАССИВА   БАБОЧКОЙ");
		for (int i = 0; i < m.length/2+1; i++) {			
			for (int j = 0; j < m[i].length; j++) {	
				if ((j >= i) && (j <= (m[i].length-1-i))) m[i][j] = 1;								
				//else m[i][j] = 0;
			}
		}
		
		//2-ая итерация
		for (int i = m.length-1; i>=m.length/2; i--) {		
            for (int j=0; j<m[i].length; j++) {
                if ((j<(m[i].length-1-i)) || (j>i)) m[i][j]=0;                  
                else m[i][j]=1;                  
            }			
        }
		Print(m);		
	}
	
	/**
	 * СТАРТ  ПРОГРАММЫ
	 */
	public static void main(String[] args) {
		//ОБЪЯВЛЕНИЕ  И  СОЗДАНИЕ  МАСИИВА
		int size = 11;
		ProcEasyArray(size); // Простой массив		
		ProcButterflyArray(size); //Массив бабочкой		
	}

}
