import java.util.ArrayList;

public interface Dao {
	Receiver getReceiver(int num);		//Получить ПОЛУЧАТЕЛЯ по номеру
	ArrayList<Receiver> getReceivers();	//Получить список ПОЛУЧАТЕЛЕЙ 
	Expense getExpense(int num);		//Получить ПЛАТЕЖ по номеру
	ArrayList<Expense> getExpenses();	//Получить список ПЛАТЕЖЕЙ
	int addReceiver(Receiver receiver);	//Добавить ПОЛУЧАТЕЛЯ
	int delReceiver(Receiver receiver);	//Удалить  ПОЛУЧАТЕЛЯ
	int addExpense(Expense expense);	//Добавить ПЛАТЕЖ
	int delExpense(Expense expense);	//Удалить  ПЛАТЕЖ
}
