/*	
 * 	ЗАДАНИЕ № 21  		StrBuilder
 * 	22.11.2014
 * 	Напишите 2 цикла выполняющих многократное сложение строк, один с помощью оператора сложения и String, а другой с помощью
 * 	String Builder и метода append. Сравните скорость их выполнения.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class StrBuilder {

	public static void main(String[] args) {
		//1-ый блок String
		String str = "";
		int count=0;
		int max=10000;
		System.out.println("Итераций      - "+max+" раз");
		int StartTime=0, StopTime=0, Razniza=0;
		StartTime=(int) System.currentTimeMillis(); 
		for (int i=0; i<max; i++) {
			count++;
			str=str+" "+count;
		}
		StopTime=(int) System.currentTimeMillis();		
		Razniza=StopTime-StartTime;
		System.out.println("String        - "+Razniza+"   милисек.");
		
		//2-ой блок StringBuffer
		StringBuffer StrBuff = new StringBuffer("");
		count=0;
		StartTime=0; StopTime=0; Razniza=0;
		StartTime=(int) System.currentTimeMillis(); 
		for (int i=0; i<max; i++) {
			count++;
			StrBuff=StrBuff.append(" "+count);
		}
		StopTime=(int) System.currentTimeMillis();		
		Razniza=StopTime-StartTime;
		System.out.println("StringBuffer  - "+Razniza+"   милисек.");
		
		//3-ой блок StringBuilder
		StringBuilder StrBuild = new StringBuilder("");
		count=0;
		StartTime=0; StopTime=0; Razniza=0;
		StartTime=(int) System.currentTimeMillis(); 
		for (int i=0; i<max; i++) {
			count++;
			StrBuild=StrBuild.append(" "+count);
		}
		StopTime=(int) System.currentTimeMillis();		
		Razniza=StopTime-StartTime;
		System.out.println("StringBuilder - "+Razniza+"   милисек.");		
	}
}

/**
//Результаты запусков
Итераций      - 10000 раз
String        - 670   милисек.
StringBuffer  - 0   милисек.
StringBuilder - 0   милисек.

Итераций      - 20000 раз
String        - 2917   милисек.
StringBuffer  - 0   милисек.
StringBuilder - 0   милисек.

Итераций      - 30000 раз
String        - 7020   милисек.
StringBuffer  - 0   милисек.
StringBuilder - 16   милисек.

Итераций      - 40000 раз
String        - 12838   милисек.
StringBuffer  - 0   милисек.
StringBuilder - 16   милисек.

Итераций      - 50000 раз
String        - 20858   милисек.
StringBuffer  - 15   милисек.
StringBuilder - 0   милисек.

Итераций      - 60000 раз
String        - 31871   милисек.
StringBuffer  - 15   милисек.
StringBuilder - 17   милисек.

Итераций      - 70000 раз
String        - 46176   милисек.
StringBuffer  - 15   милисек.
StringBuilder - 16   милисек.

Итераций      - 80000 раз
String        - 63586   милисек.
StringBuffer  - 15   милисек.
StringBuilder - 17   милисек.

Итераций      - 90000 раз
String        - 84973   милисек.
StringBuffer  - 16   милисек.
StringBuilder - 17   милисек.

Итераций      - 100000 раз
String        - 110464   милисек.
StringBuffer  - 31   милисек.
StringBuilder - 17   милисек.

Итераций      - 200000 раз
String        - 816817   милисек.
StringBuffer  - 48   милисек.
StringBuilder - 47   милисек.
*/