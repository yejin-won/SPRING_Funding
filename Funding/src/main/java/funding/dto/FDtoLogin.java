package funding.dto;

public class FDtoLogin {

	String seller_id;
	String seller_pw;
	String seller_licence;
	String seller_number;
	String seller_profile;
	String seller_name;
	String seller_phone;
	String seller_person_name;
	String seler_person_phone;
	String seller_state;
	
	public FDtoLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public FDtoLogin(String seller_id) {
		super();
		this.seller_id = seller_id;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	
}
