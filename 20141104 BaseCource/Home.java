/*	
 * 	������� � 7		Home
 * 	10.11.2014
 * 	������� ��� ���� ��������� � �� b � � �� d. ������� ������� ��������� � �� f. 
 * 	��������� ���������� �� ��� ���� �� ������ �������. ������� ����� � ����������� �������� �������, 
 * 	� ��������� ���������� ����� ���� �����.
 * 	 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Home {
	
	/**
	 * OLD  ��������� ������� � ������ ����������� OLD  (����������� ����������� ��������)
	 */
	public static void Proc(int a, int b, int c, int d, int e, int f) {
		String rezult="";		
		rezult="1st HOUSE: "+a+"x"+b+" ("+a*b+")"+",  2nd HOUSE: "+c+"x"+d+" ("+c*d+")"+",  AREA: "+e+"x"+f+" ("+e*f+")";
		System.out.println("   "+rezult);		
		if ((a<=0)||(b<=0)||(c<=0)||(d<=0)||(e<=0)||(f<=0)) {
			rezult="";
			rezult="INCORRECT DATA. SIDE OF HOUSE MUST BE MORE THEN  0";
			System.out.println("   "+rezult+'\n');
		} else {	
			//����� ������� �������� ������� 1-�� ���� � ���������� - A
			int temp=0;
			if (b > a) {
			  temp = b;
			  b = a;
			  a = temp;
			}		
			
			//����� ������� �������� ������� 2-�� ���� � ���������� - C
			temp=0;
			if (d > c) {
			  temp = d;
			  d = c;
			  c = temp;
			}		
			
			//������ ������� �.�. ������ ����� �������� ����
			int max=0;
			if (a > max) max=a;
			if (c > max) max=c;
			
			int min = b + d;

			temp=0;
			if (min>max) {
			  temp=max;
			  max=min;
			  min=temp;		  
			}
			
			//����� ������� �������� ������� �������������� �������
			temp=0;
			if (f > e) {
			  temp = f;
			  f = e;
			  e = temp;
			}
			
			boolean flag1 = false;
			if ((max<=e)&&(min<=f)) flag1=true;
			rezult="";
			rezult="1. Houses have general size: "+max+"x"+min+". Locate on Area: "+e+"x"+f+" ";
			if (flag1) rezult=rezult+"it's POSSIBLE";
			else rezult=rezult+"it's IMPOSSIBLE";
			System.out.println("   "+rezult);
					
			//2-�� �������
			max=a + c;
			
			min=0;
			if (b > min) min=b;
			if (d > min) min=d;
			
			boolean flag2 = false;
			if ((max<=e)&&(min<=f)) flag2=true;
			rezult="";
			rezult="2. Houses have general size: "+max+"x"+min+". Locate on Area: "+e+"x"+f+" ";
			if (flag2) rezult=rezult+"it's POSSIBLE";
			else rezult=rezult+"it's IMPOSSIBLE";
			System.out.println("   "+rezult+'\n');
		}								
	}


	/**
	 * ��������� ProcNew ������� � ������ ����������   ���������� 14.11.2014 
	 */	
	public static void Analiz(int r_side, int a, int b, int e, int f) {
		int l_side=a;
		if (b>l_side) l_side=b;
		
		boolean flag=false;		
		if ((r_side <= e ) && (l_side <= f)) flag=true;
		if (flag==false) {
			if ((r_side <= f ) && (l_side <= e)) flag=true; 
		}
		
		String rezult="";
		rezult="���� ��������: "+r_side+"x"+l_side+" ";
		
		if (flag==true) rezult=rezult+ " ���������� �� �������: "+e+"x"+f;					
		else rezult=rezult+ " �� ���������� �� �������: "+e+"x"+f;
		
		System.out.println(rezult);		
	}
	
	/**
	 * NEW �������� ������ ��������� �� �������   ���������� 14.11.2014 
	 */	
	public static void ProcNew(int a, int b, int c, int d, int e, int f) {
		String rezult="";		
		rezult="1 ���: "+a+"x"+b+" ("+a*b+")"+",  2 ���: "+c+"x"+d+" ("+c*d+")"+",  �������: "+e+"x"+f+" ("+e*f+")";
		System.out.println(rezult);
		
		Analiz(a + c, b, d, e, f);
		Analiz(a + d, b, c, e, f);
		Analiz(b + c, a, d, e, f);
		Analiz(b + d, c, a, e, f);
		System.out.println("");
	}	
	
	public static void main(String[] args) { 
		int a=0, b=0, c=0, d=0, e=0, f=0;		
		a=5; b=7; c=6; d=9; e=11; f=9;  	ProcNew(a, b, c, d, e, f);		
		a=8; b=5; c=10; d=6; e=20; f=10;  	ProcNew(a, b, c, d, e, f);
				
		//a=0; b=8; c=0; d=9; e=16; f=5;  	Proc(a, b, c, d, e, f);		
		//a=5; b=7; c=6; d=9; e=11; f=9;  	Proc(a, b, c, d, e, f);
		//a=5; b=7; c=6; d=9; e=16; f=6;  	Proc(a, b, c, d, e, f);
		//a=40; b=25; c=13; d=83; e=83; f=38;  	Proc(a, b, c, d, e, f);
		//a=40; b=25; c=13; d=83; e=123; f=25;  	Proc(a, b, c, d, e, f)
		//a=50; b=50; c=50; d=50; e=100; f=50;  	Proc(a, b, c, d, e, f);			
	}

}