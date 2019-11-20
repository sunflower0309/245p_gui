package application;

public class stu_info {
	
	private String Id;
	private String Lastname;
	private String Firstname;
	private String Major;
	private String Currentgrade;
	private String Gradeoption;
	private String Honor;
	private String Notes;
	private String Photo;
	public stu_info(String i, String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8) {
		this.Id=i;
		this.Lastname=string;
		this.Firstname=string2;
		this.Major=string3;
		this.Currentgrade=string4;
		this.Gradeoption=string5;
		this.Honor=string6;
		this.Notes=string7;
		this.Photo=string8;
	}
	public String getId() {
		return this.Id;
	}
	public void set_id(String id) {
		this.Id=id;
	}
	public String getLastname() {
		return this.Lastname;
	}
	public void setLastname(String Lastname) {
		this.Lastname=Lastname;
	}
	public String getFirstname() {
		return this.Firstname;
	}
	public void set_Firstname(String Firstname) {
		this.Firstname=Firstname;
	}
	public String getMajor() {
		return this.Major;
	}
	public void set_Major(String Major) {
		this.Major=Major;
	}
	public String getCurrentgrade() {
		return this.Currentgrade;
	}
	public void set_Currentgrade(String Currentgrade) {
		this.Currentgrade=Currentgrade;
	}
	public String getGradeoption() {
		return this.Gradeoption;
	}
	public void set_Gradeoption(String Gradeoption) {
		this.Gradeoption=Gradeoption;
	}
	public String getHonor() {
		return this.Honor;
	}
	public void set_Honor(String Honor) {
		this.Honor=Honor;
	}
	public String getNotes() {
		return this.Notes;
	}
	public void set_Notes(String Notes) {
		this.Notes=Notes;
	}
	public String getPhoto() {
		return this.Photo;
	}
	public void set_Photo(String Photo) {
		this.Photo=Photo;
	}
}
