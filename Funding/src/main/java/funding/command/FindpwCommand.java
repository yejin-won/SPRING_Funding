package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dao.FDaoS;

public class FindpwCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String id = request.getParameter("id").trim();
		String pw_q = request.getParameter("pw_q").trim();
		String pw_a = request.getParameter("pw_a").trim();
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		String customer_pw = dao.findpw(id,pw_q, pw_a);
		if(customer_pw!=null) {
			request.setAttribute("customer_pw", customer_pw);
			request.setAttribute("customer_id", id);
			request.setAttribute("viewpage", "../../pages/findpw");
			
		}else request.setAttribute("viewpage", "../../pages/findpw_view.jsp?error=error");
	}

}

