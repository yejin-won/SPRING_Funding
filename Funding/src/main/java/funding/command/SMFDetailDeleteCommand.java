package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoS;

public class SMFDetailDeleteCommand implements FCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
				
		// TODO Auto-generated method stub
		String funding_num =request.getParameter("funding_num");
		FDaoS daoS = new FDaoS();
		
		System.out.println(funding_num);
		daoS.deleteSelectDetail(funding_num);
	}

}
