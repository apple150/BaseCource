/*	
 * 	������� � 23  		Bankomat	���	������ - Bank
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

public class Bankomat {
	public int AllMoney=0;
	public int Money20=0;
	public int Money50=0;
	public int Money100=0;
	
	/**
	 * ����������� �� ���������
	 */
	public Bankomat() {
		this.Money20 = 200;
		this.Money50 = 200;
		this.Money100 = 200;
		SumAllMoney();
	}
	
	/**
	 * ����������� � �����������
	 */
	public Bankomat(int m20, int m50, int m100) {
		this.Money20 = m20;
		this.Money50 = m50;
		this.Money100 = m100;
		SumAllMoney();
	}
	
	/**
	 * ��������� ������������ ������ ���������� ����� � ����� 
	 */
	public void SumAllMoney() {
		AllMoney=((Money20*20)+(Money50*50)+(Money100*100));
	}
	
	/**
	 * ��������� ������������ ������� � ��������� ����� 
	 */
	public int GetAllMoney() {
		return AllMoney;
	}

	
	/**
	 * �������� ���-�� ����� � ���������  
	 */
	public String GetCash() {
		String rezult="";
		rezult="� ���������: "+(AllMoney+" �������� �����, �.�. (20-���)-"+Money20+" ��. (50-���)-"+Money50+" ��. (100-���)-"+Money100+" ��.");
		return rezult;
	}
	
	public void PrintCash() {
		System.out.println('\t'+GetCash());
	}
	
	/**
	 * ��������� ������ �����
	 */
	public int WithdrawMoney(int ClientMoney) {
		int rezult=-1;
		if (ClientMoney<=AllMoney) {
			int zn=0;			
			int flag=0;
			zn=ClientMoney%20;
			if (zn==0) flag=20;
			if (flag==0) { zn=ClientMoney%40; if (zn==0) flag=40; }
			if (flag==0) { zn=ClientMoney%50; if (zn==0) flag=50; }
			if (flag==0) { zn=ClientMoney%60; if (zn==0) flag=60; }
			if (flag==0) { zn=ClientMoney%70; if (zn==0) flag=70; }
			if (flag==0) { zn=ClientMoney%80; if (zn==0) flag=50; }
			if (flag==0) { zn=ClientMoney%90; if (zn==0) flag=90; }
			if (flag==0) { zn=ClientMoney%100; if (zn==0) flag=100; }														
			if (flag>0) {
				//System.out.println("\t������� �� ������� �� %"+flag+"="+zn);
				if (ClientMoney>110) {
					if (Money50 > Money100) {
						while (ClientMoney > 110) { 
							if (Money50 > 0) { 
								Money50--; ClientMoney-=50; SumAllMoney(); 
							} else break; 
						}
					} else if (Money100 > Money50) {
						while (ClientMoney > 110) { 
							if (Money100 > 0) { 
								Money100--; ClientMoney-=100;  SumAllMoney(); 
							} else break; 
						}						
					} else if (Money100 == Money50) {
						while (ClientMoney > 110) { 
							if (Money100 > 0) { 
								Money100--; ClientMoney-=100;  SumAllMoney();
							} else break; 
						}						
					}
				}
				if ((ClientMoney==20) && (Money20>0)) { Money20--; ClientMoney-=20; SumAllMoney(); }
				if ((ClientMoney==40) && (Money20>1)) { Money20-=2; ClientMoney-=40; SumAllMoney(); } 
				if ((ClientMoney==50) && (Money50>0)) { Money50--; ClientMoney-=50; SumAllMoney(); }
				if ((ClientMoney==60) && (Money20>2)) { Money20-=3; ClientMoney-=60;  SumAllMoney(); }
				if ((ClientMoney==70) && (Money20>0) && (Money50>0)) { Money20--; Money50--; ClientMoney-=70; SumAllMoney(); }
				if ((ClientMoney==80) && (Money20>3)) { Money20-=4;  ClientMoney-=80;  SumAllMoney(); }
				if ((ClientMoney==90) && (Money20>1) && (Money50>0)) { Money20-=2; Money50--; ClientMoney-=90; SumAllMoney(); }
				if ((ClientMoney==100) && (Money100>0)) { Money100--; ClientMoney-=100; SumAllMoney(); }
				if ((ClientMoney==110) && (Money20>2) && (Money50>0)) { Money20-=3; Money50--; ClientMoney-=110;  SumAllMoney(); }
				
				
				/*
				if (ClienMoney<=110) {
					if ((ClientMoney==20) && (Money20>0)) Money20--;
					if ((ClientMoney==40) && (Money20>1)) Money20-=2; 
					if ((ClientMoney==50) && (Money50>0)) Money50--;
					if ((ClientMoney==60) && (Money20>2)) Money20-=3;
					if ((ClientMoney==70) && (Money20>0) && (Money50>0)) { Money20--; Money50--; }
					if ((ClientMoney==80) && (Money20>3)) Money20-=4;
					if ((ClientMoney==90) && (Money20>1) && (Money50>0)) { Money20-=2; Money50--; }
					if ((ClientMoney==100) && (Money100>0)) Money100--;
					if ((ClientMoney==110) && (Money20>2) && (Money50>0)) { Money20-=3; Money50--; }
				}
				
				if (ClientMoney>110) {
					if (Money50 > Money100) {
						while (ClientMoney < 110) Money50--;
					} else if (Money100 > Money50) {
						
					} else if (Money100 == Money50) {
						
					}
					
					if ((ClientMoney==120) && (Money20>0) && (Money100>0)) { Money20--; Money100--; }
					if ((ClientMoney==130) && (Money20>3) && (Money50>0)) { Money20-=4; Money50--; }
					if ((ClientMoney==140) && (Money20>1) && (Money100>0)) { Money20-=2; Money100--; }
					
					if ((ClientMoney==200) && (Money100>1)) { Money100-=2; }
					if ((ClientMoney==300) && (Money100>2)) { Money100-=3; }
					
					if ((ClientMoney==150) && (Money50>0) && (Money100>0)) { Money50--; Money100--; }
					if ((ClientMoney==250) && (Money50>0) && (Money100>1)) { Money50--; Money100-=2; }
				}
				
				AllMoney=AllMoney-ClientMoney;
				*/
				rezult=0; 
			} else {
				return 1;
			}
		} else {
			rezult=-1; //� ����� ������������ �����
		}
		return rezult;
	}
	
}
