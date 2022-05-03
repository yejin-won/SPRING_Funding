package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;

public class MainCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		String query = null;
		String sort = request.getParameter("sort");
		
		if(request.getParameter("sort")==null) sort = "all";
		switch(sort) {
		case(""):
			query = "WHERE FUNDING_STATE = '진행'";
			break;
		case("all"):
			query = "WHERE FUNDING_STATE = '진행'";
		break;
		case("hits"):
			query = "WHERE FUNDING_STATE = '진행' ORDER BY FUNDING_HITS DESC";
			break;
		case("achievement"):
			query = "WHERE FUNDING_STATE = '진행' ORDER BY ACHIEVEMENT DESc";
		break;
		case("closeAt"):
			query = "WHERE FUNDING_STATE = '진행' ORDER BY FUNDING_CLOSEAT";
		break;
		case("end"):
			query = "WHERE FUNDING_STATE != '진행'";
		break;
		}
		
		ArrayList<FDtoFunding> list = dao.mainlist(query);
		request.setAttribute("list", list);
	}

}
