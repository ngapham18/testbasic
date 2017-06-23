package testbasic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public final class User {
	/**
	 * annotate this the userID as id, setting to GenerateValue to be Auto
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
	@Column(name="USER_NAME")
	 String userName;
	@Column(name="USER_PASSWORD")
	 String password;
	
	public User() {}
	
	public User(Long id, String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 @Override
	  public String toString() {
	    return "User [id=" + id + ", username=" + userName + ", password=" + password + "]";
	  }
}
