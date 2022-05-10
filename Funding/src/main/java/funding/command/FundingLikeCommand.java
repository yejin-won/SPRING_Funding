package funding.command;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;


public class FundingLikeCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String like_customer  = request.getParameter("customer_id");
		Date like_at = Date.valueOf(LocalDate.now());
		
		int like_funding  = Integer.parseInt(request.getParameter("funding_num")) ;
		
		request.setAttribute("viewpage", "/fundingContent_view?fid=" + request.getParameter("funding_num"));
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		dao.likeInsert(like_customer, like_funding, like_at);
		
	}
}
