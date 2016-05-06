/*	
 * 	������� � 14		MaxScore
 *	15.11.2014�.
 *	�������  ����������
 *	� ������ �� ����� ������������ ������, ������� �� ���� ������, � �� �����.
 *
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
 */

public class MaxScore {

	public static void main(String[] args) {
		//���������  �  ���������  ������
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1);
		}
		
		//�������  ������  ���  �����������
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print(i+"-"+marks[i]);
			else System.out.print(", "+i+"-"+marks[i]);
		}
		System.out.println("");
		int maxMark = marks[0];
		int itemMark = 0;
		
		//�������  ������������  ��������  �  ���  ����������  �����  �  �������
		for (int i=0; i<marks.length; i++) {
			if (maxMark < marks[i]) {
				maxMark = marks[i];
				itemMark = i;
			}
		}
		System.out.println("������������ ������ = "+maxMark+" ����� �������� = "+itemMark);
	}

}
