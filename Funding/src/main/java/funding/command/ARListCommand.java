package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
import funding.dto.FDtoC;

public class ARListCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String queryName =request.getParameter("query");
		String queryContent =request.getParameter("lContent");
		System.out.println(queryName);
		System.out.println(queryContent);
		
		FDaoA daoA = sqlSession.getMapper(FDaoA.class);
//		ArrayList<FDtoC> dtos = daoA.clist(adminId);
//		request.setAttribute("clist", dtos);
		
		
		

	}

}
