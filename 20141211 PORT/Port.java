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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Port {
	/**
	 *	������ ���������� ��������� �������� � �������� ��������� 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}	
	
	public static void main(String[] args) {		
		List<Ship> arrayShip = new ArrayList<Ship>();
		String [] mas = {"VICTORIA", "BRITANIA", "COLUMBIA", "ATLANTIC", "PILIGRIM", "NAUTILUS", "A.LINKOLN", "DRESDEN", "INVISIBLE", "INFLEXIBLE", "SIDNEY", "SHARNHORST", "GNEYSENAU", "NASSAU", "GOOD HOPE", "UTLANDIA", "GLASGOW", "ORLANDO"};
		String [] masProd = {"Oranges", "Banana", "Oil", "Gasoil", "Wood", "Coal", "Paper", "Limon", "Iron", "Auto", "Grapes", "Plastic", "Equipment", "Granite", "Sand", "Animals", "Balast", "Dimonds"};
		int item=0, itemProd=0;
		String temp="", tempProd="";
		String nameFile="Port.txt";
		File fl = new File(nameFile);
		PrintWriter pw=null;
		
		//��������� ����
		try {
			pw = new PrintWriter(fl);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
		
		//�������������� ������ ��������
		for (int i=0; i<mas.length; i++) {
			//System.out.println(i);
			item=GetRandomItem(i,(mas.length-i));
			itemProd=GetRandomItem(i,(masProd.length-i));
			
			temp=mas[item];
			tempProd=masProd[itemProd];
			arrayShip.add(new Ship(temp, tempProd, GetRandomItem(30, 101), pw)); //��������� � ������ ��������� �������� �������� � �� ������ � ������
			
			//�������� ��� ���� ����� ������������� �������� �������
			mas[item]=mas[i];
			mas[i]=temp;
			
			masProd[itemProd]=masProd[i];
			masProd[i]=tempProd;
		}
		
		//������ ������� �������� � ��������� ����������		
		for (int i=0; i<arrayShip.size(); i++) {
			arrayShip.get(i).setNpp(i+1);			
			//arrayShip.get(i).setTerminal(1);			
			arrayShip.get(i).start();			
		}
		
		//������ �������� ��������� ������ main-��
		for (int i=0; i<arrayShip.size(); i++) {
			try {
				arrayShip.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//��������� ����
		try {
			pw.close();
		} catch (Exception e) {
			System.out.println("I cant close file: "+nameFile);
		}		
	}
}
