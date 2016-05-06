/*
 *	������� � 2		Time
 *	06.11.2014 
 *	���������� ����������� ������, �������� ������ � ����� ����� � ������ 
 * 	����������� ����� ����� ������ �� ������ �������� ��������� ��������
 *  
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/


public class Time {

	//��������� ������ ����������
	public static void ProcOut(int item, int week, int day, int h, int min, int sec) {
		String rezult="";
		if (item!=0) rezult=rezult+item+" = ";
		if (week!=0) rezult=rezult+week+" week ";
		if (day!=0) rezult=rezult+day+" day  ";
		if (h!=0) rezult=rezult+h+" hour ";
		if (min!=0) rezult=rezult+min+" min  ";
		if (sec!=0) rezult=rezult+sec+" sec ";
		System.out.println("   "+rezult);
	}
	
	//������ ������� ������� � ���� ���������
	public static void Proc(int tm) {
		int sec, min, hour, day, week=0; // �������� ����������
		int m, d, w=0; //�������������� ���������
		
			sec = tm % 60; 	// ������� ������ ����� ������� �� 60
		m = (tm - sec) / 60; // ����� ���������� �����
			min = m % 60; 	// �������  ����� ����� ������� �� 60
		d = (m - min) / 60; // ����� ���������� �����
			hour = d%24; 	// ������� ����� ����� ������� �� 24
		w = (d-hour)/24; 	// ����� ���������� ����
			day = w%7; 		// ������� ���� ����� ������� �� 7 (�.� ����� ������)
		week = (w-day)/7; 	// ����� ���������� ������		
		
		ProcOut(tm, week, day, hour, min, sec); // ������� ���������
	}

	public static void main(String[] args) { 
		//System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		//System.out.println("   ***           TIME            ***"+'\n');		
	
		int tm = 0;
		tm = 3662;    Proc(tm);		
		tm = 370000;  Proc(tm);		
		tm = 604800;  Proc(tm); // ����� 1 ������		
		tm = 604801;  Proc(tm); // ����� 1 ������ 1 �������
		tm = 604861;  Proc(tm); // ����� 1 ������ 1 ������ 1 �������
		tm = 608461;  Proc(tm); // ����� 1 ������ 1 ��� 1 ������ 1 �������
		tm = 694861;  Proc(tm); // ����� 1 ������ 1 ���� 1 ��� 1 ������ 1 �������
		tm = 3024000; Proc(tm); //����� 5 ������		
		tm = 4233600; Proc(tm); //����� 7 ������		
		tm = 5245890; Proc(tm);				
					
		//System.out.println('\n'+"   ***       End Of Program      ***");
	}
}
