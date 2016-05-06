/*	
 * 	ЗАДАНИЕ № 24  		DvdPlayer 	использует: AudioVideo
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
 * КЛАСС  DVD-ПЛЕЕР 3-го УРОВНЯ  
 * дополнение к классу ОБОРУДОВАНИЕ и АУДИО ВИДЕО
 * от него будут создаваться конкретные объекты т.е. DVD-ПЛЕЕРЫ
 */

public class DvdPlayer extends AudioVideo {
	protected String type="DVD-плеер";
	
	/**
	 * Конструктор по умолчанию
	 */	
	public DvdPlayer () {
		super();
		power=GetRandomItem(100, 300); //Минимально-100 ватт, Максимально-400 ватт.
		producer=getProducer();
		int i=GetRandomItem(0, 2);
		if (i==0) on(); else off();		
	}
	
	/**
	 * Конструктор с параметрами
	 */	
	public DvdPlayer (int Power, String Producer) {
		//super(GetRandomItem(250, 500), getProducer());
		super(0, "");
		power=GetRandomItem(250, 500);
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
		String [] m={"SAMSUNG", "PHILIPS", "PANASONIC", "HITACHI", "GOLDSTAR", "SONY"};
		int i=GetRandomItem(0, m.length);
		rezult=m[i];
		return rezult;
	}
	
	@Override
	public String toString() {
		return "Для-"+specalization+'\t'+type+"\tПроизводитель-"+producer+"\t Мощность-"+power+'\t'+getState()+"\t"+super.toString();
	}	
}
