/*
 * 	������� � 1		����������� �������		Port � Ship 	
 * 	11.12.2014
 * 	��������� �������� � �����
 * 	������ ������������ ������� ��� �����
 * 	�������� ������ ���� �� ������ 10-��
 * 	� ����� ���� ����� ��� 3-�
 * 	����� �� ������� ��� � ���� 
 * 	���������� ������������ ������� wait() �� �������� 7
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Greeting {
	/**
	 * �����  �������  ������ 
	 */
	public static void SortVibor(Locale m[]) {
		int minIndex=0;
		for (int i=0; i<m.length; i++) {
			minIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[minIndex].toString().compareTo(m[j].toString()) > 0 ) {
					minIndex = j;
				}
			}
			Locale temp = m[minIndex];
			m[minIndex] = m[i];
			m[i] = temp;	
		}
	}
	
	public static void main(String[] args) {
		String itemLocal="";
		Locale loc = new Locale("ru", "RU");		
		if (args.length>0) {
			for (int i=0; i<args.length; i++) {
				itemLocal=args[i].toString();
				System.out.println("Locale �� args: "+itemLocal);
				if ((itemLocal.compareTo("en")==0)||(itemLocal.compareTo("ru")==0)||(itemLocal.compareTo("zz")==0)) {
					loc = new Locale(itemLocal);
					ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
					System.out.println('\t'+rb.getString("greeting"));
					System.out.println('\t'+rb.getString("question"));
					System.out.println("");
				}
			}
		} else {
			System.out.println("�� ��������� ���������� Local ");
			loc = new Locale(itemLocal);
			ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
			System.out.println('\t'+rb.getString("greeting"));
			System.out.println('\t'+rb.getString("question"));			
		}
		
		System.out.println("���������� Lokal");
		loc = new Locale("en", "UK");		
		ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));
		System.out.println('\t'+rb.getString("question"));		
		
		System.out.println("\n������� Lokal");
		loc = new Locale("ru", "RU");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));		
		System.out.println('\t'+rb.getString("question"));
		
		System.out.println("\n����������� Lokal");
		loc = new Locale("be", "BY");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));		
		System.out.println('\t'+rb.getString("question"));

		System.out.println("\n���������� Lokal");
		loc = new Locale("uk", "UA");
		rb = ResourceBundle.getBundle("MessagesBundle", loc); 
		System.out.println('\t'+rb.getString("greeting"));		
		System.out.println('\t'+rb.getString("question"));
		
		/*
		System.out.println("");
		System.out.println("������������ ������");
		Locale [] mas = Locale.getAvailableLocales();		
		System.out.println("�������������� ������");
		SortVibor(mas);
		for (int i=0; i<mas.length; i++) {
			System.out.println(mas[i].toString());
		}
		*/
	}
}
