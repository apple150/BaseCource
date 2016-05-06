/*	
 * 	������� � 6  		����������� �������		Loger
 * 	20.12.2014
 * 	������� ���������� ������ ��������� ��������� �� ������� � ��������� ����.
 * 	������ ������� ������ ���� ������ � ������� �� Singleton. 
 * 	� ������� ������ ���� ������������ ���� ����� ���������� �� ����
 * 	����� ��������� (�� ������ ...) � ������������ ��� � ���� ������ � 
 * 	����������� � ���� � ������� �����������
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Logger {
	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	/**
	 * �����  �������  ������ 
	 */
	public static void SortVibor(String m[]) {
		int minIndex=0;
		for (int i=0; i<m.length; i++) {
			minIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[minIndex].toString().compareTo(m[j].toString()) > 0 ) {
					minIndex = j;
				}
			}
			String temp = m[minIndex];
			m[minIndex] = m[i];
			m[i] = temp;	
		}
	}	

	/**
	 * �����  ������  �  LOG-����
	 */
	public static void PrintArray(String m[], MySingle ms) {
		ms.WriteStr("\t\t����� ������ �������", 0);
		int count=0;
		for (int i=0; i<m.length; i++) {
			count++;
			/*
			try {
				ms.WriteStr("������ �� ������� ��������: "+m[i], count);
			} catch (Exception ex) {
				ms.WriteStr("�������� �������� = NULL", count);
			}*/
			
			if (m[i]==null) {
				ms.WriteStr("�������� �������� = NULL", count);
			} else {
				ms.WriteStr("������ �� ������� ��������: "+m[i], count);
			}
		}			
	}
		
	public static void main(String[] args) {
		MySingle ms = MySingle.GetMySingle(); //2-�� ������� ������� �� ���������
		ms.OpenFile();
		List<String> arrayShip = new ArrayList<String>();
		String [] mas = {"VICTORIA", "BRITANIA", "COLUMBIA", "ATLANTIC", "PILIGRIM", "NAUTILUS", "A.LINKOLN", "DRESDEN", "INVISIBLE", "INFLEXIBLE", "SIDNEY", "SHARNHORST", "GNEYSENAU", "NASSAU", "GOOD HOPE", "UTLANDIA", "GLASGOW", "ORLANDO"};
		String temp="";
		int item=0, count=0;
		ms.WriteStr("\t\t����� ���������� �������", 0);
		for (int i=0; i<mas.length; i++) {
			item=GetRandomItem(i,(mas.length-i));
			temp=mas[item];			
			arrayShip.add(temp); //��������� � ������ ��������� �������� �������� � �� ������ � ������
			count++;
			ms.WriteStr("�������� � ������ ����� ��������: "+temp, count);
			//�������� ��� ���� ����� ������������� �������� �������
			mas[item]=mas[i];
			mas[i]=temp;
		}
		
		ms.WriteStr("\t\t����� ������ �������", 0);
		count=0;
		for (int i=0; i<mas.length; i++) {
			count++;
			ms.WriteStr("������ �� ������� ��������: "+mas[i], count);
		}
		
		ms.WriteStr("\t\t���������� �������", 0);
		SortVibor(mas);
		
		ms.WriteStr("\t\t����� ������ �������", 0);
		count=0;
		for (int i=0; i<mas.length; i++) {
			count++;
			ms.WriteStr("������ �� ������� ��������: "+mas[i], count);		
		}		
		
		mas[3]=null;
		PrintArray(mas, ms);
		
		ms.CloseFile();		
	}
}
