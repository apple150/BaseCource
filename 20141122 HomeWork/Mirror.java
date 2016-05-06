/*
 * 	������� � 17		Mirror		(�������������)
 * 	18.11.2014
 * 	������� ���������� ������ � �������� ��� �� ���������
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Mirror {

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
	 * ���������  ������  ���������� �� 1-... 25 (� ������� 5x5)
	 */
	public static void InitialArrayEasy(int m[][]) {
		//���������  ������
		int count=0;
		for (int i=0; i<m.length; i++) {
			for (int j=0; j < m[i].length; j++) {
				count++;
				m[i][j] = count;
			}
		}
	}
		
	/**
	 * ��������  ������������  �������� (��������� ������� ����� ���� - ������ ������ ����  \)
	 */
	public static void Perestanovka(int m[][]) {
		int temp=0, iTemp=0, jTemp=0;
		for (int i=0; i<m.length-1; i++) {
			for (int j=i+1; j < m[i].length; j++) {
				iTemp=m.length-1-i;  jTemp=m[i].length-1-j;
				temp=m[iTemp][jTemp];
				m[iTemp][jTemp]=m[i][j];
				m[i][j]=temp;
			}
		}
	}	

	/**
	 * ��������  ������������  �������� (��������� ������� ������ ���� - ������ ����� ����  /)
	 */
	public static void PerestanovkaNew(int m[][]) {		
		int temp=0, iTemp=0, jTemp=0;
		for (int i=0; i<m.length-1; i++) {
			for (int j=0; j < m[i].length-i-1; j++) {
				iTemp=m.length-1-i;  jTemp=m[i].length-1-j;				
				temp=m[iTemp][jTemp];
				m[iTemp][jTemp]=m[i][j];
				m[i][j]=temp;
			}
		}
	}	
	
	/**
	 * �����  ���������
	 */
	public static void main(String[] args) {		
		int size = 7;
		int interval = 20;    //�������� ��������� �������� �� 1 �� 50

		int[][] m = new int[size][size]; 		//���������  ������
		//InitialArray(m, interval);            //��������� ������� ���������� ������� 
		InitialArrayEasy(m);					//��������� ������ ������� �� 1 �� 25 (� �������� 5x5)
		System.out.println("������ ������� - "+size+"x"+size);
		System.out.println("�������� ����  �� 1-"+interval);
		System.out.println("�������� �� ��������� �� �������� ������ ���� �� ������� ������� ");
		Print(m);	//������������� ������
		System.out.println("");

		Perestanovka(m); 	//������������  �������� (��������� ������� ����� ���� - ������ ������ ���� \ )
		Print(m); 			//������������� �������������� ������ 
		System.out.println("");
		System.out.println("�������� �� ��������� �� �������� ������� ���� �� ������� ������");
		InitialArrayEasy(m);	//��������� ������ ������� �� 1 �� 25 (� �������� 5x5)
		Print(m);				//������������� ������
		System.out.println("");
		PerestanovkaNew(m); //������������  �������� (��������� ������� ������ ���� - ������ ����� ���� / )
		Print(m);			//������������� �������������� ������
	}
}
