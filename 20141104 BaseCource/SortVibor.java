
public class SortVibor {

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

		//���������  ������ �� ��������  �  ��������  (�������  �������  ������)
		int maxIndex=0;
		for (int i=0; i<marks.length; i++) {
			maxIndex=i;
			for (int j=i; j<marks.length; j++) {
				if (marks[maxIndex] < marks[j]) {
					maxIndex = j;
				}
			}
			int temp = marks[maxIndex];
			marks[maxIndex] = marks[i];
			marks[i] = temp;			
		}
						
		//�������  ������  ���  �����������
		System.out.println("���������������  ������  �������  �������  ������");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");		
	}
}
