/*
 * 	������� � 20		LastLetters
 * 	20.11.2014
 * 	������� ������ � �������. ������� �����, 
 * 	������������ �� ��������� ���� ���� ����.
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class LastLetters {

	public static boolean Analiz(char s, String symbols) {
		boolean flag=false;
		for (int i=0; i<symbols.length(); i++) {
			if (s==symbols.charAt(i)) {
				flag=true; break;				
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String str = " ��,  ���������, ������ ?�, ?���������� !!,.������� .,. � �������,. �.����������������, �������!   ��  ";
		System.out.println(str+'\n');
		
		String symbols=" ,.!?;:";	//������� ������� � ����� �� ������
		String dop="";
		int iterator=0, count=0;
		int len=str.length()-1; //������ ������		
		for (int i=0; i <= len; i++) {			
			if (Analiz(str.charAt(i), symbols)) { //���� ��� ���� �� ��������
				if (count > 0) {
					iterator++;
					dop=str.substring(i-count, i);
					System.out.print(dop.charAt(dop.length()-1));					
					count=0;
				}
			} else if (len == i) {
				iterator++;
				dop=str.substring(i-count, i+1);
				System.out.print(dop.charAt(dop.length()-1));				
			} else count++;
		}		
		System.out.println("\n\n� ������ - "+iterator+" ����");		
	}
}
