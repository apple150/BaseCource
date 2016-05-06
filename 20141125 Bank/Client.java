/*	
 * 	ЗАДАНИЕ № 23  		Client	для	класса - Bank
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

public class Client {
	public int summa=0; //Сумма которую хочет снять клиент
	public int minSumma=10;  //минимальная сумма которю он может снять
	public int maxSumma=300; //максимальная сумма которю он хочет снять
	
	public Client() {
		summa = GetRandomItem(minSumma,maxSumma); 	// Интервал
		int ostatok = summa%10;
		//if (ostatok > 0) summa=summa+(10-ostatok);
		if (ostatok > 0) summa=summa-ostatok;
		//if (summa > 300) summa=300; 
	}
	
	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	public int GetRandomItem(int IntervalOt, int IntervalDo) {
		int rezult=0;
		rezult=(int) (Math.random() * IntervalDo + IntervalOt) ;
		return rezult;
	}

	public String getClientCash() {
		String rezult="";
		rezult="Клиент запросил: "+summa+"\tусловных денег";
		if (summa == minSumma) rezult=rezult+" MIN";
		if (summa == maxSumma) rezult=rezult+" MAX";
		return rezult;
	}
	
	public void PrintClientCash() {
		System.out.println(getClientCash());
	}	
	
	/**
	 * Процедура получения денег 
	 */
	public int getMoney() {
		return summa;
	}		
}
