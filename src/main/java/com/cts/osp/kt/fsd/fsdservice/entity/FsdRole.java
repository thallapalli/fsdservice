package com.cts.osp.kt.fsd.fsdservice.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FSD_ROLE database table.
 * 
 */
@Entity
@Table(name="FSD_ROLE")
@NamedQuery(name="FsdRole.findAll", query="SELECT f FROM FsdRole f")
public class FsdRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FSD_ROLE_ROLEID_GENERATOR", sequenceName="SEQ_USER_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FSD_ROLE_ROLEID_GENERATOR")
	@Column(name="ROLE_ID")
	private String roleId;

	@Column(name="ROLE_NAME")
	private String roleName;

	//bi-directional many-to-one association to FsdUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private FsdUser fsdUser;

	public FsdRole() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public FsdUser getFsdUser() {
		return this.fsdUser;
	}

	public void setFsdUser(FsdUser fsdUser) {
		this.fsdUser = fsdUser;
	}

}