package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dao.FDaoS;

public class FindidCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String name = request.getParameter("name").trim();
		String phone = request.getParameter("phone1").trim()+"-"+request.getParameter("phone2").trim()+
				"-"+request.getParameter("phone3").trim();
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		String customer_id = dao.findId(name, phone);
		if(customer_id!=null) {
			request.setAttribute("customer_id", customer_id);
			request.setAttribute("customer_name", name);
			request.setAttribute("viewpage", "../../pages/findId");
			
		}else request.setAttribute("viewpage", "../../pages/findId_view.jsp?error=error");
	}

}
