/*	
 * 	ЗАДАНИЕ № 15		SumMaxMin
 * 	15.11.2014
 * 	Определить сумму элементов массива, расположенных между 
 * 	максимальным и минимальным значениами  	
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class SumMaxMin {

	public static void main(String[] args) {
		//ОБЪЯВЛЯЕМ  И  ЗАПОЛНЯЕМ  МАССИВ
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1); //Случайные значения в диапазоне от 1 до 10
		}
		
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");
		int maxMark = marks[0];
		int minMark = marks[0];	
		int iMax=0;
		int iMin=0;
		
		//НАХОДИМ  МАКСИМАЛЬНОЕ  ЗНАЧЕНИЕ  И  МИНИМАЛЬНОЕ  ЗНАЧЕНИЕ
		for (int i=0; i<marks.length; i++) {
			if (maxMark < marks[i]) {
				iMax = i;		
				maxMark = marks[i];
			}
			if (minMark > marks[i]) {
				iMin = i;
				minMark = marks[i];
			}
		}
		
		System.out.println("Миним значение элемента ["+iMin+"]-"+minMark+"   Максимальное значение элемента ["+iMax+"]-"+maxMark);
		
		//ЕСЛИ ПОРЯДКОВЫЙ  НОМЕР  МАКСИМАЛЬНОГО  МЕНЬШЕ  МИНИМАЛЬНОГО ТО МЕНЯЕМ  ИХ  МЕСТАМИ
		if (iMax < iMin) {
			int temp=iMax;
			iMax=iMin;
			iMin=temp;
			System.out.println("РАЗВОРОТ: "+"Миним значение пор. номера ["+iMin+"]   Максимальное значение пор. номера ["+iMax+"]");
		}
		
		
		//ПРОИЗВОДИМ  СУММИРОВАНИЕ  СРЕДИ  НАЙДЕНЫХ  ЭЛЕМЕНТОВ
		int sum=0;
		for (int i=iMin; i<=iMax; i++) {
			if (i==iMin) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(", ["+i+"]-"+marks[i]);			
			sum += marks[i];
		}
		System.out.println("");
		System.out.println("Сумма между МИНИМАЛЬНЫМ и МАКСИМАЛЬНЫМ значением масиива = "+sum);
	}
}
