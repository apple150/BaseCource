import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Multiplication extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("cp1251");
		PrintWriter out = response.getWriter();
		
		out.println("<HTML><HEAD><TITLE>Multiplication</TITLE></HEAD>");
		out.println("<HEAD><TITLE>Multiplication</TITLE></HEAD>");
		out.println("  <TITLE>Multiplication</TITLE></HEAD>");
		out.println("</HEAD>"); 
		out.println("<BODY>");
		out.println("  <H2>Table of Multiplication</H2>");
		out.println("  <TABLE border=\"1\" cellspacing=\"0\" cellpadding=\"8\">");
		for (int i=1; i<10; i++) {
			out.println("    <TR>");
			for (int j=1; j<10; j++) {
				int rez=i*j;
				if (rez%2==0) {
					out.println("      <TD style=\"background-color: yellow; color: red\">"+rez+"</TD>");
				} else {
					out.println("      <TD>"+rez+"</TD>");
				}
			}
			out.println("    </TR>");
		}
		out.println("  </TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}
