package funding.command;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoC;


public class FundingLikeCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String like_customer  = request.getParameter("customer_id");
		Date like_at = Date.valueOf(LocalDate.now());
		
		int like_funding  = Integer.parseInt(request.getParameter("funding_num")) ;
		
		request.setAttribute("viewpage", "/fundingContent_view.do?fid=" + request.getParameter("funding_num"));
		FDaoC dao = new FDaoC();
		dao.likeInsert(like_customer, like_funding, like_at);
		
	}
}
