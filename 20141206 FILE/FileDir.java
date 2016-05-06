/*	
 * 	ЗАДАНИЕ № 33  		FileDir
 * 	09.12.2014
 * 	
 * 	Вывести список файлов и каталогов выбранного каталога на диске.
 *  Файлы и каталоги должны быть распечатаны отдельно.
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FileDir {

	public static void main(String[] args) {
		String dir="";
		//dir=".";
		dir="C:/";
		File path = new File(dir);
		File [] mas;
		mas = path.listFiles();
		System.out.println("В массиве "+mas.length+" объектов");
		
		List<String> lDirc = new LinkedList<String>();
		List<String> lFile = new LinkedList<String>();
		
		boolean flag=false;
		for (int i=0; i < mas.length; i++) {
			if (mas[i].isDirectory()) {
				lDirc.add(mas[i].getName()+" размер: "+mas[i].length()+" дата изменения: "+mas[i].lastModified());
			} else {
				lFile.add(mas[i].getName()+" размер: "+mas[i].length()+" дата изменения: "+mas[i].lastModified());
			}
		}
		
		int count=0;
		System.out.println("\nВсе файлы в каталоге");		
		Iterator<String> it = lFile.iterator();
		while(it.hasNext()) {
			count++;
			System.out.println(count+". "+it.next());
		}

		count=0;
		System.out.println("\nВсе директории в каталоге");		
		Iterator<String> itd = lDirc.iterator();
		while(itd.hasNext()) {
			count++;
			System.out.println(count+". "+itd.next());
		}
		
	}

}
