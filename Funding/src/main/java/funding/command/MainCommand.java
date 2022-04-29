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
		
		System.out.println("main here");
		if(request.getParameter("sort")==null) sort = "all";
		switch(sort) {
		case(""):
			query = "where funding_state = '진행'";
			break;
		case("all"):
			query = "where funding_state = '진행'";
		break;
		case("hits"):
			query = "where funding_state = '진행' order by funding_hits desc";
			break;
		case("achievement"):
			query = "where funding_state = '진행' order by achievement desc";
		break;
		case("closeAt"):
			query = "where funding_state = '진행' order by funding_closeAt";
		break;
		case("end"):
			query = "where funding_state != '진행'";
		break;
		}
		
		ArrayList<FDtoFunding> list = dao.mainlist(query);
		request.setAttribute("list", list);
	}

}
