package com.projects.springboot.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "families")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Family implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private Long familyId;

	@JoinColumn(unique = true, name = "head_of_family_parent_id")
	@OneToOne(cascade = CascadeType.MERGE)
	private Parent headOfFamilyParentId;

	@NotEmpty
	@Column(name = "family_name")
	private String familyName;

	public Family() {

	}

	public Family(Long familyId, Parent headOfFamilyParentId, String familyName) {
		super();
		this.familyId = familyId;
		this.headOfFamilyParentId = headOfFamilyParentId;
		this.familyName = familyName;

	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public Parent getHeadOfFamilyParentId() {
		return headOfFamilyParentId;
	}

	public void setHeadOfFamilyParentId(Parent headOfFamilyParentId) {
		this.headOfFamilyParentId = headOfFamilyParentId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
