/*	
 * 	ЗАДАНИЕ № 22  		ClassTime
 * 	25.11.2014
 * 	Создать класс и объекты описывающие промежуток времени. саойства класса Часы, Минуты, Секунды
 * 	Сделать метод сравнения двух объектов этого класса
 * 	Сделать 2 коструктора (получающий кол-во минут и часы минуты секунды отдельно) 	
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class ClassTime {

	public int hour=0; //Часы
	public int min=0;  //Минуты
	public int sec=0;  //Секунды

	//Конструктор по умолчанию
	public ClassTime() {
		/*
		this.hour = (int) (Math.random() * 23) ;
		this.min = (int) (Math.random() * 59) ;
		this.sec = (int) (Math.random() * 59) ;
		*/
		this.hour = GetRandomItem(0,23); 	// Часы
		this.min = GetRandomItem(0,59); 	// Минуты
		this.sec = GetRandomItem(0,59); 	// Секунды
	}
	
	//Конструктор получающий секуды большим числом
	public ClassTime(int tm) {
		int m, h; // Основные переменные		
			sec = tm % 60; 	// Остаток СЕКУНД после деления на 60
		m = (tm - sec) / 60; // Целое количество МИНУТ
			min = m % 60; 	// Остаток  МИНУТ после деления на 60
		h = (m - min) / 60; // Целое количество ЧАСОВ
			hour = h%24; 	// Остаток ЧАСОВ после деления на 24
	}
	
	//Конструктор получающий секуды часы, минуты, секунды
	public ClassTime(int hour, int min, int sec) {
		this.hour=hour;
		this.min=min;
		this.sec=sec;
	}
	
	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	public int GetRandomItem(int IntervalOt, int IntervalDo) {
		int rezult=0;
		rezult=(int) (Math.random() * IntervalDo + IntervalOt) ;
		return rezult;
	}
	
	public int getHour() {
		return this.hour;
	}

	public int getMin() {
		return this.min;
	}
	
	public int getSec() {
		return this.sec;
	}
	
	/**
	 * Возвращает значение отформатированное до 2-х символов
	 */
	public String getIntToString2(int item) {
		String rezult=item+"";
		if (item < 10) rezult="0"+item;
		return rezult;
	}
	
	
	/**
	 *	Процедура сравнения возвращает INT (-1, 0, 1)
	 */
	public int compareToReturnInt(ClassTime item) {
		int rezult=-1;
		if (this.hour>item.hour) rezult=1;
		else if (this.hour == item.hour) {
			if (this.min>item.min) rezult=1;
			else if (this.min == item.min) {
				if (this.sec>item.sec) rezult=1;
				else if (this.sec == item.sec) {
					rezult=0;
				}				
			}			
		}
		return rezult; 
	}

	/**
	 *	Процедура сравнения возвращает STRING  
	 */
	public String compareToReturnString(ClassTime item, String c1, String c2) {
		String rezult=c1+" < "+c2;
		if (this.hour>item.hour) rezult=c1+" > "+c2;
		else if (this.hour == item.hour) {
			if (this.min>item.min) rezult=c1+" > "+c2;
			else if (this.min == item.min) {
				if (this.sec>item.sec) rezult=c1+" > "+c2;
				else if (this.sec == item.sec) {
					rezult=c1+" = "+c2+" BINGO !!!";
				}				
			}			
		}
		return rezult; 
	}
	
	
	//вывод результатов
	public void Print(String st) {
		System.out.println(st+" -  hour: "+hour+",  min: "+min+",  sec: "+sec);
	}
	
	public void Print1(String st) {
		System.out.println(st+" - "+hour+":"+min+":"+sec);
	}

	/**
	 *	Получить сравниетельный отчет по 2-ум объектам 
	 */
	public String GetFullReport(ClassTime item, String c1, String c2) {
		String rezult="";
		//System.out.println(c1+" - "+this.hour+":"+this.min+":"+this.sec+"\t"+c2+" - "+item.hour+":"+item.min+":"+item.sec+"\t"+compareToReturnString(item,c1,c2));
		//rezult=c1+" - "+this.hour+":"+this.min+":"+this.sec+"\t"+c2+" - "+item.hour+":"+item.min+":"+item.sec+"\t"+compareToReturnString(item,c1,c2);
		rezult=GetTimeFormat(this, c1)+'\t'+GetTimeFormat(item, c2)+'\t'+compareToReturnString(item,c1,c2);
		return rezult;
	}
	
	//процедура отдающая время в строке формата (часы минуты секунды)
	public String GetTime(String st) {
		String temp="";
		temp=st+" - "+hour+":"+min+":"+sec;
		return temp;
	}

	/**
	 * Процедура отдающая время в строке формата (часы минуты секунды) полноформатное
	 * @param item
	 * @param st
	 * @return
	 */
	public String GetTimeFormat(ClassTime item, String st) {
		String temp="";
		temp=st+" - "+getIntToString2(item.hour)+":"+getIntToString2(item.min)+":"+getIntToString2(item.sec);
		return temp;
	}
	
}
