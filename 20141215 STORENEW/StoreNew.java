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


public class StoreNew {

	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		List<CustomNew> arrayCustom = new ArrayList<CustomNew>();
		String [] masCustom = {"ИВАН", "АРТЕМ", "АЛИНА", "ВАСИЛИЙ", "ИГОРЬ", "НИНА", "КОЛЯ", "ОЛЯ", "ЛЕНА", "РОМА", "МАКСИМ", "НАСТЯ", "ЛАРИСА", "ЗОЯ", "ЛЕША", "ГЕНА", "АЛИСА", "ВОВА"};
		
		String [] masProd = {"Бананы", "Апельсины", "Молоко", "Хлеб", "Макароны", "Рис", "Гречка", "Квас", "Хурма", "Кофе", "Печенье", "Яйца", "Капуста", "Конфеты", "Ананнасы", "Яблоки", "Джем", "Сыр", "Водка", "Шампанское"};
		String [] masPrice = {"11000", "15000", "12000", "11500", "15000", "16000", "17000", "10000", "20000", "100000", "15000", "16000", "12000", "120000", "30000", "7000", "60000", "95000", "75000", "100000"};
		String [] masMeasure = {"1 кило.", "1 кило.", "1 литр", "1 буханка", "500 грамм", "1 кило.", "1 кило.", "1,5 литра", "1 кило.", "500 грамм", "1 пачка", "1 десяток", "1 кило.", "1 кило.", "1 кило.", "1 кило.", "1 банка", "1 кило.", "1 бутылка","1 бутылка"};
		int item=0, itemProd=0;
		String nameCustom="", nameProd="", priceProd="", measureProd="";
		int countProd=0;
		String nameFile="StoreNew.txt";
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
		
		int all = masCustom.length; //всего покупателей
		
		int minCountPurchase=3; //кол-во минимальных покупок
		//Инициализируем массив покупателей
		String [][] arrayCustomProd = null;
		for (int i=0; i < masCustom.length; i++) {
			item=GetRandomItem(i,(masCustom.length-i)); //Случайный ПОКУПАТЕЛЬ из массива (т.е. ИМЯ)
			nameCustom=masCustom[item]; //Взяли ИМЯ  ПОКУПАТЕЛЯ
			//Операции перестановки что бы не повторялись значения ПОКУПАТЕЛЕЙ
			masCustom[item]=masCustom[i];
			masCustom[i]=nameCustom;
			
			//Берем кол-во продуктов которые купит покупатель
			countProd=GetRandomItem(minCountPurchase,(masProd.length-minCountPurchase));
			//Инициализация массива новых значений
			arrayCustomProd = null;
			arrayCustomProd = new String [countProd][4];			
			for (int j=0; j < countProd; j++) {
				itemProd=GetRandomItem(j,(masProd.length-j)); //ВЫБИРАЕМ ЭЛЕМЕНТ В КОТОРОМ ХРАНИТСЯ НАЗВАНИЕ ПРОДУКТА 	
				nameProd=masProd[itemProd];			//Наименование продукта
				priceProd=masPrice[itemProd];  		//Цена продукта
				measureProd=masMeasure[itemProd];  	//Еденица измерения продукта
				
				//Операции перестановки что бы не повторялись значения ПОКУПОК
				masProd[itemProd]=masProd[j];
				masProd[j]=nameProd;
				
				//Операции перестановки что бы не повторялись значения ЦЕНЫ
				masPrice[itemProd]=masPrice[j];
				masPrice[j]=priceProd;

				//Операции перестановки что бы не повторялись значения ЕДЕНИЦЫ ИЗМЕРЕНИЯ
				masMeasure[itemProd]=masMeasure[j];
				masMeasure[j]=measureProd;
				
				arrayCustomProd[j][0]=GetRandomItem(1,masProd.length)+""; 	//Заносим кол-во ПРОДУКТА одного наименования
				arrayCustomProd[j][1]=nameProd; 	//Заносим НАИМЕНОВАНИЕ ПРОДУКТА 
				arrayCustomProd[j][2]=priceProd; 	//Заносим ЦЕНУ ПРОДУКТА в бел.руб 
				arrayCustomProd[j][3]=measureProd; 	//Заносим ЕДЕНИЦУ  ПРОДУКТА						
			}
			arrayCustom.add(new CustomNew(all, nameCustom, arrayCustomProd, pw, lock)); //Добавляем в массив случайные значения кораблей с их грузом и массой
		}
		
		int countCass=5;
		ExecutorService pool = Executors.newFixedThreadPool(countCass);		

		int pnc=0; //порядковый номер КАССЫ
		//Запуск Потоков Покупателей с указанием терминалов		
		for (int i=0; i<arrayCustom.size(); i++) {
			arrayCustom.get(i).setNpp(i+1);
			pnc++; //порядковый номер кассы
			arrayCustom.get(i).setTerminal(pnc);
			if (pnc == countCass) pnc=0; //Если равно кол-ву касс новый клиент пойдет опять в 1-ю кассу
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
