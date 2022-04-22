package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoSystemQuestion;

public class MypageCommand implements FCommand {

	@Override
	public void execute(Model model) {

		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		int tab = 1;
		if(request.getParameter("tab") != null) {
			tab = Integer.parseInt(request.getParameter("tab"));
		}
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		FDaoC dao = new FDaoC();
		int myFundingCount = dao.myFundingCount(id);
		int myLikeCount = dao.myLikeCount(id);
		int mySystemQuestionCount = dao.mySystemQuestionCount(id);
		int myFundingQuestionCount = dao.myFundingQuestionCount(id);
		
		ArrayList<FDtoFunding> myfundinglist = null;
		ArrayList<FDtoFunding> mylikelist = null;
		ArrayList<FDtoSystemQuestion> myquestionlist = null;
		ArrayList<FDtoFundingQuestion> myfundingquestionlist = null;
		
		if(tab == 1) {
			myfundinglist = dao.myfundinglist(id, page);		
		}else {
			myfundinglist = dao.myfundinglist(id, 1);		
		}
		if(tab == 2) {
			mylikelist = dao.mylikelist(id, page);	
		}else {
			mylikelist = dao.mylikelist(id, 1);		
		}
		if(tab == 3) {
			myquestionlist = dao.mysystemquestion_list(id, page);
		}else {
			myquestionlist = dao.mysystemquestion_list(id, 1);
		}
		if(tab == 4) {
			myfundingquestionlist = dao.myfundingquestion_list(id, page);
		}else {
			myfundingquestionlist = dao.myfundingquestion_list(id, 1);	
		}
		
		
		request.setAttribute("myFundingCount", myFundingCount);
		request.setAttribute("myLikeCount", myLikeCount);
		request.setAttribute("mySystemQuestionCount", mySystemQuestionCount);
		request.setAttribute("myFundingQuestionCount", myFundingQuestionCount);
		
		request.setAttribute("funding", myfundinglist);
		request.setAttribute("like", mylikelist);
		request.setAttribute("question", myquestionlist);
		request.setAttribute("fundingquestion", myfundingquestionlist);
	}

}
