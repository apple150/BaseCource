
public class SortVstavka {

	public static void main(String[] args) {
		//���������  �  ���������  ������
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1);
		}

		//�������  ������  ���  �����������
		System.out.println("�����������  ������");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");

		//���������� �������  ������  �������
	    for(int i = 1; i < marks.length; i++){
	         int currElem = marks[i];
	         int prevKey = i - 1;
	         while(prevKey >= 0 && marks[prevKey] > currElem){
	        	 marks[prevKey+1] = marks[prevKey];
	        	 marks[prevKey] = currElem;
	             prevKey--; 
	             i--;
	         }  
	     }
				
		//�������  ������  ���  �����������
		System.out.println("���������������  ������  �������  ������  �������");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");
	}

}
