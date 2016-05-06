/*	
 * 	ЗАДАНИЕ № 4		Radius
 * 	08.11.2014
 * 	Определить, можно ли его полностью закрыть круглой картонкой радиусом R.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.lang.Math;

public class Radius {
	// Процедура оценивающая необходимый минимальный радиус
	public static void DefineRadius(int a, int b, int r) { 		
		double DevideA, DevideB, Gipotenuza=0.0; //среднее значение грани прямоугольника
		DevideA=a/2.0;
		DevideB=b/2.0;
		/*System.out.println("   "+"DevideA-"+DevideA);
		System.out.println("   "+"DevideB-"+DevideB);*/
		Gipotenuza=Math.sqrt(Math.pow(DevideA,2)+Math.pow(DevideB,2));
		
		String rezult="";
		rezult=rezult+"(A="+a+", B="+b+")   RADIUS="+r;
		if (r<Gipotenuza) rezult = rezult+"  Can NOT CLOSE rectangle";
		else rezult = rezult+"  Can CLOSE rectangle";
		System.out.println("   "+rezult);
		System.out.println("   "+"MIN Radius that can close rectangle is "+Gipotenuza+'\n');		
	}

	public static void main(String[] args) { 
		System.out.println('\n'+"   *** Copyright -Sergey Buglak- ***");
		System.out.println("   ***          RADIUS           ***"+'\n');				
		
		int a, b, r= 0;		
		a=5; b=3; r=3;			DefineRadius(a, b, r);
		a=42; b=28; r=24;		DefineRadius(a, b, r);
		a=50; b=50; r=32;		DefineRadius(a, b, r);
		a=685; b=532; r=434;	DefineRadius(a, b, r);
		
		System.out.println('\n'+"   ***       End of program      ***");
	}

}