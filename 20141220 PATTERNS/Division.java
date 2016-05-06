
public class Division extends Command {
	protected int x=0;
	protected int y=0;
	protected double rez=0;
	protected String st="";

	public Division(int itemX, int itemY) {
		x=itemX;
		y=itemY;	
	}
	
	@Override
	public void execute(MySingle ms) {
		rez=(double)x/y;
		st="  / ("+x+"/"+y+"="+rez+")\tDivision";		
		System.out.println(st);
		ms.WriteStr(st, 0);		
	}
}