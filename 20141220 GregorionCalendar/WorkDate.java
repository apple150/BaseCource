/*
 * 	������� � 1		����������� �������		WorkDate 	
 * 	20.12.2014
 * 	GregorianCalendar ������ � ���
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.GregorianCalendar;
import java.util.Locale;

public class WorkDate {

	public static void main(String[] args) {
		GregorianCalendar calen = new GregorianCalendar(2014, 4, 2);
		System.out.println("�������� ����: " + calen.getTime());
		
		Locale loc= null; 
		loc = new Locale("ru", "RU");
		//loc = new Locale("en", "UK");
		//loc = new Locale("be", "BY");
		//loc = new Locale("uk", "UA");
		calen = new GregorianCalendar(loc);
		System.out.println("������� ����� toGMT    : " + calen.getTime().toGMTString());
		System.out.println("������� ����� toLocal  : " + calen.getTime().toLocaleString());
		System.out.println("������� ����� toInstant: " + calen.getTime().toInstant());
		System.out.println("������� ����� toString : " + calen.getTime().toString());
		System.out.println("TimeZone : " + calen.getTimeZone());
		
		int y=calen.get(calen.YEAR);
		int m=calen.get(calen.MONTH)+1;
		int d=calen.get(calen.DATE);
		int h=calen.get(calen.HOUR_OF_DAY);
		int mn=calen.get(calen.MINUTE);
		int s=calen.get(calen.SECOND);
		System.out.println("y: " + y+" m: "+m+" d:"+d+" - h:"+h+" mn:"+mn+" s:"+s);
		System.out.println(y+"."+m+"."+d+" "+h+":"+mn+":"+s);
	}

}
