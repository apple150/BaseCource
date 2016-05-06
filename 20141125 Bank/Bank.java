/*	
 * 	ЗАДАНИЕ № 23  		Bank 	использует: Bankomat, Client
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

public class Bank {

	public static void main(String[] args) {
		Bankomat bt = new Bankomat(100, 100, 100);
		//bt.PrintCash();
		System.out.println('\t'+bt.GetCash()+'\n');
				
		int CountSuccsess=0, CountUnSuccsess=0, count=0, CountNotCupur=0; 
		int rezult=0;
		Client cl = null;
		for (int i=0; i<500; i++) {
			count++;
			cl = null; cl = new Client();			
			System.out.println((i+1)+".\t"+cl.getClientCash());
			rezult=bt.WithdrawMoney(cl.getMoney()); //Процедура вывода денег
			if (rezult == 0) {
				CountSuccsess++;
				System.out.println("\tПроцедура получения денег прошла УСПЕШНО !!!");
				bt.PrintCash();
				if (bt.GetAllMoney() < 20) break;
			} else if (rezult == 1) {
				CountNotCupur++;
				System.out.println("\tВ БАНКОМАТЕ деньги есть но запрошенную сумму выдать невозможно");
			} else if (rezult == -1) {
				CountUnSuccsess++;
				System.out.println("\tПроцедура получения денег прошла БЕЗ УСПЕШНО т.к. в банкомате НЕТ БАНКНОТ  СООТВЕТСТВУЮЩЕГО  НОМИНАЛА");
				bt.PrintCash();								
			}
		}
		System.out.println("\nБЫЛО ОБСЛУЖЕНО: \n\tУСПЕШНО:\t"+CountSuccsess+" кл. \n\tБЕЗУСПЕШНО:\t"+CountUnSuccsess+"кл. \n\tВСЕГО:\t\t"+count+" кл. \n\tНЕ БЫЛО КУПЮР:\t"+CountNotCupur+" кл.");
	}

}
