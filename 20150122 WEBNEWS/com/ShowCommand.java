package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.News;
import dao.MyDao;
import dao.Dao;

public class ShowCommand extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<News> list;
		List<News> subList;
		Iterator<News> newsIterator;
		Dao dao = MyDao.getDao("");
		list = dao.getNews();
		newsIterator = list.iterator();
		StringBuffer st = new StringBuffer();
		st.append("<ul>");
		while(newsIterator.hasNext())
		{
			News newsData = newsIterator.next();
			st.append("<li>");
			st.append(newsData.getTitle());
			st.append(" <a href=\"adminController?operation=edit&id=");
			st.append( newsData.getId());
			st.append("\">Edit</a>");
			st.append(" <a href=\"adminController?operation=delete&id=");
			st.append( newsData.getId());
			st.append("\">Delete</a>");
			//st.append("</a>");
			
			subList = dao.getNews();
			Iterator<News> subNewsIterator = subList.iterator();
			
			st.append("<ul>");
			while(subNewsIterator.hasNext())
			{
				News subNewsData = subNewsIterator.next();
				st.append("<li>");
				st.append(subNewsData.getTitle());
				st.append(" <a href=\"adminController?operation=edit&id=");
				st.append(subNewsData.getId());
				st.append("\">Edit</a>");
				st.append(" <a href=\"adminController?operation=delete&id=");
				st.append(subNewsData.getId());
				st.append("\">Delete</a>");
				st.append("</li>");
			}
			st.append("<li><a href=\"adminController?operation=add&id=");
			st.append( newsData.getId());
			st.append("\">Add page</a></li>");			
			st.append("</ul>");
			st.append("</li>");
		}
		st.append("<li><a href=\"adminController?operation=add&id=main\">");
		st.append("Add page</a></li>");
		st.append("</ul>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mainadmin.jsp");
		request.setAttribute("menu", st.toString());
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
