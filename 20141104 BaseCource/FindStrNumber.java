/*	
 * 	������� � 21  		FindStrNumber		(�������������)
 * 	22.11.2014
 * 	��� �����. ����� � ������ ��� ����� � ����������� ��
 * 	�������� ("   a15 163 52b 19text  ")
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class FindStrNumber {

	public static void main(String[] args) {
		String str="   a15 163 52b 19text 8  ";
		System.out.println(str+'\n');
		char s;
		int count=0;
		String number="";
		int sum=0;
		int OldInt=0; 
		int NewInt=0;
		boolean flag=false;
		
		for (int i=0; i<str.length(); i++) {			
			s = str.charAt(i);
			
			if ((s=='0')||(s=='1')||(s=='2')||(s=='3')||(s=='4')||(s=='5')||(s=='6')||(s=='7')||(s=='8')||(s=='9')) {
				OldInt=NewInt=i;
				count++;
				if (flag==true) OldInt=NewInt-count; //������ ���� ���������
				flag=true;
			} else {
				if (flag==true) {
					if (count > 0) {
						if (count==1) number=str.charAt(OldInt)+""; //number=str.substring(OldInt, OldInt+1);  //number=str.charAt(OldInt);													
						else number=str.substring(OldInt+1, OldInt+1+count);						
						System.out.println("number-"+number);
						count=0;
						int zn=Integer.parseInt(number);
						sum+=zn; //���������
					}
				}
				flag=false;
				NewInt=0;
				OldInt=0;				
			}
		}
		System.out.println("\n�����: "+sum);
	}

}
