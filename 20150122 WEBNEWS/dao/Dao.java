/*	
 * 	DAO		Интерфейс 	
 * 	Описание всех функций которые нужно будет реализовать
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dao;

import dto.News;
import dto.User;

import java.util.ArrayList;

public interface Dao {
	User getUser(String email);	//Получить ПОЛЬЗОВАТЕЛЯ по E-MAIL
	ArrayList<User> getUsers();	//Получить список ПОЛЬЗОВАТЕЛЕЙ 
	
	News getNews(int num);		//Получить НОВОСТЬ по идентификатору
	ArrayList<News> getNews();	//Получить список НОВОСТЕЙ
	
	int addUser(User user);		//Добавить ПОЛЬЗОВАТЕЛЯ
	int delUser(User user);		//Удалить  ПОЛЬЗОВАТЕЛЯ
	
	int addNews(News news);		//Добавить НОВОСТЬ
	int delNews(News news);		//Удалить  НОВОСТЬ
}