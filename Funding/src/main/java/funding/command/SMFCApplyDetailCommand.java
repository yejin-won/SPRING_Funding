package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import funding.dao.FDaoS;
import funding.dto.FDtoCalculate;

public class SMFCApplyDetailCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		HttpSession session = request.getSession();
		String seller = (String) session.getAttribute("id");
		String fNum = request.getParameter("calculate_funding");
		
		FDaoS daoS = new FDaoS();
		
		FDtoCalculate dtos = daoS.list(fNum, seller);
		request.setAttribute("list", dtos);
		request.setAttribute("fNum", fNum);

	}

}
