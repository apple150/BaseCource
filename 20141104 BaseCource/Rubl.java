/*	
 * 	ÇÀÄÀÍÈÅ ¹ 5  	Rubl 	
 * 	10.11.2014
 * 	Èìååòñÿ öåëîå ÷èñëî (ëşáîå), ıòî ÷èñëî — ñóììà äåíåã â ğóáëÿõ.
 * 	Âûâåñòè ıòî ÷èñëî, äîáàâèâ ê íåìó ñëîâî «ğóáëåé» â ïğàâèëüíîì ïàäåæå.
 * 	
 * 	Ïåğåäåëûâàëîñü 17.11.2014
 * 
 *  © Copyright		Sergey Buglak		(Ñåğãåé Áóãëàê) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Rubl {

	/**
	 * Ñòàğûé àëãîğèòì íå î÷åíü âåğíûé ñîñáåííîíà çíà÷åíèÿõ 1111, 1112  
	 */
	public static void Proc(int rub) { 
		String rezult="";
		String StrRub="";
		rezult=rub+" ";
		if (rub>=0) {
			if ((rub>=11)&&(rub<=14)) StrRub="ğóáëåé";
			else {
				if (((rub+0)%10)==0) StrRub="ğóáëåé";
				else if (((rub+9)%10)==0) StrRub="ğóáëü";
				else if ((((rub+8)%10)==0) || (((rub+7)%10)==0) || (((rub+6)%10)==0)) StrRub="ğóáëÿ";
				else  StrRub="ğóáëåé";			
			}
			rezult=rezult+StrRub;
			System.out.println("   "+rezult);
		} else System.out.println("   "+rezult+" ìåíüøå ÷åì 0");
	}

	/**
	 * 	Íîâûé àëãîğèòì ïî ïîäñêàçêå Àíòîíà ôåäîğîâè÷à Ñìàëşêà 14.11.2014
	 */
	public static void ProcNew(int rub) { 
		String StrRub="";
		int i= (rub%100); //Äåëèì íà 100  (äëÿ òîãî ÷òîáû ïğîâåğÿòü îò 0 äî 100  äëÿ 11, 12, 13, 14)
		if (i==0) StrRub="ğóáëåé";
		else if (i==1) StrRub="ğóáëü";
		else if ((i>=2)&&(i<=4)) StrRub="ğóáëÿ";
		else if ((i>=5)&&(i<=20)) StrRub="ğóáëåé";		
		else if (i>14) {
			i= (rub%10); //Äåëèì íà 10  (äëÿ òîãî ÷òîáû ïğîâåğÿòü îò 0 äî 9)
			if (i==0) StrRub="ğóáëåé";
			else if (i==1) StrRub="ğóáëü";
			else if ((i>=2)&&(i<=4)) StrRub="ğóáëÿ";
			else if ((i>=5)&&(i<=9)) StrRub="ğóáëåé";
		}
		System.out.println(rub+" "+StrRub);
	}	
	
	public static void main(String[] args) {		
		
		for (int i=0; i<=40; i++) {
			ProcNew(i);
		}
		ProcNew(111);
		ProcNew(112);
		ProcNew(1111);
		ProcNew(1112);
		
		/*
		int rub=0;				
		rub=-1; Proc(rub);
		rub=0;  Proc(rub);
		rub=1;  Proc(rub);
		rub=3;  Proc(rub);
		rub=7;  Proc(rub);
		rub=10; Proc(rub);
		rub=11; Proc(rub);
		rub=12; Proc(rub);
		rub=13; Proc(rub);
		rub=14; Proc(rub);
		rub=104;   Proc(rub);
		rub=10871; Proc(rub);
		*/
	}

}