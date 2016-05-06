/*	
 * 	������� � 23  		Client	���	������ - Bank
 * 	25.11.2014
 * 	
 * 	������� ����� � ������� ����������� ��������. 
 * 	����� ����� ����������� � ��������� ������ ���������� ����� ����������: 
 * 	����������� ����� ��������� 20, 50, 100. 
 * 	1. ������� ������ ��� ���������� ����� � ��������. 
 * 	2. ������� ������� ��������� ������. 
 * 	3. �� ���� ���������� ����� �����. 
 * 	4. �� ����� - ��������� �������� (�������� ������� ��� ���). 
 * 	5. ��� ������ ����� ������� ������ ������������ ����� ����������� ����� ������ �������� �������� �����. 
 * 	6. ������� ����������� � ����� ����������� - ����������� �����. ������ - �� ���� ����������.
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Client {
	public int summa=0; //����� ������� ����� ����� ������
	public int minSumma=10;  //����������� ����� ������ �� ����� �����
	public int maxSumma=300; //������������ ����� ������ �� ����� �����
	
	public Client() {
		summa = GetRandomItem(minSumma,maxSumma); 	// ��������
		int ostatok = summa%10;
		//if (ostatok > 0) summa=summa+(10-ostatok);
		if (ostatok > 0) summa=summa-ostatok;
		//if (summa > 300) summa=300; 
	}
	
	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	public int GetRandomItem(int IntervalOt, int IntervalDo) {
		int rezult=0;
		rezult=(int) (Math.random() * IntervalDo + IntervalOt) ;
		return rezult;
	}

	public String getClientCash() {
		String rezult="";
		rezult="������ ��������: "+summa+"\t�������� �����";
		if (summa == minSumma) rezult=rezult+" MIN";
		if (summa == maxSumma) rezult=rezult+" MAX";
		return rezult;
	}
	
	public void PrintClientCash() {
		System.out.println(getClientCash());
	}	
	
	/**
	 * ��������� ��������� ����� 
	 */
	public int getMoney() {
		return summa;
	}		
}
