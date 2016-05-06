/*	
 * 	Been		NEWS 	
 * 	Объект DTO (Data Transfer Object) 
 * 	(переносчик и инкапуляток данных от БД к сервлету и обратно)
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dto;

import java.io.Serializable;

public class News implements Serializable {
	private int id; 			// Идентификатор Новости
	private String category;	// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
	private String title; 		// Заголовок новости
	private String annotation; 	// Аннотация (краткое оприсание Новости)
	private String author; 		// Имя и Фамилия Автора Новости
	private String agency; 		// Агенство опубликовавшее Новость
	private String drelease;	// Дата печати Новости
	private String document; 	// Текст Новости
	
	public News() {}  //Конструктор
	
	//Конструктор с параметрами
	public News(int id, String category, String title, String annotation, String author, String agency, String drelease, String document) {
		setId(id);		// Идентификатор Пользователя
		setCategory(category);	// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
		setTitle(title);		// Заголовок новости
		setAnnotation(annotation);// Аннотация (краткое оприсание Новости)
		setAuthor(author);		// Имя и Фамилия Автора Новости
		setAgency(agency);		// Агенство опубликовавшее Новость
		setDrelease(drelease);	// Дата печати Новости
		setDocument(document);	// Текст Новости
	}
	
	/**
	 * GET  Идентификатор Новости
	 */
	public int getId() {
		return id;
	}
	/**
	 * SET  Идентификатор Новости
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * GET  Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * SET  Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * GET  Заголовок новости
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * SET  Заголовок новости
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * GET  Аннотация (краткое оприсание Новости)
	 */
	public String getAnnotation() {
		return annotation;
	}
	/**
	 * SET  Аннотация (краткое оприсание Новости)
	 */
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	/**
	 * GET  Имя и Фамилия Автора Новости
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * SET  Имя и Фамилия Автора Новости
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * GET  Агенство опубликовавшее Новость
	 */
	public String getAgency() {
		return agency;
	}
	/**
	 * SET  Агенство опубликовавшее Новость
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * GET  Дата печати Новости
	 */
	public String getDrelease() {
		return drelease;
	}
	/**
	 * SET  Дата печати Новости
	 */
	public void setDrelease(String drelease) {
		this.drelease = drelease;
	}
	/**
	 * GET  Текст Новости
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * SET  Текст Новости
	 */
	public void setDocument(String document) {
		this.document = document;
	}	
	
	/**
	 * Переопределенное сравнение 2-х объектов NEWS
	 */	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof News) {
			News news = (News)obj;
			if (id == news.id) {	// Идентификатор Новости
				if (category.equals(news.category)) {	// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
					if (title.equals(news.title)) {		// Заголовок новости
						if (annotation.equals(news.annotation)) {	// Аннотация (краткое оприсание Новости)
							if (author.equals(news.author)) {		// Имя и Фамилия Автора Новости
								if (agency.equals(news.agency)) {	// Агенство опубликовавшее Новость
									if (drelease.equals(news.drelease)) {		// Дата печати Новости
										if (document.equals(news.document)) {	// Текст Новости
											flag=true;	//Два объекта равны
										}
									}									
								}
							}
						}
					}
				}
			} 	
		}			
		return flag;
	}
	
	/**
	 * Переопределенный хэш-код объекта NEWS
	 */		
	@Override
	public int hashCode() {
		return annotation.hashCode();
	}	
	
	/**
	 * Переопределенный toString() NEWS
	 */		
	@Override
	public String toString() {
		String ret="";
		ret="ID-"+id+", CATEGORY-"+category+", TITLE-"+title+", ANNATATION-"+annotation+", AUTHOR-"+author+", AGENCY-"+agency+", DRELEASE-"+drelease+", DOCUMENT-"+document+" ["+super.toString()+"]";
		return ret;
	}
	
}