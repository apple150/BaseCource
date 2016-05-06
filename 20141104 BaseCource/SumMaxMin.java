/*	
 * 	������� � 15		SumMaxMin
 * 	15.11.2014
 * 	���������� ����� ��������� �������, ������������� ����� 
 * 	������������ � ����������� ����������  	
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class SumMaxMin {

	public static void main(String[] args) {
		//���������  �  ���������  ������
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1); //��������� �������� � ��������� �� 1 �� 10
		}
		
		//�������  ������  ���  �����������
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");
		int maxMark = marks[0];
		int minMark = marks[0];	
		int iMax=0;
		int iMin=0;
		
		//�������  ������������  ��������  �  �����������  ��������
		for (int i=0; i<marks.length; i++) {
			if (maxMark < marks[i]) {
				iMax = i;		
				maxMark = marks[i];
			}
			if (minMark > marks[i]) {
				iMin = i;
				minMark = marks[i];
			}
		}
		
		System.out.println("����� �������� �������� ["+iMin+"]-"+minMark+"   ������������ �������� �������� ["+iMax+"]-"+maxMark);
		
		//���� ����������  �����  �������������  ������  ������������ �� ������  ��  �������
		if (iMax < iMin) {
			int temp=iMax;
			iMax=iMin;
			iMin=temp;
			System.out.println("��������: "+"����� �������� ���. ������ ["+iMin+"]   ������������ �������� ���. ������ ["+iMax+"]");
		}
		
		
		//����������  ������������  �����  ��������  ���������
		int sum=0;
		for (int i=iMin; i<=iMax; i++) {
			if (i==iMin) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(", ["+i+"]-"+marks[i]);			
			sum += marks[i];
		}
		System.out.println("");
		System.out.println("����� ����� ����������� � ������������ ��������� ������� = "+sum);
	}
}
