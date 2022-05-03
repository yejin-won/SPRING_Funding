package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;


public class LoginCommand implements FCommand {

	public void execute(SqlSession sqlSession, Model model) {

		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String input_id = request.getParameter("customer_id").trim();
		String input_pw = request.getParameter("customer_pw").trim();
		
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		String customer_id = dao.login(input_id, input_pw);
		
		if(customer_id!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", customer_id);
			session.setAttribute("customer_id", customer_id);
			session.setAttribute("email", customer_id);
		}
		if(customer_id==null) {
			request.setAttribute("viewpage", "../../pages/login.jsp?error=error");
		}else {
			request.setAttribute("viewpage", "main");
		}
	}

}
