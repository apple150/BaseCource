/*	
 * 	������� � 27  		Repeat
 * 	02.12.2014
 * 	
 * 	������� ���������, ��������� �� ���������� �������. �������	������������� �����. 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class Repeat {
	
	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	

	/**
	 * ���������� ��� LinkedList<Integer>
	 */
	static Comparator<Integer> compareLinkedListInteger = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };		
	
	public static void main(String[] args) {
		System.out.println("������������ ������ � LINKEDLIST\n");
		List<Integer> linkedList = new LinkedList<Integer>();
		int count=20, item=0; 
		for (int i=0; i<count; i++) {
			item=GetRandomItem(1, 10);
			linkedList.add(item);
		}
		System.out.println("��������� �������� �������:\t"+linkedList+"  - "+linkedList.size()+" ���������");
		
		for (int i=0; i<linkedList.size(); i++) {
			for (int j=i+1; j<linkedList.size(); j++) {
				if (linkedList.get(i) == linkedList.get(j)) { linkedList.remove(j); j--;}
			} 
		}
		System.out.println("������ � ������. ����������:\t"+linkedList+"  - "+linkedList.size()+" ���������\n");
		//linkedList.sort(compareLinkedListInteger);		 //����������
		Collections.sort(linkedList, compareLinkedListInteger);
		System.out.println("��������������� ������:\t\t"+linkedList+"  - "+linkedList.size()+" ���������\n");
		
	}	
}
