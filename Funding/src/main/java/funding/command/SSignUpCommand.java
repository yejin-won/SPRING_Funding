package funding.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import funding.dao.FDaoC;
import funding.dao.FDaoS;

public class SSignUpCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String seller_id = request.getParameter("seller_id");	
		String seller_pw = request.getParameter("seller_pw1");
		String seller_number =request.getParameter("seller_number1") + "-" + request.getParameter("seller_number2")
								+"-" + request.getParameter("seller_number3");
		String seller_profile = request.getParameter("seller_profile");
		String seller_name = request.getParameter("seller_name");
		String seller_phone = request.getParameter("seller_phone1") + "-" + request.getParameter("seller_phone2")
								+"-" + request.getParameter("seller_phone3");
		String seller_person_name = request.getParameter("seller_person_name");
		String seller_person_phone = request.getParameter("seller_person_phone1")+"-"+request.getParameter("seller_person_phone2")
								+"-"+request.getParameter("seller_person_phone3");
		
		String address_seller = request.getParameter("seller_id");
		String address_state = request.getParameter("address1");
		String address_city = request.getParameter("address2");
		String address_line = request.getParameter("address3");
		
		FDaoS daoS = new FDaoS();
		daoS.ssignUp(seller_id, seller_pw, seller_number, seller_profile, seller_name, seller_phone, 
				seller_person_name, seller_person_phone);
		daoS.address(address_seller, address_state, address_city, address_line);
		
		FDaoC daoC = new FDaoC();
		daoC.signUp(seller_id, seller_pw, seller_name, seller_phone, null, null);
		
		
	}

}
