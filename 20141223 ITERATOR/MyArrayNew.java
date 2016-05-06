/**
 * Интерфейс
 */
interface MyIteratorNew {
	Object next();
	boolean hasNext();
}

/**
 * Класс Массив
 */
public class MyArrayNew {
	int a [];
	
	public MyArrayNew (int size) { //Конструктор устанавливает первоначальное кол-во элементов
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
	MyIteratorNew Iterator() {  
		return new MyIteratorNew() {
			int curNum = 0;
			public Object next() {
				if (curNum < a.length) {
					curNum ++;
					return new Integer(a[curNum-1]);					
				} else return null;				
			}
			
			public boolean hasNext() { //Проверка на то индекс текущий элемента меньше кол-ва всего массива
				if (curNum < a.length) return true;				
				else return false;				
			}			
		};
	}
	
	/*
	private class IntIteratorNew implements MyIteratorNew {
		int curNum = 0;
		public IntIteratorNew() {} //Конструктор по умолчанию (может и не быть)
		
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
	*/
}