
public class SortBubble {

	public static void main(String[] args) {
		//назъбкъел  х  гюонкмъел  люяяхб
		int marks[] = new int[20];
		for (int i=0; i<20; i++) {
			marks[i] = (int)(Math.random()*10 + 1);
		}

		//бшбндхл  люяяхб  дкъ  мюцкъдмнярх
		System.out.println("гюонкмеммши  люяяхб");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");

		//осгшпэйнбюъ  янпрхпнбйю
		for (int i = 0; i < marks.length - 1; i++) {
		    for (int j = 0; j < marks.length - i - 1; j++) {
		        if (marks[j] > marks[j + 1]) {
					int temp = marks[j];
					marks[j] = marks[j + 1];
					marks[j + 1] = temp;					            
		        }
		    }
		}   
				
		//бшбндхл  люяяхб  дкъ  мюцкъдмнярх
		System.out.println("нрянпрхпнбюммши  люяяхб  осгшпэйнбюъ  янпрхпнбйю");
		for (int i=0; i<marks.length; i++) {
			if (i==0) System.out.print("["+i+"]-"+marks[i]);
			else System.out.print(",["+i+"]-"+marks[i]);
		}
		System.out.println("");	
	}

}
