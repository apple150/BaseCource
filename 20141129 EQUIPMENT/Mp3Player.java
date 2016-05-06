/*	
 * 	ЗАДАНИЕ № 24  		Mp3Player 	использует: AudioVideo
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
 * КЛАСС  mp3-ПЛЕЕР 3-го УРОВНЯ  
 * дополнение к классу ОБОРУДОВАНИЕ и АУДИО ВИДЕО
 * от него будут создаваться конкретные объекты т.е. mp3-ПЛЕЕРЫ
 */

public class Mp3Player extends AudioVideo {
	protected String type="mp3-плеер";
	
	/**
	 * Конструктор по умолчанию
	 */	
	public Mp3Player () {
		super();
		power=GetRandomItem(30, 50); //Минимально-30 ватт, Максимально-80 ватт.
		producer=getProducer();
		int i=GetRandomItem(0, 2);
		if (i==0) on(); else off();		
	}
	
	/**
	 * Конструктор с параметрами
	 */	
	public Mp3Player (int Power, String Producer) {
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
		//return "Для-"+specalization+'\t'+type+"\tПроизводитель-"+producer+"\t Мощность-"+power+'\t'+getState()+"\t"+super.toString()+'\t'+super.super.toString();
	}	
}