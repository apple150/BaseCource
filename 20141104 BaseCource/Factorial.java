/*	
 * 	ЗАДАНИЕ № 8		Factorial
 * 	11.11.2014
 * 	Изменить пример с суммой чисел таким образом,
 * 	чтобы рассчитывалась не сумма, а произведение, т.е. ФАКТОРИАЛ числа.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Factorial {

	//процедура анализа и вывода результатов
	public static void Proc(int f) {
		int sum = 1 ; int i = 1; 
		while (i <= f) { 
			sum = sum*i; i++;
		}
		System.out.println("Factorial "+f+"="+sum);
	
	}

	public static void main(String[] args) { 
		//System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		//System.out.println("   ***    UMNOGENIE V CIKLE      ***"+'\n');
		
		Proc(1);
		Proc(2);
		Proc(3);
		Proc(4);
		Proc(5);
		Proc(6);
		Proc(7);
		Proc(8);
		Proc(9);
		Proc(10);
		Proc(11);
		Proc(12);
		Proc(13);
		
		/*
		int sum = 1 ; int i = 1; 
		while (i <= 15) { 
			sum = sum*i; i++;
		}
		System.out.println("   "+sum);
		*/
		
		//System.out.println('\n'+"   ***       End of program      ***");
	}

}