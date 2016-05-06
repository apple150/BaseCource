/*
 * 	������� � 1		����������� �������		StoreNew � CustomNew 	
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

import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;

public class CustomNew extends Thread {
	private String nameCustom ="";  //��� ����������
	private int npp=0; 				//����� �� �������
	private int terminal=0; 		//����� ���������
	private int allCustom=0;        //����� �����������		
		
	private PrintWriter pw=null;	
	Lock lock=null;
	String [][] purchase = null;
	
	public static int MaxSum=0; //������������� ����������� �����
	public static String NameCustomMaxSum=""; //������������� ����������� �����
	private static int sumCustom=0; //��� ������������ ������ ������������ ����� ���������� �����������
	private static int countProd=0; //���-�� ���������
	
	
	public CustomNew(int all, String name, String [][] mas, PrintWriter itemFile, Lock lockItem) {
		nameCustom = name;		
		pw= itemFile;
		purchase = mas;
		lock=lockItem;
		allCustom = all; //����� �����������
	}
	
	@Override
	public void run()  {  //������� ����������������
		lock.lock(); //����������		
		sumCustom++;
		int count=0, sum=0;
		
		String aboutCustom="";
		for(int i=0; i < purchase.length; i++) {						
			count=Integer.parseInt(purchase[i][0]);
			for (int j=0; j < count; j++) {
				sum+=Integer.parseInt(purchase[i][2]);
				aboutCustom="�: "+getNpp()+", �����: "+getTerminal()+", ����������: "+nameCustom+"\t �������: "+purchase[i][1]+"\t ���������: "+purchase[i][2]+"\t ������� ���.: "+purchase[i][3];
				try {
					pw.println(aboutCustom);
				} catch (Exception e) {
					System.out.println("I cant write to file:");
				}															
			}				
		}
		
		if (sum > MaxSum) {
			MaxSum = sum;
			NameCustomMaxSum = "����������: "+nameCustom+", �����: "+getTerminal()+", �: "+getNpp();
			countProd=purchase.length;
		}
		
		try {
			pw.println("*****  ����������: "+nameCustom+" ��������: "+sum+" ���.����.  *****\n");
		} catch (Exception e) {
			System.out.println("I cant write to file:");
		}
		
		if (sumCustom == allCustom) {
			try {
				pw.println("�� "+allCustom+" ����������� ����������� ��������: "+NameCustomMaxSum+", C����: "+MaxSum+" (����� ���-�� ��������� - "+countProd+")");
			} catch (Exception e) {
				System.out.println("I cant write to file:");
			}				
		}		
		lock.unlock(); //������������� 
	}

	/**
	 * ������� ������ ������ �� ������ ����������� ������
	 */
	public void setNpp(int i) {
		npp=i;
	}
	
	/**
	 * ������� �������� ����� �� ������ ����������� ������
	 */
	public int getNpp() {
		return npp;
	}
		
	/**
	 * ������� ���������� �������� ��������
	 */
	public String getNameCustom() {
		return nameCustom;
	}

	/**
	 * ������� ���������� ���� ��������
	 */
	public int getTerminal() {
		return terminal;
	}
	
	/**
	 * ������� ������������� ����� ��������
	 */
	public void setTerminal(int i) {
		terminal = i;
	}
}
