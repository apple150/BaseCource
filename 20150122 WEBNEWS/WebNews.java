/**	
 * 	�����������  ������ 	WebNews		24.01.2015
 * 	
 * 		���������� ������� ����� �������� ��� �����. 
 * 		�������� (�������) � ������� �
 * 	������� � ���������, ����������, �������, ����� �������, �������� �������
 * 	� ������� ���� ��������� ��������� �������� - ���������, ����� ��������, �.�.�.
 * 	������������ � ������, �������� � email � �������. � ������� email �������� ���������������.
 * 
 * 	1. ����� ������� ��������� ������ � ���������� ������� ��� ������� ������� (������� ������ ������).
 *	2. ������� web application, ������� ����� ��������� ��������� ��������� ��������:
 * 		�. 	������ �������� - �������� 2 ���� - ��� ����� ����� ������������ � ��� ������. 
 * 			���� �������� "Login", ��� ����, ����� ����� � �������. 
 * 			������� �������� �� ���������� (������������) ��������� ������ ���.
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AddCommand;
import com.AddWrite;
import com.Command;
import com.ShowCommand;

import log.Logger;
import dao.Dao;
import dao.MyDao;
import dto.News;
import dto.User;

/**
 * Servlet implementation class WebNews
 */

//@WebServlet("/WebNews")

public class WebNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Dao myDao; //������� ������ DAO � ���������� ���������� 
	public Logger myLog; //������� ������ Logger � ���������� ����������
	
	/*
	@Override
	public void init() throws ServletException {
		super.init();
		myDao = MyDao.getDao();
	}
	*/	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config = getServletConfig();
		//myDao = MyDao.getDao(config.getInitParameter("CurDir"));
		String CurDir = config.getInitParameter("CurDir");
		myLog = Logger.getLogger(CurDir);
		myLog.AddStrToLogFile("*** ������ ��������� ***");
		myDao = MyDao.getDao(CurDir);			
	}
	
    /**
     * Default constructor
     */
    public WebNews() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=windows-1251");
		response.setCharacterEncoding("Cp1251");
		String email = request.getParameter("email");
		if (email == null) {
			myLog.AddStrToLogFile("E-MAIL �� ����� �� ���� NULL");
		} else {
			if (email.equals("")) {
				myLog.AddStrToLogFile("������������ ������� ������ e-mail");		
				response.sendRedirect("Login.html");
			} else {
				
			}
		}
		
		String operation = request.getParameter("operation");		
		Command com = null;		
		if (operation == null) {
			com = new ShowCommand();
		} else if(operation.equals("add")) {
			com = new AddCommand();
		} else if(operation.equals("addwrite")) {
			com = new AddWrite();
		}
		com.execute(request, response);
		
		
		/*
		//1. �������� ��� �������		
		ArrayList<News> array_news = myDao.getNews();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllNews.jsp");
		request.setAttribute("array_news", array_news);
		dispatcher.forward(request, response);
		*/
		
		/*
		//2. �������� ���� �������������		
		ArrayList<User> array_users = myDao.getUsers();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllUsers.jsp");
		request.setAttribute("array_users", array_users);
		dispatcher.forward(request, response);
		*/	
		
		
		//3. �������� 1-�� ������������
		/*
		User user = new User(4, 2, "���������", "��������", "saa@gmail.com","123");
		myDao.addUser(user); //��������� ������������
			//�������� ���� �������������
		ArrayList<User> array_users = myDao.getUsers();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllUsers.jsp");
		request.setAttribute("array_users", array_users);
		dispatcher.forward(request, response);		
		*/
		
		/*
		//4. ������� ������������ �� ID
		User user = new User(4, 2, "���������", "��������", "saa@gmail.com","123");
		myDao.delUser(user); //������� ������������
			//�������� ���� �������������
		ArrayList<User> array_users = myDao.getUsers();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllUsers.jsp");
		request.setAttribute("array_users", array_users);
		dispatcher.forward(request, response);			
		*/
		
		/*
		//5. �������� 1-�� �������
		int id=11; 			// ������������� �������
		String category="�����";	// ��������� ������� ��������, ���������, �����, ...
		String title="����������� ����������� ��������� ������"; 		// ��������� �������
		String annotation="����������� ����������� ��������� ������ � ��������� ����� ��������������� ������ ��-2015 � ��������� �� ������������� �����"; 	// ��������� (������� ��������� �������)
		String author="��������� ��������"; 		// ��� � ������� ������ �������
		String agency="TUT.BY"; 		// �������� �������������� �������
		String drelease="2015-01-23";	// ���� ������ �������
		String document="����������� ������� ������� �������� ������ � ��������� ������� ��������� � ���� ��������������� ������ ���������� ���� - 2015, ������� �������� � ������. �������� ������� ������ ����, �� ������ ������ �������� ������� ����������� ������� ����������� � ��������� ��������� ��������� � ���� ���������."; 	// ����� �������		
		News news = new News(id, category, title, annotation, author, agency, drelease, document);
		myDao.addNews(news); //��������� �������
			// �������� ��� �������		
		ArrayList<News> array_news = myDao.getNews();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllNews.jsp");
		request.setAttribute("array_news", array_news);
		dispatcher.forward(request, response);				
		*/
		
		/*
		//6. ������� ������� �� ID
		int id=11; 			// ������������� �������
		String category="�����";	// ��������� ������� ��������, ���������, �����, ...
		String title="����������� ����������� ��������� ������"; 		// ��������� �������
		String annotation="����������� ����������� ��������� ������ � ��������� ����� ��������������� ������ ��-2015 � ��������� �� ������������� �����"; 	// ��������� (������� ��������� �������)
		String author="��������� ��������"; 		// ��� � ������� ������ �������
		String agency="TUT.BY"; 		// �������� �������������� �������
		String drelease="2015-01-23";	// ���� ������ �������
		String document="����������� ������� ������� �������� ������ � ��������� ������� ��������� � ���� ��������������� ������ ���������� ���� - 2015, ������� �������� � ������. �������� ������� ������ ����, �� ������ ������ �������� ������� ����������� ������� ����������� � ��������� ��������� ��������� � ���� ���������."; 	// ����� �������		
		News news = new News(id, category, title, annotation, author, agency, drelease, document);
		myDao.delNews(news); //������� �������
			// �������� ��� �������		
		ArrayList<News> array_news = myDao.getNews();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllNews.jsp");
		request.setAttribute("array_news", array_news);
		dispatcher.forward(request, response);		
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}