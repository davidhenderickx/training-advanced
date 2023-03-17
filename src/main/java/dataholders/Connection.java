package dataholders;

/**
 * Simple data holder. No checks on validity of the 
 * content.
 */
public class Connection {
	private String firstName;
	private String lastName;
	private String sex;
	private String company;
	private String ssu;
	private String experience;
	private String mail;
	private String telephone;
	private String info;

	public Connection(String firstName, String lastName, String sex,
			String company, String ssu, String experience, String mail,
			String telephone, String info) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.company = company;
		this.ssu = ssu;
		this.experience = experience;
		this.mail = mail;
		this.telephone = telephone;
		this.info = info;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSsu() {
		return ssu;
	}
	public void setSsu(String ssu) {
		this.ssu = ssu;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
