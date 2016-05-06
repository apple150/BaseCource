/*	
 * 	ЗАДАНИЕ № 11		Easy
 *	13.11.2014г.
 *	Имеется целое число, определить является ли это число простым, 
 *	т.е. делится без остатка только на 1 и себя.
 *
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
 */
//Имеется целое число, определить является ли это число простым, т.е. делится без остатка только на 1 и себя.
public class Easy {

	public static void main(String[] args) {		
		int item=107;  //проверяемое значение
		int count=0;
		if (item > 2) { 	//Если число больше 2-х
			if (item%2!=0) { 	//Если число четное
				for (int i=1; i<=item; i++) {					
					if (i%2==0) continue;
					if (item%i==0) count++; //Проверяется если делитель нечетный					
				}
			}
		}
		//System.out.println("COUNT "+count);
		if ((count==2)||(item==1)||(item==2)) System.out.println("Число "+item+" ЯВЛЯЕТСЯ ПРОСТЫМ");
		else System.out.println("Число "+item+" НЕ является простым");
	}	
}
