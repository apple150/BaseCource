/**
 * Интерфейс
 */
interface MyIterator {
	Object next();
	boolean hasNext();
}

/**
 * Класс Массив
 */
public class MyArray {
	int a [];
	
	public MyArray (int size) { //Конструктор устанавливает первоначальное кол-во элементов
		a = new int[size];
	}
	
	int Get (int num) { //Возвращает значение конкретного элемента массива
		return a[num];
	}
	
	void Set (int num, int val) { //Устанавливает значение конкретного элемента массива
		a[num] = val;
	}
	
	int Size() { //Возвращает оьщее кол-во элементов в массиве
		return a.length;
	}
	
	/**
	 * Создание МЕТОДА-ФАБРИКИ (ИТЕРАТОР)
	 * Обращение к внктреннему классу 
	 * первоначально объявленному в интерфейсе
	 */
	MyIterator Iterator() {  
		return new IntIterator();
	}

	private class IntIterator implements MyIterator {
		int curNum = 0;
		public IntIterator() {} //Конструктор по умолчанию (может и не быть)
		
		public Object next() { //Получение значения следующего элемента массива
			if (curNum < a.length) {
				curNum ++;
				return new Integer(a[curNum-1]);
			} else return null;
		}	
		
		public boolean hasNext() { //Проверка на то индекс текущий элемента меньше кол-ва всего массива
			if (curNum < a.length) return true;				
			else return false;				
		}
	}
}