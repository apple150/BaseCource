package admin.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pageDao;
import data.PageData;

public class AddWriteCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PageData pageData = new PageData();
		pageDao dao = pageDao.getDao();
		
		pageData.setId(request.getParameter("id"));
		pageData.setParentid(request.getParameter("parentid"));
		pageData.setTitle(request.getParameter("title"));
		pageData.setTitle4menu(request.getParameter("title4menu"));
		pageData.setKeywords(request.getParameter("keywords"));
		pageData.setDescription(request.getParameter("description"));
		pageData.setMaintext(request.getParameter("maintext"));
		dao.addPage(pageData);
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}