/*	
 * 	ЗАДАНИЕ № 16		Reverse
 * 	15.11.2014
 * 	Создато массив, заполнить его случайными элементами, распечатать, перевернуть,
 * 	и снова распечатать (при переворачивании нежелательно создавать еще один массив)
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Reverse {

	public static void main(String[] args) {
		//ОБЪЯВЛЯЕМ  И  ЗАПОЛНЯЕМ  МАССИВ
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1);
		}
		
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		System.out.println("ЗАПОЛНЕННЫЙ  МАССИВ");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");
		
		//СОРТИРУЕМ  МАССИВ ОТ БОЛЬШЕГО  К  МЕНЬШЕМУ  (МЕТОДОМ  ПРЯМОГО  ВЫБОРА)
		int maxIndex=0;
		for (int i=0; i<marks.length; i++) {
			maxIndex=i;
			for (int j=i; j<marks.length; j++) {
				if (marks[maxIndex] < marks[j]) {
					maxIndex = j;
				}
			}
			int temp = marks[maxIndex];
			marks[maxIndex] = marks[i];
			marks[i] = temp;			
		}
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		System.out.println("ОТСОРТИРОВАННЫЙ  МАССИВ");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");

		//МЕНЯЕМ  В  МАССИВЕ  МЕСТАМИ ЭЛЕМЕНТЫ
		int j=0, temp=0; 
		int count=0;
		for (int i=0; i<(int)(marks.length/2); i++) {
			count++;
			j=marks.length-1-i;
			temp = marks[i];
			marks[i] = marks[j];
			marks[j] = temp;
			
		}
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		System.out.println("РАЗВЕРНУТЫЙ  МАССИВ");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");
		System.out.println("count-"+count);
	}

}
