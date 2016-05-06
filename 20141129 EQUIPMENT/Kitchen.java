/*	
 * 	������� � 24  		Kitchen 	����������: Equipment
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
 * �� ���� ����� ������������� ���������� �������� �������
 * 
 */

public class Kitchen extends Equipment {
	protected String specalization; //������������� ��� ����� 
		
	/**
	 * ����������� �� ���������
	 */	
	public Kitchen () {
		super();
		setSpecialization();				
	}

	/**
	 * ����������� � �����������
	 */	
	public Kitchen (int Power, String Producer) {
		super(Power, Producer);
		setSpecialization();		
	}	
	
	/**
	 * ���������� ������������� �������
	 */
	public void setSpecialization() {
		specalization="�����";
	}
	
	public String toString() {
		return super.toString(); 
	}	
}
