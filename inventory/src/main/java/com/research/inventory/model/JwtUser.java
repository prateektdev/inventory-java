package com.research.inventory.model;

/**

* The class is the model for the user which We are setting in the token and getting back from
*  the token received  in the request headers

* @version 1.0

* @author Prateek T

*/
public class JwtUser {
    private String userName;
    private long id;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

	@Override
	public String toString() {
		return "JwtUser [userName=" + userName + ", id=" + id + ", role=" + role + "]";
	}
}
