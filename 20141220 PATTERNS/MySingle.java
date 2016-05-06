/*	
 * 	ЗАДАНИЕ № 6  		Углубленный уровень		Loger
 * 	20.12.2014
 * 	Создать простейший логгер выводящий сообщения об ошибках в текстовый файл.
 * 	Объект логгера должен быть создан с помощью ШП Singleton. 
 * 	У объекта должен быть обязательным один метод получающий на вход
 * 	текст сообщения (об ошибке ...) и записывающий его в файл вместе с 
 * 	информацией о дате и времени проишествия
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class MySingle {
	private String nameFile="LogFile.txt";
	PrintWriter pw=null;
	private MySingle() {} //Конструктор private		
	
	private static MySingle inst;
	public static synchronized MySingle GetMySingle() {
		if (inst == null) {
			inst = new MySingle();
		}
		return inst;
	}	
	
	public void OpenFile() {
		try {
			pw = new PrintWriter(nameFile); //Открываем файл
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}		
	}

	public void WriteStr(String st, int porNomer) {
		try {			
			if (porNomer==0) pw.println(GetDateTime()+st);				
			else {
				String pn=StrTo2(porNomer);
				pw.println(GetDateTime()+pn+". "+st);
			}
		} catch (Exception e) {
			System.out.println("I cant write to file: "+nameFile);
		}							
	}
	
	public void CloseFile() {
		try {
			pw.close(); 		//Закрываем файл
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
		}				
	}
	
	public String StrTo2(int i) {
		String rez="";
		if (i<10) rez="0"+i;
		else rez=i+"";
		return rez;
	}
	
	public String GetDateTime() {
		String dt="";
		GregorianCalendar cl = new GregorianCalendar();
		int y=cl.get(cl.YEAR);
		int m=cl.get(cl.MONTH)+1;
		int d=cl.get(cl.DATE);
		int h=cl.get(cl.HOUR_OF_DAY);
		int mn=cl.get(cl.MINUTE);
		int s=cl.get(cl.SECOND);
		int ms=cl.get(cl.MILLISECOND);
		//dt=y+"."+StrTo2(m)+"."+StrTo2(d)+" "+StrTo2(h)+":"+StrTo2(mn)+":"+StrTo2(s)+" - ";
		dt=y+"."+StrTo2(m)+"."+StrTo2(d)+" "+StrTo2(h)+":"+StrTo2(mn)+":"+StrTo2(s)+":"+ms+" - ";
		return dt;
	}
}