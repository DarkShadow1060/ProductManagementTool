/**
 * 
 */
package com.nagarro.productmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @author heram
 *
 */
@Entity
public class UserEntity {
	@Id
	@Column
	private String userName;
	@Column
	private String passWord;
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	@Column
	private String email;  
	@Column
	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getemail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setemail(String email) {
		this.email = email;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
