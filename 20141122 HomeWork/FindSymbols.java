/*	
 * 	ЗАДАНИЕ № 18		FindSymbols
 *	20.11.2014г.
 *	Найти в строке не только запятые, но и другие знаки препинания 
 *	подсчитать общее их кол-во
 *
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
 */

public class FindSymbols {

	public static void main(String[] args) {		
		String str = " Ла,  Текстовая, строка ?с, ?несколкими !!,.заптыми .,. и точками,. и.восклицательными, знаками!   за  ";
		
		int z=0, t=0, e=0, q=0; //z подсчет запятых, t-подсчет точек, e-подсчета восклицательных знаков, q-подсчета вопросов
		char s;
		for (int i=0; i<str.length(); i++) {
			s = str.charAt(i);
			if (s == ',') z++;
			else if (s == '.') t++;
			else if (s == '!') e++;
			else if (s == '?') q++;
		}
		System.out.println("В строке: "+str+'\n');
		System.out.println(z+" запятых");
		System.out.println(t+" точек");
		System.out.println(q+" вопросов");
		System.out.println(e+" восклицательных знаков");		
	}
}
