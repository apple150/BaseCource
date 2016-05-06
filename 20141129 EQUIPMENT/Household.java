/*	
 * 	������� � 24  		Household 	����������: Equipment
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
 * ����� ����� 2-�� ������  
 * ���������� � ������ ������������
 * �� ���� ����� ������������� ���������� ������� �������
 * 
 */

public class Household extends Equipment {
	protected String specalization; //������������� ��� ����� 
	
	/**
	 * ����������� �� ���������
	 */	
	public Household () {
		super();
		setSpecialization();				
	}

	/**
	 * ����������� � �����������
	 */	
	public Household (int Power, String Producer) {
		super(Power, Producer);
		setSpecialization();		
	}	
	
	/**
	 * ���������� ������������� �������
	 */
	public void setSpecialization() {
		specalization="����";
	}
	
	public String toString() {
		return super.toString(); 
	}
}
