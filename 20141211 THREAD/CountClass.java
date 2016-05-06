
public class CountClass extends Thread {
	private StringBuffer text;
	private int countTo;
	
	public CountClass(StringBuffer s, int c) {
		text = s;
		countTo = c;
	}
	
	@Override
	public void run() {
		synchronized (text) {
			int sum = 0;
			for(int i=1; i <= countTo; i++) {
				sum += i;
				text.append("Item-"+i+", ");
			}
			text.append("\n\tSUM = "+sum+'\n') ;
		}
	}
}