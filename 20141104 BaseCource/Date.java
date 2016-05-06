/*
 * 	ЗАДАНИЕ № 6		Date
 * 	10.11.2014
 *	Имеются три числа — день, месяц, год. 
 *	Вывести в виде трех чисел дату следующего дня. 
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/
public class Date {
	
	//Процедура анализа даты и вывода результата
	public static void Proc(int year, int month, int day) { 		
		int yearNew=year, monthNew=month, dayNew=day, countDay=0;
				
		boolean VisokYear=false; //Флаг для проверки высокостного года
		
		if ((year%4)==0) VisokYear=true;
		
		//3-ий вариант
		if ((month==4)||(month==6)||(month==9)||(month==11)) countDay=30;
		else if ((month==2) && (VisokYear==false)) countDay=28;
		else if ((month==2) && (VisokYear==true)) countDay=29;
		else countDay=31;
		
		/*
		 //2-ой вариант
		if ((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)) countDay=31;
		else if ((month==2) && (VisokYear==false)) countDay=28;
		else if ((month==2) && (VisokYear==true)) countDay=29;		
		else if ((month==4)||(month==6)||(month==9)||(month==11)) countDay=30;
		*/
		
		
		/*
		 //1-ый вариант
		if (month==1) countDay=31;
		else if ((month==2) && (VisokYear==false)) countDay=28;
		else if ((month==2) && (VisokYear==true)) countDay=29;
		else if (month==3) countDay=31;
		else if (month==4) countDay=30;
		else if (month==5) countDay=31;
		else if (month==6) countDay=30;
		else if (month==7) countDay=31;
		else if (month==8) countDay=31;
		else if (month==9) countDay=30;
		else if (month==10) countDay=31;
		else if (month==11) countDay=30;
		else if (month==12) countDay=31;
		*/
		
		boolean flag=true;  //Флаг для проверки корректности даты
		
		if (dayNew < countDay) dayNew++;
		else if (dayNew == countDay) {			
			dayNew=1;
			if (monthNew < 12) monthNew++;
			else if (monthNew == 12) {				
				yearNew++;
			} else flag=false;
		} else flag=false;
		
		String rezult="SET: "+day+"."+month+"."+year;
		if (flag) rezult=rezult+"   GET: "+dayNew+"."+monthNew+"."+yearNew;
		else rezult=rezult+"   DATE  INCORRECT";
		System.out.println(rezult);
	}
	
	public static void main(String[] args) { 
		int year, month, day=0;
		year=2012; month=02; day=28; Proc(year, month, day);
		year=2013; month=02; day=28; Proc(year, month, day);		
		year=2014; month=11; day=10; Proc(year, month, day);
		year=2014; month=12; day=31; Proc(year, month, day);
		year=2014; month=12; day=32; Proc(year, month, day);
		year=2014; month=13; day=31; Proc(year, month, day);
		year=2075; month=12; day=05; Proc(year, month, day);
	}

}