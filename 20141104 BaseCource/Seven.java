/*	
 * 	ЗАДАНИЕ № 3		Seven
 * 	08.11.2014
 * 	Создайте число. Определите, является ли последняя цифра числа семеркой.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Seven {

	public static void Proc(int i) { 
		String rezult;
		rezult="Number "+i+"   - ";
		if (i>=0) {
			if (((i+3)%10) ==0 ) rezult=rezult+"ended on 7  (true)";
			else rezult=rezult+" not ended on 7   (false)";
		} else {
			if (((i-3)%10) ==0 ) rezult=rezult+"ended on 7   (true)";
			else rezult=rezult+" not ended on 7  (false)";		
		}
		System.out.println("   "+rezult);
	}

	public static void main(String[] args) { 
		System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		System.out.println("   ***      SEVEN  OR  NOT       ***"+'\n');				
		
		int i=0;
		i=7; Proc(i);
		i=25; Proc(i);
		i=97; Proc(i);
		i=3287; Proc(i);
		i=9854; Proc(i);
		i=-7; Proc(i);
		i=-3258; Proc(i);
		
		System.out.println('\n'+"   ***       End Of Program      ***");
	}

}