package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dao.FDaoS;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoOrder;



public class FundingdetailCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		//세션이 필요하다면 활성화하기
//		HttpSession session = request.getSession();
//		Object uID = session.getAttribute("uId"); 
		HttpSession session = request.getSession();
		String funding_num  =request.getParameter("fid");
		String id = (String) session.getAttribute("email");
		FDaoC dao = sqlSession.getMapper(FDaoC.class);

		System.out.println(id);
		int hits = dao.select_hits(funding_num);
		hits++;
		dao.update_hits(funding_num, hits);
		
		FDtoFunding dtos = dao.funding_detail(funding_num);
		ArrayList<FDtoFundingOption> optionDtos = dao.optionList(funding_num);
		ArrayList<FDtoFundingQuestion> questionDtos = dao.questionList(funding_num);
		ArrayList<FDtoOrder> orderDtos = dao.orderList(funding_num);
		boolean isLike = false;
		if(id!=null) {
		String Like = dao.checkLike(id, funding_num);
		if(Like!=null) isLike = true;
		}
		request.setAttribute("funding", dtos);
		request.setAttribute("optionList", optionDtos);
		request.setAttribute("questionList",questionDtos);
		request.setAttribute("orderList",orderDtos);
		request.setAttribute("isLike", isLike);
		
	}

}
