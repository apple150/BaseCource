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


public class Store {

	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {
		List<Custom> arrayCustom = new ArrayList<Custom>();
		String [] masCustom = {"����", "�����", "�����", "�������", "�����", "����", "����", "���", "����", "����", "������", "�����", "������", "���", "����", "����", "�����", "����"};
		String [] masProd = {"������", "���������", "������", "����", "��������", "���", "������", "����", "�����", "����", "�������", "����", "�������", "�������", "��������", "������", "����", "���"};
		int item=0, itemProd=0;
		String nameCustom="", nameProd="";		
		String nameFile="Store.txt";
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
		
		//�������������� ������ �����������
		for (int i=0; i < masCustom.length; i++) {
			item=GetRandomItem(i,(masCustom.length-i));
			itemProd=GetRandomItem(i,(masProd.length-i));
			
			nameCustom=masCustom[item];
			nameProd=masProd[itemProd];
			arrayCustom.add(new Custom(nameCustom, nameProd, GetRandomItem(5, 30), pw, lock)); //��������� � ������ ��������� �������� �������� � �� ������ � ������
			
			//�������� ��� ���� ����� ������������� �������� �������
			masCustom[item]=masCustom[i];
			masCustom[i]=nameCustom;
			
			masProd[itemProd]=masProd[i];
			masProd[i]=nameProd;
		}
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		//������ ������� ����������� � ��������� ����������		
		for (int i=0; i<arrayCustom.size(); i++) {
			arrayCustom.get(i).setNpp(i+1);
			arrayCustom.get(i).setTerminal(1);
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
