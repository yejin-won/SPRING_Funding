package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoA;
import funding.dto.FDtoSystemQuestion;

public class ASystemQDetailCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String question_num = request.getParameter("question_num");
		FDaoA daoA = new FDaoA();
		ArrayList<FDtoSystemQuestion> dtos = daoA.SystemQuestionDetail(question_num);
		
		request.setAttribute("system_question_detail", dtos);
	}
		
	}
	
	


