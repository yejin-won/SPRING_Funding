package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoS;
import funding.dto.FDtoFunding;

public class SMFCApplyCommand2 implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String funding_num = request.getParameter("funding_num");
		//String funding_seller = request.getParameter(funding_num);
		
		FDaoS daoSeller = sqlSession.getMapper(FDaoS.class);
		FDtoFunding dto = daoSeller.calfunding(funding_num);
		//String result = daoSeller.calinf(funding_num);
		request.setAttribute("funding", dto);
		//request.setAttribute("cal", result);
	
	}

}
