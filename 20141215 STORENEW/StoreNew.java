/*
 * 	������� � 1		����������� �������		Store � Custom 	
 * 	13.12.2014
 * 	��������� ������������ ����� � ��������. 
 * 	���������� ��������� ����, ���������� ������������
 * 	������ ���������� ��������� �����
 * 	����� ���-�� ����������� ����� ���� ������ ��� ���-�� ����
 * 	�� ������������ �� ����� �������������� ������ �����������
 * 	��� ������� ������� ����.
 * 	� ������� ���������� ���� ����� �������, 
 * 	������� ������ ���� �������� � �������� ������������
 * 
 * 	����� �� ������� ��� � ���� 
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class StoreNew {

	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		List<CustomNew> arrayCustom = new ArrayList<CustomNew>();
		String [] masCustom = {"����", "�����", "�����", "�������", "�����", "����", "����", "���", "����", "����", "������", "�����", "������", "���", "����", "����", "�����", "����"};
		
		String [] masProd = {"������", "���������", "������", "����", "��������", "���", "������", "����", "�����", "����", "�������", "����", "�������", "�������", "��������", "������", "����", "���", "�����", "����������"};
		String [] masPrice = {"11000", "15000", "12000", "11500", "15000", "16000", "17000", "10000", "20000", "100000", "15000", "16000", "12000", "120000", "30000", "7000", "60000", "95000", "75000", "100000"};
		String [] masMeasure = {"1 ����.", "1 ����.", "1 ����", "1 �������", "500 �����", "1 ����.", "1 ����.", "1,5 �����", "1 ����.", "500 �����", "1 �����", "1 �������", "1 ����.", "1 ����.", "1 ����.", "1 ����.", "1 �����", "1 ����.", "1 �������","1 �������"};
		int item=0, itemProd=0;
		String nameCustom="", nameProd="", priceProd="", measureProd="";
		int countProd=0;
		String nameFile="StoreNew.txt";
		File fl = new File(nameFile);
		PrintWriter pw=null;
		Lock lock = null;
		
		//��������� ����
		try {
			pw = new PrintWriter(fl);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
		
		lock = new ReentrantLock();  
		
		int all = masCustom.length; //����� �����������
		
		int minCountPurchase=3; //���-�� ����������� �������
		//�������������� ������ �����������
		String [][] arrayCustomProd = null;
		for (int i=0; i < masCustom.length; i++) {
			item=GetRandomItem(i,(masCustom.length-i)); //��������� ���������� �� ������� (�.�. ���)
			nameCustom=masCustom[item]; //����� ���  ����������
			//�������� ������������ ��� �� �� ����������� �������� �����������
			masCustom[item]=masCustom[i];
			masCustom[i]=nameCustom;
			
			//����� ���-�� ��������� ������� ����� ����������
			countProd=GetRandomItem(minCountPurchase,(masProd.length-minCountPurchase));
			//������������� ������� ����� ��������
			arrayCustomProd = null;
			arrayCustomProd = new String [countProd][4];			
			for (int j=0; j < countProd; j++) {
				itemProd=GetRandomItem(j,(masProd.length-j)); //�������� ������� � ������� �������� �������� �������� 	
				nameProd=masProd[itemProd];			//������������ ��������
				priceProd=masPrice[itemProd];  		//���� ��������
				measureProd=masMeasure[itemProd];  	//������� ��������� ��������
				
				//�������� ������������ ��� �� �� ����������� �������� �������
				masProd[itemProd]=masProd[j];
				masProd[j]=nameProd;
				
				//�������� ������������ ��� �� �� ����������� �������� ����
				masPrice[itemProd]=masPrice[j];
				masPrice[j]=priceProd;

				//�������� ������������ ��� �� �� ����������� �������� ������� ���������
				masMeasure[itemProd]=masMeasure[j];
				masMeasure[j]=measureProd;
				
				arrayCustomProd[j][0]=GetRandomItem(1,masProd.length)+""; 	//������� ���-�� �������� ������ ������������
				arrayCustomProd[j][1]=nameProd; 	//������� ������������ �������� 
				arrayCustomProd[j][2]=priceProd; 	//������� ���� �������� � ���.��� 
				arrayCustomProd[j][3]=measureProd; 	//������� �������  ��������						
			}
			arrayCustom.add(new CustomNew(all, nameCustom, arrayCustomProd, pw, lock)); //��������� � ������ ��������� �������� �������� � �� ������ � ������
		}
		
		int countCass=5;
		ExecutorService pool = Executors.newFixedThreadPool(countCass);		

		int pnc=0; //���������� ����� �����
		//������ ������� ����������� � ��������� ����������		
		for (int i=0; i<arrayCustom.size(); i++) {
			arrayCustom.get(i).setNpp(i+1);
			pnc++; //���������� ����� �����
			arrayCustom.get(i).setTerminal(pnc);
			if (pnc == countCass) pnc=0; //���� ����� ���-�� ���� ����� ������ ������ ����� � 1-� �����
			pool.execute(arrayCustom.get(i));			
		}
		
		//������ �������� ��������� ������ main-��
		pool.shutdown(); //������� ��������� ���������� �������
		
		try {
			pool.awaitTermination(2, TimeUnit.SECONDS); //������ join()
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//��������� ����
		try {
			pw.close();
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
		}
	}
}
