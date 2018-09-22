package com.cts.osp.kt.fsd.fsdservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USER_POLICIES database table.
 * 
 */
@Entity
@Table(name="USER_POLICIES")
@NamedQuery(name="UserPolicy.findAll", query="SELECT u FROM UserPolicy u")
public class UserPolicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_ENDDATE")
	private Date policyEnddate;

	private String valid;

	//bi-directional many-to-one association to FsdUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private FsdUser fsdUser;

	//bi-directional many-to-one association to Policy
	@ManyToOne
	private Policy policy;

	public UserPolicy() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getPolicyEnddate() {
		return this.policyEnddate;
	}

	public void setPolicyEnddate(Date policyEnddate) {
		this.policyEnddate = policyEnddate;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public FsdUser getFsdUser() {
		return this.fsdUser;
	}

	public void setFsdUser(FsdUser fsdUser) {
		this.fsdUser = fsdUser;
	}

	public Policy getPolicy() {
		return this.policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

}