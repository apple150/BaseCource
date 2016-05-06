
public class MyFirst {

	public static void main(String[] args) {
		/*
		MyArray ar1 = new MyArray(10);
		for (int i=0; i < ar1.Size(); i++) {
			ar1.Set(i, 50-i); //Устанавливает значение конкретного элемента массива
		}
		
		MyIterator mi = ar1.Iterator();
		
		while(mi.hasNext()) {
			Integer i = (Integer) mi.next();
			System.out.println(i+"\t"+i.getClass().toString()+"\t\t"+i.getClass().hashCode()+"\t\t"+i.getClass().getSuperclass().toString());
			//System.out.println(i.getClass().getSuperclass().toString());
		}
		*/
		
		MyArrayNew ar1 = new MyArrayNew(10);
		for (int i=0; i < ar1.Size(); i++) {
			ar1.Set(i, 50-i); //Устанавливает значение конкретного элемента массива
		}
		
		MyIteratorNew mi = ar1.Iterator();
		
		while(mi.hasNext()) {
			Integer i = (Integer) mi.next();
			System.out.println(i+"\t"+i.getClass().toString()+"\t\t"+i.getClass().hashCode()+"\t\t"+i.getClass().getSuperclass().toString());
			//System.out.println(i.getClass().getSuperclass().toString());
		}		
	}

}
