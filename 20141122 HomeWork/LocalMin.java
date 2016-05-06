/*	
 * 	������� � 17		LocalMin	(�������������)
 * 	18.11.2014
 * 	������ ������ ��������� ��������� � 2-� ������ �������
 * 	�.�. �������� ������ ���� ������ ���� ����������� ������ 
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class LocalMin {

	/**
	 * ��������� ������ ������� �� �����
	 */
	public static void Print(int  m[][]) {
		//�����  ��������  ��  �����
		for (int i = 0; i < m.length; i++) {
			//if (i>0) System.out.println("");
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j]<10) System.out.print("   "+m[i][j]);
				else System.out.print("  "+m[i][j]);				
			}
			System.out.println("");
		}
	}

	/**
	 * ���������  ������  ����������  ���������� � ��������� �� 1-interval
	 */
	public static void InitialArray(int m[][], int interval) {
		//���������  ������
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {
				m[i][j] = (int)(Math.random()*interval + 1);
			}
		}
	}
	
	/**
	 * OLD ��������  ������ ��������� ���������
	 */
	public static void FindMinOld(int m[][]) {
		int MaxStr=m.length-1; //������������ ���-��  �����
		int MaxItem=m[0].length-1; //������������ ���-�� ��������� � ������
		int CurrentItem=0;
		int item=0;
		int sum=0;
		int count=0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {				
				sum=0;
				CurrentItem=m[i][j]; //������� �������
				if ((i==0)||(i==MaxStr)) sum++;
				if ((j==0)||(j==MaxItem)) sum++;
				
				if (i==0) { //���� ������ ������ �������	
					//� ���� �����  �����  ������ ������� � ������ ������ �������
					if (j==0) { //1-�� ������� ������
						if (j+1<=MaxItem) {if (CurrentItem < m[i][j+1]) sum++;}
						if (i+1<=MaxStr)  {if (CurrentItem < m[i+1][j]) sum++;}	//���������� I		
					} else if (j==MaxItem) { //��������� ������� ������							
						if (j-1>=0) {if (CurrentItem < m[i][j-1]) sum++; }
						if (i+1<=MaxStr) {if (CurrentItem<m[i+1][j]) sum++; } //���������� I						
					} else {
						if (j+1<=MaxItem) {if (CurrentItem < m[i][j+1]) sum++;}
						if (j-1>=0) {if (CurrentItem < m[i][j-1]) sum++; }
						if (i+1<=MaxStr) {if (CurrentItem<m[i+1][j]) sum++; } //���������� I
					}
				} else if (i==MaxStr) { //���� ��������� ������ �������		
					//� ���� �����  �����  ������  ������� �  ������ �������  �������
					if (j==0) {
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}												
					} else if (j==MaxItem) {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}												
					} else {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}												
					}
				} else { //���� ������ � ������� �������
					//� ���� �����  �����  ������ ������� � ����� ������� � ������ ������� 
					if (j==0) {
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}
						if (i+1<=MaxStr) {
							item=m[i+1][j]; if (CurrentItem<item) sum++;							
						}												
					} else if (j==MaxItem) {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}
						if (i+1<=MaxStr) {
							item=m[i+1][j]; if (CurrentItem<item) sum++;							
						}																		
					} else {
						item=m[i][j-1];
						if (CurrentItem<item) sum++;
						item=m[i][j+1];
						if (CurrentItem<item) sum++;
						if (i-1>=0) {
							item=m[i-1][j]; if (CurrentItem<item) sum++;							
						}
						if (i+1<=MaxStr) {
							item=m[i+1][j]; if (CurrentItem<item) sum++;							
						}						
					}
				}
				if (sum==4) {					
					System.out.println("��������� MIN ["+(i+1)+"]["+(j+1)+"] = "+CurrentItem);
					count++;
				}				
			}
		}		
		System.out.println("����� - "+count+" ��������� ���������");
	}

	/**
	 * NEW ���������������� ��������  ������ ��������� ���������
	 */
	public static void FindMinNew(int m[][]) {
		int MaxStr=m.length-1; 		//������������ ���-��  ����� ��� ��������
		int MaxItem=m[0].length-1; 	//������������ ���-�� ��������� � ������ ��� ��������				
		int sum=0;
		int count=0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {				
				sum=0;				
				
				if ((i==0)||(i==MaxStr)) sum++;	//�������  ��������������  ������
				if ((j==0)||(j==MaxItem)) sum++; //�������  ������������  ������

				if (j+1<=MaxItem) 	{ if (m[i][j] < m[i][j+1]) 	sum++;	} //��������  � ������ + 1
				if (j-1>=0) 		{ if (m[i][j] < m[i][j-1]) 	sum++; 	} //��������  � ������ - 1
				if (i+1<=MaxStr) 	{ if (m[i][j] < m[i+1][j]) 	sum++; 	} //��������  ��� ������� + 1
				if (i-1>=0) 		{ if (m[i][j] < m[i-1][j]) 	sum++; 	} //��������  ��� ������� + 1

				if (sum==4) {					
					System.out.println("��������� MIN ["+(i+1)+"]["+(j+1)+"] = "+m[i][j]);
					count++;
				}				
			}
		}		
		System.out.println("����� - "+count+" ��������� ���������");
	}
		
	public static void main(String[] args) {
		//����������  �  ��������  �������   (����������� ����� 10 ��������� ��������� �� �������� 13 � ������� 5x5)
		int size = 5;
		int interval = 50;    //�������� ��������� �������� �� 1 �� 50
		int[][] m = new int[size][size]; 		//���������  ������
		InitialArray(m, interval);
		System.out.println("������ ������� - "+size+"x"+size);
		System.out.println("�������� ��������  �� 1-"+interval);
		Print(m);
		//System.out.println("������� ���������  ��������");
		FindMinNew(m);
	}
}
