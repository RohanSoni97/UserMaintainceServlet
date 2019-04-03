package Beans;

public class UserBean 
{
 private int userid;
    private String username,password,userType,name,email,contact,address;
    boolean userstatus;
    
    public int getUserid() 
    {
        return userid;
    }

    public void setUserid(int userid) 
    {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isUserstatus() {
        return userstatus;
    }

    public void setUserstatus(boolean userstatus) {
        this.userstatus = userstatus;
    }
    public String toString()
    {
	return this.userid+" "+this.username+" "+this.userType+" "+this.name+" "+this.email+this.contact+" "+this.address+" "+this.userstatus;
    }

       
}
