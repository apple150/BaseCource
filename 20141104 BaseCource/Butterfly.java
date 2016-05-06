/**
 * 	������� � 17  		Butterfly
 * 	18.11.2014
 * 	������� ���������� ���������� ������, � ��������� ��� ���������,
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Butterfly {

	/**
	 * ��������� ������ ������� �� �����
	 */
	public static void Print(int  m[][]) {
		//�����  ��������  ��  �����
		for (int i = 0; i < m.length; i++) {
			if (i>0) System.out.println("");
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(" "+m[i][j]);				
			}
		}		
		System.out.println(""); System.out.println("");
	}

	/**
	 * ��������� �������� � ���������� �������� �������
	 */
	public static void ProcEasyArray(int  size) {
		int m[][] = new int[size] [size] ;
		//����������  �������  ��������� 1
		System.out.println("�������  ����������  �������");
		/*
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = 1;
			}
		}*/
		Print(m);		
	}
	
	/**
	 * ��������� �������� � ���������� ������� ��������
	 */
	public static void ProcButterflyArray(int  size) {
		int m[][] = new int[size] [size] ;
		//����������  �������  ��������  1-�� ��������
		System.out.println("����������  �������   ��������");
		for (int i = 0; i < m.length/2+1; i++) {			
			for (int j = 0; j < m[i].length; j++) {	
				if ((j >= i) && (j <= (m[i].length-1-i))) m[i][j] = 1;								
				//else m[i][j] = 0;
			}
		}
		
		//2-�� ��������
		for (int i = m.length-1; i>=m.length/2; i--) {		
            for (int j=0; j<m[i].length; j++) {
                if ((j<(m[i].length-1-i)) || (j>i)) m[i][j]=0;                  
                else m[i][j]=1;                  
            }			
        }
		Print(m);		
	}
	
	/**
	 * �����  ���������
	 */
	public static void main(String[] args) {
		//����������  �  ��������  �������
		int size = 11;
		ProcEasyArray(size); // ������� ������		
		ProcButterflyArray(size); //������ ��������		
	}

}
