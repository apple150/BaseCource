/*	
 * 	Been		USER 	
 * 	Объект DTO (Data Transfer Object) 
 * 	(переносчик и инкапуляток данных от БД к сервлету и обратно)
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dto;

import java.io.Serializable;

public class User implements Serializable {
	private int id; 	 	// Идентификатор Пользователя
	private int role; 	 	// Права доступа Пользователя (1-администратор, 2-пользователь)
	private String name; 	// Имя Пользователя
	private String fam;  	// Фамилия Пользователя
	private String email; 	// E-Mail Пользователя
	private String password;// Пароль Пользователя
		
	public User() {}  //Конструктор
 	
	//Конструктор с параметрами
	public User(int id, int role, String name, String fam, String email, String password) {
		setId(id);		// Идентификатор Пользователя
		setRole(role);	// Права доступа Пользователя (1-администратор, 2-пользователь)
		setName(name);	// Имя Пользователя
		setFam(fam);	// Фамилия Пользователя
		setEmail(email);		// E-Mail Пользователя
		setPassword(password);	// Пароль Пользователя
	}  
	
	/**
	 * GET Идентификатор Пользователя
	 */	
	public int getId() {
		return id;
	}
	
	/**
	 * SET Идентификатор Пользователя
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * GET  Права доступа Пользователя (1-администратор, 2-пользователь)
	 */	
	public int getRole() {
		return role;
	}

	/**
	 * SET  Права доступа Пользователя (1-администратор, 2-пользователь)
	 */	
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * GET  Имя Пользователя
	 */
	public String getName() {
		return name;
	}

	/**
	 * SET  Имя Пользователя
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * GET  Фамилия Пользователя
	 */
	public String getFam() {
		return fam;
	}

	/**
	 * SET  Фамилия Пользователя
	 */
	public void setFam(String fam) {
		this.fam = fam;
	}

	/**
	 * GET  E-Mail Пользователя
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * SET  E-Mail Пользователя
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * GET  Пароль Пользователя
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * SET  Пароль Пользователя
	 */
	public void setPassword(String password) {
		this.password = password;
	}	
	
	/**
	 * Переопределенное сравнение 2-х объектов USER
	 */
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof User) {
			User user = (User)obj;
			if (id == user.id) {	// Идентификатор Пользователя
				if (role == user.role) {	// Права доступа Пользователя (1-администратор, 2-пользователь)
					if (name.equals(user.name)) {	// Имя Пользователя
						if (fam.equals(user.fam)) {	// Фамилия Пользователя
							if (email.equals(user.email)) {	// E-Mail Пользователя
								if (password.equals(user.password)) {	// Пароль Пользователя
									flag=true;	//Два объекта равны
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
	 * Переопределенный хэш-код объекта USER
	 */	
	@Override
	public int hashCode() {
		return id+"".hashCode();
		//return email.hashCode();
	}	
	
	/**
	 * Переопределенный toString() USER
	 */		
	@Override
	public String toString() {
		String ret="";
		ret="ID-"+id+", ROLE-"+role+", NAME-"+name+", FAM-"+fam+", EMAIL-"+email+", PASSWORD-"+password+" ["+super.toString()+"]";
		return ret;
	}
}