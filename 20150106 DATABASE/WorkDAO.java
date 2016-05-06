/*	
 * 	������� � 7		WorkDAO
 * 	06.01.2015
 * 	������� ������ DAO �� ������ ���������� � ��� ����������
 * 	��� �� �������  ������ Receiver �  Expense 
 * 	�������� ������� ������������� ����� �� Receivers � Expenses
 * 	���� ���� ����� ������� � ���� ������
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.ArrayList;

public class WorkDAO {

	public static void main(String[] args) {
		Dao myDao = MyDao.getDao();
		
		//1.  ������ ������� RECEIVERS (����������) 1-� �������� � ��������� ��������
		/**
		Receiver myReceiver = myDao.getReceiver(5); //1. 	�������� �������� ����������
		System.out.println(myReceiver.toString()); 	//   	���������� �������� ����������

		ArrayList<Receiver> mas = myDao.getReceivers(); //3 �������� �������� ������� �����������
		((MyDao) myDao).ShowArrayListReceiver(mas);		//	���������� �������� �����������
		*/
		
		//2.  ������ ������� EXPENSES (�������) 1-� �������� � ��������� ��������
		/**
		Expense myExpense = myDao.getExpense(5); 	//2. 	�������� �������� �������
		System.out.println(myExpense.toString()); 	//		���������� �������� �������
				
		ArrayList<Expense> masEx = myDao.getExpenses(); //4 �������� �������� ������� ��������
		((MyDao) myDao).ShowArrayListExpense(masEx);	//	���������� �������� ��������
		*/
		
		//3.  ��������� ������� � ������� RECEIVERS (����������)
		/**
		String nameStore="������� �������";
		Receiver AddReceiver = new Receiver(nameStore); 	//5 ��������� ���������� � ������ Receiver
		if (myDao.addReceiver(AddReceiver) > 0) System.out.println(AddReceiver.toString()+" - �������� ���������� � ��");	//	��������� � �� ���������� ����� ������ Receiver
		if (myDao.delReceiver(AddReceiver) > 0) System.out.println(AddReceiver.toString()+" - �������� ��������  �� ��");	//	������� �� �� ���������� ����� ������ Receiver (�� �����)
		*/
		
		//4.  ��������� ������� � ������� EXPENSES (�������)
		/**
		int money = 201550; //����� � ����������� ������
		//Expense AddExpense = new Expense(0, "2015-01-10", 5, money);
		Expense AddExpense = new Expense(5, money);
		//System.out.println(AddExpense.toString());
		//if (myDao.addExpense(AddExpense) > 0) System.out.println(AddExpense.toString()+" - �������� ���������� � ��");	//	��������� � �� ������ ����� ������ Expense
		//if (myDao.delExpense(AddExpense) > 0) System.out.println(AddExpense.toString()+" - �������� ��������  �� ��");	//	�������  �� �� ������ ����� ������ Expense (�� ������)
		*/
	}
}
