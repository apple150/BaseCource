/*	
 * 	������� � 16		Sort
 * 	17.11.2014
 * 	������������ ������ 5-�� ����� ����������
 * 	1. �����  �������  ������ 
 * 	2. �����  ������  ������� 
 * 	3. ����� ����������� ����������
 * 	4. ����� ���������� ����� ��� (HEAPSORT)
 * 	5. ����� ������� ���������� ��� (QUICKSORT)
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Sort {

	/**
	 * �����  �������  �� �������
	 */
	public static void PrintArray(int marks[], int count, String st) {
		//�������  ������  ���  �����������
		System.out.print(st+"  ");
		for (int i=0; i<marks.length; i++) {
			//if (i==0) System.out.print("["+i+"]-"+marks[i]);
			//else System.out.print(",["+i+"]-"+marks[i]);
			if (i==0) System.out.print(i+"-"+marks[i]);
			else System.out.print(", "+i+"-"+marks[i]);			
		}
		if (count==0) System.out.println("");
		else System.out.println("  ("+count+")");
	}
	
	/**
	 * ���������  ������  ����������  ���������� � ��������� �� 1-interval
	 */
	public static void InitialArray(int marks[], int interval) {
		//���������  ������
		for (int i=0; i<20; i++) {
			//marks[i] = (int)(Math.random()*10 + 1);
			marks[i] = (int)(Math.random()*interval + 1);
		}
	}

	/**
	 * ��������  ��������  ������� � ������  ������������  �����
	 */
	public static void CopyArray(int marks[], int marks_new[]) {
		//���������  ������
		for (int i=0; i<20; i++) {
			marks_new[i] = marks[i];
		}
	}
	
	/**
	 * �����  �������  ������ 
	 */
	public static void SortVibor(int m[]) {
		//�������  �������  ������
		int minIndex=0, count=0;
		for (int i=0; i<m.length; i++) {
			minIndex=i;
			for (int j=i; j<m.length; j++) {
				if (m[minIndex] > m[j]) {
					count++;
					minIndex = j;
				}
			}
			int temp = m[minIndex];
			m[minIndex] = m[i];
			m[i] = temp;	
		}		
		PrintArray(m, count, "�����  �������  ������:");
	}

	/**
	 * �����  ������  ������� 
	 */
	public static void SortVstavka(int m[]) {
		//�������  ������  �������
		int count=0;
	    for(int i = 1; i < m.length; i++){
	         int currElem = m[i];
	         int prevKey = i - 1;
	         while(prevKey >= 0 && m[prevKey] > currElem) {
	        	 count++;
	        	 m[i] = m[prevKey];
	        	 m[prevKey] = currElem;
	             prevKey--; 
	             i--;
	         }  
	    }		
	    PrintArray(m, count, "�����  ������  �������:");
	}
		
	/**
	 * �����������  ���������� 
	 */
	public static void SortBubble(int m[]) {
		//�����������  ����������
		int temp=0, count=0;
		for (int i = 0; i < m.length - 1; i++) {
		    for (int j = 0; j < m.length - i - 1; j++) {
		        if (m[j] > m[j + 1]) {
		        	count++;
					temp = m[j];
					m[j] = m[j + 1];
					m[j + 1] = temp;					            
		        }
		    }
		} 		
		PrintArray(m, count, "����� ����������� ����:");
	}

	/**
	 * �������  ����������  (QUICKSORT) 
	 */
	public static void SortQuickSort(int m[], int low, int high) {
		// �����  �������  ����������  (QuickSort)
		int count=0;
		int temp=0;
		
		if (m == null || m.length == 0) return;
		if (low >= high) return;
 
		//pick the pivot		
		int middle = low + (high - low) / 2;
		int pivot = m[middle];
 
		//make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (m[i] < pivot) i++;			
			while (m[j] > pivot) j--; //��� ���� ������ Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
			if (i <= j) {
				count++;
				temp = m[i];
				m[i] = m[j];
				m[j] = temp;
				i++;
				j--;
			}
		}
		//recursively sort two sub parts
		if (low < j) 	SortQuickSort(m, low, j);
		if (high > i) 	SortQuickSort(m, i, high);						
		PrintArray(m, count, "�����  �������  ����������:");
	}	
		
	public static int count;
	
	/**
	 * ������������  ���  ������  (HEAPSORT)
	 */
	public static void MAX_HEAPIFY(int m[], int i, int heapSize)   {
		int l=2*i+1; //returns left index of a zero index based array
		int r=2*i+2; //returns right index of a zero based array
        int largestElementIndex = -1;  //index can't be negative so initialise largest index, it will be used later
        //heapSize is the current size of the heap being worked upon
        //check if left index lies within the heap.
        //if element at left index is greater than root(m[i]) element, max heap property is violated
        //copy the index of violated element in largestElementIndex
        if (l < heapSize && m[l] > m[i]) {
            largestElementIndex = l;
        } else { //if max heap property is not violated copy the root's index in largestElementIndex        
            largestElementIndex=i;
        }
        //check to see the right sub tree for max heap property violation
        //here the largestElementIndex is calculated from previous step
        if(r<heapSize && m[r] > m[largestElementIndex]) {
            largestElementIndex = r;
        }
        //if root doesn't has the largest index then swap the largest element with root element
        if(largestElementIndex!=i)  {
            int temp = m[i];
            m[i]=m[largestElementIndex];
            m[largestElementIndex]=temp;            
            count++;
            MAX_HEAPIFY(m, largestElementIndex, heapSize); //after swap, recursively call the MAX_HEAPIFY on the largest index(root element)
        }
    }	
	
	/**
	 * ���������� �����  (HEAPSORT) 
	 */
	public static void SortHeapSort(int m[]) {
		// �����  ����������  �����  (HeapSort)
		count = 0;
        int heapSize = m.length; //���-�� ��������� �������
        for(int i = m.length/2; i>=0; i--) {  //since n/2, n/2+1 ... are leaves we can start from n/2 step downwards        	
            MAX_HEAPIFY(m, i, heapSize);  //call MAX_HEAPIFY on each root node starting from n/2            
        }
        //starting from end loop through entire array
        for(int i=m.length-1; i>=0; i--) {        	
            //since heap is already heapified and maintains max heap property
            //the first element of the array is root of max heap
            //swap it with the extreme element of the array i.e. setting the largest element to the end of array
            int temp = m[0];
            m[0]=m[i];
            m[i]=temp;
            //reduce the heap window by 1
            heapSize = heapSize-1;
            MAX_HEAPIFY(m, 0, heapSize);  //call max heapify on the reduced heap
        }
        PrintArray(m, count, "����� �����  HEAP SORT:");
	}
	
	/**
	 * �����  ���������
	 */
	public static void main(String[] args) {
		int SizeOfArray = 20; //����������� ��������� � �������
		System.out.println("	   ������ ������� - "+SizeOfArray+" ���������");
		//System.out.println("");		
		int[] m1,m2,m3,m4,m5; 		//���������  5 ��������
			m1= new int[SizeOfArray];	//������� ����� 1
			m2= new int[SizeOfArray];	//������� ����� 2
			m3= new int[SizeOfArray];	//������� ����� 3
			m4= new int[SizeOfArray];	//������� ����� 4
			m5= new int[SizeOfArray];	//������� ����� 5
			
		InitialArray(m1,50); //��������� ������ ���������� ������� � ��������� �� 1 �� 50 			
		CopyArray(m1, m2);	//��������  �������� �� ������� 1 �  ������ 2
		CopyArray(m1, m3);	//��������  �������� �� ������� 1 �  ������ 3
		CopyArray(m1, m4);	//��������  �������� �� ������� 1 �  ������ 4
		CopyArray(m1, m5);	//��������  �������� �� ������� 1 �  ������ 5
		
			PrintArray(m1, 0, "������-1:"); 	//������� ������ 1
			PrintArray(m2, 0, "������-2:"); 	//������� ������ 2 
			PrintArray(m3, 0, "������-3:"); 	//������� ������ 3
			PrintArray(m4, 0, "������-4:"); 	//������� ������ 4
			PrintArray(m5, 0, "������-5:"); 	//������� ������ 5
			System.out.println("");
		
		SortVibor(m1); 	  //��������� � ������� ������ �������  �������  ������
		SortVstavka(m2);  //��������� � ������� ������ ������� ������  �������
		SortBubble(m3);   //��������� � ������� ������ �����������  �����������		
		SortHeapSort(m4); //��������� � ������� ������ ������� �����, ��� HEAP SORT
		//SortQuickSort(m5, 0, m4.length);   //��������� � ������� ������ ������� ������� ���������� ��� QUICKSORT
	}

}
