/*	
 * 	������� � 23  		Bank 	����������: Bankomat, Client
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

public class Bank {

	public static void main(String[] args) {
		Bankomat bt = new Bankomat(100, 100, 100);
		//bt.PrintCash();
		System.out.println('\t'+bt.GetCash()+'\n');
				
		int CountSuccsess=0, CountUnSuccsess=0, count=0, CountNotCupur=0; 
		int rezult=0;
		Client cl = null;
		for (int i=0; i<500; i++) {
			count++;
			cl = null; cl = new Client();			
			System.out.println((i+1)+".\t"+cl.getClientCash());
			rezult=bt.WithdrawMoney(cl.getMoney()); //��������� ������ �����
			if (rezult == 0) {
				CountSuccsess++;
				System.out.println("\t��������� ��������� ����� ������ ������� !!!");
				bt.PrintCash();
				if (bt.GetAllMoney() < 20) break;
			} else if (rezult == 1) {
				CountNotCupur++;
				System.out.println("\t� ��������� ������ ���� �� ����������� ����� ������ ����������");
			} else if (rezult == -1) {
				CountUnSuccsess++;
				System.out.println("\t��������� ��������� ����� ������ ��� ������� �.�. � ��������� ��� �������  ����������������  ��������");
				bt.PrintCash();								
			}
		}
		System.out.println("\n���� ���������: \n\t�������:\t"+CountSuccsess+" ��. \n\t����������:\t"+CountUnSuccsess+"��. \n\t�����:\t\t"+count+" ��. \n\t�� ���� �����:\t"+CountNotCupur+" ��.");
	}

}
