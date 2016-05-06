/*	
 * 	ЗАДАНИЕ № 7		WorkDAO
 * 	06.01.2015
 * 	Создать объект DAO на основе интерфейса и его реализацию
 * 	Так же создать  классы Receiver и  Expense 
 * 	свойства которых соответствуют полям БД Receivers и Expenses
 * 	Поле дата можно хранить в виде строки
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.util.ArrayList;

public class WorkDAO {

	public static void main(String[] args) {
		Dao myDao = MyDao.getDao();
		
		//1.  ЧТЕНИЕ таблицы RECEIVERS (ПОЛУЧАТЕЛИ) 1-о значение и несколько значений
		/**
		Receiver myReceiver = myDao.getReceiver(5); //1. 	Получаем значение Получателя
		System.out.println(myReceiver.toString()); 	//   	Показываем значение Получателя

		ArrayList<Receiver> mas = myDao.getReceivers(); //3 Получаем значение Массива Получателей
		((MyDao) myDao).ShowArrayListReceiver(mas);		//	Показываем значение Получателей
		*/
		
		//2.  ЧТЕНИЕ таблицы EXPENSES (ПЛАТЕЖИ) 1-о значение и несколько значений
		/**
		Expense myExpense = myDao.getExpense(5); 	//2. 	Получаем значение Платежа
		System.out.println(myExpense.toString()); 	//		Показываем значение Платежа
				
		ArrayList<Expense> masEx = myDao.getExpenses(); //4 Получаем значение Массива Платежей
		((MyDao) myDao).ShowArrayListExpense(masEx);	//	Показываем значение Платежей
		*/
		
		//3.  ДОБАВЛЕНИ УДАЛЕНИ в таблицу RECEIVERS (ПОЛУЧАТЕЛИ)
		/**
		String nameStore="Магазин Колобок";
		Receiver AddReceiver = new Receiver(nameStore); 	//5 Добавляем Получателя в объект Receiver
		if (myDao.addReceiver(AddReceiver) > 0) System.out.println(AddReceiver.toString()+" - Успешное ДОБАВЛЕНИЕ в БД");	//	Добавляем в БД Получателя через объект Receiver
		if (myDao.delReceiver(AddReceiver) > 0) System.out.println(AddReceiver.toString()+" - Успешное УДАЛЕНИЕ  из БД");	//	Удаляем из БД Получателя через объект Receiver (по имени)
		*/
		
		//4.  ДОБАВЛЕНИ УДАЛЕНИ в таблицу EXPENSES (ПЛАТЕЖИ)
		/**
		int money = 201550; //Сумма в белорусских рублях
		//Expense AddExpense = new Expense(0, "2015-01-10", 5, money);
		Expense AddExpense = new Expense(5, money);
		//System.out.println(AddExpense.toString());
		//if (myDao.addExpense(AddExpense) > 0) System.out.println(AddExpense.toString()+" - Успешное ДОБАВЛЕНИЕ в БД");	//	Добавляем в БД Платеж через объект Expense
		//if (myDao.delExpense(AddExpense) > 0) System.out.println(AddExpense.toString()+" - Успешное УДАЛЕНИЕ  из БД");	//	Удаляем  из БД Платеж через объект Expense (по номеру)
		*/
	}
}
