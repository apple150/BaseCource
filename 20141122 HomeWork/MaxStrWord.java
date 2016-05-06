/*	
 * 	ЗАДАНИЕ № 21  		MaxStrWord		(Дополнительно)
 * 	22.11.2014
 * 	Найти в тексте самое длинное слово
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class MaxStrWord {

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
		String dop="";
		int max=0;
		String MaxWord="";
		int iterator=0, count=0;
		int len=str.length()-1; //Длинна строки		
		for (int i=0; i <= len; i++) {			
			if (Analiz(str.charAt(i), symbols)) { //Если это один из символов
				if (count > 0) {
					iterator++;
					dop=str.substring(i-count, i);
					if (dop.length()>max) {
						max=dop.length();
						MaxWord=dop;
					}
					System.out.println(iterator+".  "+dop);					
					count=0;
				}
			} else if (len == i) {
				iterator++;
				dop=str.substring(i-count, i+1);
				if (dop.length()>max) {
					max=dop.length();
					MaxWord=dop;
				}				
				System.out.println(iterator+".  "+dop);				
			} else count++;
		}		
		System.out.println("\n\nВ строке - "+iterator+" слов");		
		System.out.println("Самое длинное слово - ("+MaxWord+") состоит из - "+max+" символов");
	}
}