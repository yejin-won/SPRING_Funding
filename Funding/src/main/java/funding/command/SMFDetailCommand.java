package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoS;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingContent;
import funding.dto.FDtoFundingOption;

public class SMFDetailCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		// TODO Auto-generated method stub	
		String funding_num =request.getParameter("funding_num");
		FDaoS daoS = new FDaoS();
		FDtoFunding dto = daoS.selectDetail(funding_num);
		request.setAttribute("Mfunding", dto);
		
		ArrayList<FDtoFundingOption> options = daoS.selectOption(funding_num);
		//System.out.println(options.get(0).getOption_name());
		request.setAttribute("Mfunding_options", options);
		
		
		FDtoFundingContent dto1 = daoS.selectDetail1(funding_num);
		request.setAttribute("Mfunding1", dto1);
		
	}

}
