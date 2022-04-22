package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import funding.dao.FDaoS;

public class SLoginCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		
		String id = request.getParameter("seller_id");
		String pw = request.getParameter("seller_pw");
		FDaoS daoS = new FDaoS();
		
		String seller_id = daoS.slogin(id,pw);
		if(seller_id != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", seller_id);
			session.setAttribute("isSeller", "true");
		}
		
		if(seller_id == null) {
			request.setAttribute("viewpage", "../../pages/slogin.jsp?error=error");
		}else {
			request.setAttribute("viewpage", "main.do?sort=all");
		}
	}	

}