package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;

public class IdCheckCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		
		String customer = dao.checkCustomer(id);
		String seller = dao.checkSeller(id);
		boolean result=false;
		if(customer==null && seller==null) {
			result=true;
		}
		request.setAttribute("result", result);
		request.setAttribute("id", id);
	}

}

