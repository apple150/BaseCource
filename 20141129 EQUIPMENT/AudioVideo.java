/*	
 * 	ЗАДАНИЕ № 24  		AudioVideo 	использует: Equipment
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
 * КЛАСС АУДИО & ВИДЕО 2-го УРОВНЯ  
 * дополнение к классу ОБОРУДОВАНИЕ
 * от него будут наследоваться конкретные АУДИО & ВИДЕО приборы
 */

public class AudioVideo extends Equipment {
	protected String specalization; //специализация для кухни 
	
	/**
	 * Конструктор по умолчанию
	 */	
	public AudioVideo () {
		super();
		setSpecialization();				
	}

	/**
	 * Конструктор с параметрами
	 */	
	public AudioVideo (int Power, String Producer) {
		super(Power, Producer);
		setSpecialization();		
	}	
	
	/**
	 * Установить специализацию прибора
	 */
	public void setSpecialization() {
		specalization="Аудио&Видео";
	}
	
	public String toString() {
		return super.toString(); 
	}	
}
