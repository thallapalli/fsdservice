package com.cts.osp.kt.fsd.fsdservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the FSD_USER database table.
 * 
 */
@Entity
@Table(name="FSD_USER")
@NamedQuery(name="FsdUser.findAll", query="SELECT f FROM FsdUser f")
public class FsdUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NAME")
	private String username;

	private String password;
	@Transient
	private String passwordConfirm;


	/**
	 * @return the passwordConfirm
	 */
	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	//bi-directional many-to-one association to FsdRole
	@OneToMany(mappedBy="fsdUser")
	private Set<FsdRole> fsdRoles;

	public FsdUser() {
	}

	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<FsdRole> getFsdRoles() {
		return this.fsdRoles;
	}

	public void setFsdRoles(Set<FsdRole> fsdRoles) {
		this.fsdRoles = fsdRoles;
	}

	public FsdRole addFsdRole(FsdRole fsdRole) {
		getFsdRoles().add(fsdRole);
		fsdRole.setFsdUser(this);

		return fsdRole;
	}

	public FsdRole removeFsdRole(FsdRole fsdRole) {
		getFsdRoles().remove(fsdRole);
		fsdRole.setFsdUser(null);

		return fsdRole;
	}

}