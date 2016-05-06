/*	
 * 	ЗАДАНИЕ № 10		ДОПОЛНИТЕЛЬНОЕ		OrderEqual
 * 	11.11.2014
 * 	Имеется целое число. 
 * 	Найти самую длинную последовательность одинаковых цифр в числе.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class OrderEqual {

	//СТАРАЯ  ПРОЦЕДУРА
	public static void Proc(int item) {
		int param = item;
		//int item=113999988;
		//System.out.println("Заданное число = "+item);
		int z=0;
		int n_0=0, n_1=0, n_2=0, n_3=0, n_4=0, n_5=0, n_6=0, n_7=0, n_8=0, n_9=0;
		int OldItem=0;				
		while (item!=0) {
			z= (int) (item % 10);
			if (z!=0) {
				switch (z) {
					case 1: if (OldItem!=z) n_1=0; else n_1++; break;
					case 2: if (OldItem!=z) n_2=0; else n_2++; break;
					case 3: if (OldItem!=z) n_3=0; else n_3++; break;
					case 4: if (OldItem!=z) n_4=0; else n_4++; break;
					case 5: if (OldItem!=z) n_5=0; else n_5++; break;
					case 6: if (OldItem!=z) n_6=0; else n_6++; break;
					case 7: if (OldItem!=z) n_7=0; else n_7++; break;
					case 8: if (OldItem!=z) n_8=0; else n_8++; break;
					case 9: if (OldItem!=z) n_9=0; else n_9++; break;
				}
				
				OldItem=z;
				
				item -= z;	
				if (item>9) {
					item=item/10;	
				}							
			} else {
				//Если на конце 0;
				if (OldItem!=0) n_0=0; else n_0++;
				OldItem=z;
				item=item/10; 				
			}
		}
		
		int max=0,  zn=0;
		max=n_0; zn=0;
		if (n_1>max) { max=n_1; zn=1; }
		if (n_2>max) { max=n_2; zn=2; }
		if (n_3>max) { max=n_3; zn=3; }
		if (n_4>max) { max=n_4; zn=4; }
		if (n_5>max) { max=n_5; zn=5; }
		if (n_6>max) { max=n_6; zn=6; }
		if (n_7>max) { max=n_7; zn=7; }
		if (n_8>max) { max=n_8; zn=8; }
		if (n_9>max) { max=n_9; zn=9; }	
		
		max++;
		
		//System.out.println("Число = "+zn+" встретилось максимально "+max+" раз");	
		System.out.println("OLD PROCERURE  "+"Заданное число - "+param+", Число - "+zn+" встретилось "+max+" раз");
	}
	
	//НОВАЯ  ПРОЦЕДУРА
	public static void Proc1(int item) {
		int param=item;
		
		//System.out.println("Заданное число = "+item);
		int z=0;
		int count=0;
		int sum=0;
		int max=0;
		int Number=0;
		while (item!=0) {
			z= (int) (item % 10);
			sum += z;
			count++;			
			if (z!=0) { //Если на конце не 0
				if (sum/z == count) { // Если число повторилось
					if (max < count) {
						max = count;
						Number = z;				
					}					
				} else { // Если появилось новое число				
					count = 1;
					sum = z;					
				}
				//Уменьшаем число удаляя последние разряды
				item -= z;
				if (item>9) item=item/10;
			} else { //Если на конце 0
				if (sum == 0) { // Если число 0 повторилось
					if (max < count) {
						max = count;
						Number = z;				
					}					
				} else { // Если появилось новое число
					count = 1;
					sum = z;					
				}
				item=item/10; //Уменьшаем число удаляя последние разряды 				
			}
		}
		//System.out.println("");
		System.out.println("NEW PROCERURE  "+"Заданное число - "+param+", Число - "+Number+" встретилось "+max+" раз");
	}
	
	//NEW НОВАЯ  ПРОЦЕДУРА ОПТИМИЗИРОВАНА 19.11.2014
	public static void Proc2(int item) {
		int param=item;
		int z=0;
		int count=0;
		int sum=0;
		int max=0;
		int Number=0;
		while (item!=0) {
			z= item % 10;
			sum += z;
			count++;							
			if (sum/count == z) { // Если число повторилось
				if (max < count) {
					max = count;
					Number = z;				
				}					
			} else { // Если появилось новое число				
				count = 1;
				sum = z;					
			}	
			item -= z;
			if (item>9) item=item/10;
		}
		System.out.println("N-2 PROCERURE  "+"Заданное число - "+param+", Число - "+Number+" встретилось "+max+" раз");
	}
		
	public static void main(String[] args) {
		int item=0;
		item=113999988; Proc(item); Proc1(item); Proc2(item); System.out.println("");		
		item=133333300;	Proc(item); Proc1(item); Proc2(item); System.out.println("");
		item=133000033;	Proc(item); Proc1(item); Proc2(item); System.out.println("");
	}

}
