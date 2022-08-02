package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
import funding.dto.FDtoNotice;

public class ANContentCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String noticeNum = request.getParameter("noticeNum");
		FDaoA daoA = sqlSession.getMapper(FDaoA.class);
//		FDtoNotice dto = daoA.noticecontent(noticeNum);
//		request.setAttribute("noticecontent", dto);

	}
	
}