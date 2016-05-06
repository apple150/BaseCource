/*	
 * 	ЗАДАНИЕ № 12  		Buhgalter		(Названа самой сложной)
 * 	13.11.2014
 * 	Имеется целое число, следует вывести его в бухгалтерском формате.
 * 	Т.е., начиная справа, каждые три позиции отделяются пробелом.
 * 	Например, число 20023143 должно быть выведено как   20 023 143
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

public class Buhgalter {

	/** 
	 * СТАРАЯ  ПРОЦЕДУРА 
	 */
	public static void Proc(int item) {
		int razr=0, sum=0, z=0, count=0;		
		System.out.println("");
		System.out.println(item+" Заданное число OLD");		
		// 1-ый WHILE		(с разворотом числа)
		boolean flag=false; //на проверку первого нуля		
		while (item!=0) {
			razr++;	//Считаем разряды (или итерации)
			z= (int) (item % 10);
			if (z!=0) {				
				item -= z;	sum += z;
				if (item>9) {
					item=item/10;	
					if (sum==0) {sum=1; flag=true;} sum = sum*10;
				}							
			} else {				
				item=item/10; 
				if (sum==0) {sum=1; flag=true;} sum = sum*10;			
			}
		}		
		System.out.println(sum+" Развернутое число");				
		int first= (int) (razr%3);
		if (first==0) first=3;
		
		// 2-ой WHILE и окончательный с выводом на консоль
		int i=0;
		while (sum!=0) {
			count++;
			i++;
			z= (int) (sum % 10);
			if (z!=0) {				
				sum -= z;	sum = sum/10;
				if (count==razr) {
					if (flag==true) System.out.print("0");
					else System.out.print(z);
				} else System.out.print(z);								
			} else {				
				sum = sum/10;
				if (count==razr) {
					if (flag==true) System.out.print("0");
					else System.out.print(z);
				} else System.out.print(z);											
			}
			//Вывод с соответствующими разрядами
			if (i==first) {
				if (i==first) first=3;
				System.out.print(" "); 
				i=0;
			}
		}
		System.out.println(" ГОТОВЫЙ  РЕЗУЛЬТАТ");
		System.out.println("");
	}

	/**
	 * СТАРАЯ  ПРОЦЕДУРА ОПТИМИЗИРОВАННАЯ  19.11.2014
	 */
	public static void Proc1(int item) {		
		System.out.println(item+" Заданное число NEW");
		if (item < 0) return; 		//С отрицательными значениями не работаем
		if ((item >= 0) && (item < 10)) {
			System.out.println(item+" ГОТОВЫЙ  РЕЗУЛЬТАТ\n");
			return;
		}
		int razr=0, sum=0, z=0;
		boolean flag=false; 	//Для проверки в конце числа первого нуля				
		while (item!=0) { 		// 1-ый WHILE	для разворота числа
			razr++;			//Считаем разряды (или итерации целочисленного деления на 10)
			z= item % 10;
			item -= z;	 sum += z;
			if (item>9) {
				item=item/10;	if (sum==0) {sum=1; flag=true;} sum = sum*10;
			} 			
		}		
		System.out.println(sum+" Развернутое число");							
		while (sum!=0) { // 2-ой WHILE с выводом на консоль
			razr--;  	//Для корректного вывода разрядов 
			z= sum % 10;
			sum -= z;	sum = sum/10;
			if (razr==0) { //Если пришел последний разряд				
				if (flag==true) z=0;  
				System.out.print(z);				
			} else System.out.print(z);
			if (razr%3==0) System.out.print(" ");	//Вывод с соответствующими разрядами
		}
		System.out.println(" ГОТОВЫЙ  РЕЗУЛЬТАТ\n");
	}
	
	/**
	 * NEW НОВАЯ  ПРОЦЕДУРА  (ВАРИАНТ  СМАЛЮКА АНТОНА ФЕДОРОВИЧА)
	 */
	public static void ProcNew(int num) {		
		System.out.println(num+" Заданное число ВС");
		int len=0;  //Для подсчета кол-ва разрядов
		int p=1;    //Чтоб не умножать на 0
		int tmpNum = num;
		while (tmpNum > 0) {
			len++;
			p*=10;
			tmpNum/=10;
		}		

		tmpNum=num;		
					
		while (len > 0) {
			if (len%3 == 0) System.out.print(" ");
			len--;
			
			p/=10;
			int n = tmpNum/p;
			System.out.print(n);
			tmpNum=tmpNum-n*p;
		}
		System.out.print("  ГОТОВЫЙ  РЕЗУЛЬТАТ");
		System.out.println("");
	}

	/**
	 * NEW НОВАЯ  ПРОЦЕДУРА  (ВАРИАНТ  СМАЛЮКА АНТОНА ФЕДОРОВИЧА) ОПТИМИЗИРОВАННАЯ
	 */
	public static void ProcNewOptim(int num) {		
		System.out.println(num+" Заданное число ВС");
		int len=0;  //Для подсчета кол-ва разрядов
		int p=1;    //Чтоб не умножать на 0
		int tmpNum = num;		
		while (tmpNum > 0) {
			len++;
			p*=10;
			tmpNum/=10;
		}				
		tmpNum=num;		
			
		while (len > 0) {
			if (len%3 == 0) System.out.print(" ");
			len--;				
			p/=10;
			int n = tmpNum/p;
			System.out.print(n);
			tmpNum=tmpNum-n*p;
		}
		System.out.print("  ГОТОВЫЙ  РЕЗУЛЬТАТ");
		System.out.println("");
	}
	
	/**
	 * СТАРТ  ПРОГРАММЫ
	 */
	public static void main(String[] args) {
		int item=0;
		item=20023140;  Proc(item); Proc1(item); ProcNew(item); ProcNewOptim(item);
		
		//item=2147483647;  Proc(item); Proc1(item); ProcNew(item);
		//item=2147483642;  Proc(item); Proc1(item); ProcNew(item);
		//item=1;  Proc(item); Proc1(item); ProcNew(item);
		
		//item=20123;  Proc(item); Proc1(item); ProcNew(item);
		//item=204748349;  Proc(item); Proc1(item); ProcNew(item);
		//item=1000000000;  Proc(item); Proc1(item); ProcNew(item);
		
		//item=100000010; ProcNewOptim(item); Proc1(item);
		
		//item=2147483641;  Proc(item); Proc1(item); ProcNew(item);
		
		//item=2002314321;  Proc(item); Proc1(item); ProcNew(item);
				
		//item=120000;  Proc(item); Proc1(item); ProcNew(item);
		
		//item=10314321;  Proc(item); Proc1(item); ProcNew(item);
	}
}