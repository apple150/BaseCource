/*	
 * 	������		Logger
 * 	������ � ������� �� Singleton.
 * 	����� ������ � ���� LogFil.txt
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Logger {
	private static Logger inst_log;
	private static String nameFile="";
	PrintWriter pw=null;
	
	/**
	 * �.�. �� SINGLETON �� ����������� ����������� ������ ���� private
	 */
	private Logger(String CurDir) {
		nameFile=CurDir+"//log//LogFile.txt";
	} 		

	/**
	 * ��������� ����������� ����� ������������ ������ �� ���� �� �����
	 * ���� ������ ����� ������������ ������������� � ������ �������, ��
	 * ���������� ������ ���������� ����� ������� ����� �������:
	 *   public static synchronized MyDao getDao()
	 * �� ���� ������� ��� ������������� ��������� ������
	 */	
	public static synchronized Logger getLogger(String CurDir) {
		if (inst_log == null) {
			inst_log = new Logger(CurDir);
		}
		return inst_log;
	}	
		
	public static String ReadFile()  {	    
	    StringBuilder sb = new StringBuilder();	 	
	    try { 	        
	        BufferedReader in = new BufferedReader(new FileReader(nameFile)); //������ ��� ������ ����� � �����
	        try {
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s+'\n');
	            }
	        } finally {	            
	            in.close(); //����� �� �������� ������� ����
	        }
	    } catch(IOException e) {
	        e.printStackTrace();
	    }	 	    
	    return sb.toString(); 
	}	
		
	public void OpenFile() {
		try {
			pw = new PrintWriter(nameFile); //��������� ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public void CloseFile() {
		try {
			pw.close(); 		//��������� ����
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}	
	
	/**
	 * ��������� ������ � ���� ���� �.�. � LogFile.txt
	 */
	public void AddStrToLogFile(String str) {
		File f1 = new File(nameFile);
		if (f1.exists()) {
			String rez = ReadFile();
			OpenFile();
			try {
				pw.print(rez);
				pw.print(GetDateTime()+str);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			CloseFile();
		} else {
			OpenFile();
			try {
				pw.print(GetDateTime()+str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			CloseFile();
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
		//GregorianCalendar cl = new GregorianCalendar();
		//Calendar cl = new GregorianCalendar(TimeZone.getTimeZone("Ukraine/Kiev"));
		Calendar cl = new GregorianCalendar(TimeZone.getTimeZone("GMT+3"));
		int y=cl.get(cl.YEAR);
		int m=cl.get(cl.MONTH)+1;
		int d=cl.get(cl.DATE);
		int h=cl.get(cl.HOUR_OF_DAY);
		int mn=cl.get(cl.MINUTE);
		int s=cl.get(cl.SECOND);
		int ms=cl.get(cl.MILLISECOND);
		String milis=StrTo2(ms);
		if (ms<100) milis="0"+milis;
		//dt=y+"."+StrTo2(m)+"."+StrTo2(d)+" "+StrTo2(h)+":"+StrTo2(mn)+":"+StrTo2(s)+" - ";
		dt=y+"."+StrTo2(m)+"."+StrTo2(d)+" "+StrTo2(h)+":"+StrTo2(mn)+":"+StrTo2(s)+"."+milis+" - ";
		return dt;
	}
}
