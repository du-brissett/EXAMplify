package Model;
public class User {

	private String fname;
	private String lname ;
	private String email;
	private String id ;
	private String dob ;
	private String gender ;
	private String phone ;
	private String password;
	private int group;
	
	
	public int getGroup() {
		return group;
	}


	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email + ", id=" + id + ", dob=" + dob
				+ ", gender=" + gender + ", phone=" + phone + ", password=" + password + ", group=" + group + "]";
	}


	public void setGroup(int group) {
		this.group = group;
	}


	public User(String fname, String lname, String email, String id, String dob, String gender, String phone,
			String password, int group) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.id = id;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.password = password;
		this.group = group;
	}
	
	
	public User() {
		super();
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
