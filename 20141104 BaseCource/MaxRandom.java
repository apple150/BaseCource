/*	
 * 	������� � 9		MaxRandom
 * 	11.11.2014
 * 	������� ������������������ ��������� �����, ����� � ������� ���������� �� ���.
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class MaxRandom {

	public static void main(String[] args) {
		int count=0;
		int x = (int) (Math.random() *20);
		int max=0;
		while(x != 0) {
			count++;
			x = (int)(Math.random()*20);
			if (x>max) max=x;
			System.out.println("x = " + x);
		} 
		System.out.println("�� "+count+" �����  MAX = " + max);
		
		/*			
		 //������� ������������������ ��������� �����, ����� � ������� �� ������� �������� 
		double sum =0.0; 	int n = 0;
		int x = (int) (Math.random() *20) ;
		int max=0;
		while(x != 0) { 
			sum += x; n ++;
			x = (int)(Math.random()*20);
			if (x>max) max=n;
			System.out.println("x = " + x);
		} 
		
		double sr = 0.0;
		if (n != 0) {
			sr = sum / n;
		} else { 
			sr = 0 ;
		}
		System.out.println("�������:" + sr);		
		*/
	}
}
