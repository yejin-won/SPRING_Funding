package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
public class ALoginCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model){
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String aid = request.getParameter("adminId");
		String apw = request.getParameter("adminPw");
		FDaoA daoA = sqlSession.getMapper(FDaoA.class);
		
		

		//String aId = daoA.AlogIn(aid, apw);
//		if(aId != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("adminId", aId);
//		}
//
//		if(aId == null) {
//			request.setAttribute("viewPage", "aLogin.jsp?error=error");
//		}else {
//			request.setAttribute("viewPage", "aCList.do");
//		}
		

	}

}
