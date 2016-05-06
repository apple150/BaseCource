
public class DictionaryNew {
	
	/**
	 * Проверка строки на точки запятые т.е. на знаки препинания 
	 */
	public static boolean Analiz(char s, String symbols) {
		boolean flag=false;
		for (int i=0; i<symbols.length(); i++) {
			if (s==symbols.charAt(i)) {
				flag=true; break;				
			}
		}
		return flag;
	}
	
	/**
	 * Создание строки Аккумулятора с кол-вом раз 
	 */
	public static String AccumulationStr(String word, String SummaStr) {
		String temp="";
		String FindWord= "*"+word+"@"; //искомое слово с ограничивающими символами
		int zn= SummaStr.indexOf(FindWord);
		if (zn == -1) {
			temp=SummaStr+FindWord+"1@";
		} else { //В строке накопление мы нашли искомое солово
			int kk=zn+FindWord.length(); //значение до			
			String ii=SummaStr.charAt(kk)+"";
			int sum=Integer.parseInt(ii);
			sum++;
			ii=sum+"";
			
			temp=SummaStr.substring(0,kk);
			int iZn=SummaStr.indexOf("@",kk);
			int iCount=0;
			if (iZn-kk==1) { //если это слово 1-а буква				
				String kkk=SummaStr.charAt(kk)+"";				
				iCount=Integer.parseInt(kkk);
				iCount++;
			} else { //если это слово больше чем 1-а буква
				iCount=Integer.valueOf(SummaStr.substring(kk,iZn));
				iCount++;
			}
			if (iCount>0) { //подстановка нового значения кол-ва слов в заданной строке
				temp=temp+iCount+"@"+SummaStr.substring(iZn+1);;
			}			
		}
		return temp;
	}
	
	/**
	 * Вывод Аккумулированной строки с кол-вом раз употребления и максимальным количесвом
	 */
	public static void PrintAccumulationStr(String SummaStr) {
		if (!SummaStr.isEmpty()) {
			System.out.println(SummaStr+'\n');
			String temp=SummaStr;
			int p=0, n=0, z=0, kolvo=0;			
			String zn="", cnt="";
			String MaxStr="";
			int max=0;
			while(p != -1) {
				p = temp.indexOf('*', p);
				if(p != -1) {
					kolvo++;
					n=temp.indexOf('@', p) ;				
					z=temp.indexOf('@', n+1) ;					
					zn=temp.substring(p+1, n);					
					cnt=temp.substring(n+1, z);
					int intCnt=Integer.parseInt(cnt);
					if (intCnt > max) {
						max=intCnt;
						MaxStr=zn;
					}
					System.out.println(kolvo+". "+zn+" - "+cnt+" раз");
					p=z;
				}
			}
			if (MaxStr.length()==1) System.out.println("\nМаксимальное встречается буква - ("+MaxStr+") - "+max+" раз.  ИТОГО - "+kolvo+" слов.");
			else System.out.println("\nМаксимальное встречается слово - ("+MaxStr+") - "+max+" раз.  ИТОГО - "+kolvo+" слов.");			
		}		
	}
	
	public static void main(String[] args) {
		String str = ""; 
		str = "  Текстовая, строка Текстовая ?с, строка ?несколкими !!,.заптыми .,знаками.и точками,. и.восклицательными, знаками!  з Текстовая, з з з з з з з з з з з з з з з  з восклицательными";
		//str = "  Текстовая, тест Текстовая";
		System.out.println(str);
		
		String symbols=" ,.!?;:";	//символы которые в слова не входят
		String word="";
		String SummaStr="";
		int iterator=0, count=0;
		int len=str.length()-1; //Длинна строки		
		for (int i=0; i <= len; i++) {			
			if (Analiz(str.charAt(i), symbols)) { //Если это один из символов
				if (count > 0) {
					iterator++; word=str.substring(i-count, i); SummaStr=AccumulationStr(word, SummaStr); 					
					count=0;
				}
			} else if (len == i) {
				iterator++;  word=str.substring(i-count, i+1); 	SummaStr=AccumulationStr(word, SummaStr); 			
			} else count++;
		}		
		System.out.println("В строке - "+iterator+" слов"+'\n');
		PrintAccumulationStr(SummaStr);
				
	}

}
