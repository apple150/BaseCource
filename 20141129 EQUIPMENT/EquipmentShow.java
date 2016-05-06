/*	
 * 	ЗАДАНИЕ № 24  		EquipmentShow 	ЗАПУСКАЕМЫЙ  КЛАСС
 * 	27.11.2014
 * 	
 * 	Создать иерархию классов описывающих бытовую технику 
 * 	Создать несколько объектов описанных класов, часть из них включить в розетку 
 * 	Иерархия должна иметь хотя бы 3 уровня 
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class EquipmentShow {
	
	/**
	 *	Фунция возвращает случайные значения в заданном интервале 
	 */
	static public int GetRandomItem(int IntervalOt, int IntervalDo) {		
		return (int) (Math.random() * IntervalDo + IntervalOt) ;		 
	}
	
	public static void main(String[] args) {		
		System.out.println("СТАРТ  ПРОГРАММЫ - ОБОРУДОВАНИЕ\n");
		int count = 50, random=0;
		int ref=0, mic=0, vac=0, irn=0, dvd=0, mp3=0; //для подсчета кол-ва приборов
		Equipment mas[] = new Equipment[count];		
		for (int i=0; i < count; i++) {
			random=GetRandomItem(0, 6);
			switch (random) { 
				case 0:  mas[i]= new Refrigerator(); 	ref++;	break; // Создание Холодильника
				case 1:  mas[i]= new Microwave(); 	 	mic++;	break; // Создание Микроволновки
				case 2:  mas[i]= new VacuumCleaner(); 	vac++; 	break; // Создание Пылесоса
				case 3:  mas[i]= new Iron(); 			irn++;	break; // Создание Утюга
				case 4:  mas[i]= new DvdPlayer(); 		dvd++;	break; // Создание DVD-плеера
				case 5:  mas[i]= new Mp3Player();		mp3++;	break; // Создание mp3-плеера
				default: break;
			}		
		}
		
		//Вывод массива заполненного приборами
		int sumEnergyOn=0, kolvo=0, sumEnergyOff=0;
		for (int i=0; i < mas.length; i++) {			
			System.out.println(mas[i].toString());
			if (mas[i].isOn) {
				sumEnergyOn+=mas[i].power;
				kolvo++;
			} else sumEnergyOff+=mas[i].power;
		}
		System.out.println("\nИз "+count+" приборов, включено "+kolvo+" приборов. Суммарно расходуется - "+sumEnergyOn+" ватт. Остальные расходовали бы - "+sumEnergyOff+" ватт.");
		System.out.println("ИТОГО С РАЗЛОЖЕНИЕМ ТОВАРА ПО КАТЕГОРИЯМ ИЗ МАССИВА:");
		System.out.println("Холодильников\t - "+ref+" шт. ");
		System.out.println("Микроволновок\t - "+mic+" шт. ");
		System.out.println("Пылесосов\t - "+vac+" шт. ");
		System.out.println("Утюгов\t\t - "+irn+" шт. ");
		System.out.println("DVD-плееров\t - "+dvd+" шт. ");
		System.out.println("mp3-плееров\t - "+mp3+" шт. ");
	}
}
