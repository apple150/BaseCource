/*	
 * 	ЗАДАНИЕ № 9		CountUsers
 * 	08.01.2015
 * 	Создать простейший сервлет подсчитывающий кол-во посещений 
 * 	т.е. при каждом обращении к сервлету следует увеличить 
 * 	счетчик посещений и выводить его значение на страницу. 
 * 	Количество следут хранить в файле.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountUsers
 */
@WebServlet("/CountUsers")
public class CountUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public final String nameFile = "D:\\Students\\ServletTest\\CountUsers.txt"; 
	public final String nameFile = "C:\\JAVA\\TestServlet\\CountUsers.txt";

    /**
     * Default constructor. 
     */
    public CountUsers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0;
		i=ReadItem(nameFile);
		i++;
		WriteNewItem(nameFile, i);
		response.setCharacterEncoding("cp1251");
		PrintWriter out = response.getWriter();
		out.println("<h2>You are "+i+" on this servlet</h2>");		
	}

    public int ReadItem(String nameFile) {
    	int ret=0;
    	File fl = new File(nameFile);
    	if (fl.exists()==true) {
			BufferedReader fr = null;
			try {
				fr = new BufferedReader(new FileReader(nameFile)); //Открываем файл
				try {
					String res = fr.readLine();
					if (res.length() > 0) res=res.trim();
					ret = Integer.parseInt(res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else {
    		System.out.println("Файл не найден");
    	}
		return ret;
    }
	
	public void WriteNewItem(String nameFile, int i) {
		File fl = new File(nameFile);
		if (fl.exists() == false) {
			try {
				fl.createNewFile();
			} catch (IOException e) {
				System.out.println("Файл не создался "+nameFile);
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(fl); 
			pw.println(i);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+nameFile);
			return;
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
