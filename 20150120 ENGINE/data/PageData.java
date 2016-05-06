package data;

import java.io.Serializable;

public class PageData implements Serializable{
	public PageData() {
		
	}
	public String getMaintext() {
		return maintext;
	}
	public void setMaintext(String maintext) {
		this.maintext = maintext;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getTitle4menu() {
		return title4menu;
	}
	public void setTitle4menu(String title4menu) {
		this.title4menu = title4menu;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String id;
	private String parentid;
	private String title;
	private String title4menu;
	private String keywords;
	private String description;
	private String maintext;
			
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof PageData)
		{
			PageData pd = (PageData)obj;
			if(id.equals(pd.id) && parentid.equals(pd.parentid))
				return true;
			else
				return false;
		}
		else
			return false;		
		//return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
		//return super.hashCode();
	}
}