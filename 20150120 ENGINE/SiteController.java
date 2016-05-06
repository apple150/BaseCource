

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pageDao;
import data.PageData;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	pageDao dao;
    /**
     * Default constructor. 
     */
    public SiteController() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	dao = pageDao.getDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String section = request.getParameter("sect");
		
		String subsection = request.getParameter("subsect");
		String id;
		if(section == null)
		{
			id = "main";
		}
		else if(subsection == null)
		{
			id = section;
		}
		else
		{
			id = subsection;
		}
		PageData pageData = dao.getPage(id);
		//request.setAttribute("pageid", id);
		request.setAttribute("pagedata", pageData);
		//System.out.println(pageData);
		StringBuffer menutext = new StringBuffer();
		menutext.append("<ul>");
		List<PageData> mpages = dao.getPagesByParent("main");
		for(int i=0;i<mpages.size();i++)
		{
			menutext.append("<li><a href=\"SiteController?sect=");
			menutext.append(mpages.get(i).getId());
			menutext.append("\">");
			menutext.append(mpages.get(i).getTitle4menu());
			menutext.append("</a>");
			List<PageData> spages = dao.getPagesByParent(mpages.get(i).getId());
			menutext.append("<ul>");
			for(int j=0;j<spages.size();j++)
			{
				menutext.append("<li><a href=\"SiteController?sect=");
				menutext.append(mpages.get(i).getId());
				menutext.append("&subsect=");
				menutext.append(spages.get(j).getId());
				menutext.append("\">");
				menutext.append(spages.get(j).getTitle4menu());
				menutext.append("</a></li>");
				
			}
			menutext.append("</ul>");
			menutext.append("</li>");
		}
		menutext.append("</ul>");
		request.setAttribute("pagemenu", menutext.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}