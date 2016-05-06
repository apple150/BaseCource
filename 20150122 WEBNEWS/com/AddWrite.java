package com;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.MyDao;
import dto.News;

public class AddWrite extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			Dao dao = MyDao.getDao("");			
			int id=11; 			// ������������� �������
			String category="�����";	// ��������� ������� ��������, ���������, �����, ...
			String title="����������� ����������� ��������� ������"; 		// ��������� �������
			String annotation="����������� ����������� ��������� ������ � ��������� ����� ��������������� ������ ��-2015 � ��������� �� ������������� �����"; 	// ��������� (������� ��������� �������)
			String author="��������� ��������"; 		// ��� � ������� ������ �������
			String agency="TUT.BY"; 		// �������� �������������� �������
			String drelease="2015-01-23";	// ���� ������ �������
			String document="����������� ������� ������� �������� ������ � ��������� ������� ��������� � ���� ��������������� ������ ���������� ���� - 2015, ������� �������� � ������. �������� ������� ������ ����, �� ������ ������ �������� ������� ����������� ������� ����������� � ��������� ��������� ��������� � ���� ���������."; 	// ����� �������		
			News news = new News(id, category, title, annotation, author, agency, drelease, document);
			dao.addNews(news); //��������� �������
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
