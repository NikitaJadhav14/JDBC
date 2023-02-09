package count.jsp.student.dto;

public class Student {
    private int id;
    private String Name;
    private String Email;
    
   
    /*public Student (int ID,String Name,String Email) {
      this.id=ID;
      this.Name=Name;
      this.Email=Email;
    }*/

	public int getId() {
		return id;
	}

	public void setId(int ID) {
		this.id = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
    
}
