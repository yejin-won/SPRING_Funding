package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;
import funding.dto.FDtoOrder;

public class MyOrderDetailCommand implements FCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String funding_num = request.getParameter("funding_num");
		FDaoC dao = new FDaoC();
		FDtoFunding dto = dao.myorder_funding(funding_num);
		ArrayList<FDtoOrder> list = dao.myorder_ordering(funding_num, id);
		
		request.setAttribute("funding", dto);
		request.setAttribute("ordering", list);
	}

}
