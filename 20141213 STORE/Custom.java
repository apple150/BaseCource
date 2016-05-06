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

import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;

public class Custom extends Thread {
	private String nameCustom ="";  	//�������� �����
	private String cargoCustom=""; 	//�������� ����� � �������� ��������
	private int npp=0; 				//����� �� �������
	private int cargoCount=0; 		//���������� ����� � �������� ��������
	private int terminal=0; 		//����� ���������
	private String aboutCustom=""; 	//���������� � �������
	private boolean unloading=false; //��������� ����������� ��� ���	
	private PrintWriter pw=null; 
	Lock lock=null;
	
	public Custom() {
		aboutCustom = getAllInformation(); 
	}
		
	public Custom(String name, String cargo, int CountCargo, PrintWriter itemFile, Lock lockItem) {
		nameCustom = name;
		cargoCount = CountCargo;
		cargoCustom = cargo;
		aboutCustom = getAllInformation();
		pw= itemFile;
		lock=lockItem;
	}
	
	@Override
	public void run()  {  //������� ����������������
		lock.lock();
		for(int i=cargoCount; i != 0; i--) {
			try {
				pw.println(aboutCustom+", �������: "+i);
			} catch (Exception e) {
				System.out.println("I cant write to file:");
			}							
		}
		pw.println("");
		lock.unlock(); 
		setUnloading(); //��������� ���������
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
	 * ������� ������� ���������� ���������� � ��� ��� ��������� �����������
	 */
	public void setUnloading() {
		unloading=true;
	}
	
	/**
	 * ������� ���������� ���������� ���������� � ��� ��� ��������� �����������
	 */
	public boolean getUnloading() {
		return unloading;
	}
	
	/**
	 * ������� ���������� ���-�� �����
	 */
	public int getCountCargo() {
		return cargoCount;
	}

	/**
	 * ������� ���������� �������� ��������
	 */
	public String getNameCustom() {
		return nameCustom;
	}

	/**
	 * ������� ���������� �������� �����
	 */
	public String getCargoName() {
		return cargoCustom;
	}
	
	/**
	 * ������� ������������� ����� ���������
	 */
	public void setTerminal(int number) {
		terminal=number;
		aboutCustom = getAllInformation();
	}
	
	/**
	 * ������� ���������� ���� ��������
	 */
	public int getTerminal() {
		return terminal;
	}
	
	/**
	 * ������� ������������� ����� ���������
	 */
	public String getAllInformation() {
		String rez="";
		rez="�: "+getNpp()+", Term: "+getTerminal()+", Ship: "+getNameCustom()+", Cargo: "+getCargoName()+", Weight: "+getCountCargo();
		return rez;
	}	
}
