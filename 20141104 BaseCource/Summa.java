/*	
 * 	������� � 10		Summa
 * 	11.11.2014
 * 	������� ����� �����. ������� ��������� ����� ���� ������� �����.
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Summa {

	public static void main(String[] args) { 
		int i=1050735;  int a=i;		
		int z=0;
		int sum=0;
		while (i!=0) {
			z= (int) (i % 10);
			if (z!=0) {
				sum += z;
				i -= z;
			} else {
				i=i/10;
			}
		}
		System.out.println("����� ����� "+a+" = "+sum);		
	}
}
