package org.ahmadiyya.halqa.software.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Receipt")
public class Receipt {
	
	@Id
	@Column(name = "id", nullable = false)
    @NotNull
	private int id;
	
	@Column(name = "memberId", nullable = false)
    @NotNull
	private int memberId;
	
	@Column(name = "wassiyatId")
	private int wassiyatId;
	
	@Column(name = "memberName", nullable = false)
    @NotNull
    @Size(max = 255)
	private String memberName;
	
	@Column(name = "receiptDate")
	@Type(type="date")
	private Date receiptDate;
	
	@Column ( name="aam" )
	private BigDecimal aam;
	
	@Column ( name="hissaAmad" )
	private BigDecimal hissaAmad;
	
	@Column ( name="jalsaSalana" )
	private BigDecimal jalsaSalana;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getWassiyatId() {
		return wassiyatId;
	}

	public void setWassiyatId(int wassiyatId) {
		this.wassiyatId = wassiyatId;
	}


	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public BigDecimal getAam() {
		return aam;
	}

	public void setAam(BigDecimal aam) {
		this.aam = aam;
	}

	public BigDecimal getHissaAmad() {
		return hissaAmad;
	}

	public void setHissaAmad(BigDecimal hissaAmad) {
		this.hissaAmad = hissaAmad;
	}

	public BigDecimal getJalsaSalana() {
		return jalsaSalana;
	}

	public void setJalsaSalana(BigDecimal jalsaSalana) {
		this.jalsaSalana = jalsaSalana;
	}
	
	
	

}
