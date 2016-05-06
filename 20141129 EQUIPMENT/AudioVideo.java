/*	
 * 	������� � 24  		AudioVideo 	����������: Equipment
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
 * ����� ����� & ����� 2-�� ������  
 * ���������� � ������ ������������
 * �� ���� ����� ������������� ���������� ����� & ����� �������
 */

public class AudioVideo extends Equipment {
	protected String specalization; //������������� ��� ����� 
	
	/**
	 * ����������� �� ���������
	 */	
	public AudioVideo () {
		super();
		setSpecialization();				
	}

	/**
	 * ����������� � �����������
	 */	
	public AudioVideo (int Power, String Producer) {
		super(Power, Producer);
		setSpecialization();		
	}	
	
	/**
	 * ���������� ������������� �������
	 */
	public void setSpecialization() {
		specalization="�����&�����";
	}
	
	public String toString() {
		return super.toString(); 
	}	
}
