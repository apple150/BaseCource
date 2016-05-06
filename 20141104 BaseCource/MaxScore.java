/*	
 * 	ЗАДАНИЕ № 14		MaxScore
 *	15.11.2014г.
 *	МАССИВЫ  ОДНОМЕРНЫЕ
 *	В задаче на поиск максимальной оценки, вывести не саму оценку, а ее номер.
 *
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
 */

public class MaxScore {

	public static void main(String[] args) {
		//ОБЪЯВЛЯЕМ  И  ЗАПОЛНЯЕМ  МАССИВ
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1);
		}
		
		//ВЫВОДИМ  МАССИВ  ДЛЯ  НАГЛЯДНОСТИ
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print(i+"-"+marks[i]);
			else System.out.print(", "+i+"-"+marks[i]);
		}
		System.out.println("");
		int maxMark = marks[0];
		int itemMark = 0;
		
		//НАХОДИМ  МАКСИМАЛЬНОЕ  ЗНАЧЕНИЕ  И  ЕГО  ПОРЯДКОВЫЙ  НОМЕР  В  МАССИВЕ
		for (int i=0; i<marks.length; i++) {
			if (maxMark < marks[i]) {
				maxMark = marks[i];
				itemMark = i;
			}
		}
		System.out.println("Максимальная оценка = "+maxMark+" Номер элемента = "+itemMark);
	}

}
