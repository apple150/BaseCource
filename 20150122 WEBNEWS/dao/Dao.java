/*	
 * 	DAO		��������� 	
 * 	�������� ���� ������� ������� ����� ����� �����������
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dao;

import dto.News;
import dto.User;

import java.util.ArrayList;

public interface Dao {
	User getUser(String email);	//�������� ������������ �� E-MAIL
	ArrayList<User> getUsers();	//�������� ������ ������������� 
	
	News getNews(int num);		//�������� ������� �� ��������������
	ArrayList<News> getNews();	//�������� ������ ��������
	
	int addUser(User user);		//�������� ������������
	int delUser(User user);		//�������  ������������
	
	int addNews(News news);		//�������� �������
	int delNews(News news);		//�������  �������
}