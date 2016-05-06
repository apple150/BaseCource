/*	
 * 	ЗАДАНИЕ № 13		EasyNumbers
 * 	13.11.2014
 * 	Решить задание на поиск простых чисел с использованием    break
 * 	
 * 	7 решений с оптимизацией (Массив 130x130 из 16900 итераций производит  439 )
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class EasyNumbers {

	public static void main(String[] args) {
		int size=130; // Размерность массива
		int iter=0;   // Счетчик колва итераций
		int count=0;  // Счетчик для простых чисел будет равен 2
		int СountEasyNumbers=0; //Счетчик общего кол-ва простых чисел в массиве
		String rezult=""; //Сторка вывода результата конкретных значений простых чисел в обозначенном массиве
		
		//1. Массив без breake
		СountEasyNumbers=0;
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			count=0;
			for (int j=1; j<=size; j++) { //вложенный цикл до 100
				iter++;
				if ((i==1)&&(j==1)) {
					rezult=rezult+i;
					СountEasyNumbers++;
				}				
				if (j <= i) {
					if (i%j == 0) count++;
										
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						СountEasyNumbers++;										
					}
				} 
			}
		}		
		System.out.println("1. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций: "+iter+"   ("+rezult+")");

		//2. Массив с breake
		iter=0;
		СountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			count=0;
			for (int j=1; j<=size; j++) { //вложенный цикл до 100
				iter++;
				if ((i==1)&&(j==1)) {
					rezult=rezult+i;
					СountEasyNumbers++;
					break;
				}				
				if (j <= i) {
					if (i%j == 0) count++; //проверка на остаток от деления										
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						СountEasyNumbers++;
						break;						
					}
				} else break;
			}
		}		
		System.out.println("2. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций:  "+iter+"   ("+rezult+")");
		
		//3. Массив с breake
		iter=0;
		СountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			if ((i==1)||(i==2)) {	
				iter++;
				СountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}			
			if (i%2!=0) {
				count=0;
				for (int j=1; j<=size; j++) { //вложенный цикл до 100
					iter++;
					if (j <= i) {
						if (i%j == 0) count++;											
						if ((count==2) && (j==i)) {
							rezult=rezult+", "+i;
							СountEasyNumbers++;
							break;						
						}
					} else break;
				}
			}
		}		
		System.out.println("3. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций:  "+iter+"   ("+rezult+")");

		
		//4. Массив с breake + разница
		iter=0;
		СountEasyNumbers=0;
		rezult="";
		int OldEasyNumber=0; //Старое значение простого числа
		int razniza=0;
		String RezultRazniza="";
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			if ((i==1)||(i==2)) {				
				iter++;
				СountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				if (OldEasyNumber!=0) {
					razniza=i-OldEasyNumber;
					RezultRazniza=""+razniza;
				}
				OldEasyNumber=i; //Старое значение простого числа
				continue;
			}
			
			if (i%2==0) continue;  //Если четное значение то даже не идем на его проверку
			
			count=0;
			for (int j=1; j<=size; j++) { //вложенный цикл до 100
				if (j%2==0) continue; //В 2 раза уменьшает цикл. Если четное значение также не идем на его проверку 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;											
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						СountEasyNumbers++;
						if (OldEasyNumber!=0) {
							razniza=i-OldEasyNumber;
							RezultRazniza=RezultRazniza+", "+razniza;
						}							
						OldEasyNumber=i; //Старое значение простого числа
						break;						
					}
				} else break;
			}

		}		
		System.out.println("4. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций:  "+iter+"   ("+rezult+")");
		

		//5. Массив с breake (деление на 2, 5)
		iter=0;
		СountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			if ((i==1)||(i==2)||(i==3)||(i==5)) {
				iter++;
				СountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}
			
			if ((i%2==0) || (i%5==0)) continue;  //Если четное значение или делится на 3, 5 то даже не идем на его проверку
			
			count=0;
			for (int j=1; j<=size; j++) { //вложенный цикл до 100
				if ((j%2==0) || (j%5==0)) continue; //В 2 раза уменьшает цикл. Если четное значение или делится на 3, 5 также не идем на его проверку 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;											
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						СountEasyNumbers++;
						break;						
					}
				} else break;
			}

		}		
		System.out.println("5. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций:   "+iter+"   ("+rezult+")");
		
		
		//6. Массив с breake (деление на 2, 3, 5)
		iter=0;
		СountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			if ((i==1)||(i==2)||(i==3)||(i==5)) {
				iter++;
				СountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}
			
			if ((i%2==0)||(i%3==0)||(i%5==0)) continue;  //Если четное значение или делится на 3, 5 то даже не идем на его проверку
			
			count=0;
			for (int j=1; j<=size; j++) { //вложенный цикл до 100
				if ((j%2==0) ||(j%3==0) || (j%5==0)) continue; //В 2 раза уменьшает цикл. Если четное значение или делится на 3, 5 также не идем на его проверку 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;											
					if ((count==2) && (j==i)) {
						rezult=rezult+", "+i;
						СountEasyNumbers++;
						break;						
					}
				} else break;
			}

		}		
		System.out.println("6. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций:   "+iter+"   ("+rezult+")");
		
		//7. Массив с breake (деление на 2, 3, 5, 7)
		iter=0;
		СountEasyNumbers=0;
		rezult="";
		for (int i=1; i<=size; i++) { //Основной цикл до 100
			if ((i==1)||(i==2)||(i==3)||(i==5)||(i==7)) {
				iter++;
				СountEasyNumbers++;
				if (i==1) rezult=rezult+i;
				else rezult=rezult+", "+i;
				continue;
			}
			
			if ((i%2==0)||(i%3==0)||(i%5==0)||(i%7==0)) continue;  //Если четное значение или делится на 3, 5, 7 то даже не идем на его проверку
			
			count=0;
			for (int j=1; j<=size; j++) { //вложенный цикл до 100
				if ((j%2==0) ||(j%3==0) || (j%5==0)|| (j%7==0)) continue; //Если четное значение или делится на 3, 5, 7 также не идем на его проверку 
				iter++;
				if (j <= i) {
					if (i%j == 0) count++;
					if (i==j) {
						if (count==2) {
							rezult=rezult+", "+i;
							СountEasyNumbers++;
							break;						
						} else break;
					}
				} else break;
			}

		}		
		System.out.println("7. Массив "+size+"x"+size+" имеет "+СountEasyNumbers+" ПРОСТЫХ ЧИСЕЛ.   Итераций:   "+iter+"   ("+rezult+")");
		System.out.println("Разница "+RezultRazniza);		
	}

}
