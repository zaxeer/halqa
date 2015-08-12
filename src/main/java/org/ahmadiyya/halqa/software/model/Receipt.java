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
@Table(name = "Receipts")
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
	
	@Column ( name="tj" )
	private BigDecimal tj;
	
	@Column ( name="wj" )
	private BigDecimal wj;
	
	@Column ( name="bilal" )
	private BigDecimal bilal;
	
	@Column ( name="maryam" )
	private BigDecimal maryam;
	
	@Column ( name="sadqa" )
	private BigDecimal sadqa;
	
	@Column ( name="zakat" )
	private BigDecimal zakat;
	
	@Column ( name="hundertM" )
	private BigDecimal hundertM;
	
	@Column ( name="student" )
	private BigDecimal student;
	
	@Column ( name="mta" )
	private BigDecimal mta;
	
	@Column ( name="lokal" )
	private BigDecimal lokal;
	
	@Column ( name="idCard" )
	private BigDecimal idCard;
	
	@Column ( name="firtana" )
	private BigDecimal fitrana;
	
	@Column ( name="eidFund" )
	private BigDecimal eidFund;

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

	public BigDecimal getTj() {
		return tj;
	}

	public void setTj(BigDecimal tj) {
		this.tj = tj;
	}

	public BigDecimal getWj() {
		return wj;
	}

	public void setWj(BigDecimal wj) {
		this.wj = wj;
	}

	public BigDecimal getBilal() {
		return bilal;
	}

	public void setBilal(BigDecimal bilal) {
		this.bilal = bilal;
	}

	public BigDecimal getMaryam() {
		return maryam;
	}

	public void setMaryam(BigDecimal maryam) {
		this.maryam = maryam;
	}

	public BigDecimal getSadqa() {
		return sadqa;
	}

	public void setSadqa(BigDecimal sadqa) {
		this.sadqa = sadqa;
	}

	public BigDecimal getZakat() {
		return zakat;
	}

	public void setZakat(BigDecimal zakat) {
		this.zakat = zakat;
	}

	public BigDecimal getHundertM() {
		return hundertM;
	}

	public void setHundertM(BigDecimal hundertM) {
		this.hundertM = hundertM;
	}

	public BigDecimal getStudent() {
		return student;
	}

	public void setStudent(BigDecimal student) {
		this.student = student;
	}

	public BigDecimal getMta() {
		return mta;
	}

	public void setMta(BigDecimal mta) {
		this.mta = mta;
	}

	public BigDecimal getLokal() {
		return lokal;
	}

	public void setLokal(BigDecimal lokal) {
		this.lokal = lokal;
	}

	public BigDecimal getIdCard() {
		return idCard;
	}

	public void setIdCard(BigDecimal idCard) {
		this.idCard = idCard;
	}

	public BigDecimal getFitrana() {
		return fitrana;
	}

	public void setFitrana(BigDecimal fitrana) {
		this.fitrana = fitrana;
	}

	public BigDecimal getEidFund() {
		return eidFund;
	}

	public void setEidFund(BigDecimal eidFund) {
		this.eidFund = eidFund;
	}
	
	
	

}
