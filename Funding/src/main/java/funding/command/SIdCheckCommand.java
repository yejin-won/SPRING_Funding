package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoS;

public class SIdCheckCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		FDaoS daoS = sqlSession.getMapper(FDaoS.class);
		
//		String seller = daoS.checkDuplicateId(id);
//		String customer = daoS.
	}

}
