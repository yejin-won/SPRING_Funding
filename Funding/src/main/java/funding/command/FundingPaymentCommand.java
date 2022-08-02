package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;


public class FundingPaymentCommand implements FCommand {
	@Override
	public void execute(SqlSession sqlSession, Model model){
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String order_customer = request.getParameter("order_customer");
		int order_funding = Integer.parseInt(request.getParameter("order_funding"));

		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		
		if (request.getParameter("order_option0") != null) {
			Integer order_option0 = Integer.parseInt(request.getParameter("order_option0"));
			Integer order_price0 = Integer.parseInt(request.getParameter("order_price0"));
			Integer order_count0 = Integer.parseInt(request.getParameter("order_count0"));
			dao.OrderInsert(order_customer, order_funding, order_option0, order_price0, order_count0);
		}
		if (request.getParameter("order_option1") != null) {
			Integer order_option1 = Integer.parseInt(request.getParameter("order_option1"));
			Integer order_price1 = Integer.parseInt(request.getParameter("order_price1"));
			Integer order_count1 = Integer.parseInt(request.getParameter("order_count1"));
			dao.OrderInsert(order_customer, order_funding, order_option1, order_price1, order_count1);
		}
		
		if (request.getParameter("order_option2") != null) {
			Integer order_option2 = Integer.parseInt(request.getParameter("order_option2"));
			Integer order_price2 = Integer.parseInt(request.getParameter("order_price2"));
			Integer order_count2 = Integer.parseInt(request.getParameter("order_count2"));
			dao.OrderInsert(order_customer, order_funding, order_option2, order_price2, order_count2);
		}
		
		if (request.getParameter("order_option3") != null) {
			Integer order_option3 = Integer.parseInt(request.getParameter("order_option3"));
			Integer order_price3 = Integer.parseInt(request.getParameter("order_price3"));
			Integer order_count3 = Integer.parseInt(request.getParameter("order_count3"));
			dao.OrderInsert(order_customer, order_funding, order_option3, order_price3, order_count3);
		}
		if (request.getParameter("order_option4") != null) {
			Integer order_option4 = Integer.parseInt(request.getParameter("order_option4"));
			Integer order_price4 = Integer.parseInt(request.getParameter("order_price4"));
			Integer order_count4 = Integer.parseInt(request.getParameter("order_count4"));
			dao.OrderInsert(order_customer, order_funding, order_option4, order_price4, order_count4);
		}	
	}
}
