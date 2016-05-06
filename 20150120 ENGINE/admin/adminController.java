package admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.commands.AddCommand;
import admin.commands.AddWriteCommand;
import admin.commands.Command;
import admin.commands.ShowCommand;

import dao.pageDao;
import data.PageData;

/**
 * Servlet implementation class adminController
 */
@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	pageDao dao;
    public adminController() {
        super();
        dao = pageDao.getDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		
		Command com = null;
		
		if(operation == null)
		{
			com = new ShowCommand();
		}
		else if(operation.equals("add"))
		{
			com = new AddCommand();
		}
		else if(operation.equals("addwrite"))
		{
			com = new AddWriteCommand();
		}
		com.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}