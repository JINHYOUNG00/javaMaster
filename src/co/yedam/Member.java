package co.yedam;

public class Member {
	
	private int memberId;
	private String memberName;
	private String tel;
	private String memberBday;
	private String gender;
	private String email;
	

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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMemberBday() {
		return memberBday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMemberBday(String memberBday) {
		this.memberBday = memberBday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return memberId + "\t" + memberName + "\t" + tel + "\t\t"
				+ memberBday + "\t\t" + gender + "\t\t" + email;
	}
	
	
	
	
}
