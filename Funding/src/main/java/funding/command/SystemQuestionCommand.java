package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import funding.dao.FDaoC;

public class SystemQuestionCommand implements FCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		FDaoC dao = new FDaoC();
		dao.create_systemQuestion(id, title, content);
	}

}
