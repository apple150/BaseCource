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
			int id=11; 			// Идентификатор Новости
			String category="СПОРТ";	// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
			String title="Белорусские гандболисты проиграли Катару"; 		// Заголовок новости
			String annotation="Белорусские гандболисты проиграли Катару в последнем матче предварительной стадии ЧМ-2015 и поборются за Президентский кубок"; 	// Аннотация (краткое оприсание Новости)
			String author="Станислав Шаршуков"; 		// Имя и Фамилия Автора Новости
			String agency="TUT.BY"; 		// Агенство опубликовавшее Новость
			String drelease="2015-01-23";	// Дата печати Новости
			String document="Гандболисты мужской сборной Беларуси матчем с хозяевами турнира завершили в Дохе предварительную стадию чемпионата мира - 2015, который проходит в Катаре. Уверенно выиграв первый тайм, на старте второй половины встречи белорусская дружина расклеилась и потерпела четвертое поражение в пяти поединках."; 	// Текст Новости		
			News news = new News(id, category, title, annotation, author, agency, drelease, document);
			dao.addNews(news); //Добавляем НОВОСТЬ
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
