package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionDetailCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String num = request.getParameter("question_num");
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		FDtoSystemQuestion detail = dao.systemquestion_detail(num);
		
		request.setAttribute("dto", detail);
	}

}
