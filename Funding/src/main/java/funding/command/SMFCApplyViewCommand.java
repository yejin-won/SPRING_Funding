package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import funding.dao.FDaoS;

public class SMFCApplyViewCommand implements FCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String seller = (String)session.getAttribute("id");
		String fNum = request.getParameter("calculate_funding");
		
		FDaoS daoS = new FDaoS();
		daoS.sMFCapply(fNum,seller);
		System.out.println("seller: "+seller);
		System.out.println("fNum: "+fNum);
	}

}
