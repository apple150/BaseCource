/*	
 * 	ЗАДАНИЕ № 30  		FileText
 * 	06.12.2014
 * 	
 * 	Создать файл с текстом, прочитать, 
 * 	подсчитать в тексте кол-во знаков препинания и слов.
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.*;
import java.util.*;
/*
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
*/

public class FileText {

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
			if (c == symbols.charAt(i)) {
				flag = true; break;				
			}
		}
		return flag;
	}

	/**
	 * Анализ на цифры 
	 */	
	public static boolean AnalizNumber(char c) {
		boolean flag=false;
		if (c>='0' && c<='9') flag=true;
		return flag;
	}	
	
	/**
	 * Сравнитель для LinkedList<Integer>
	 */
	static Comparator<Integer> compareLinkedListInteger = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };		
    
	public static void main(String[] args) {
		String NameFile = "readme3.txt";
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader(NameFile)); //Открываем файл			
			try {				
				Map <String, Integer> map = new HashMap<String, Integer> (); //Инициализируем коллекцию
				List<Integer> linkedList = new LinkedList<Integer>();
				
				int count=0, first=0, countWord=0, countSymbols=0, countAll=0, countProbel=0, countNumber=0, countOther=0, countLetters=0;
				int firstNumb=0, countNumb=0, countZifr=0;
				char c=' ';
				String word="";				
				String res = fr.readLine();
				while (res != null) {
					for (int i=0; i < res.length(); i++) {
						countAll++; //Считаем все символы
						c=res.charAt(i); //Берем символ из строки						
						if (c==' ') countProbel++; //Если пробелы
						else if (AnalizSymbols(c)) countSymbols++; //Если знаки препинания
						else if (AnalizNumber(c)) { //Если цифры
							countNumber++; //Если число
							if (firstNumb ==0) firstNumb=i;
							countNumb++; //для просчета числа состоящего из нескольких цифр
							if ((i==res.length()-1) || (AnalizNumber(res.charAt(i+1))==false)) {
								i++;
								if (i != res.length()) {
									countAll++;
									if (res.charAt(i)==' ') countProbel++; //Если пробелы																																							
									else if (AnalizSymbols(res.charAt(i)))  countSymbols++; //Если знаки препинания
									else if (AnalizLetter(res.charAt(i))) {
										countLetters++;
										if (first == 0) first=i;
										count++;
									} else countOther++;
								}
								word=res.substring(i-countNumb, i); countZifr++;
								linkedList.add(Integer.parseInt(word)); //Добавляем значение числа в массив LinkedList
								firstNumb=0; countNumb=0;
							}
						} else if (AnalizLetter(c)) { //Если это БУКВА
							countLetters++;
							if (first == 0) first=i;
							count++;	
							if ((i==res.length()-1) || (AnalizLetter(res.charAt(i+1))==false)) {
								i++; 
								if (i != res.length()) {
									countAll++;
									if (res.charAt(i)==' ') countProbel++; //Если пробелы								
									else if (AnalizNumber(res.charAt(i))) {
										countNumber++; //Если число для просчета числа состоящего из нескольких цифр
										if (firstNumb ==0) firstNumb=i;
									} else if (AnalizSymbols(res.charAt(i)))  countSymbols++; //Если знаки препинания										
									else countOther++;
								}
								word=res.substring(i-count, i); countWord++;
								if (map.containsKey(word)==false) map.put(word, new Integer(1));
								else map.put(word, new Integer(map.get(word)+1));
								first=0; count=0;
							}
						} else countOther++;
					}
					System.out.println(res);
					res = fr.readLine();					
				}
				//ВЫВОД ОТЧЕТА  ПО  МАССИВУ
				System.out.println("\nВ файле - "+NameFile+":"); 
				System.out.println("\t(пробелы+препинан+ост.символы (ДОП)) - ("+countProbel+"+"+countSymbols+"+"+countOther+"="+(countProbel+countSymbols+countOther)+")");
				System.out.println("\t(цифры / значные цифры) - ("+countNumber+" / "+countZifr+")");
				System.out.println("\t(буквы / слова) - ("+countLetters+" / "+countWord+")");
				System.out.println("\tвсего ("+countAll+") символов (ДОП+ЦИФР+БУКВ) - ("+(countProbel+countSymbols+countOther)+"+"+countNumber+"+"+countLetters+"="+(countProbel+countSymbols+countOther+countNumber+countLetters)+")");
				System.out.println("\t(Неповторимых слов / Всего слов) - ("+map.size()+" / "+countWord+")");
				
				
				if (linkedList.size() > 0) {
					System.out.println("\nВыводим массив LINKEDLIST");
					System.out.println("Начальное значение массива:\t"+linkedList+"  - "+linkedList.size()+" элементов");
					int countArray=0;
					Iterator<Integer> iteratorList = linkedList.iterator();
					while(iteratorList.hasNext()) {
						countArray+=iteratorList.next();
					}
					System.out.println("Сумма массива чисел:\t\t"+countArray);
					
					for (int i=0; i<linkedList.size(); i++) {
						for (int j=i+1; j<linkedList.size(); j++) {
							if (linkedList.get(i) == linkedList.get(j)) { linkedList.remove(j); j--;}
						} 
					}
					
					System.out.println("Массив с уникал. значениями:\t"+linkedList+"  - "+linkedList.size()+" элементов");
					Collections.sort(linkedList, compareLinkedListInteger);
					System.out.println("Отсортированный массив:\t\t"+linkedList+"  - "+linkedList.size()+" элементов");
	
					countArray=0;
					iteratorList = linkedList.iterator();
					while(iteratorList.hasNext()) {
						countArray+=iteratorList.next();
					}
					System.out.println("Сумма массива чисел:\t\t"+countArray);
				} else System.out.println("\nВ тексте отсутствуют числа !!!");
				
				
				System.out.println("\nВыводим (Частотный Словарь)  HASHMAP");
				Set<String> keys = map.keySet();  //извлекли ключи в коллекцию SET
				Iterator<String> iterator = keys.iterator();  //созаем итератор от SET
				while (iterator.hasNext()) {
					String s = iterator.next();
					System.out.println("\tЗНАЧЕНИЕ/КЛЮЧ:  "+map.get(s)+" - "+s);
				}											
				/*
				System.out.println("\nВ файле - "+NameFile+" "+countAll+" всех знаков буквы, пробелы, знаки препинания");				
				System.out.println("\nВ файле - "+NameFile+" "+countProbel+" пробелов");
				System.out.println("В файле - "+NameFile+" "+countSymbols+" знаков препинания");
				System.out.println("В файле - "+NameFile+" "+countOther+" других символов");
				System.out.println("\nВ файле - "+NameFile+" "+countLetters+" букв");
				System.out.println("В файле - "+NameFile+" "+countWord+" слов");		
				System.out.println("\nВ файле - "+NameFile+" "+countNumber+" цифр");
				System.out.println("В файле - "+NameFile+" "+countZifr+" цифр 1-значных, 2-значных, 3-значных");
				System.out.println("\nВ массиве HASHMAP - "+map.size()+" неповторяющихся значений");
				*/
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
