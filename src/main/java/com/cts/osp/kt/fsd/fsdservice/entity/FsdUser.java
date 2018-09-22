package com.cts.osp.kt.fsd.fsdservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private String userId;

	private String address;

	@Column(name="CONTACT_NO")
	private BigDecimal contactNo;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	//bi-directional many-to-one association to UserPolicy
	@OneToMany(mappedBy="fsdUser")
	private List<UserPolicy> userPolicies;

	public FsdUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(BigDecimal contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserPolicy> getUserPolicies() {
		return this.userPolicies;
	}

	public void setUserPolicies(List<UserPolicy> userPolicies) {
		this.userPolicies = userPolicies;
	}

	public UserPolicy addUserPolicy(UserPolicy userPolicy) {
		getUserPolicies().add(userPolicy);
		userPolicy.setFsdUser(this);

		return userPolicy;
	}

	public UserPolicy removeUserPolicy(UserPolicy userPolicy) {
		getUserPolicies().remove(userPolicy);
		userPolicy.setFsdUser(null);

		return userPolicy;
	}

}