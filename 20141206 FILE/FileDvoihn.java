/*	
 * 	ЗАДАНИЕ № 32  		FileDvoihn
 * 	09.12.2014
 * 	
 * 	Записать двоичный файл 20 случайных чисел.   
 * 	Прочитать записанный файл, 
 * 	распечатать числа и их среднее арифметическое
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.*;
import java.util.*;

public class FileDvoihn {

	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		String nameFile = "hello.txt";
		//Пишем в файл
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nameFile)));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
		List<Integer> linkedList = new LinkedList<Integer>();
		
		int count=20, item=0;		
		for (int i=0; i < count; i++) {
			try {
				item=GetRandomItem(1, 99);
				linkedList.add(item); //Добавляем значение числа в массив LinkedList
				dos.writeInt(item);
			} catch (Exception e) {
				System.out.println("I cant write to file: "+nameFile);
				return;
			}
		}
				
		try {
			dos.close();
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
			return;
		}
		System.out.println("LinkedListWrite "+linkedList.size()+" items:\t"+linkedList);
		System.out.println("I write to file: "+nameFile+" ("+count+") items");
		
		//Читаем файл
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(nameFile));
		} catch (Exception e) {
			System.out.println("File Not Found: "+nameFile);
			return;			
		}
		
		int sum=0;
		List<Integer> linkedListNew = new LinkedList<Integer>();
		try {
			int res = 0;
			while (true) {
				try {
					res = dis.readInt();
					sum+=res;
					linkedListNew.add(res);
				} catch (EOFException e) {
					break;
				}				
			}
			if (dis != null) dis.close(); //Закрываем файл
		} catch (Exception e) {
			System.out.println("I can't read file: "+nameFile);
			return;				
		}
		
		/*
		try {
			dis.close();
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
			return;
		}
		*/
		
		System.out.println("LinkedListRead "+linkedListNew.size()+" items:\t"+linkedListNew);
		System.out.println("Сумма "+count+" элементов = "+sum);
		System.out.println("Среднее арифметическое ("+sum+"/"+count+" = "+(double)sum/count+")");
	}
}
