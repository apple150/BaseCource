/*	
 * 	������� � 15		ArrayMax3
 * 	15.11.2014
 * 	���������� ������������ ������� � �������, ����� 2-�� �� �������� �������� 
 * 	� 3-� �� �������� ��������, �� 1 ������. 
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class ArrayMax3 {

	public static void main(String[] args) {
		//���������  �  ���������  ������
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1); //��������� �������� � ��������� �� 1 �� 10
		}
		
		//�������  ������  ���  �����������
		System.out.print("SET  ARRAY: ");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");
		
		//���������  ������ �� ��������  �  ��������  (�������  �������  ������)
		int maxIndex=0;
		for (int i=0; i<marks.length; i++) {
			maxIndex=i;
			for (int j=i; j<marks.length; j++) {
				if (marks[maxIndex] < marks[j]) {
					maxIndex = j;
				}
			}
			int temp = marks[maxIndex];
			marks[maxIndex] = marks[i];
			marks[i] = temp;			
		}
		
		//�������  ������  ���  �����������
		System.out.print("SORT ARRAY: ");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");		
		
		//�����  �����������  �������� 1-�� �������  (���������������  ������  ��  ���������)
		int first=0, second=0, third=0;
		for (int i=0; i<marks.length; i++) {
			if (marks[i]>=first) first=marks[i];
			else if (marks[i]>=second) second=marks[i]; 
			else if (marks[i]>=third) third=marks[i];			
		}
		System.out.println("First-"+first+", Second-"+second+", Third-"+third);
		
		//�����  �����������  �������� 2-�� �������  (���������  ��������������� ������)
		int item=0;
		int count=0;
		for (int i=0; i<marks.length; i++) {
			if (item!=marks[i]) {
					count++;
				item=marks[i];
				if (i==0) System.out.print("item_"+count+"-"+item);
				else System.out.print(", item_"+count+"-"+item);
					if (count==3) break;
			}
		}		
	}

}
