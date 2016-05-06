/*
 * 	ЗАДАНИЕ № 1		Углубленный уровень		StoreNew и CustomNew 	
 * 	13.12.2014
 * 	Программа моделирующая кассы в магазине. 
 * 	Существует несколько касс, работающих одновременно
 * 	Каждый покупатель отдельный поток
 * 	Общее кол-во покупателей может быть больше чем кол-во касс
 * 	но одновременно не может обрабатываться больше покупателей
 * 	чем имеется рабочих касс.
 * 	У каждого покупателя есть набор товаров, 
 * 	которые должны быть выведены в процессе обслуживания
 * 
 * 	Вывод на консоль или в файл 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;

public class CustomNew extends Thread {
	private String nameCustom ="";  //ИМЯ ПОКУПАТЕЛЯ
	private int npp=0; 				//НОМЕР по порядку
	private int terminal=0; 		//НОМЕР терминала
	private int allCustom=0;        //всего покупателей		
		
	private PrintWriter pw=null;	
	Lock lock=null;
	String [][] purchase = null;
	
	public static int MaxSum=0; //Максималдьная потраченная сумма
	public static String NameCustomMaxSum=""; //Максималдьная потраченная сумма
	private static int sumCustom=0; //для окончательно вывода максимальной суммы конкретным покупателем
	private static int countProd=0; //кол-во продуктов
	
	
	public CustomNew(int all, String name, String [][] mas, PrintWriter itemFile, Lock lockItem) {
		nameCustom = name;		
		pw= itemFile;
		purchase = mas;
		lock=lockItem;
		allCustom = all; //всего покупателей
	}
	
	@Override
	public void run()  {  //Функция синхронизирована
		lock.lock(); //БЛОКИРОВКА		
		sumCustom++;
		int count=0, sum=0;
		
		String aboutCustom="";
		for(int i=0; i < purchase.length; i++) {						
			count=Integer.parseInt(purchase[i][0]);
			for (int j=0; j < count; j++) {
				sum+=Integer.parseInt(purchase[i][2]);
				aboutCustom="№: "+getNpp()+", Касса: "+getTerminal()+", Покупатель: "+nameCustom+"\t Продукт: "+purchase[i][1]+"\t Стоимость: "+purchase[i][2]+"\t Еденица изм.: "+purchase[i][3];
				try {
					pw.println(aboutCustom);
				} catch (Exception e) {
					System.out.println("I cant write to file:");
				}															
			}				
		}
		
		if (sum > MaxSum) {
			MaxSum = sum;
			NameCustomMaxSum = "Покупатель: "+nameCustom+", Касса: "+getTerminal()+", №: "+getNpp();
			countProd=purchase.length;
		}
		
		try {
			pw.println("*****  Покупатель: "+nameCustom+" потратил: "+sum+" бел.рубл.  *****\n");
		} catch (Exception e) {
			System.out.println("I cant write to file:");
		}
		
		if (sumCustom == allCustom) {
			try {
				pw.println("Из "+allCustom+" покупателей максимально потратил: "+NameCustomMaxSum+", Cумма: "+MaxSum+" (общее кол-во продуктов - "+countProd+")");
			} catch (Exception e) {
				System.out.println("I cant write to file:");
			}				
		}		
		lock.unlock(); //РАЗБЛОКИРОВКА 
	}

	/**
	 * Функция записи номера по прядку запущенного потока
	 */
	public void setNpp(int i) {
		npp=i;
	}
	
	/**
	 * Функция полкчить номер по прядку запущенного потока
	 */
	public int getNpp() {
		return npp;
	}
		
	/**
	 * Функция возвращает название колрабля
	 */
	public String getNameCustom() {
		return nameCustom;
	}

	/**
	 * Функция возвращает ноер термнала
	 */
	public int getTerminal() {
		return terminal;
	}
	
	/**
	 * Функция устанавливает номер термнала
	 */
	public void setTerminal(int i) {
		terminal = i;
	}
}
