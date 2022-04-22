package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionlistCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		FDaoC dao = new FDaoC();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int countQuestion = dao.countQuestion();
		ArrayList<FDtoSystemQuestion> list = dao.systemquestion_view(page);
		
		request.setAttribute("question", list);
		request.setAttribute("countQuestion", countQuestion);

	}

}
