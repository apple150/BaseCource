/*	
 * 	ЗАДАНИЕ № 24  		Refrigerator 	использует: Kitchen
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
 * КЛАСС  МИКРОВОЛНОВКА 3-го УРОВНЯ  
 * дополнение к классу ОБОРУДОВАНИЕ и КУХНЯ
 * от него будут создаваться конкретные объекты т.е. МИКРОВОЛНОВКИ
 */

public class Microwave extends Kitchen {
	protected String type="Микроволновка";
	
	/**
	 * Конструктор по умолчанию
	 */
	
	public Microwave () {
		super();
		power=GetRandomItem(250, 250); //Минимально-250 ватт, Максимально-500 ватт.
		producer=getProducer();
		int i=GetRandomItem(0, 2);
		if (i==0) on(); else off();		
	}
	
	/**
	 * Конструктор с параметрами
	 */	
	public Microwave (int Power, String Producer) {
		//super(GetRandomItem(250, 500), getProducer());
		super(0, "");
		power=GetRandomItem(200, 300);
		producer=getProducer();
	}	

	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}
		
	public String getProducer() {
		String rezult="";
		String [] m={"VESTEL", "SAMSUNG", "DELONGI", "ATLANT", "PHILIPS", "MOULINEX", "PANASONIC", "HITACHI", "GOLDSTAR", "BOMANN"};
		int i=GetRandomItem(0, m.length);
		rezult=m[i];
		return rezult;
	}
	
	@Override
	public String toString() {
		return "Для-"+specalization+'\t'+type+"\tПроизводитель-"+producer+"\t Мощность-"+power+'\t'+getState()+"\t"+super.toString();
	}	
}
