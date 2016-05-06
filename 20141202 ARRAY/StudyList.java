/*	
 * 	������� � 28  		StudyList
 * 	04.12.2014
 * 	
 * 	������� ������ ������ �������� � ������� ArrayList, 
 * 	��������� ���������� ��������. 
 * 	����� ����� ������� ������ � ������� ���������   
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.*;

public class StudyList {

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
    
	/**
	 *	������ ����������� ������ �� ����������� ���������� � ��� ����� 
	 */
	static public void AnalizMaxRepeatNumber(List<Integer> arrayList) {
		int previous=-1, maxCount=0, number=0, i=0, count=0;
		Iterator<Integer> iterator = arrayList.iterator();   //�����  �������  �������  ��������
		while (iterator.hasNext()) {
			i=iterator.next().intValue();
			if (previous==-1) previous=i; 
			if (i == previous) { 
				count++;
				if (count > maxCount) {
					maxCount=count;
					number=i;
				}				
			} else {
				count=1; previous=i;
			} 			
			
		}
		System.out.println("����������� ����������� ����� :\t"+number+"\t"+maxCount+" ���");				
	}
    
	/**
	 *	������ ����������� ������ �� ����������� �������� ����� 
	 */
	static public void AnalizMaxNumber(List<Integer> arrayList) {
		int max=0, i=0, count=0;
		Iterator<Integer> iterator = arrayList.iterator();   //�����  �������  �������  �������� 
		while (iterator.hasNext()) {
			i=iterator.next().intValue();
			if (i > max) { 
				max=i; count=1; 
			} else if (i == max) count++; 			 
		}
		System.out.println("MAX:\t"+max+"\t���-�� ����� ������\t("+count+")");		
	}
	
	public static void main(String[] args) {
		System.out.println("������������ ������ � ARRAYLIST � ����������\n");
		List<Integer> arrayList = new ArrayList<Integer>();
		int count=20, item=0; 
		for (int i=0; i<count; i++) {
			item=GetRandomItem(1, 10);
			arrayList.add(item);
		}
		System.out.println("��������� �������� �������:\t"+arrayList+"  - "+arrayList.size()+" ���������");
		AnalizMaxNumber(arrayList);			//������ ����������� ������ �� ����������� �������� �����
		AnalizMaxRepeatNumber(arrayList);	//������ ����������� ������ �� ����������� ���������� � ��� �����
		
		Collections.sort(arrayList, compareArrayListInteger);
		//Arrays.sort(arrayList);
		System.out.println("\n��������������� ������:\t\t"+arrayList+"  - "+arrayList.size()+" ���������\n");
		AnalizMaxNumber(arrayList); 		//������ ����������� ������ �� ����������� �������� �����
		AnalizMaxRepeatNumber(arrayList); 	//������ ����������� ������ �� ����������� ���������� � ��� �����
	}
}
