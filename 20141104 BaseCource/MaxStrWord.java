/*	
 * 	ЗАДАНИЕ № 21  		MaxStrWord		(Дополнительно)
 * 	22.11.2014
 * 	Найти в тексте самое длинное слово
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class MaxStrWord {

	public static void main(String[] args) {
		String str = "  Текстовая, строка ?с, ?несколкими !!,.заптыми .,.и точками,. и.восклицательными, знаками!  з ";
		System.out.println(str+'\n');
		char s;
		int OldInt=0, NewInt=0, count=0;
		String maxStr="";
		int max=0;
		String dop="";
		for (int i=0; i<str.length(); i++) {			
			s = str.charAt(i);
			NewInt=str.indexOf(s, NewInt); NewInt++;
			if ((s == ' ') || (s == ',') || (s == '.') || (s == '!') || (s == '?')) {
				if ((NewInt-OldInt)>1) { //обнаружили слово
					count++;
					dop=""; dop=str.substring(OldInt, NewInt-1);
					System.out.println(count+".  слово-"+dop);
					if (dop.length() > max) { //Запоминаем максимальное слово и кол-во символов в нем 
						max=dop.length(); maxStr=dop;
					}
				}
				OldInt=NewInt; //запиминаем позицию с ктотрого начинается слово
			} else {				  				
				if (NewInt==str.length()) {
					count++;
					dop=""; dop=str.substring(OldInt, NewInt);
					System.out.println(count+".  слово-"+dop);
				}
			}
		}
		System.out.println("\nВ строке - "+count+" слов");		
		System.out.println("Самое длинное слово - ("+maxStr+") состоит из - "+max+" символов");
	}
}