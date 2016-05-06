/*	
 * 	ЗАДАНИЕ № 6  		Углубленный уровень		Calc
 * 	22.12.2014
 * 	Создать простейший калькулятор на основе шаблона COMMAND
 * 	Объект логгера должен быть создан с помощью ШП Singleton.
 * 	 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.Console;

public class Calc {

	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	public static int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		int count=100; //Кол-во операций
		MySingle ms = MySingle.GetMySingle(); //2-го объекта создать не получится
		ms.OpenFile();
		 
		Command cd = null;
		int zn=0;
		for (int i=0; i < count; i++) {			
			zn=GetRandomItem(0, 4);
			switch (zn) {
				case 0:  cd=new Addition(GetRandomItem(1,10), GetRandomItem(1,10)); break;
				case 1:  cd=new Subtraction(GetRandomItem(1,10), GetRandomItem(1,10)); break;
				case 2:  cd=new Multiplication(GetRandomItem(1,10), GetRandomItem(1,10)); break;
				case 3:  cd=new Division(GetRandomItem(1,10), GetRandomItem(1,10)); break;				
			}
			cd.execute(ms);
			cd=null;
		}
		ms.CloseFile();
		
		/*
		Command cd = null; 
		cd = new Plus();  cd.execute();
		cd = new Minus(); cd.execute();
		Console con = null;
		con = System.console();
		System.out.println(con);
		try {
			if (con != null) {
				String i = ""; 
				con.readLine("Введите значение 1: ");
				System.out.println(i);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
	}
}
