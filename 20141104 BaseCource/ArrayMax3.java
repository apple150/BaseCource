/*	
 * 	ЗАДАНИЕ № 15		ArrayMax3
 * 	15.11.2014
 * 	Определите максимальный элемент в массиве, затем 2-ое по величине значение 
 * 	и 3-е по величине значение, за 1 проход. 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class ArrayMax3 {

	public static void main(String[] args) {
		//ОБЪЯВЛЯЕМ  И  ЗАПОЛНЯЕМ  МАССИВ
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1); //Случайные значения в диапазоне от 1 до 10
		}
		
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		System.out.print("SET  ARRAY: ");
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
		System.out.print("SORT ARRAY: ");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");		
		
		//ПОИСК  НЕОБХОДИМЫХ  ЗНАЧЕНИЙ 1-ый вариант  (ОТСОРТИРОВАННЫЙ  МАССИВ  НЕ  ТРЕБУЕТСЯ)
		int first=0, second=0, third=0;
		for (int i=0; i<marks.length; i++) {
			if (marks[i]>=first) first=marks[i];
			else if (marks[i]>=second) second=marks[i]; 
			else if (marks[i]>=third) third=marks[i];			
		}
		System.out.println("First-"+first+", Second-"+second+", Third-"+third);
		
		//ПОИСК  НЕОБХОДИМЫХ  ЗНАЧЕНИЙ 2-ой вариант  (НЕОБХОДИМ  ОТСОРТИРОВАННЫЙ МАССИВ)
		int item=0;
		int count=0;
		for (int i=0; i<marks.length; i++) {
			if (item!=marks[i]) {
					count++;
				item=marks[i];
				if (i==0) System.out.print("item_"+count+"-"+item);
				else System.out.print(", item_"+count+"-"+item);
					if (count==3) break;
			}
		}		
	}

}
