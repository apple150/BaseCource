
public class Receiver {
	private int num; //Номер магазина
	private String name; //Название магазина
	
	public Receiver() {}
	
	public Receiver(String name) {
		setName(name);
	}
	
	public Receiver(int num, String name) {
		setNum(num);
		setName(name);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String name="";
		name="Obj Receiver:\tnum-"+getNum()+"\t name-"+getName();
		return name;		
	}
}
