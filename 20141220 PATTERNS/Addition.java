
public class Addition extends Command {
	
	protected int x=0;
	protected int y=0;
	protected int rez=0;
	protected String st="";
	
	public Addition(int itemX, int itemY) {
		x=itemX;
		y=itemY;	
	}
	
	@Override
	public void execute(MySingle ms) {
		rez=x+y;
		st="  + ("+x+"+"+y+"="+rez+")\tAddition";
		//System.out.println("+ ("+x+"+"+y+"="+rez+")\tAddition");
		System.out.println(st);
		ms.WriteStr(st, 0);			
	}
}