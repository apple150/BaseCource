/*	
 * 	������� � 21  		MaxStrWord		(�������������)
 * 	22.11.2014
 * 	����� � ������ ����� ������� �����
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class MaxStrWord {

	public static void main(String[] args) {
		String str = "  ���������, ������ ?�, ?���������� !!,.������� .,.� �������,. �.����������������, �������!  � ";
		System.out.println(str+'\n');
		char s;
		int OldInt=0, NewInt=0, count=0;
		String maxStr="";
		int max=0;
		String dop="";
		for (int i=0; i<str.length(); i++) {			
			s = str.charAt(i);
			NewInt=str.indexOf(s, NewInt); NewInt++;
			if ((s == ' ') || (s == ',') || (s == '.') || (s == '!') || (s == '?')) {
				if ((NewInt-OldInt)>1) { //���������� �����
					count++;
					dop=""; dop=str.substring(OldInt, NewInt-1);
					System.out.println(count+".  �����-"+dop);
					if (dop.length() > max) { //���������� ������������ ����� � ���-�� �������� � ��� 
						max=dop.length(); maxStr=dop;
					}
				}
				OldInt=NewInt; //���������� ������� � �������� ���������� �����
			} else {				  				
				if (NewInt==str.length()) {
					count++;
					dop=""; dop=str.substring(OldInt, NewInt);
					System.out.println(count+".  �����-"+dop);
				}
			}
		}
		System.out.println("\n� ������ - "+count+" ����");		
		System.out.println("����� ������� ����� - ("+maxStr+") ������� �� - "+max+" ��������");
	}
}