package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import funding.dao.FDaoC;

public class SignupCommand implements FCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model)  {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("pw").trim();
		String name = request.getParameter("name").trim();
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2").trim()+
				"-"+request.getParameter("phone3").trim();
		String addrees1 = request.getParameter("address1");
		String addrees2 = request.getParameter("address2");
		String addrees3 = request.getParameter("address3");
		String pw_q = request.getParameter("pw_q");
		String pw_a = request.getParameter("pw_a").trim();
		
		FDaoC dao = sqlSession.getMapper(FDaoC.class);
		dao.signUp(id, pw, name, phone, pw_q, pw_a);
		dao.addAddress(id, addrees1, addrees2, addrees3);
	}

}
