/*	
 * 	������� � 24  		Mp3Player 	����������: AudioVideo
 * 	27.11.2014
 * 	
 * 	������� �������� ������� ����������� ������� ������� 
 * 	������� ��������� �������� ��������� ������, ����� �� ��� �������� � ������� 
 * 	�������� ������ ����� ���� �� 3 ������ 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

/**
 * �����  mp3-����� 3-�� ������  
 * ���������� � ������ ������������ � ����� �����
 * �� ���� ����� ����������� ���������� ������� �.�. mp3-������
 */

public class Mp3Player extends AudioVideo {
	protected String type="mp3-�����";
	
	/**
	 * ����������� �� ���������
	 */	
	public Mp3Player () {
		super();
		power=GetRandomItem(30, 50); //����������-30 ����, �����������-80 ����.
		producer=getProducer();
		int i=GetRandomItem(0, 2);
		if (i==0) on(); else off();		
	}
	
	/**
	 * ����������� � �����������
	 */	
	public Mp3Player (int Power, String Producer) {
		//super(GetRandomItem(250, 500), getProducer());
		super(0, "");
		power=GetRandomItem(250, 500);
		producer=getProducer();
	}	

	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}
		
	public String getProducer() {
		String rezult="";
		String [] m={"SAMSUNG", "PHILIPS", "PANASONIC", "HITACHI", "GOLDSTAR", "SONY"};
		int i=GetRandomItem(0, m.length);
		rezult=m[i];
		return rezult;
	}
	
	@Override
	public String toString() {
		return "���-"+specalization+'\t'+type+"\t�������������-"+producer+"\t ��������-"+power+'\t'+getState()+"\t"+super.toString();
		//return "���-"+specalization+'\t'+type+"\t�������������-"+producer+"\t ��������-"+power+'\t'+getState()+"\t"+super.toString()+'\t'+super.super.toString();
	}	
}