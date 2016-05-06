/*
 * 	ЗАДАНИЕ № 19		CountWords
 * 	20.11.2014
 *	Имеется строка с текстом. Подсчитать кол-во слов в тексте. 
 *	Желательно учесть, что слова могут разделяться несколькими пробелами,
 *	в начале и конце текста так же могут быть пробелы, но могут и отсутствовать
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class CountWords {

	public static boolean Analiz(char s, String symbols) {
		boolean flag=false;
		for (int i=0; i<symbols.length(); i++) {
			if (s==symbols.charAt(i)) {
				flag=true; break;				
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String str = " Ла,  Текстовая, строка ?с, ?несколкими !!,.заптыми .,. и точками,. и.восклицательными, знаками!   за  ";
		System.out.println(str+'\n');
		
		String symbols=" ,.!?;:";	//символы которые в слова не входят			
		int iterator=0, count=0;
		int len=str.length()-1; //Длинна строки		
		for (int i=0; i <= len; i++) {			
			if (Analiz(str.charAt(i), symbols)) { //Если это один из символов
				if (count > 0) {
					iterator++; System.out.println(iterator+".  "+str.substring(i-count, i));					
					count=0;
				}
			} else if (len == i) {
				iterator++; System.out.println(iterator+".  "+str.substring(i-count, i+1));				
			} else count++;
		}		
		System.out.println("\nВ строке - "+iterator+" слов");
	}	
}