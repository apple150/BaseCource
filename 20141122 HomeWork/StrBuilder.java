/*	
 * 	������� � 21  		StrBuilder
 * 	22.11.2014
 * 	�������� 2 ����� ����������� ������������ �������� �����, ���� � ������� ��������� �������� � String, � ������ � �������
 * 	String Builder � ������ append. �������� �������� �� ����������.
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class StrBuilder {

	public static void main(String[] args) {
		//1-�� ���� String
		String str = "";
		int count=0;
		int max=10000;
		System.out.println("��������      - "+max+" ���");
		int StartTime=0, StopTime=0, Razniza=0;
		StartTime=(int) System.currentTimeMillis(); 
		for (int i=0; i<max; i++) {
			count++;
			str=str+" "+count;
		}
		StopTime=(int) System.currentTimeMillis();		
		Razniza=StopTime-StartTime;
		System.out.println("String        - "+Razniza+"   �������.");
		
		//2-�� ���� StringBuffer
		StringBuffer StrBuff = new StringBuffer("");
		count=0;
		StartTime=0; StopTime=0; Razniza=0;
		StartTime=(int) System.currentTimeMillis(); 
		for (int i=0; i<max; i++) {
			count++;
			StrBuff=StrBuff.append(" "+count);
		}
		StopTime=(int) System.currentTimeMillis();		
		Razniza=StopTime-StartTime;
		System.out.println("StringBuffer  - "+Razniza+"   �������.");
		
		//3-�� ���� StringBuilder
		StringBuilder StrBuild = new StringBuilder("");
		count=0;
		StartTime=0; StopTime=0; Razniza=0;
		StartTime=(int) System.currentTimeMillis(); 
		for (int i=0; i<max; i++) {
			count++;
			StrBuild=StrBuild.append(" "+count);
		}
		StopTime=(int) System.currentTimeMillis();		
		Razniza=StopTime-StartTime;
		System.out.println("StringBuilder - "+Razniza+"   �������.");		
	}
}

/**
//���������� ��������
��������      - 10000 ���
String        - 670   �������.
StringBuffer  - 0   �������.
StringBuilder - 0   �������.

��������      - 20000 ���
String        - 2917   �������.
StringBuffer  - 0   �������.
StringBuilder - 0   �������.

��������      - 30000 ���
String        - 7020   �������.
StringBuffer  - 0   �������.
StringBuilder - 16   �������.

��������      - 40000 ���
String        - 12838   �������.
StringBuffer  - 0   �������.
StringBuilder - 16   �������.

��������      - 50000 ���
String        - 20858   �������.
StringBuffer  - 15   �������.
StringBuilder - 0   �������.

��������      - 60000 ���
String        - 31871   �������.
StringBuffer  - 15   �������.
StringBuilder - 17   �������.

��������      - 70000 ���
String        - 46176   �������.
StringBuffer  - 15   �������.
StringBuilder - 16   �������.

��������      - 80000 ���
String        - 63586   �������.
StringBuffer  - 15   �������.
StringBuilder - 17   �������.

��������      - 90000 ���
String        - 84973   �������.
StringBuffer  - 16   �������.
StringBuilder - 17   �������.

��������      - 100000 ���
String        - 110464   �������.
StringBuffer  - 31   �������.
StringBuilder - 17   �������.

��������      - 200000 ���
String        - 816817   �������.
StringBuffer  - 48   �������.
StringBuilder - 47   �������.
*/