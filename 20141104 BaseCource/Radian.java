/*	
 * 	������� � 2			Radian 	(�������������� �������)
 * 	06.11.2014
 * 	����������� ������� ������ ������� �� �������
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Radian {

	//��������� ������ ����������
	public static void ProcOut(double rad, int grad, int min, int sec) {
		System.out.println("   "+rad+" rad  =  "+grad+"gr "+min+"' "+sec+"\"");
	}

	//��������� ������� �������� ����� � ������
	public static int Proc(int i, double pi, double item) {
		int rezult=0;		
		if (i==1) rezult=(int)(item/(pi/180));  		// �������
		if (i==2) rezult=(int)(item/(pi/(180*60))); 	// ������
		if (i==3) rezult=(int)(item/(pi/(180*60*60))); 	// �������
		return rezult;
	}
	
	//��������� �������� ��� ���������� ������� �� ������� ������ � �������
	public static void ExpandRadian(double rad) {
		double pi=3.14159; 		// ����� ��		
		double dop=0.0;    		// �������������� ����������
		int grad, min, sec;		// �������� �������, ������ ������� 
						
		//double rad=1.0; // �������� �������		
		grad=0; min=0; sec=0;
		grad=Proc(1, pi, rad); // �������
			dop=(rad%(pi/180));
		min=Proc(2, pi, dop);  // ������
			dop=(rad%(pi/(180*60)));
		sec=Proc(3, pi, dop); // �������		
			ProcOut(rad, grad, min, sec); //��������� ������ ����������		
	}
	
	public static void main(String[] args) {
		System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		System.out.println("   ***          RADIAN           ***");
		System.out.println("   ***  1 rad  =  57gr 17' 45''  ***"+'\n');				
		
		double rad=0.0; // �������� �������		
		rad=1.0; 		ExpandRadian(rad);
		rad=1.87548; 	ExpandRadian(rad);
		rad=5.35848; 	ExpandRadian(rad);
		rad=23.4253458; ExpandRadian(rad);
		
		System.out.println('\n'+"   ***       End Of Program      ***");
	}
}