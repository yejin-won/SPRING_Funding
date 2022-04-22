package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionSearchCommand implements FCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String search = request.getParameter("question_search");
		FDaoC dao = new FDaoC();
		ArrayList<FDtoSystemQuestion> list = dao.systemquestion_search(search);
		
		request.setAttribute("question", list);
	}

}
