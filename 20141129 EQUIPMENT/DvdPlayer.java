/*	
 * 	������� � 24  		DvdPlayer 	����������: AudioVideo
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
 * �����  DVD-����� 3-�� ������  
 * ���������� � ������ ������������ � ����� �����
 * �� ���� ����� ����������� ���������� ������� �.�. DVD-������
 */

public class DvdPlayer extends AudioVideo {
	protected String type="DVD-�����";
	
	/**
	 * ����������� �� ���������
	 */	
	public DvdPlayer () {
		super();
		power=GetRandomItem(100, 300); //����������-100 ����, �����������-400 ����.
		producer=getProducer();
		int i=GetRandomItem(0, 2);
		if (i==0) on(); else off();		
	}
	
	/**
	 * ����������� � �����������
	 */	
	public DvdPlayer (int Power, String Producer) {
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
	}	
}
