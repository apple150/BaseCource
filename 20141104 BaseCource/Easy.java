/*	
 * 	������� � 11		Easy
 *	13.11.2014�.
 *	������� ����� �����, ���������� �������� �� ��� ����� �������, 
 *	�.�. ������� ��� ������� ������ �� 1 � ����.
 *
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
 */
//������� ����� �����, ���������� �������� �� ��� ����� �������, �.�. ������� ��� ������� ������ �� 1 � ����.
public class Easy {

	public static void main(String[] args) {		
		int item=107;  //����������� ��������
		int count=0;
		if (item > 2) { 	//���� ����� ������ 2-�
			if (item%2!=0) { 	//���� ����� ������
				for (int i=1; i<=item; i++) {					
					if (i%2==0) continue;
					if (item%i==0) count++; //����������� ���� �������� ��������					
				}
			}
		}
		//System.out.println("COUNT "+count);
		if ((count==2)||(item==1)||(item==2)) System.out.println("����� "+item+" �������� �������");
		else System.out.println("����� "+item+" �� �������� �������");
	}	
}
