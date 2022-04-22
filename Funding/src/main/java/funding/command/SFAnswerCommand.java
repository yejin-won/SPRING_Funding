package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoS;

public class SFAnswerCommand implements FCommand {

	@Override
	public void execute(Model model)  {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String answer_content = request.getParameter("answer_content");
		String question_num = request.getParameter("question_num");
		
		FDaoS dao = new FDaoS();
		dao.FAnswer_Update(question_num, answer_content);
		
		String viewpage = "sFADetail.do?question_num="+question_num;
		request.setAttribute("viewpage", viewpage);
	}

}
