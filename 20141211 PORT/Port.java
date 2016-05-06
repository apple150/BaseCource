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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Port {
	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {		
		List<Ship> arrayShip = new ArrayList<Ship>();
		String [] mas = {"VICTORIA", "BRITANIA", "COLUMBIA", "ATLANTIC", "PILIGRIM", "NAUTILUS", "A.LINKOLN", "DRESDEN", "INVISIBLE", "INFLEXIBLE", "SIDNEY", "SHARNHORST", "GNEYSENAU", "NASSAU", "GOOD HOPE", "UTLANDIA", "GLASGOW", "ORLANDO"};
		String [] masProd = {"Oranges", "Banana", "Oil", "Gasoil", "Wood", "Coal", "Paper", "Limon", "Iron", "Auto", "Grapes", "Plastic", "Equipment", "Granite", "Sand", "Animals", "Balast", "Dimonds"};
		int item=0, itemProd=0;
		String temp="", tempProd="";
		String nameFile="Port.txt";
		File fl = new File(nameFile);
		PrintWriter pw=null;
		
		//Открываем файл
		try {
			pw = new PrintWriter(fl);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
		
		//Инициализируем массив кораблей
		for (int i=0; i<mas.length; i++) {
			//System.out.println(i);
			item=GetRandomItem(i,(mas.length-i));
			itemProd=GetRandomItem(i,(masProd.length-i));
			
			temp=mas[item];
			tempProd=masProd[itemProd];
			arrayShip.add(new Ship(temp, tempProd, GetRandomItem(30, 101), pw)); //Добавляем в массив случайные значения кораблей с их грузом и массой
			
			//Операции для того чтобы неповторялись значения массива
			mas[item]=mas[i];
			mas[i]=temp;
			
			masProd[itemProd]=masProd[i];
			masProd[i]=tempProd;
		}
		
		//Запуск Потоков Кораблей с указанием терминалов		
		for (int i=0; i<arrayShip.size(); i++) {
			arrayShip.get(i).setNpp(i+1);			
			//arrayShip.get(i).setTerminal(1);			
			arrayShip.get(i).start();			
		}
		
		//Запуск ожидания окончания потока main-ом
		for (int i=0; i<arrayShip.size(); i++) {
			try {
				arrayShip.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Закрываем файл
		try {
			pw.close();
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
		}		
	}
}
