/*	
 * 	ЗАДАНИЕ № 10		DataForm
 * 	10.01.2015
 * 	Создать форму с вводом имени, телефона и электронной почты.
 *	Создать сервлет, который будет получать эти данные, и распечатывать на странице. 
 *	Если пользователь не ввел имя, или одновременно пропущены телефон и 
 *	электронная почта, следует выводить сообщение об ошибке.
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataForm
 */
@WebServlet("/DataForm")
public class DataForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fio = request.getParameter("fio");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		fio=fio.trim();  phone=phone.trim(); email=email.trim();
		out.println("<HTML>");
		out.println("<META Content-type: text/html; CHARSET=windows-1251 >");
		out.println("<HEAD><TITLE>Servlet DataForm</TITLE></HEAD>");
		out.println("<BODY>");
		String color="";
		if ((fio=="")&&(phone=="")&&(email=="")) {
			color="#FF0000"; //Red
			WriteInfoLine(out, color, "ERROR: You have not completed a single field!", null);			
		} else if ((fio!="")&&(phone=="")&&(email=="")) {
			color="#FF8C00"; //DarkOrange
			WriteInfoLine(out, color, "ERROR: You have only NAME!", null);						
		} else if ((fio!="")&&(phone!="")&&(email!="")) {
			color="#0000FF"; //Blue1
			WriteInfoLine(out, color, "USER", fio);
			WriteInfoLine(out, color, "PHONE", phone);
			WriteInfoLine(out, color, "EMAIL", email);
		} else if ((fio!="")&&((phone!="")||(email!=""))) {
			color="#00BFFF";  //DeepSkyBlue1
			WriteInfoLine(out, color, "USER", fio);
			if (phone!="") WriteInfoLine(out, color, "PHONE", phone);
			if (email!="") WriteInfoLine(out, color, "EMAIL", email);
		} else {
			out.println("<H1>"+fio+"</H1>");
		}
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	public void WriteInfoLine(PrintWriter out, String color, String param, String item) {
		if (item!=null) out.println("<H2 style=\"color:"+color+"\">"+param+": "+item+"</H2>");
		else out.println("<H2 style=\"color:"+color+"\">"+param+"</H2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
