package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dto.FDtoNotice;

public class NoticeDetailCommand implements FCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String notice_num = request.getParameter("notice_num");
		FDaoC dao = new FDaoC();
		FDtoNotice dto = dao.notice_detail(notice_num);
		
		request.setAttribute("notice", dto);
	}

}
