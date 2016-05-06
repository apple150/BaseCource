/*	
 * 	������� � 24  		Equipment 	������� ����� 1-�� ������ 
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
 * ����� ������������ 1-�� ������  
 * � �����-�� ������� ����������� ����� 
 * �� �������� ����������� ��������� ������
 */

public class Equipment {
	//������������ ������� ������
	protected int power=0; 			//������������ ��������
	protected String producer=""; 	//�������������	
	protected boolean isOn;			//������� ��� ��������
	//protected int inv_num=0; 		//����������� �����
	
	public void on() {
		isOn = true;
	}
	
	public void off() {
		isOn = false;
	}
	
	public String getState() {
		String rezult="";
		if (isOn==true) rezult="on"; else rezult="off";
		return rezult;
	}	
		
	/**
	 * ����������� �� ���������
	 */
	public Equipment() {
		setPower(0);
		setProducer("");
	}

	/**
	 * ����������� � �����������
	 */
	public Equipment(int Power, String Producer) {
		setPower(Power);
		setProducer(Producer);
	}
	
	/*
	public String toString() {
		return getInfo()+super.toString(); 
	}
	*/
	
	public int getPower() {
		return power;
	}
	
	public String getProducer() {
		return producer;
	}

	public void setPower(int item) {
		power=item;
	}
	
	public void setProducer(String item) {
		producer=item;
	}
	
	public String getInfo() {
		return "power-"+power+", producer-"+producer+" ";
	}
}