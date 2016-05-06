/*	
 * 	гюдюмхе ╧ 16		Sort
 * 	17.11.2014
 * 	дЕЛНМЯРПЮЖХЪ ПЮАНРШ 5-РХ БХДНБ ЯНПРХПНБНЙ
 * 	1. лернд  опълнцн  бшанпю 
 * 	2. лернд  опълни  бярюбйх 
 * 	3. лернд осгшпэйнбюъ янпрхпнбйю
 * 	4. лернд янпрхпнбйю йсвеи хкх (HEAPSORT)
 * 	5. лернд ашярпюъ янпрхпнбйю хкх (QUICKSORT)
 * 	
 *  ╘ Copyright		Sergey Buglak		(яЕПЦЕИ аСЦКЮЙ) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Sort {

	/**
	 * бшбнд  люяяхбю  мю йнмянкэ
	 */
	public static void PrintArray(int marks[], int count, String st) {
		//бшбндхл  люяяхб  дкъ  мюцкъдмнярх
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
	 * гюонкмъел  люяяхб  яксвюимшлх  гмювемхълх б дхюоюгнме нр 1-interval
	 */
	public static void InitialArray(int marks[], int interval) {
		//гюонкмъел  люяяхб
		for (int i=0; i<20; i++) {
			//marks[i] = (int)(Math.random()*10 + 1);
			marks[i] = (int)(Math.random()*interval + 1);
		}
	}

	/**
	 * йнохпсел  щкелемрш  люяяхбю б дпсцни  пюбмнгмювмши  люяхб
	 */
	public static void CopyArray(int marks[], int marks_new[]) {
		//гюонкмъел  люяяхб
		for (int i=0; i<20; i++) {
			marks_new[i] = marks[i];
		}
	}
	
	/**
	 * лернд  опълнцн  бшанпю 
	 */
	public static void SortVibor(int m[]) {
		//лернднл  опълнцн  бшанпю
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
		PrintArray(m, count, "лернд  опълнцн  бшанпю:");
	}

	/**
	 * лернд  опълни  бярюбйх 
	 */
	public static void SortVstavka(int m[]) {
		//лернднл  опълни  бярюбйх
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
	    PrintArray(m, count, "лернд  опълни  бярюбйх:");
	}
		
	/**
	 * осгшпэйнбюъ  янпрхпнбйю 
	 */
	public static void SortBubble(int m[]) {
		//осгшпэйнбюъ  янпрхпнбйю
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
		PrintArray(m, count, "лернд осгшпэйнбюъ янпр:");
	}

	/**
	 * ашярпюъ  янпрхпнбйю  (QUICKSORT) 
	 */
	public static void SortQuickSort(int m[], int low, int high) {
		// лернд  ашярпни  янпрхпнбйх  (QuickSort)
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
			while (m[j] > pivot) j--; //рср дюер ньхайс Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
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
		PrintArray(m, count, "лернд  ашярпни  янпрхпнбйх:");
	}	
		
	public static int count;
	
	/**
	 * ондопнжедспю  дкъ  лерндю  (HEAPSORT)
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
	 * янпрхпнбйю йсвеи  (HEAPSORT) 
	 */
	public static void SortHeapSort(int m[]) {
		// лернд  янпрхпнбйю  йсвеи  (HeapSort)
		count = 0;
        int heapSize = m.length; //ЙНК-БН ЩКЕЛЕМРНБ ЛЮЯЯХБЮ
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
        PrintArray(m, count, "лернд йсвеи  HEAP SORT:");
	}
	
	/**
	 * ярюпр  опнцпюллш
	 */
	public static void main(String[] args) {
		int SizeOfArray = 20; //йНККХВЕЯРБН ЩКЕЛЕМРНБ Б ЛЮЯЯХБЕ
		System.out.println("	   пюглеп люяяхбю - "+SizeOfArray+" щкелемрнб");
		//System.out.println("");		
		int[] m1,m2,m3,m4,m5; 		//назъбкъел  5 люяяхбнб
			m1= new int[SizeOfArray];	//янгдюел люяхб 1
			m2= new int[SizeOfArray];	//янгдюел люяхб 2
			m3= new int[SizeOfArray];	//янгдюел люяхб 3
			m4= new int[SizeOfArray];	//янгдюел люяхб 4
			m5= new int[SizeOfArray];	//янгдюел люяхб 5
			
		InitialArray(m1,50); //гЮОНКМЪЕЛ ЛЮЯЯХБ ЯКСВЮИМШЛХ ВХЯКЮЛХ Б ХМРЕПБЮКЕ НР 1 ДН 50 			
		CopyArray(m1, m2);	//йнохпсел  гмювемхъ хг люяяхбю 1 б  люяяхб 2
		CopyArray(m1, m3);	//йнохпсел  гмювемхъ хг люяяхбю 1 б  люяяхб 3
		CopyArray(m1, m4);	//йнохпсел  гмювемхъ хг люяяхбю 1 б  люяяхб 4
		CopyArray(m1, m5);	//йнохпсел  гмювемхъ хг люяяхбю 1 б  люяяхб 5
		
			PrintArray(m1, 0, "люяяхб-1:"); 	//бшбндхл люяяхб 1
			PrintArray(m2, 0, "люяяхб-2:"); 	//бшбндхл люяяхб 2 
			PrintArray(m3, 0, "люяяхб-3:"); 	//бшбндхл люяяхб 3
			PrintArray(m4, 0, "люяяхб-4:"); 	//бшбндхл люяяхб 4
			PrintArray(m5, 0, "люяяхб-5:"); 	//бшбндхл люяяхб 5
			System.out.println("");
		
		SortVibor(m1); 	  //янпрхпсел х бшбндхл люяяхб лернднл  опълнцн  бшанпю
		SortVstavka(m2);  //янпрхпсел х бшбндхл люяяхб лернднл опълни  бярюбйх
		SortBubble(m3);   //янпрхпсел х бшбндхл люяяхб осгшпэйнбни  янпрхпнбйни		
		SortHeapSort(m4); //янпрхпсел х бшбндхл люяяхб лернднл йсвеи, хкх HEAP SORT
		//SortQuickSort(m5, 0, m4.length);   //янпрхпсел х бшбндхл люяяхб лернднл ашярпни янпрхпнбйх хкх QUICKSORT
	}

}
