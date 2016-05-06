/*	
 * 	������� � 26  		Students
 * 	02.12.2014
 * 	
 * 	������� ������ ������ �������� � ������� ArrayList, 
 * 	��������� ���������� ��������. 
 * 	������� �������������������� ������ �� ������  
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class Students {

	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	/**
	 * ���������� ��� ArrayList<Integer>
	 */
	static Comparator<Integer> compareArrayListInteger = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };	
	
	public static void main(String[] args) {
		System.out.println("������������ ������ � ARRAYLIST\n");
		List<Integer> arrayList = new ArrayList<Integer>();
		int count=20, item=0; 
		for (int i=0; i<count; i++) {
			item=GetRandomItem(1, 10);
			arrayList.add(item);
		}
		System.out.println("��������� �������� �������:\t"+arrayList+"  - "+arrayList.size()+" ���������");
		Collections.sort(arrayList, compareArrayListInteger);
		//arrayList.sort(compareArrayListInteger);  //����������		
		System.out.println("��������������� ������:\t\t"+arrayList+"  - "+arrayList.size()+" ���������\n");
		
		for (int i=0; i<arrayList.size(); i++) {
			if (arrayList.get(i) < 4) { arrayList.remove(i); i--;} 
		}
		System.out.println("������ ��� �������� ������ 3-�:\t"+arrayList+"  - "+arrayList.size()+" ���������");
	}
}
