/*
 * 	ЗАДАНИЕ № 1		Углубленный уровень		Store и Custom 	
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

public class Custom extends Thread {
	private String nameCustom ="";  	//Название судна
	private String cargoCustom=""; 	//Название груза в условных коробках
	private int npp=0; 				//Номер по порядку
	private int cargoCount=0; 		//Количество груза в условных коробках
	private int terminal=0; 		//номер терминала
	private String aboutCustom=""; 	//информация о корабле
	private boolean unloading=false; //разгрузка закончилась или нет	
	private PrintWriter pw=null; 
	Lock lock=null;
	
	public Custom() {
		aboutCustom = getAllInformation(); 
	}
		
	public Custom(String name, String cargo, int CountCargo, PrintWriter itemFile, Lock lockItem) {
		nameCustom = name;
		cargoCount = CountCargo;
		cargoCustom = cargo;
		aboutCustom = getAllInformation();
		pw= itemFile;
		lock=lockItem;
	}
	
	@Override
	public void run()  {  //Функция синхронизирована
		lock.lock();
		for(int i=cargoCount; i != 0; i--) {
			try {
				pw.println(aboutCustom+", Остаток: "+i);
			} catch (Exception e) {
				System.out.println("I cant write to file:");
			}							
		}
		pw.println("");
		lock.unlock(); 
		setUnloading(); //Разгрузка завершена
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
	 * Функция взводит сигнальную переменную о том что разгрузка завершилась
	 */
	public void setUnloading() {
		unloading=true;
	}
	
	/**
	 * Функция возвращает сигнальную переменную о том что разгрузка завершилась
	 */
	public boolean getUnloading() {
		return unloading;
	}
	
	/**
	 * Функция возвращает кол-во груза
	 */
	public int getCountCargo() {
		return cargoCount;
	}

	/**
	 * Функция возвращает название колрабля
	 */
	public String getNameCustom() {
		return nameCustom;
	}

	/**
	 * Функция возвращает название груза
	 */
	public String getCargoName() {
		return cargoCustom;
	}
	
	/**
	 * Функция устанавливает номер терминала
	 */
	public void setTerminal(int number) {
		terminal=number;
		aboutCustom = getAllInformation();
	}
	
	/**
	 * Функция возвращает ноер термнала
	 */
	public int getTerminal() {
		return terminal;
	}
	
	/**
	 * Функция устанавливает номер терминала
	 */
	public String getAllInformation() {
		String rez="";
		rez="№: "+getNpp()+", Term: "+getTerminal()+", Ship: "+getNameCustom()+", Cargo: "+getCargoName()+", Weight: "+getCountCargo();
		return rez;
	}	
}
