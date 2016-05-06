public class Subtraction extends Command {
	protected int x=0;
	protected int y=0;
	protected int rez=0;
	protected String st="";
	
	public Subtraction(int itemX, int itemY) {
		x=itemX;
		y=itemY;	
	}
	
	@Override
	public void execute(MySingle ms) {
		rez=x-y;
		st="  - ("+x+"-"+y+"="+rez+")\tSubtraction";
		//System.out.println("- ("+x+"-"+y+"="+rez+")\tSubtraction");
		System.out.println(st);		
		ms.WriteStr(st, 0);
		if (x<y) {
			st="  Оператор ввел X меньше чем Y ";
			System.out.println(st);		
			ms.WriteStr(st, 0);
		} else if (x==y) {
			st="  Оператор ввел X равный Y ";			
			System.out.println(st);		
			ms.WriteStr(st, 0);			
		}		
	}
}