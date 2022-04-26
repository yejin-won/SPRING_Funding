package funding.command;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;

public class ANModifyCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String notice_num = request.getParameter("noticeNum");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		String notice_At_String = request.getParameter("notice_At");
		Timestamp notice_At = Timestamp.valueOf(notice_At_String);
		
		FDaoA daoA = sqlSession.getMapper(FDaoA.class);
		daoA.anoticemodify(notice_num, notice_title, notice_content, notice_At);
		
	}

}
