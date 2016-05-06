/*
 * 	ЗАДАНИЕ № 20		LastLetters
 * 	20.11.2014
 * 	Имеется строка с текстом. Вывести текст, 
 * 	составленный из последних букв всех слов.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class LastLetters {

	public static void main(String[] args) {
		String str = ""; 
		str="  Текстовая , строка ?с, ?несколкими !!,.заптыми .,.и точками,. и.восклицательными, знаками!  з";		
		System.out.println(str+'\n');
		char s;
		int OldInt=0, NewInt=0, count=0; 
		for (int i=0; i<str.length(); i++) {			
			s = str.charAt(i);
			if ((s == ' ') || (s == ',') || (s == '.') || (s == '!') || (s == '?')) {
				NewInt=str.indexOf(s, NewInt);	NewInt++;
				if ((NewInt-OldInt)>1) {
					count++;
					//System.out.println(count+".  буква-"+str.substring(NewInt-2, NewInt-1));
					//System.out.print(str.substring(NewInt-2, NewInt-1));					
					//System.out.println(count+".  буква-"+str.charAt(NewInt-2)+"");
					
					System.out.print(str.charAt(NewInt-2)+"");
				}	
				OldInt=NewInt;				 
			} else {
				NewInt=str.indexOf(s, NewInt);  	
				if (NewInt==str.length()-1) {
					System.out.print(str.charAt(NewInt)+"");
				}
			}
		}		
		System.out.println("\nВ строке - "+count+" слов");
	}
}
