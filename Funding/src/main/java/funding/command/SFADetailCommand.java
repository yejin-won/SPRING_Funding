package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingQuestion;

public class SFADetailCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model)  {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String question_num = request.getParameter("question_num");
		FDaoS daoS = sqlSession.getMapper(FDaoS.class);
		FDtoFundingQuestion dtosFQ = daoS.FQuestion_list(question_num);
		request.setAttribute("FAnswer_detail", dtosFQ);
	}

}
