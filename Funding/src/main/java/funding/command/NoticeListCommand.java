package funding.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoNotice;


public class NoticeListCommand implements FCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		FDaoC dao = new FDaoC();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int countNotice = dao.countNotice();
		ArrayList<FDtoNotice> list = dao.notice_list(page);
		
		request.setAttribute("notice", list);
		request.setAttribute("countNotice", countNotice);
	}

}
