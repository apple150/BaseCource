/*
 *	ЗАДАНИЕ № 2		Time
 *	06.11.2014 
 *	Продолжите приведенный пример, добавьте расчет и вывод суток и недель 
 * 	Определение часов минут секунд по одному большому числовому значению
 *  
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/


public class Time {

	//Процедура вывода результата
	public static void ProcOut(int item, int week, int day, int h, int min, int sec) {
		String rezult="";
		if (item!=0) rezult=rezult+item+" = ";
		if (week!=0) rezult=rezult+week+" week ";
		if (day!=0) rezult=rezult+day+" day  ";
		if (h!=0) rezult=rezult+h+" hour ";
		if (min!=0) rezult=rezult+min+" min  ";
		if (sec!=0) rezult=rezult+sec+" sec ";
		System.out.println("   "+rezult);
	}
	
	//Логика расчета времени в этой процедуре
	public static void Proc(int tm) {
		int sec, min, hour, day, week=0; // Основные переменные
		int m, d, w=0; //Дополнительные переменые
		
			sec = tm % 60; 	// Остаток СЕКУНД после деления на 60
		m = (tm - sec) / 60; // Целое количество МИНУТ
			min = m % 60; 	// Остаток  МИНУТ после деления на 60
		d = (m - min) / 60; // Целое количество ЧАСОВ
			hour = d%24; 	// Остаток ЧАСОВ после деления на 24
		w = (d-hour)/24; 	// Целое количество ДНЕЙ
			day = w%7; 		// Остаток ДНЕЙ после деления на 7 (т.е после недели)
		week = (w-day)/7; 	// Целое количество НЕДЕЛЬ		
		
		ProcOut(tm, week, day, hour, min, sec); // Выводит результат
	}

	public static void main(String[] args) { 
		//System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		//System.out.println("   ***           TIME            ***"+'\n');		
	
		int tm = 0;
		tm = 3662;    Proc(tm);		
		tm = 370000;  Proc(tm);		
		tm = 604800;  Proc(tm); // ровно 1 неделя		
		tm = 604801;  Proc(tm); // ровно 1 неделя 1 секунда
		tm = 604861;  Proc(tm); // ровно 1 неделя 1 минута 1 секунда
		tm = 608461;  Proc(tm); // ровно 1 неделя 1 час 1 минута 1 секунда
		tm = 694861;  Proc(tm); // ровно 1 неделя 1 день 1 час 1 минута 1 секунда
		tm = 3024000; Proc(tm); //ровно 5 недель		
		tm = 4233600; Proc(tm); //ровно 7 недель		
		tm = 5245890; Proc(tm);				
					
		//System.out.println('\n'+"   ***       End Of Program      ***");
	}
}
