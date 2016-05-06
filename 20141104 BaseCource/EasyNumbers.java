/*	
 * 	������� � 13		EasyNumbers
 * 	13.11.2014
 * 	������ ������� �� ����� ������� ����� � ��������������    break
 * 	
 * 	7 ������� � ������������ (������ 130x130 �� 16900 �������� ����������  439 )
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class EasyNumbers {

	public static void main(String[] args) {
		int size=130; // ����������� �������
		int iter=0;   // ������� ����� ��������
		int count=0;  // ������� ��� ������� ����� ����� ����� 2
		int �ountEasyNumbers=0; //������� ������ ���-�� ������� ����� � �������
		String rezult=""; //������ ������ ���������� ���������� �������� ������� ����� � ������������ �������
		
		//1. ������ ��� breake
		�ountEasyNumbers=0;
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			count=0;
			for (int j=1; j<=size; j++) { //��������� ���� �� 100
				iter++;
				if ((i==1)&&(j==1)) {
					rezult=rezult+i;
					�ountEasyNumbers++;
				}				
				if (j <= i) {
					if (i%j == 0) count++;
										
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						�ountEasyNumbers++;										
					}
				} 
			}
		}		
		System.out.println("1. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������: "+iter+"   ("+rezult+")");

		//2. ������ � breake
		iter=0;
		�ountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			count=0;
			for (int j=1; j<=size; j++) { //��������� ���� �� 100
				iter++;
				if ((i==1)&&(j==1)) {
					rezult=rezult+i;
					�ountEasyNumbers++;
					break;
				}				
				if (j <= i) {
					if (i%j == 0) count++; //�������� �� ������� �� �������										
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						�ountEasyNumbers++;
						break;						
					}
				} else break;
			}
		}		
		System.out.println("2. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������:  "+iter+"   ("+rezult+")");
		
		//3. ������ � breake
		iter=0;
		�ountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			if ((i==1)||(i==2)) {	
				iter++;
				�ountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}			
			if (i%2!=0) {
				count=0;
				for (int j=1; j<=size; j++) { //��������� ���� �� 100
					iter++;
					if (j <= i) {
						if (i%j == 0) count++;											
						if ((count==2) && (j==i)) {
							rezult=rezult+", "+i;
							�ountEasyNumbers++;
							break;						
						}
					} else break;
				}
			}
		}		
		System.out.println("3. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������:  "+iter+"   ("+rezult+")");

		
		//4. ������ � breake + �������
		iter=0;
		�ountEasyNumbers=0;
		rezult="";
		int OldEasyNumber=0; //������ �������� �������� �����
		int razniza=0;
		String RezultRazniza="";
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			if ((i==1)||(i==2)) {				
				iter++;
				�ountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				if (OldEasyNumber!=0) {
					razniza=i-OldEasyNumber;
					RezultRazniza=""+razniza;
				}
				OldEasyNumber=i; //������ �������� �������� �����
				continue;
			}
			
			if (i%2==0) continue;  //���� ������ �������� �� ���� �� ���� �� ��� ��������
			
			count=0;
			for (int j=1; j<=size; j++) { //��������� ���� �� 100
				if (j%2==0) continue; //� 2 ���� ��������� ����. ���� ������ �������� ����� �� ���� �� ��� �������� 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;											
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						�ountEasyNumbers++;
						if (OldEasyNumber!=0) {
							razniza=i-OldEasyNumber;
							RezultRazniza=RezultRazniza+", "+razniza;
						}							
						OldEasyNumber=i; //������ �������� �������� �����
						break;						
					}
				} else break;
			}

		}		
		System.out.println("4. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������:  "+iter+"   ("+rezult+")");
		

		//5. ������ � breake (������� �� 2, 5)
		iter=0;
		�ountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			if ((i==1)||(i==2)||(i==3)||(i==5)) {
				iter++;
				�ountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}
			
			if ((i%2==0) || (i%5==0)) continue;  //���� ������ �������� ��� ������� �� 3, 5 �� ���� �� ���� �� ��� ��������
			
			count=0;
			for (int j=1; j<=size; j++) { //��������� ���� �� 100
				if ((j%2==0) || (j%5==0)) continue; //� 2 ���� ��������� ����. ���� ������ �������� ��� ������� �� 3, 5 ����� �� ���� �� ��� �������� 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;											
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						�ountEasyNumbers++;
						break;						
					}
				} else break;
			}

		}		
		System.out.println("5. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������:   "+iter+"   ("+rezult+")");
		
		
		//6. ������ � breake (������� �� 2, 3, 5)
		iter=0;
		�ountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			if ((i==1)||(i==2)||(i==3)||(i==5)) {
				iter++;
				�ountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}
			
			if ((i%2==0)||(i%3==0)||(i%5==0)) continue;  //���� ������ �������� ��� ������� �� 3, 5 �� ���� �� ���� �� ��� ��������
			
			count=0;
			for (int j=1; j<=size; j++) { //��������� ���� �� 100
				if ((j%2==0) ||(j%3==0) || (j%5==0)) continue; //� 2 ���� ��������� ����. ���� ������ �������� ��� ������� �� 3, 5 ����� �� ���� �� ��� �������� 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;											
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						�ountEasyNumbers++;
						break;						
					}
				} else break;
			}

		}		
		System.out.println("6. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������:   "+iter+"   ("+rezult+")");
		
		//7. ������ � breake (������� �� 2, 3, 5, 7)
		iter=0;
		�ountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //�������� ���� �� 100
			if ((i==1)||(i==2)||(i==3)||(i==5)||(i==7)) {
				iter++;
				�ountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}
			
			if ((i%2==0)||(i%3==0)||(i%5==0)||(i%7==0)) continue;  //���� ������ �������� ��� ������� �� 3, 5, 7 �� ���� �� ���� �� ��� ��������
			
			count=0;
			for (int j=1; j<=size; j++) { //��������� ���� �� 100
				if ((j%2==0) ||(j%3==0) || (j%5==0)|| (j%7==0)) continue; //���� ������ �������� ��� ������� �� 3, 5, 7 ����� �� ���� �� ��� �������� 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;
					if (i==j) {
						if (count==2) {
							rezult=rezult+", "+i;
							�ountEasyNumbers++;
							break;						
						} else break;
					}
				} else break;
			}

		}		
		System.out.println("7. ������ "+size+"x"+size+" ����� "+�ountEasyNumbers+" ������� �����.   ��������:   "+iter+"   ("+rezult+")");
		System.out.println("������� "+RezultRazniza);		
	}

}
