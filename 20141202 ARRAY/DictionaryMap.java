/*	
 * 	ЗАДАНИЕ № 29  		DictionaryMap
 * 	04.12.2014
 * 	
 * 	Имеется текст. Следует составить для него частотный словарь. 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class DictionaryMap {

	/**
	 * Проверка строки на точки запятые т.е. на знаки препинания 
	 */
	public static boolean Analiz(char c) {
		boolean flag=false;
		if ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='а' && c<='я') || (c>='А' && c<='Я')) flag=true;
		return flag;
	}

	public static void main(String[] args) {
		String str = ""; 
		str = "  Текстовая, строка Текстовая ?с, строка ?несколькими !!,.заптыми .,знаками.и точками,. и.восклицательными, знаками!  з Текстовая, з з з з з з з з з з з з з з з  з восклицательными";
		System.out.println(str);
		
		Map <String, Integer> map = new HashMap<String, Integer> ();
		
		//Для сортировки вводятся 2 доп элемента 
		ValueComparator bvc =  new ValueComparator(map);		
		TreeMap<String, Integer> sorted_map = new TreeMap(bvc);
		
		String word="";		
		int count=0, first=0, countWord=0;		
		for (int i=0; i < str.length(); i++) {			
			if (Analiz(str.charAt(i))) { //Если это БУКВА
				if (first == 0) first=i;
				count++;	
				if ((i==str.length()-1) || (Analiz(str.charAt(i+1))==false)) {
					i++;
					word=str.substring(i-count, i); countWord++;
					//System.out.println("Слово - "+word);
					//int value = map.get(word);
					if (map.containsKey(word)==false) map.put(word, new Integer(1));					
					else map.put(word, new Integer(map.get(word)+1));
					first=0; count=0;
				}
			} 
		}		
		System.out.println("В строке - "+countWord+" слов");		
		System.out.println("Массив MAP - "+map);
		
		Set<String> keys = map.keySet();  //извлекли ключи в коллекцию SET
		Iterator<String> iterator = keys.iterator();  //созаем итератор от SET
		while (iterator.hasNext()) {
			String s = iterator.next();
			//|System.out.println("ЗНАЧЕНИЕ: "+map.get(s)+"\tКЛЮЧ: "+s);
			System.out.println("ЗНАЧЕНИЕ/КЛЮЧ:  "+map.get(s)+" - "+s);
		}
				
		/*
		//Выбираем все ключи
		for (String key : map.keySet()) {
		    System.out.println("Key: " + key);
		}		
		//Выбираем все значения
		for (int value : map.values()) {
		    System.out.println("Value: " + value);
		}
		*/
		
		/*
		//Выбираем все ключи и значения 		
		System.out.println("НЕ СОРТИРОВАННЫЙ  HASHMAP");
		countWord=0;
		for (Map.Entry entry : map.entrySet()) {
			countWord++;
			System.out.println(countWord+".\tValue: "+ entry.getValue()+"\tKey: " + entry.getKey());
		}
		System.out.println("В массиве HASHMAP - "+countWord+" слов\n");
		*/
		
		/*
		sorted_map.putAll(map);
		
		System.out.println("results");		
        for (String key : sorted_map.keySet()) {
            System.out.println("Value: " + sorted_map.get(key) +"\tKey: "+key);
        }
        System.out.println("Массив MAP - "+map);
        */
	}
}

class ValueComparator implements Comparator {	 
	  Map base;
	  public ValueComparator(Map base) {
	      this.base = base;
	  }	  
	  
	  public int compare(Object a, Object b) {
		  if ((Integer)base.get(a) < (Integer)base.get(b)) {
			  return 1;
		  } else if ((Integer)base.get(a) == (Integer)base.get(b)) {
			  return 0;
		  } else {
			  return -1;
		  }	    
	  }
}
