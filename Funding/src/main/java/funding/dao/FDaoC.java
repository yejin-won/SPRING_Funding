package funding.dao;

import java.sql.Date;
import java.util.ArrayList;

import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoNotice;
import funding.dto.FDtoOrder;
import funding.dto.FDtoSystemQuestion;

public interface FDaoC {
	public void leave(String id);
	public String login(String id, String pw);
	public void signUp(String customer_id, String customer_pw, String customer_name, 
			String customer_phone, String customer_pw_q, String customer_pw_a);
	public void addAddress(String customer_id, String address1, String address2, String address3);
	public String findId(String name, String phone);
	public String findpw(String id, String pw_q, String pw_a);
	public boolean checkEmail(String email);
	
	public ArrayList<FDtoFunding> mainlist(String querying);
	
	public String checkLike(String cid, String fid);
	public FDtoFunding funding_detail(String fnum);
	public ArrayList<FDtoFundingOption> optionList(String funding_num);
	public ArrayList<FDtoFundingQuestion> questionList(String funding_num);
	public void likeInsert(String like_customer, int like_funding, Date like_at);
	public void unlike(String like_customer, int like_funding);
	public void OrderInsert(String order_customer, int order_funding, int order_option, int order_price, int order_count);
	public ArrayList<FDtoOrder> orderList(String funding_num);
	public int select_hits(String funding_num);
	public void update_hits(String funding_num, int hits);
	public void question_create(String funding_num, String id, String content);
	
	public int myFundingCount(String id);
	public int myLikeCount(String id);
	public int mySystemQuestionCount(String id);
	public int myFundingQuestionCount(String id);
	public int countNotice();
	public int countFunding();
	public int countQuestion();
	
	public ArrayList<FDtoNotice> notice_list(int page);
	public ArrayList<FDtoNotice> notice_search(String search);
	public FDtoNotice notice_detail(String num);
	public ArrayList<FDtoFunding> funding_list_view(int page);
	public ArrayList<FDtoFunding> fundingsearch(String search);
	public ArrayList<FDtoSystemQuestion>systemquestion_view(int page);
	public ArrayList<FDtoSystemQuestion>systemquestion_search(String search);
	public FDtoSystemQuestion systemquestion_detail(String num);
	public void create_systemQuestion(String id, String title, String content);
	
	public ArrayList<FDtoSystemQuestion>mysystemquestion_list(String id, int page);
	public ArrayList<FDtoFundingQuestion>myfundingquestion_list(String id, int page);
	public ArrayList<FDtoFunding> myfundinglist(String id, int page);
	public ArrayList<FDtoFunding> mylikelist(String id, int page);
	public FDtoFunding myorder_funding(String num);
	public ArrayList<FDtoOrder> myorder_ordering(String num,String id);
	public void update_infor(String id, String pw, String phone);
}
