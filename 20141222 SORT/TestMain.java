import java.util.Random;


public class TestMain {

	/**
	 * ÂÛÂÎÄ  ÌÀÑÑÈÂÀ  ÍÀ ÊÎÍÑÎËÜ
	 */
	public static void PrintArray(int marks[], long count, String st) {	
		//ÂÛÂÎÄÈÌ  ÌÀÑÑÈÂ  ÄËß  ÍÀÃËßÄÍÎÑÒÈ
		if (count==0) System.out.print(st+"  ");
		else System.out.println(st+" "+count+" ");
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
	 * ÇÀÏÎËÍßÅÌ  ÌÀÑÑÈÂ  ÑËÓ×ÀÉÍÛÌÈ  ÇÍÀ×ÅÍÈßÌÈ Â ÄÈÀÏÀÇÎÍÅ ÎÒ 1-interval
	 */
	public static void InitialArray(int marks[], int interval) {
		//ÇÀÏÎËÍßÅÌ  ÌÀÑÑÈÂ
		for (int i=0; i<interval; i++) {
			//marks[i] = (int)(Math.random()*10 + 1);
			marks[i] = (int)(Math.random()*interval + 1);
		}
	}
	
	/**
	 * ÊÎÏÈĞÓÅÌ  İËÅÌÅÍÒÛ  ÌÀÑÑÈÂÀ Â ÄĞÓÃÎÉ  ĞÀÂÍÎÇÍÀ×ÍÛÉ  ÌÀÑÈÂ
	 */
	public static void CopyArray(int marks[], int marks_new[]) {
		//ÇÀÏÎËÍßÅÌ  ÌÀÑÑÈÂ
		for (int i=0; i<marks.length; i++) {
			marks_new[i] = marks[i];
		}
	}	
	
	
	static Random rand;
	
	public static void qSort(int[] array, int l, int r) {
        int i = l;
        int j = r-1;
        int x = (i + j) / 2;
        while (i <= j) {        	
            while (array[i] < array[x]) { 
                i++; //íàøëè çíà÷åíèå âûõîäÿùåå çà ïğàâóş ÷àñòü ìàññèâà
            }
            //System.out.println("x-"+x+" (i-"+i+" r-"+r+")  (j-"+j+" l-"+l+")");
            
            while (array[j] > array[x]) {
                j--; //íàøëè çíà÷åíèå âûõîäÿùåå çà ëåâóş ÷àñòü ìàññèâà
            }
            System.out.println("i-"+i+ "  j-"+j);
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        //System.out.println("l-"+l+" j-"+j);
        if (l < j) {
            qSort(array, l, j);
        }
        //System.out.println("i-"+i+" r-"+r);
        if(i < r) {
            qSort(array, i, r);
        }
    }	
	
	 public static void qSort1(int array[], int begin, int end){
	     int med = (begin + end - 1) / 2;
	     while(begin != med && end != med){
	    	 while (array[begin] <= array[med]) {	         
	    		 begin += 1;
	         }
	         while (array[end] >= array[med]) {
	        	 end -= 1;
	         }
	         if (begin < end){
	        	 int temp = array[begin];
	             array[begin] = array[end];
	             array[end] = temp;
	         }
	    }
	    qSort1(array, med + 1, end);
	    qSort1(array, begin, med - 1);
	}
	
	public static void main(String[] args) {
		
		long timeOt=0, timeDo=0, rez=0; 		
		int SizeOfArray = 10; //Êîëëè÷åñòâî ıëåìåíòîâ â ìàññèâå
		System.out.println("	   ĞÀÇÌÅĞ ÌÀÑÑÈÂÀ - "+SizeOfArray+" İËÅÌÅÍÒÎÂ");
		//System.out.println("");		
		//int[] m1,m2,m3,m4,m5; 		//ÎÁÚßÂËßÅÌ  5 ÌÀÑÑÈÂÎÂ
		int[] m1, m2; 		//ÎÁÚßÂËßÅÌ  5 ÌÀÑÑÈÂÎÂ
			m1= new int[SizeOfArray];	//ÑÎÇÄÀÅÌ ÌÀÑÈÂ 1
			m2= new int[SizeOfArray];	//ÑÎÇÄÀÅÌ ÌÀÑÈÂ 2
			//m3= new int[SizeOfArray];	//ÑÎÇÄÀÅÌ ÌÀÑÈÂ 3
			//m4= new int[SizeOfArray];	//ÑÎÇÄÀÅÌ ÌÀÑÈÂ 4
			//m5= new int[SizeOfArray];	//ÑÎÇÄÀÅÌ ÌÀÑÈÂ 5
			
		InitialArray(m1, SizeOfArray); //Çàïîëíÿåì ìàññèâ ñëó÷àéíûìè ÷èñëàìè â èíòåğâàëå îò 1 äî 50 			
		CopyArray(m1, m2);	//ÊÎÏÈĞÓÅÌ  ÇÍÀ×ÅÍÈß ÈÇ ÌÀÑÑÈÂÀ 1 Â  ÌÀÑÑÈÂ 2
		
		//PrintArray(m1, 0, "ÌÀÑÑÈÂ-1:"); 	//ÂÛÂÎÄÈÌ ÌÀÑÑÈÂ 1
		//timeOt=System.currentTimeMillis();
			//HeapSort.sort(m1); 
		//timeDo=System.currentTimeMillis(); rez=timeDo-timeOt;
		//PrintArray(m1, 0, "ÌÀÑÑÈÂ-1:"); 	//ÂÛÂÎÄÈÌ ÌÀÑÑÈÂ 1
			//System.out.println("Ìàññèâ: "+SizeOfArray+" ıë. îòñîğòèğîâàí çà "+rez+" ìèë.ñåê. àëãîğèòìîì HeapSort");

		PrintArray(m2, rez, "ÌÀÑÑÈÂ-1:"); 	//ÂÛÂÎÄÈÌ ÌÀÑÑÈÂ 1
		timeOt=System.currentTimeMillis();
			qSort(m2, 0, m2.length); 
		timeDo=System.currentTimeMillis(); rez=timeDo-timeOt;
		//PrintArray(m1, 0, "ÌÀÑÑÈÂ-1:"); 	//ÂÛÂÎÄÈÌ ÌÀÑÑÈÂ 1
			System.out.println("Ìàññèâ: "+SizeOfArray+" ıë. îòñîğòèğîâàí çà "+rez+" ìèë.ñåê. àëãîğèòìîì QuickSort");			
			
		PrintArray(m2, rez, "ÌÀÑÑÈÂ-1:"); 	//ÂÛÂÎÄÈÌ ÌÀÑÑÈÂ 1
	}
}
