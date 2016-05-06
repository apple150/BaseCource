/*	
 * 	������� � 6  		����������� �������		Calc
 * 	22.12.2014
 * 	������� ���������� ����������� �� ������ ������� COMMAND
 * 	������ ������� ������ ���� ������ � ������� �� Singleton.
 * 	 
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.Console;

public class Calc {

	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	public static int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		int count=100; //���-�� ��������
		MySingle ms = MySingle.GetMySingle(); //2-�� ������� ������� �� ���������
		ms.OpenFile();
		 
		Command cd = null;
		int zn=0;
		for (int i=0; i < count; i++) {			
			zn=GetRandomItem(0, 4);
			switch (zn) {
				case 0:  cd=new Addition(GetRandomItem(1,10), GetRandomItem(1,10)); break;
				case 1:  cd=new Subtraction(GetRandomItem(1,10), GetRandomItem(1,10)); break;
				case 2:  cd=new Multiplication(GetRandomItem(1,10), GetRandomItem(1,10)); break;
				case 3:  cd=new Division(GetRandomItem(1,10), GetRandomItem(1,10)); break;				
			}
			cd.execute(ms);
			cd=null;
		}
		ms.CloseFile();
		
		/*
		Command cd = null; 
		cd = new Plus();  cd.execute();
		cd = new Minus(); cd.execute();
		Console con = null;
		con = System.console();
		System.out.println(con);
		try {
			if (con != null) {
				String i = ""; 
				con.readLine("������� �������� 1: ");
				System.out.println(i);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
	}
}
