
public class Test {
	public static void main(String[] args) {
		int count=200;
		StringBuffer text = new StringBuffer();
		CountClass c1 = new CountClass(text, count);
		CountClass c2 = new CountClass(text, count);
		CountClass c3 = new CountClass(text, count);
		
		c1.start();
		c2.start();
		c3.start();
		try {
			c1.join();
			c2.join();
			c3.join();			
		} catch (Exception e) {
			System.out.println("ננננננ");
		}
		System.out.println("\tResult:\n"+text);
	}
}
