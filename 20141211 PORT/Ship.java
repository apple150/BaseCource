/*
 * 	������� � 1		����������� �������		Port � Ship 	
 * 	11.12.2014
 * 	��������� �������� � �����
 * 	������ ������������ ������� ��� �����
 * 	�������� ������ ���� �� ������ 10-��
 * 	� ����� ���� ����� ��� 3-�
 * 	����� �� ������� ��� � ���� 
 * 	���������� ������������ ������� wait() �� �������� 7
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class Ship extends Thread {
	private String nameShip ="";  	//�������� �����
	private String cargoName=""; 	//�������� ����� � �������� ��������
	private int npp=0; 				//����� �� �������
	private int cargoCount=0; 		//���������� ����� � �������� ��������
	private int terminal=0; 		//����� ���������
	private String aboutShip=""; 	//���������� � �������
	private boolean unloading=false; //��������� ����������� ��� ���	
	private PrintWriter pw=null; 
	public String nameFile="";
	public static int countTreads=0;
	
	
	public Ship() {
		aboutShip = getAllInformation(); 
	}
		
	public Ship(String name, String cargo, int CountCargo, PrintWriter itemFile) {
		nameShip = name;
		cargoCount = CountCargo;
		cargoName = cargo;
		aboutShip = getAllInformation();
		nameFile="hello.txt";
		pw= itemFile;
	}
	
	@Override
	public void run()  {  //������� ����������������		
		synchronized (pw) {
			countTreads++;
			this.setTerminal(countTreads);
			for(int i=cargoCount; i != 0; i--) {
				try {
					pw.println(aboutShip+", �������: "+i);
				} catch (Exception e) {
					System.out.println("I cant write to file: "+nameFile);
				}							
			}
			//pw.println("\t�������� ���������\n");
			pw.println("");
			if (countTreads==3) countTreads=0;
		}	
		//this.notify(); 
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
	public String getNameShip() {
		return nameShip;
	}

	/**
	 * ������� ���������� �������� �����
	 */
	public String getCargoName() {
		return cargoName;
	}
	
	/**
	 * ������� ������������� ����� ���������
	 */
	public void setTerminal(int number) {
		terminal=number;
		aboutShip = getAllInformation();
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
		rez="�: "+getNpp()+", Term: "+getTerminal()+", Ship: "+getNameShip()+", Cargo: "+getCargoName()+", Weight: "+getCountCargo();
		return rez;
	}	
}
