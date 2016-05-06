/*	
 * 	Been		USER 	
 * 	������ DTO (Data Transfer Object) 
 * 	(���������� � ����������� ������ �� �� � �������� � �������)
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dto;

import java.io.Serializable;

public class User implements Serializable {
	private int id; 	 	// ������������� ������������
	private int role; 	 	// ����� ������� ������������ (1-�������������, 2-������������)
	private String name; 	// ��� ������������
	private String fam;  	// ������� ������������
	private String email; 	// E-Mail ������������
	private String password;// ������ ������������
		
	public User() {}  //�����������
 	
	//����������� � �����������
	public User(int id, int role, String name, String fam, String email, String password) {
		setId(id);		// ������������� ������������
		setRole(role);	// ����� ������� ������������ (1-�������������, 2-������������)
		setName(name);	// ��� ������������
		setFam(fam);	// ������� ������������
		setEmail(email);		// E-Mail ������������
		setPassword(password);	// ������ ������������
	}  
	
	/**
	 * GET ������������� ������������
	 */	
	public int getId() {
		return id;
	}
	
	/**
	 * SET ������������� ������������
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * GET  ����� ������� ������������ (1-�������������, 2-������������)
	 */	
	public int getRole() {
		return role;
	}

	/**
	 * SET  ����� ������� ������������ (1-�������������, 2-������������)
	 */	
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * GET  ��� ������������
	 */
	public String getName() {
		return name;
	}

	/**
	 * SET  ��� ������������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * GET  ������� ������������
	 */
	public String getFam() {
		return fam;
	}

	/**
	 * SET  ������� ������������
	 */
	public void setFam(String fam) {
		this.fam = fam;
	}

	/**
	 * GET  E-Mail ������������
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * SET  E-Mail ������������
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * GET  ������ ������������
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * SET  ������ ������������
	 */
	public void setPassword(String password) {
		this.password = password;
	}	
	
	/**
	 * ���������������� ��������� 2-� �������� USER
	 */
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof User) {
			User user = (User)obj;
			if (id == user.id) {	// ������������� ������������
				if (role == user.role) {	// ����� ������� ������������ (1-�������������, 2-������������)
					if (name.equals(user.name)) {	// ��� ������������
						if (fam.equals(user.fam)) {	// ������� ������������
							if (email.equals(user.email)) {	// E-Mail ������������
								if (password.equals(user.password)) {	// ������ ������������
									flag=true;	//��� ������� �����
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
	 * ���������������� ���-��� ������� USER
	 */	
	@Override
	public int hashCode() {
		return id+"".hashCode();
		//return email.hashCode();
	}	
	
	/**
	 * ���������������� toString() USER
	 */		
	@Override
	public String toString() {
		String ret="";
		ret="ID-"+id+", ROLE-"+role+", NAME-"+name+", FAM-"+fam+", EMAIL-"+email+", PASSWORD-"+password+" ["+super.toString()+"]";
		return ret;
	}
}