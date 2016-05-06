/*	
 * 	ЗАДАНИЕ № 23  		Bankomat	для	класса - Bank
 * 	25.11.2014
 * 	
 * 	Создать класс и объекты описывающие Банкомат. 
 * 	Набор купюр находящихся в банкомате должен задаваться тремя свойствами: 
 * 	количеством купюр номиналом 20, 50, 100. 
 * 	1. Сделать методы для добавления денег в банкомат. 
 * 	2. Сделать функцию снимающую деньги. 
 * 	3. На вход передается сумма денег. 
 * 	4. На выход - булевское значение (операция удалась или нет). 
 * 	5. При снятии денег функция должна рапечатывать каким количеством купюр какого номинала выдается сумма. 
 * 	6. Создать конструктор с тремя параметрами - количеством купюр. Прочее - на ваше усмотрение.
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Bankomat {
	public int AllMoney=0;
	public int Money20=0;
	public int Money50=0;
	public int Money100=0;
	
	/**
	 * Конструктор по умолчанию
	 */
	public Bankomat() {
		this.Money20 = 200;
		this.Money50 = 200;
		this.Money100 = 200;
		SumAllMoney();
	}
	
	/**
	 * Конструктор с параметрами
	 */
	public Bankomat(int m20, int m50, int m100) {
		this.Money20 = m20;
		this.Money50 = m50;
		this.Money100 = m100;
		SumAllMoney();
	}
	
	/**
	 * Процедура суммирования общего количиства денег в банке 
	 */
	public void SumAllMoney() {
		AllMoney=((Money20*20)+(Money50*50)+(Money100*100));
	}
	
	/**
	 * Процедура показывающая сколько в банкомате денег 
	 */
	public int GetAllMoney() {
		return AllMoney;
	}

	
	/**
	 * Показать кол-во денег в банкомате  
	 */
	public String GetCash() {
		String rezult="";
		rezult="В БАНКОМАТЕ: "+(AllMoney+" условных денег, т.е. (20-чек)-"+Money20+" шт. (50-чек)-"+Money50+" шт. (100-чек)-"+Money100+" шт.");
		return rezult;
	}
	
	public void PrintCash() {
		System.out.println('\t'+GetCash());
	}
	
	/**
	 * Процедура снятия денег
	 */
	public int WithdrawMoney(int ClientMoney) {
		int rezult=-1;
		if (ClientMoney<=AllMoney) {
			int zn=0;			
			int flag=0;
			zn=ClientMoney%20;
			if (zn==0) flag=20;
			if (flag==0) { zn=ClientMoney%40; if (zn==0) flag=40; }
			if (flag==0) { zn=ClientMoney%50; if (zn==0) flag=50; }
			if (flag==0) { zn=ClientMoney%60; if (zn==0) flag=60; }
			if (flag==0) { zn=ClientMoney%70; if (zn==0) flag=70; }
			if (flag==0) { zn=ClientMoney%80; if (zn==0) flag=50; }
			if (flag==0) { zn=ClientMoney%90; if (zn==0) flag=90; }
			if (flag==0) { zn=ClientMoney%100; if (zn==0) flag=100; }														
			if (flag>0) {
				//System.out.println("\tОстаток от деленея на %"+flag+"="+zn);
				if (ClientMoney>110) {
					if (Money50 > Money100) {
						while (ClientMoney > 110) { 
							if (Money50 > 0) { 
								Money50--; ClientMoney-=50; SumAllMoney(); 
							} else break; 
						}
					} else if (Money100 > Money50) {
						while (ClientMoney > 110) { 
							if (Money100 > 0) { 
								Money100--; ClientMoney-=100;  SumAllMoney(); 
							} else break; 
						}						
					} else if (Money100 == Money50) {
						while (ClientMoney > 110) { 
							if (Money100 > 0) { 
								Money100--; ClientMoney-=100;  SumAllMoney();
							} else break; 
						}						
					}
				}
				if ((ClientMoney==20) && (Money20>0)) { Money20--; ClientMoney-=20; SumAllMoney(); }
				if ((ClientMoney==40) && (Money20>1)) { Money20-=2; ClientMoney-=40; SumAllMoney(); } 
				if ((ClientMoney==50) && (Money50>0)) { Money50--; ClientMoney-=50; SumAllMoney(); }
				if ((ClientMoney==60) && (Money20>2)) { Money20-=3; ClientMoney-=60;  SumAllMoney(); }
				if ((ClientMoney==70) && (Money20>0) && (Money50>0)) { Money20--; Money50--; ClientMoney-=70; SumAllMoney(); }
				if ((ClientMoney==80) && (Money20>3)) { Money20-=4;  ClientMoney-=80;  SumAllMoney(); }
				if ((ClientMoney==90) && (Money20>1) && (Money50>0)) { Money20-=2; Money50--; ClientMoney-=90; SumAllMoney(); }
				if ((ClientMoney==100) && (Money100>0)) { Money100--; ClientMoney-=100; SumAllMoney(); }
				if ((ClientMoney==110) && (Money20>2) && (Money50>0)) { Money20-=3; Money50--; ClientMoney-=110;  SumAllMoney(); }
				
				
				/*
				if (ClienMoney<=110) {
					if ((ClientMoney==20) && (Money20>0)) Money20--;
					if ((ClientMoney==40) && (Money20>1)) Money20-=2; 
					if ((ClientMoney==50) && (Money50>0)) Money50--;
					if ((ClientMoney==60) && (Money20>2)) Money20-=3;
					if ((ClientMoney==70) && (Money20>0) && (Money50>0)) { Money20--; Money50--; }
					if ((ClientMoney==80) && (Money20>3)) Money20-=4;
					if ((ClientMoney==90) && (Money20>1) && (Money50>0)) { Money20-=2; Money50--; }
					if ((ClientMoney==100) && (Money100>0)) Money100--;
					if ((ClientMoney==110) && (Money20>2) && (Money50>0)) { Money20-=3; Money50--; }
				}
				
				if (ClientMoney>110) {
					if (Money50 > Money100) {
						while (ClientMoney < 110) Money50--;
					} else if (Money100 > Money50) {
						
					} else if (Money100 == Money50) {
						
					}
					
					if ((ClientMoney==120) && (Money20>0) && (Money100>0)) { Money20--; Money100--; }
					if ((ClientMoney==130) && (Money20>3) && (Money50>0)) { Money20-=4; Money50--; }
					if ((ClientMoney==140) && (Money20>1) && (Money100>0)) { Money20-=2; Money100--; }
					
					if ((ClientMoney==200) && (Money100>1)) { Money100-=2; }
					if ((ClientMoney==300) && (Money100>2)) { Money100-=3; }
					
					if ((ClientMoney==150) && (Money50>0) && (Money100>0)) { Money50--; Money100--; }
					if ((ClientMoney==250) && (Money50>0) && (Money100>1)) { Money50--; Money100-=2; }
				}
				
				AllMoney=AllMoney-ClientMoney;
				*/
				rezult=0; 
			} else {
				return 1;
			}
		} else {
			rezult=-1; //В банке недостаточно денег
		}
		return rezult;
	}
	
}
