/*	
 * 	������� � 22  		ClTimeShow ���������� ClassTime
 * 	25.11.2014
 * 	������� ����� � ������� ����������� ���������� �������. �������� ������ ����, ������, �������
 * 	������� ����� ��������� ���� �������� ����� ������
 * 	������� 2 ����������� (���������� ���-�� ����� � ���� ������ ������� ��������) 	
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class ClTimeShow {
	
	public static void main(String[] args) {
		ClassTime c1 = new ClassTime(4445); 
		//ClassTime c2 = new ClassTime(5, 40, 35);
		ClassTime c2 = new ClassTime(1, 14, 5);
		/*
		//c1.Print("c1"); c2.Print("c2");			
		c1.Print1("c1"); c2.Print1("c2");		
		System.out.println(c1.compareToReturnString(c2, "c1", "c2"));
		*/
		
		System.out.println(c1.GetFullReport(c2, "C1", "C2")+'\n'); //�������� �����
		
		/*
		if (c1.compareToReturnInt(c2)==-1) System.out.println("c1 < c2");
		else if (c1.compareToReturnInt(c2)==1) System.out.println("c1 > c2");
		else if (c1.compareToReturnInt(c2)==0) System.out.println("c1 = c2  �����");
		*/		
		int count=0;
		for (int i=0; i<1000; i++) {
			count++;
			c1=null; c2=null;
			c1= new ClassTime();
			c2= new ClassTime();
			//c2=c1;
			//System.out.println(count+".\t"+ c1.GetTime("C1")+'\t'+c2.GetTime("C2")+"\t("+rez+")"); 
			//System.out.println(count+".\t"+ c1.GetTime("C1")+'\t'+c2.GetTime("C2")+'\t'+c1.compareToReturnString(c2, "C1", "C2"));
			System.out.println(count+".\t"+ c1.GetFullReport(c2, "C1", "C2"));
		}
	}
}
