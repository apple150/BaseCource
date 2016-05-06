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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Store {

	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		List<Custom> arrayCustom = new ArrayList<Custom>();
		String [] masCustom = {"ИВАН", "АРТЕМ", "АЛИНА", "ВАСИЛИЙ", "ИГОРЬ", "НИНА", "КОЛЯ", "ОЛЯ", "ЛЕНА", "РОМА", "МАКСИМ", "НАСТЯ", "ЛАРИСА", "ЗОЯ", "ЛЕША", "ГЕНА", "АЛИСА", "ВОВА"};
		String [] masProd = {"Бананы", "Апельсины", "Молоко", "Хлеб", "Макароны", "Рис", "Гречка", "Квас", "Хурма", "Кофе", "Печенье", "Яйца", "Капуста", "Конфеты", "Ананнасы", "Яблоки", "Джем", "Сыр"};
		int item=0, itemProd=0;
		String nameCustom="", nameProd="";		
		String nameFile="Store.txt";
		File fl = new File(nameFile);
		PrintWriter pw=null;
		Lock lock = null;
		
		//Открываем файл
		try {
			pw = new PrintWriter(fl);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
		
		lock = new ReentrantLock();  
		
		//Инициализируем массив покупателей
		for (int i=0; i < masCustom.length; i++) {
			item=GetRandomItem(i,(masCustom.length-i));
			itemProd=GetRandomItem(i,(masProd.length-i));
			
			nameCustom=masCustom[item];
			nameProd=masProd[itemProd];
			arrayCustom.add(new Custom(nameCustom, nameProd, GetRandomItem(5, 30), pw, lock)); //Добавляем в массив случайные значения кораблей с их грузом и массой
			
			//Операции для того чтобы неповторялись значения массива
			masCustom[item]=masCustom[i];
			masCustom[i]=nameCustom;
			
			masProd[itemProd]=masProd[i];
			masProd[i]=nameProd;
		}
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		//Запуск Потоков Покупателей с указанием терминалов		
		for (int i=0; i<arrayCustom.size(); i++) {
			arrayCustom.get(i).setNpp(i+1);
			arrayCustom.get(i).setTerminal(1);
			pool.execute(arrayCustom.get(i));			
		}
		
		//Запуск ожидания окончания потока main-ом
		pool.shutdown(); //Ожидает окончания запущенных потоков
		

		try {
			pool.awaitTermination(2, TimeUnit.SECONDS); //Аналог join()
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		
		//Закрываем файл
		try {
			pw.close();
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
		}
	}
}
