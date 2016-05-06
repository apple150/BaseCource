/*	
 * 	������� � 18		FindSymbols
 *	20.11.2014�.
 *	����� � ������ �� ������ �������, �� � ������ ����� ���������� 
 *	���������� ����� �� ���-��
 *
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
 */

public class FindSymbols {

	public static void main(String[] args) {		
		String str = " ��,  ���������, ������ ?�, ?���������� !!,.������� .,. � �������,. �.����������������, �������!   ��  ";
		
		int z=0, t=0, e=0, q=0; //z ������� �������, t-������� �����, e-�������� ��������������� ������, q-�������� ��������
		char s;
		for (int i=0; i<str.length(); i++) {
			s = str.charAt(i);
			if (s == ',') z++;
			else if (s == '.') t++;
			else if (s == '!') e++;
			else if (s == '?') q++;
		}
		System.out.println("� ������: "+str+'\n');
		System.out.println(z+" �������");
		System.out.println(t+" �����");
		System.out.println(q+" ��������");
		System.out.println(e+" ��������������� ������");		
	}
}
