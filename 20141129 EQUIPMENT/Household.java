/*	
 * 	ЗАДАНИЕ № 24  		Household 	использует: Equipment
 * 	27.11.2014
 * 	
 * 	Создать иерархию классов описывающих бытовую технику 
 * 	Создать несколько объектов описанных класов, часть из них включить в розетку 
 * 	Иерархия должна иметь хотя бы 3 уровня 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

/**
 * КЛАСС КУХНЯ 2-го УРОВНЯ  
 * дополнение к классу ОБОРУДОВАНИЕ
 * от него будут наследоваться конкретные БЫТОВЫЕ приборы
 * 
 */

public class Household extends Equipment {
	protected String specalization; //специализация для кухни 
	
	/**
	 * Конструктор по умолчанию
	 */	
	public Household () {
		super();
		setSpecialization();				
	}

	/**
	 * Конструктор с параметрами
	 */	
	public Household (int Power, String Producer) {
		super(Power, Producer);
		setSpecialization();		
	}	
	
	/**
	 * Установить специализацию прибора
	 */
	public void setSpecialization() {
		specalization="Быта";
	}
	
	public String toString() {
		return super.toString(); 
	}
}
