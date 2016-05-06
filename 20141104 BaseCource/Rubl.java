/*	
 * 	������� � 5  	Rubl 	
 * 	10.11.2014
 * 	������� ����� ����� (�����), ��� ����� � ����� ����� � ������.
 * 	������� ��� �����, ������� � ���� ����� ������� � ���������� ������.
 * 	
 * 	�������������� 17.11.2014
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Rubl {

	/**
	 * ������ �������� �� ����� ������ ���������� ��������� 1111, 1112  
	 */
	public static void Proc(int rub) { 
		String rezult="";
		String StrRub="";
		rezult=rub+" ";
		if (rub>=0) {
			if ((rub>=11)&&(rub<=14)) StrRub="������";
			else {
				if (((rub+0)%10)==0) StrRub="������";
				else if (((rub+9)%10)==0) StrRub="�����";
				else if ((((rub+8)%10)==0) || (((rub+7)%10)==0) || (((rub+6)%10)==0)) StrRub="�����";
				else  StrRub="������";			
			}
			rezult=rezult+StrRub;
			System.out.println("   "+rezult);
		} else System.out.println("   "+rezult+" ������ ��� 0");
	}

	/**
	 * 	����� �������� �� ��������� ������ ���������� ������� 14.11.2014
	 */
	public static void ProcNew(int rub) { 
		String StrRub="";
		int i= (rub%100); //����� �� 100  (��� ���� ����� ��������� �� 0 �� 100  ��� 11, 12, 13, 14)
		if (i==0) StrRub="������";
		else if (i==1) StrRub="�����";
		else if ((i>=2)&&(i<=4)) StrRub="�����";
		else if ((i>=5)&&(i<=20)) StrRub="������";		
		else if (i>14) {
			i= (rub%10); //����� �� 10  (��� ���� ����� ��������� �� 0 �� 9)
			if (i==0) StrRub="������";
			else if (i==1) StrRub="�����";
			else if ((i>=2)&&(i<=4)) StrRub="�����";
			else if ((i>=5)&&(i<=9)) StrRub="������";
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