package com.cts.osp.kt.fsd.fsdservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the POLICY database table.
 * 
 */
@Entity
@NamedQuery(name="Policy.findAll", query="SELECT p FROM Policy p")
public class Policy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String name;

	private String details;

	//bi-directional many-to-one association to UserPolicy
	@OneToMany(mappedBy="policy")
	private List<UserPolicy> userPolicies;

	public Policy() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<UserPolicy> getUserPolicies() {
		return this.userPolicies;
	}

	public void setUserPolicies(List<UserPolicy> userPolicies) {
		this.userPolicies = userPolicies;
	}

	public UserPolicy addUserPolicy(UserPolicy userPolicy) {
		getUserPolicies().add(userPolicy);
		userPolicy.setPolicy(this);

		return userPolicy;
	}

	public UserPolicy removeUserPolicy(UserPolicy userPolicy) {
		getUserPolicies().remove(userPolicy);
		userPolicy.setPolicy(null);

		return userPolicy;
	}

}