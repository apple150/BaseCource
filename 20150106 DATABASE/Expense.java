import java.util.GregorianCalendar;


public class Expense {
	private int num; //Номер расхода
	private String paydate; //Дата расхода
	private int receiver; //Номер магазина
	private int value; //Сумма расхода
	
	
	public Expense() {}

	public Expense(int num, String paydate, int receiver, int value) {
		setNum(num);
		setPaydate(paydate);
		setReceiver(receiver);
		setValue(value);
	}
		
	public Expense(String paydate, int receiver, int value) {		
		setPaydate(paydate);
		setReceiver(receiver);
		setValue(value);
	}

	public Expense(int receiver, int value) {
		setReceiver(receiver);
		setValue(value);
		setPaydate(getCurrentDate());
	}
		
	public Expense(String paydate) {
		setPaydate(paydate);
	}

	public Expense(int value) {		
		setValue(value);
	}
	
	public String getCurrentDate() {
		String dt="";
		GregorianCalendar calen = new GregorianCalendar();
		int y=calen.get(calen.YEAR);
		int m=calen.get(calen.MONTH)+1;
		int d=calen.get(calen.DATE);
		String mes="", den="";
		if (m < 10) mes="0"+m; else mes=m+""; 
		if (d < 10) den="0"+d; else den=d+"";
		dt=y+"-"+mes+"-"+den;
		return dt;
	}
		
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		String name="";
		name="Obj  Expense:\tnum-"+getNum()+"\t paydate-"+getPaydate()+"\t receiver-"+getReceiver()+"\t value-"+getValue();
		return name;		
	}	
}
