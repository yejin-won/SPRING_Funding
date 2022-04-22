package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;

public class SearchCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String search = request.getParameter("funding_search");
		FDaoC dao = new FDaoC();
		ArrayList<FDtoFunding> list = dao.fundingsearch(search);
		request.setAttribute("funding", list);
	}

}
