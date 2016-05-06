/*	
 * 	ЗАДАНИЕ № 30  		CountWords
 * 	06.12.2014
 * 	
 * 	Создать файл с текстом, прочитать, 
 * 	подсчитать в тексте кол-во знаков препинания и слов.
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountWords {

	/**
	 * Проверка строки на точки запятые т.е. на знаки препинания 
	 */
	public static boolean AnalizLetter(char c) {
		boolean flag=false;
		if ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='а' && c<='я') || (c>='А' && c<='Я')) flag=true;
		return flag;
	}
	
	/**
	 * Анализ на знак препинания 
	 */	
	public static boolean AnalizSymbols(char c) {
		String symbols=",.!?;:";  //запятая может иметь ASCII код 32 и 44 (44 видимая, 32 не видимая, но в Internet они именно 32)
		boolean flag=false;
		for (int i=0; i < symbols.length(); i++) {
			//System.out.println("c-"+c+" ASCI-"+(int)c+"   -   "+symbols.charAt(i)+" "+(int)symbols.charAt(i)+"  i-"+i);
			if (c == symbols.charAt(i)) {
				flag = true; break;				
			}
		}
		return flag;
	}	
	
	public static void main(String[] args) {
		String NameFile = "readme.txt";
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader(NameFile));
			try {
				Map <String, Integer> map = new HashMap<String, Integer> ();
				
				int count=0, first=0, countWord=0, countSymbols=0, countAll=0, countProbel=0, smvl=0;
				String word="";
				String res = fr.readLine();
				while (res != null) {							
					smvl=res.length();
					for (int i=0; i < res.length(); i++) {
						countAll++; //Считаем все символы
						System.out.println(res.charAt(i)+" "+(int)res.charAt(i));
						if ((int)res.charAt(i)==32) {
							countProbel++;
							System.out.println(res.charAt(i)+" "+(int)res.charAt(i)+"  i-"+i);
						} else if (AnalizSymbols(res.charAt(i))) {						
							countSymbols++;
							//System.out.println(res.charAt(i)+" "+(int)res.charAt(i)+"  i-"+i);
						} else if (AnalizLetter(res.charAt(i))) { //Если это БУКВА
							if (first == 0) first=i;
							count++;	
							if ((i==res.length()-1) || (AnalizLetter(res.charAt(i+1))==false)) {
								i++; countAll++;
								word=res.substring(i-count, i); countWord++;
								//System.out.println("Слово - "+word);
								//int value = map.get(word);
								if (map.containsKey(word)==false) map.put(word, new Integer(1));					
								else map.put(word, new Integer(map.get(word)+1));								
								first=0; count=0;	
							}
						} 
					}							
					System.out.println(res);
					//System.out.println("В файле - "+NameFile+" "+countSymbols+" знаков препинания");
					res = fr.readLine();
				}
				
				/*
				System.out.println("\nВЫВОДИМ  КОЛЛЕКЦИЮ");
				Set<String> keys = map.keySet();  //извлекли ключи в коллекцию SET
				Iterator<String> iterator = keys.iterator();  //созаем итератор от SET
				while (iterator.hasNext()) {
					String s = iterator.next();
					System.out.println("ЗНАЧЕНИЕ/КЛЮЧ:  "+map.get(s)+" - "+s);
				}
				*/
				System.out.println("\nВ файле - "+NameFile+" "+countAll+" всех знаков буквы, пробелы, знаки препинания");
				System.out.println("Строка файла "+NameFile+" показала "+smvl+" всех символов");
				System.out.println("В файле - "+NameFile+" "+countProbel+" пробелов");
				System.out.println("В файле - "+NameFile+" "+countSymbols+" знаков препинания");
				System.out.println("В файле - "+NameFile+" "+countWord+" слов");		
				System.out.println("В массиве HASHMAP - "+map.size()+" неповторяющихся значений");				
			} catch (Exception e) {
				System.out.println("Проблемы с чтением файла "+NameFile);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл "+NameFile+" отсутствует");
		} finally {
			try {
				fr.close();
			} catch (Exception e) {
				System.out.println("Нет возможности закрыть файл "+NameFile);
			}
		}		
	}
}
