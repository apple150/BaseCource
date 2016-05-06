/*	
 * 	ЗАДАНИЕ № 2			Radian 	(Дополнительное задание)
 * 	06.11.2014
 * 	Определение градуса минуты секунды по радиану
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Radian {

	//Процедура вывода результата
	public static void ProcOut(double rad, int grad, int min, int sec) {
		System.out.println("   "+rad+" rad  =  "+grad+"gr "+min+"' "+sec+"\"");
	}

	//Процедура расчета градусов минут и секунд
	public static int Proc(int i, double pi, double item) {
		int rezult=0;		
		if (i==1) rezult=(int)(item/(pi/180));  		// Градусы
		if (i==2) rezult=(int)(item/(pi/(180*60))); 	// Минуты
		if (i==3) rezult=(int)(item/(pi/(180*60*60))); 	// Секунды
		return rezult;
	}
	
	//Процедура ОСНОВНАЯ для разложения РАДИАНА на градусы минуты и секунды
	public static void ExpandRadian(double rad) {
		double pi=3.14159; 		// Число ПИ		
		double dop=0.0;    		// Дополнительная переменная
		int grad, min, sec;		// Значения градуса, минуты секунды 
						
		//double rad=1.0; // Значение радиана		
		grad=0; min=0; sec=0;
		grad=Proc(1, pi, rad); // Градусы
			dop=(rad%(pi/180));
		min=Proc(2, pi, dop);  // Минуты
			dop=(rad%(pi/(180*60)));
		sec=Proc(3, pi, dop); // Секунды		
			ProcOut(rad, grad, min, sec); //Процедура вывода результата		
	}
	
	public static void main(String[] args) {
		System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		System.out.println("   ***          RADIAN           ***");
		System.out.println("   ***  1 rad  =  57gr 17' 45''  ***"+'\n');				
		
		double rad=0.0; // Значение радиана		
		rad=1.0; 		ExpandRadian(rad);
		rad=1.87548; 	ExpandRadian(rad);
		rad=5.35848; 	ExpandRadian(rad);
		rad=23.4253458; ExpandRadian(rad);
		
		System.out.println('\n'+"   ***       End Of Program      ***");
	}
}