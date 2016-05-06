/*	
 * 	ЗАДАНИЕ № 24  		Equipment 	базовый класс 1-го уровня 
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
 * КЛАСС ОБОРУДОВАНИЕ 1-го УРОВНЯ  
 * в какой-то степени абстрактный класс 
 * от которого наследуются остальные классы
 */

public class Equipment {
	//Перечисление свойств класса
	protected int power=0; 			//Потребляемая мощность
	protected String producer=""; 	//Производитель	
	protected boolean isOn;			//Включен или выключен
	//protected int inv_num=0; 		//Инвентарный номер
	
	public void on() {
		isOn = true;
	}
	
	public void off() {
		isOn = false;
	}
	
	public String getState() {
		String rezult="";
		if (isOn==true) rezult="on"; else rezult="off";
		return rezult;
	}	
		
	/**
	 * Конструктор по умолчанию
	 */
	public Equipment() {
		setPower(0);
		setProducer("");
	}

	/**
	 * Конструктор с параметрами
	 */
	public Equipment(int Power, String Producer) {
		setPower(Power);
		setProducer(Producer);
	}
	
	/*
	public String toString() {
		return getInfo()+super.toString(); 
	}
	*/
	
	public int getPower() {
		return power;
	}
	
	public String getProducer() {
		return producer;
	}

	public void setPower(int item) {
		power=item;
	}
	
	public void setProducer(String item) {
		producer=item;
	}
	
	public String getInfo() {
		return "power-"+power+", producer-"+producer+" ";
	}
}