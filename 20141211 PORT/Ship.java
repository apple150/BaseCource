/*
 * 	ЗАДАНИЕ № 1		Углубленный уровень		Port и Ship 	
 * 	11.12.2014
 * 	Разгрузка кораблей в порту
 * 	Каждый разгружаемый корабль это поток
 * 	Кораблей должно быть не меньше 10-ти
 * 	В порту есть место для 3-х
 * 	Вывод на консоль или в файл 
 * 	Необходимо использовать функцию wait() на странице 7
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class Ship extends Thread {
	private String nameShip ="";  	//Название судна
	private String cargoName=""; 	//Название груза в условных коробках
	private int npp=0; 				//Номер по порядку
	private int cargoCount=0; 		//Количество груза в условных коробках
	private int terminal=0; 		//номер терминала
	private String aboutShip=""; 	//информация о корабле
	private boolean unloading=false; //разгрузка закончилась или нет	
	private PrintWriter pw=null; 
	public String nameFile="";
	public static int countTreads=0;
	
	
	public Ship() {
		aboutShip = getAllInformation(); 
	}
		
	public Ship(String name, String cargo, int CountCargo, PrintWriter itemFile) {
		nameShip = name;
		cargoCount = CountCargo;
		cargoName = cargo;
		aboutShip = getAllInformation();
		nameFile="hello.txt";
		pw= itemFile;
	}
	
	@Override
	public void run()  {  //Функция синхронизирована		
		synchronized (pw) {
			countTreads++;
			this.setTerminal(countTreads);
			for(int i=cargoCount; i != 0; i--) {
				try {
					pw.println(aboutShip+", Остаток: "+i);
				} catch (Exception e) {
					System.out.println("I cant write to file: "+nameFile);
				}							
			}
			//pw.println("\tВыгрузка закончена\n");
			pw.println("");
			if (countTreads==3) countTreads=0;
		}	
		//this.notify(); 
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
	public String getNameShip() {
		return nameShip;
	}

	/**
	 * Функция возвращает название груза
	 */
	public String getCargoName() {
		return cargoName;
	}
	
	/**
	 * Функция устанавливает номер терминала
	 */
	public void setTerminal(int number) {
		terminal=number;
		aboutShip = getAllInformation();
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
		rez="№: "+getNpp()+", Term: "+getTerminal()+", Ship: "+getNameShip()+", Cargo: "+getCargoName()+", Weight: "+getCountCargo();
		return rez;
	}	
}
