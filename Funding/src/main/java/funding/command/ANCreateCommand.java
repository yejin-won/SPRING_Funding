package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;

public class ANCreateCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		Object notice_admin = session.getAttribute("adminId");
		
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		
		
		FDaoA daoA = new FDaoA();
		
		daoA.anoticecreate(notice_admin, notice_title, notice_content);

	}

}
