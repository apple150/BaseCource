/*	
 * 	������� � 22  		ClassTime
 * 	25.11.2014
 * 	������� ����� � ������� ����������� ���������� �������. �������� ������ ����, ������, �������
 * 	������� ����� ��������� ���� �������� ����� ������
 * 	������� 2 ����������� (���������� ���-�� ����� � ���� ������ ������� ��������) 	
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class ClassTime {

	public int hour=0; //����
	public int min=0;  //������
	public int sec=0;  //�������

	//����������� �� ���������
	public ClassTime() {
		/*
		this.hour = (int) (Math.random() * 23) ;
		this.min = (int) (Math.random() * 59) ;
		this.sec = (int) (Math.random() * 59) ;
		*/
		this.hour = GetRandomItem(0,23); 	// ����
		this.min = GetRandomItem(0,59); 	// ������
		this.sec = GetRandomItem(0,59); 	// �������
	}
	
	//����������� ���������� ������ ������� ������
	public ClassTime(int tm) {
		int m, h; // �������� ����������		
			sec = tm % 60; 	// ������� ������ ����� ������� �� 60
		m = (tm - sec) / 60; // ����� ���������� �����
			min = m % 60; 	// �������  ����� ����� ������� �� 60
		h = (m - min) / 60; // ����� ���������� �����
			hour = h%24; 	// ������� ����� ����� ������� �� 24
	}
	
	//����������� ���������� ������ ����, ������, �������
	public ClassTime(int hour, int min, int sec) {
		this.hour=hour;
		this.min=min;
		this.sec=sec;
	}
	
	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	public int GetRandomItem(int IntervalOt, int IntervalDo) {
		int rezult=0;
		rezult=(int) (Math.random() * IntervalDo + IntervalOt) ;
		return rezult;
	}
	
	public int getHour() {
		return this.hour;
	}

	public int getMin() {
		return this.min;
	}
	
	public int getSec() {
		return this.sec;
	}
	
	/**
	 * ���������� �������� ����������������� �� 2-� ��������
	 */
	public String getIntToString2(int item) {
		String rezult=item+"";
		if (item < 10) rezult="0"+item;
		return rezult;
	}
	
	
	/**
	 *	��������� ��������� ���������� INT (-1, 0, 1)
	 */
	public int compareToReturnInt(ClassTime item) {
		int rezult=-1;
		if (this.hour>item.hour) rezult=1;
		else if (this.hour == item.hour) {
			if (this.min>item.min) rezult=1;
			else if (this.min == item.min) {
				if (this.sec>item.sec) rezult=1;
				else if (this.sec == item.sec) {
					rezult=0;
				}				
			}			
		}
		return rezult; 
	}

	/**
	 *	��������� ��������� ���������� STRING  
	 */
	public String compareToReturnString(ClassTime item, String c1, String c2) {
		String rezult=c1+" < "+c2;
		if (this.hour>item.hour) rezult=c1+" > "+c2;
		else if (this.hour == item.hour) {
			if (this.min>item.min) rezult=c1+" > "+c2;
			else if (this.min == item.min) {
				if (this.sec>item.sec) rezult=c1+" > "+c2;
				else if (this.sec == item.sec) {
					rezult=c1+" = "+c2+" BINGO !!!";
				}				
			}			
		}
		return rezult; 
	}
	
	
	//����� �����������
	public void Print(String st) {
		System.out.println(st+" -  hour: "+hour+",  min: "+min+",  sec: "+sec);
	}
	
	public void Print1(String st) {
		System.out.println(st+" - "+hour+":"+min+":"+sec);
	}

	/**
	 *	�������� �������������� ����� �� 2-�� �������� 
	 */
	public String GetFullReport(ClassTime item, String c1, String c2) {
		String rezult="";
		//System.out.println(c1+" - "+this.hour+":"+this.min+":"+this.sec+"\t"+c2+" - "+item.hour+":"+item.min+":"+item.sec+"\t"+compareToReturnString(item,c1,c2));
		//rezult=c1+" - "+this.hour+":"+this.min+":"+this.sec+"\t"+c2+" - "+item.hour+":"+item.min+":"+item.sec+"\t"+compareToReturnString(item,c1,c2);
		rezult=GetTimeFormat(this, c1)+'\t'+GetTimeFormat(item, c2)+'\t'+compareToReturnString(item,c1,c2);
		return rezult;
	}
	
	//��������� �������� ����� � ������ ������� (���� ������ �������)
	public String GetTime(String st) {
		String temp="";
		temp=st+" - "+hour+":"+min+":"+sec;
		return temp;
	}

	/**
	 * ��������� �������� ����� � ������ ������� (���� ������ �������) ��������������
	 * @param item
	 * @param st
	 * @return
	 */
	public String GetTimeFormat(ClassTime item, String st) {
		String temp="";
		temp=st+" - "+getIntToString2(item.hour)+":"+getIntToString2(item.min)+":"+getIntToString2(item.sec);
		return temp;
	}
	
}
