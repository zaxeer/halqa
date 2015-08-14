package org.ahmadiyya.halqa.software.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Members")
public class Member {

	@Id
	@Column(name = "memberId", nullable = false)
	@NotNull
	private int memberId;

	@Column(name = "memberName", nullable = false)
	@NotNull
	@Size(max = 255)
	private String memberName;

	@Column(name = "wassiyatId")
	private int wassiyatId;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getWassiyatId() {
		return wassiyatId;
	}

	public void setWassiyatId(int wassiyatId) {
		this.wassiyatId = wassiyatId;
	}

}
