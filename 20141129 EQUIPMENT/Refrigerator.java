/*	
 * 	������� � 24  		Refrigerator 	����������: Kitchen
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
 * �����  ����������� 3-�� ������  
 * ���������� � ������ ������������ � �����
 * �� ���� ����� ����������� ���������� ������� �.�. ������������
 */

public class Refrigerator extends Kitchen {	
	protected String type="�����������";
		
	/**
	 * ����������� �� ���������
	 */	
	public Refrigerator () {
		super();
		power=GetRandomItem(500, 700); //����������-300 ����, �����������-1200 ����.
		producer=getProducer();
		int i=GetRandomItem(0, 2);
		if (i==0) on(); else off();		
	}
	
	/**
	 * ����������� � �����������
	 */	
	public Refrigerator (int Power, String Producer) {
		//super(GetRandomItem(250, 500), getProducer());
		super(0, "");
		power=GetRandomItem(500, 700);
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
		String [] m={"VESTEL", "SAMSUNG", "DELONGI", "ATLANT", "PHILIPS", "MOULINEX", "PANASONIC", "HITACHI", "GOLDSTAR", "BOMANN"};
		int i=GetRandomItem(0, m.length);
		rezult=m[i];
		return rezult;
	}
	
	@Override
	public String toString() {
		return "���-"+specalization+'\t'+type+"\t�������������-"+producer+"\t ��������-"+power+'\t'+getState()+"\t"+super.toString();
	}
}
