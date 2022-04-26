package funding.dao;

import java.sql.Date;
import java.util.ArrayList;

import funding.dto.FDtoCalculate;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingContent;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;

public interface FDaoS {

	//For SELLER
	//Login/out & Sign-up
	public void ssignUp(String seller_id, String seller_pw, String seller_number,
			String seller_profile, String seller_name, String seller_phone, String seller_person_name,
			String seller_person_phone);
	public boolean duplecateID(String id, String pw);
	public boolean checkDuplicateId(String id);
	public void address(String address_seller, String address_state, String address_city
			, String address_line);
	public String slogin(String id, String pw);
	//Functions
	public void sFOapply(String seller_id, String seller_name, String seller_number, String seller_person_name,
			String seller_person_phone, String address_seller, String address_state, String address_city,
			String address_line);
	public FDtoCalculate list(String fNum, String seller);
	public void sMFCapply(String fNum, String seller);
	public ArrayList<FDtoFunding> Mfunding_list(String id);
	public FDtoFunding selectDetail(String num);
	public ArrayList<FDtoFundingOption> selectOption(String num);
	public FDtoFundingContent selectDetail1(String num);
	public void modifySelectDetail(String num, String banner, String title, String openAt,
			String closeAt, String purpose, String fee);
	public void modifySelectDetail1(String num, String name, String price, String amount);
	public void modifySelectDetail2(String num, String content);
	//해당부분 뭐가 다른건지..쿼리문은 동일
	//FDaoS.xml에는 하나만 적음
	public void deleteSelectDetail(String num);
	public void deleteSelectDetail1(String num);
	//-------------------------------------------
	public FDtoFundingQuestion FQuestion_list(String num);
	public void FAnswer_Update(String num, String answer);
	public void fundingDataInsert(String funding_seller, String funding_banner
			, String funding_title, Date funding_openAt, Date funding_closeAt
			, int funding_purpose, int funding_fee);
	public int funding_num(String funding_title);
	public void optionDataInsert(int option_numbering, String option_name, int option_price
			, int option_amount,int option_funding);
	public void fundingContentInsert(int funding_num, String funding_content);
	public void update_infor(String id, String pw, String phone);
	public ArrayList<FDtoFundingQuestion> myfq(String id);
	public FDtoFunding calfunding(String num);
	public String calinf(String num);
	//For CUSTOMER
	
}
