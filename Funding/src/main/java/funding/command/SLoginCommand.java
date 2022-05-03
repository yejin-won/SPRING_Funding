package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoS;

public class SLoginCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("seller_id");
		String pw = request.getParameter("seller_pw");
		FDaoS daoS = sqlSession.getMapper(FDaoS.class);
		
		
		String seller_id = daoS.slogin((String)id,(String)pw);

		if(seller_id != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", seller_id);
			session.setAttribute("email", seller_id);
			session.setAttribute("isSeller", "true");
		}
		
		if(seller_id == null) {
			System.out.println("hello2");
			request.setAttribute("viewpage", "../../pages/slogin.jsp?error=error");
		}else {
			request.setAttribute("viewpage", "main");
		}
	}	

}
