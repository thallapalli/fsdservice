package com.cts.osp.kt.fsd.fsdservice.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_ID_GENERATOR", sequenceName="SEQ_ACCOUNT",allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_ID_GENERATOR")
	private long id;

	private String name;

	public Account() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}