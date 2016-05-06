import java.util.Random;


public class TestMain {

	/**
	 * �����  �������  �� �������
	 */
	public static void PrintArray(int marks[], long count, String st) {	
		//�������  ������  ���  �����������
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
	 * ���������  ������  ����������  ���������� � ��������� �� 1-interval
	 */
	public static void InitialArray(int marks[], int interval) {
		//���������  ������
		for (int i=0; i<interval; i++) {
			//marks[i] = (int)(Math.random()*10 + 1);
			marks[i] = (int)(Math.random()*interval + 1);
		}
	}
	
	/**
	 * ��������  ��������  ������� � ������  ������������  �����
	 */
	public static void CopyArray(int marks[], int marks_new[]) {
		//���������  ������
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
                i++; //����� �������� ��������� �� ������ ����� �������
            }
            //System.out.println("x-"+x+" (i-"+i+" r-"+r+")  (j-"+j+" l-"+l+")");
            
            while (array[j] > array[x]) {
                j--; //����� �������� ��������� �� ����� ����� �������
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
		int SizeOfArray = 10; //����������� ��������� � �������
		System.out.println("	   ������ ������� - "+SizeOfArray+" ���������");
		//System.out.println("");		
		//int[] m1,m2,m3,m4,m5; 		//���������  5 ��������
		int[] m1, m2; 		//���������  5 ��������
			m1= new int[SizeOfArray];	//������� ����� 1
			m2= new int[SizeOfArray];	//������� ����� 2
			//m3= new int[SizeOfArray];	//������� ����� 3
			//m4= new int[SizeOfArray];	//������� ����� 4
			//m5= new int[SizeOfArray];	//������� ����� 5
			
		InitialArray(m1, SizeOfArray); //��������� ������ ���������� ������� � ��������� �� 1 �� 50 			
		CopyArray(m1, m2);	//��������  �������� �� ������� 1 �  ������ 2
		
		//PrintArray(m1, 0, "������-1:"); 	//������� ������ 1
		//timeOt=System.currentTimeMillis();
			//HeapSort.sort(m1); 
		//timeDo=System.currentTimeMillis(); rez=timeDo-timeOt;
		//PrintArray(m1, 0, "������-1:"); 	//������� ������ 1
			//System.out.println("������: "+SizeOfArray+" ��. ������������ �� "+rez+" ���.���. ���������� HeapSort");

		PrintArray(m2, rez, "������-1:"); 	//������� ������ 1
		timeOt=System.currentTimeMillis();
			qSort(m2, 0, m2.length); 
		timeDo=System.currentTimeMillis(); rez=timeDo-timeOt;
		//PrintArray(m1, 0, "������-1:"); 	//������� ������ 1
			System.out.println("������: "+SizeOfArray+" ��. ������������ �� "+rez+" ���.���. ���������� QuickSort");			
			
		PrintArray(m2, rez, "������-1:"); 	//������� ������ 1
	}
}
