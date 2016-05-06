/*	
 * 	Been		NEWS 	
 * 	������ DTO (Data Transfer Object) 
 * 	(���������� � ����������� ������ �� �� � �������� � �������)
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dto;

import java.io.Serializable;

public class News implements Serializable {
	private int id; 			// ������������� �������
	private String category;	// ��������� ������� ��������, ���������, �����, ...
	private String title; 		// ��������� �������
	private String annotation; 	// ��������� (������� ��������� �������)
	private String author; 		// ��� � ������� ������ �������
	private String agency; 		// �������� �������������� �������
	private String drelease;	// ���� ������ �������
	private String document; 	// ����� �������
	
	public News() {}  //�����������
	
	//����������� � �����������
	public News(int id, String category, String title, String annotation, String author, String agency, String drelease, String document) {
		setId(id);		// ������������� ������������
		setCategory(category);	// ��������� ������� ��������, ���������, �����, ...
		setTitle(title);		// ��������� �������
		setAnnotation(annotation);// ��������� (������� ��������� �������)
		setAuthor(author);		// ��� � ������� ������ �������
		setAgency(agency);		// �������� �������������� �������
		setDrelease(drelease);	// ���� ������ �������
		setDocument(document);	// ����� �������
	}
	
	/**
	 * GET  ������������� �������
	 */
	public int getId() {
		return id;
	}
	/**
	 * SET  ������������� �������
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * GET  ��������� ������� ��������, ���������, �����, ...
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * SET  ��������� ������� ��������, ���������, �����, ...
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * GET  ��������� �������
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * SET  ��������� �������
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * GET  ��������� (������� ��������� �������)
	 */
	public String getAnnotation() {
		return annotation;
	}
	/**
	 * SET  ��������� (������� ��������� �������)
	 */
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	/**
	 * GET  ��� � ������� ������ �������
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * SET  ��� � ������� ������ �������
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * GET  �������� �������������� �������
	 */
	public String getAgency() {
		return agency;
	}
	/**
	 * SET  �������� �������������� �������
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * GET  ���� ������ �������
	 */
	public String getDrelease() {
		return drelease;
	}
	/**
	 * SET  ���� ������ �������
	 */
	public void setDrelease(String drelease) {
		this.drelease = drelease;
	}
	/**
	 * GET  ����� �������
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * SET  ����� �������
	 */
	public void setDocument(String document) {
		this.document = document;
	}	
	
	/**
	 * ���������������� ��������� 2-� �������� NEWS
	 */	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof News) {
			News news = (News)obj;
			if (id == news.id) {	// ������������� �������
				if (category.equals(news.category)) {	// ��������� ������� ��������, ���������, �����, ...
					if (title.equals(news.title)) {		// ��������� �������
						if (annotation.equals(news.annotation)) {	// ��������� (������� ��������� �������)
							if (author.equals(news.author)) {		// ��� � ������� ������ �������
								if (agency.equals(news.agency)) {	// �������� �������������� �������
									if (drelease.equals(news.drelease)) {		// ���� ������ �������
										if (document.equals(news.document)) {	// ����� �������
											flag=true;	//��� ������� �����
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
	 * ���������������� ���-��� ������� NEWS
	 */		
	@Override
	public int hashCode() {
		return annotation.hashCode();
	}	
	
	/**
	 * ���������������� toString() NEWS
	 */		
	@Override
	public String toString() {
		String ret="";
		ret="ID-"+id+", CATEGORY-"+category+", TITLE-"+title+", ANNATATION-"+annotation+", AUTHOR-"+author+", AGENCY-"+agency+", DRELEASE-"+drelease+", DOCUMENT-"+document+" ["+super.toString()+"]";
		return ret;
	}
	
}