/*	
 * 	������� � 15		LastItems		(��������� 		ArrayMax3)
 * 	15.11.2014
 * 	���������� ������������ ������� � �������, ����� 2-�� �� �������� �������� 
 * 	� 3-� �� �������� ��������, �� 1 ������. 
 * 	
 * 	��� ����� ����������  ���������� (� ��������� Find_1)
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class LastItems {

	/**
	 * �����  �������  �� �������
	 */
	public static void PrintArray(int marks[], int count, String st) {
		//�������  ������  ���  �����������
		System.out.print(st+"  ");
		for (int i=0; i<marks.length; i++) {
			//if (i==0) System.out.print("["+i+"]-"+marks[i]);
			//else System.out.print(",["+i+"]-"+marks[i]);
			if (i==0) System.out.print(i+"-"+marks[i]);
			else System.out.print(", "+i+"-"+marks[i]);			
		}
		if (count==0) System.out.println("");
		else System.out.println("  ("+count+")");
	}
	
	/**
	 * ���������  ������  ����������  ���������� � ��������� �� 1-interval
	 */
	public static void InitialArray(int marks[], int interval) {
		//���������  ������
		for (int i=0; i<20; i++) {
			//marks[i] = (int)(Math.random()*10 + 1);
			marks[i] = (int)(Math.random()*interval + 1);
		}
	}

	/**
	 * ��������  ��������  ������� � ������  ������������  ���C��
	 */
	public static void CopyArray(int marks[], int marks_new[]) {
		//���������  ������
		for (int i=0; i<20; i++) {
			marks_new[i] = marks[i];
		}
	}
	
	
	/**
	 * 1-�� ������� ������ ��� ����������
	 */	
	public static void Find_1(int m[]) {
		//�����  �����������  �������� 1-�� �������  (���������������  ������  ��  ���������)
		int first=0, second=0, third=0;
		/*// OLD VERSION
		for (int i=0; i<m.length; i++) {
			if (m[i]>=first) first=m[i];
			else if (m[i]>=second) second=m[i]; 
			else if (m[i]>=third) third=m[i];			
		}*/
		for (int i=0; i<m.length; i++) {
			if (m[i] > first) {
				if (third!=0) third=second;
				if (second!=0) second=first;
				first=m[i];
			} else if ((m[i] > second) && (m[i] < first)) {			
				if (third!=0) third=second;				
				second=m[i]; 
				//System.out.println("second-"+second);
			} else if ((m[i] > third) && (m[i] < second)) {
				third=m[i];			
				//System.out.println("third-"+third);
			}
		}		
		System.out.println("1-��  �������");
		PrintArray(m, 0, "������-1:"); 	//������� ������ 1
		System.out.println("���������: item_1-"+first+", item_2-"+second+", item_3-"+third);		
	}

	/**
	 * �����  �������  ������ 
	 */
	public static void SortVibor(int m[]) {
		//����������  �������  �������  ������
		int maxIndex=0;
		for (int i=0; i<m.length; i++) {
			maxIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[maxIndex] < m[j]) {
					maxIndex = j;
				}
			}
			int temp = m[maxIndex];
			m[maxIndex] = m[i];
			m[i] = temp;						
		}		
		PrintArray(m, 0, "��������:");
	}
		
	/**
	 * 2-�� ������� ������ � ��������������� �����������
	 */	
	public static void Find_2(int m[]) {
		System.out.println("2-��  �������");
		PrintArray(m, 0, "������-2:"); 	//������� ������ 2
		SortVibor(m);
		//�����  �����������  �������� 2-�� �������  (���������  ��������������� ������)
		int item=0;
		int count=0;
		System.out.print("���������: ");
		for (int i=0; i<m.length; i++) {
			if (item!=m[i]) {
					count++;
				item=m[i];
				if (i==0) System.out.print("item_"+count+"-"+item);
				else System.out.print(", item_"+count+"-"+item);
					if (count==3) break;
			}
		}		
	}
	
	/**
	 * �����  ���������
	 */
	public static void main(String[] args) {
		int SizeOfArray = 25; //����������� ��������� � �������
		int interval = 50;    //�������� ��������� �������� �� 1 �� 50
		System.out.println("	   ������ �������:     "+SizeOfArray+" ���������");
		System.out.println("	   ��������  ��������: 1-"+interval);
		int[] m1, m2; 		//���������  2 �������
			m1= new int[SizeOfArray];	//������� ����� 1
			m2= new int[SizeOfArray];	//������� ����� 2
			
			InitialArray(m1, interval); //��������� ������ ���������� ������� � ��������� �� 1 �� 50
			CopyArray(m1, m2);	//��������  �������� �� ������� 1 �  ������ 2
						
		Find_1(m1); //1-�� ������� ������ ��� ����������
		System.out.println("");		
		Find_2(m2); //2-�� ������� ������ � ��������������� ������������			
	}

}
