/**	
 * 	КОНТРОЛЬНАЯ  РАБОТА 	WebNews		24.01.2015
 * 	
 * 		Необходимо создать ленту новостей для сайта. 
 * 		Сущности (объекты) в системе —
 * 	Новость с названием, аннотацией, автором, датой выпуска, основным текстом
 * 	В системе есть несколько категорий новостей - экономика, спорт политика, и.т.д.
 * 	Пользователь с именем, фамилией и email и паролем. В системе email является идентификатором.
 * 
 * 	1. Нужно создать объектную модель — программно описать все объекты системы (создать нужные классы).
 *	2. Создать web application, который будет позволять совершать следующие действия:
 * 		а. 	Первая страница - содержит 2 поля - для ввода имени пользователя и его пароля. 
 * 			Есть кнопочка "Login", для того, чтобы войти в систему. 
 * 			Никаких проверок на валидность (корректность) введенных данных нет.
 * 	
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
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

	public Dao myDao; //Выносим объект DAO в глобальную переменную 
	public Logger myLog; //Выносим объект Logger в глобальную переменную
	
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
		myLog.AddStrToLogFile("*** ЛОГГЕР СТАРТОВАЛ ***");
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
			myLog.AddStrToLogFile("E-MAIL по входу на сайт NULL");
		} else {
			if (email.equals("")) {
				myLog.AddStrToLogFile("ПОЛЬЗОВАТЕЛЬ передал пустой e-mail");		
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
		//1. Показать все НОВОСТИ		
		ArrayList<News> array_news = myDao.getNews();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllNews.jsp");
		request.setAttribute("array_news", array_news);
		dispatcher.forward(request, response);
		*/
		
		/*
		//2. Показать всех ПОЛЬЗОВАТЕЛЕЙ		
		ArrayList<User> array_users = myDao.getUsers();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllUsers.jsp");
		request.setAttribute("array_users", array_users);
		dispatcher.forward(request, response);
		*/	
		
		
		//3. Добавить 1-го ПОЛЬЗОВАТЕЛЯ
		/*
		User user = new User(4, 2, "Александр", "Семченко", "saa@gmail.com","123");
		myDao.addUser(user); //Добавляем ПОЛЬЗОВАТЕЛЯ
			//Показать всех ПОЛЬЗОВАТЕЛЕЙ
		ArrayList<User> array_users = myDao.getUsers();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllUsers.jsp");
		request.setAttribute("array_users", array_users);
		dispatcher.forward(request, response);		
		*/
		
		/*
		//4. Удалить ПОЛЬЗОВАТЕЛЯ по ID
		User user = new User(4, 2, "Александр", "Семченко", "saa@gmail.com","123");
		myDao.delUser(user); //Удаляем ПОЛЬЗОВАТЕЛЯ
			//Показать всех ПОЛЬЗОВАТЕЛЕЙ
		ArrayList<User> array_users = myDao.getUsers();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllUsers.jsp");
		request.setAttribute("array_users", array_users);
		dispatcher.forward(request, response);			
		*/
		
		/*
		//5. Добавить 1-го НОВОСТЬ
		int id=11; 			// Идентификатор Новости
		String category="СПОРТ";	// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
		String title="Белорусские гандболисты проиграли Катару"; 		// Заголовок новости
		String annotation="Белорусские гандболисты проиграли Катару в последнем матче предварительной стадии ЧМ-2015 и поборются за Президентский кубок"; 	// Аннотация (краткое оприсание Новости)
		String author="Станислав Шаршуков"; 		// Имя и Фамилия Автора Новости
		String agency="TUT.BY"; 		// Агенство опубликовавшее Новость
		String drelease="2015-01-23";	// Дата печати Новости
		String document="Гандболисты мужской сборной Беларуси матчем с хозяевами турнира завершили в Дохе предварительную стадию чемпионата мира - 2015, который проходит в Катаре. Уверенно выиграв первый тайм, на старте второй половины встречи белорусская дружина расклеилась и потерпела четвертое поражение в пяти поединках."; 	// Текст Новости		
		News news = new News(id, category, title, annotation, author, agency, drelease, document);
		myDao.addNews(news); //Добавляем НОВОСТЬ
			// Показать все НОВОСТИ		
		ArrayList<News> array_news = myDao.getNews();
		ServletContext context  = getServletContext();
		RequestDispatcher dispatcher  = context.getRequestDispatcher("/AllNews.jsp");
		request.setAttribute("array_news", array_news);
		dispatcher.forward(request, response);				
		*/
		
		/*
		//6. Удалить НОВОСТЬ по ID
		int id=11; 			// Идентификатор Новости
		String category="СПОРТ";	// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
		String title="Белорусские гандболисты проиграли Катару"; 		// Заголовок новости
		String annotation="Белорусские гандболисты проиграли Катару в последнем матче предварительной стадии ЧМ-2015 и поборются за Президентский кубок"; 	// Аннотация (краткое оприсание Новости)
		String author="Станислав Шаршуков"; 		// Имя и Фамилия Автора Новости
		String agency="TUT.BY"; 		// Агенство опубликовавшее Новость
		String drelease="2015-01-23";	// Дата печати Новости
		String document="Гандболисты мужской сборной Беларуси матчем с хозяевами турнира завершили в Дохе предварительную стадию чемпионата мира - 2015, который проходит в Катаре. Уверенно выиграв первый тайм, на старте второй половины встречи белорусская дружина расклеилась и потерпела четвертое поражение в пяти поединках."; 	// Текст Новости		
		News news = new News(id, category, title, annotation, author, agency, drelease, document);
		myDao.delNews(news); //Удаляем НОВОСТЬ
			// Показать все НОВОСТИ		
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