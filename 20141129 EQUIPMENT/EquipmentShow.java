/*	
 * 	������� � 24  		EquipmentShow 	�����������  �����
 * 	27.11.2014
 * 	
 * 	������� �������� ������� ����������� ������� ������� 
 * 	������� ��������� �������� ��������� ������, ����� �� ��� �������� � ������� 
 * 	�������� ������ ����� ���� �� 3 ������ 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class EquipmentShow {
	
	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}
	
	public static void main(String[] args) {		
		System.out.println("�����  ��������� - ������������\n");
		int count = 50, random=0;
		int ref=0, mic=0, vac=0, irn=0, dvd=0, mp3=0; //��� �������� ���-�� ��������
		Equipment mas[] = new Equipment[count];		
		for (int i=0; i < count; i++) {
			random=GetRandomItem(0, 6);
			switch (random) { 
				case 0:  mas[i]= new Refrigerator(); 	ref++;	break; // �������� ������������
				case 1:  mas[i]= new Microwave(); 	 	mic++;	break; // �������� �������������
				case 2:  mas[i]= new VacuumCleaner(); 	vac++; 	break; // �������� ��������
				case 3:  mas[i]= new Iron(); 			irn++;	break; // �������� �����
				case 4:  mas[i]= new DvdPlayer(); 		dvd++;	break; // �������� DVD-������
				case 5:  mas[i]= new Mp3Player();		mp3++;	break; // �������� mp3-������
				default: break;
			}		
		}
		
		//����� ������� ������������ ���������
		int sumEnergyOn=0, kolvo=0, sumEnergyOff=0;
		for (int i=0; i < mas.length; i++) {			
			System.out.println(mas[i].toString());
			if (mas[i].isOn) {
				sumEnergyOn+=mas[i].power;
				kolvo++;
			} else sumEnergyOff+=mas[i].power;
		}
		System.out.println("\n�� "+count+" ��������, �������� "+kolvo+" ��������. �������� ����������� - "+sumEnergyOn+" ����. ��������� ����������� �� - "+sumEnergyOff+" ����.");
		System.out.println("����� � ����������� ������ �� ���������� �� �������:");
		System.out.println("�������������\t - "+ref+" ��. ");
		System.out.println("�������������\t - "+mic+" ��. ");
		System.out.println("���������\t - "+vac+" ��. ");
		System.out.println("������\t\t - "+irn+" ��. ");
		System.out.println("DVD-�������\t - "+dvd+" ��. ");
		System.out.println("mp3-�������\t - "+mp3+" ��. ");
	}
}
