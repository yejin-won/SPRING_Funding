package funding.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import funding.command.ACAWListCommand;
//import funding.command.ACApproveCommand;
//import funding.command.ACListCommand;
//import funding.command.ACRejectCommand;
//import funding.command.AFADetailCommand;
//import funding.command.AFAWListCommand;
//import funding.command.AFApproveCommand;
//import funding.command.AFListCommand;
//import funding.command.AFRejectCommand;
//import funding.command.ALoginCommand;
//import funding.command.ALogoutCommand;
//import funding.command.ANContentCommand;
//import funding.command.ANCreateCommand;
//import funding.command.ANListCommand;
//import funding.command.ANModifyCommand;
//import funding.command.ANRemoveCommand;
//import funding.command.ASQDetailCommand;
//import funding.command.ASQWListCommand;
//import funding.command.ASQualifyCommand;
//import funding.command.ASrejectCommand;
//import funding.command.ASystemQAnswerInsertCommand;
//import funding.command.ASystemQDetailCommand;
//import funding.command.ASystemQuestionRemoveCommand;
import funding.command.FCommand;
import funding.command.FindidCommand;
import funding.command.FindpwCommand;
import funding.command.FundingLikeCommand;
import funding.command.FundingListViewCommand;
import funding.command.FundingPaymentCommand;
import funding.command.FundingQuestionCommand;
import funding.command.FundingUnlikeCommand;
import funding.command.FundingdetailCommand;
import funding.command.LeaveCommand;
import funding.command.LoginCommand;
import funding.command.LogoutCommand;
import funding.command.MainCommand;
import funding.command.MyOrderDetailCommand;
import funding.command.MyinformationModifyCommand;
import funding.command.MypageCommand;
import funding.command.NoticeDetailCommand;
import funding.command.NoticeListCommand;
//import funding.command.SFADetailCommand;
import funding.command.SFAnswerCommand;
import funding.command.NoticeSearchCommand;
import funding.command.SFOApplyCommand;
import funding.command.SLoginCommand;
import funding.command.SLogoutCommand;
import funding.command.SMFCApplyCommand;
import funding.command.SMFCApplyDetailCommand;
import funding.command.SMFCApplyViewCommand;
import funding.command.SMFDetailCommand;
import funding.command.SMFDetailDeleteCommand;
//import funding.command.SMFDetailModifyCommand;
//import funding.command.SMFManageCommand;
import funding.command.SMyinformationModifyCommand;
import funding.command.SMypageCommand;
import funding.command.SQApplyCommand;
import funding.command.SSignUpCommand;
import funding.command.SearchCommand;
import funding.command.SignupCommand;
import funding.command.SocialLoginCommand;
import funding.command.SystemQuestionCommand;
import funding.command.SystemQuestionDetailCommand;
import funding.command.SystemQuestionSearchCommand;
import funding.command.SystemQuestionlistCommand;

@Controller
public class Fcontroller{

	private SqlSession sqlSession;
	FCommand command = null;
	String viewpage = null;
	
	//CUSTOMER Sign In/Out & Log In
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("login()");
		model.addAttribute("request", request);
		command = new LoginCommand();
		command.execute(model);
		
		return (String) request.getAttribute("viewpage");
	}
	
	@RequestMapping("/socialLogin.do")
	public String sociallogin(HttpServletRequest request, Model model) {
		System.out.println("sociallogin()");
		model.addAttribute("request", request);
		command = new SocialLoginCommand();
		command.execute(model);
		
		return (String) request.getAttribute("viewpage");
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request, Model model) {
		System.out.println("logout()");
		model.addAttribute("request", request);
		command = new LogoutCommand();
		command.execute(model);
		
		return "main.do?sort=all";
	}
	
	@RequestMapping("/leave.do")
	public String leave(HttpServletRequest request, Model model) {
		System.out.println("leave()");
		model.addAttribute("request", request);
		command = new LeaveCommand();
		command.execute(model);
		
		return "main.do?sort=all";
	}

	@RequestMapping("/main.do")
	public String mainscreen(HttpServletRequest request, Model model) {
		System.out.println("mainscreen()");
		
		model.addAttribute("request", request);
		command = new MainCommand();
		command.execute(model);
	
		return "main";
	}

	@RequestMapping("/signUp.do")
	public String signup(HttpServletRequest request, Model model) {
		System.out.println("signup()");
		
		model.addAttribute("request", request);
		command = new SignupCommand();
		command.execute(model);
	
		return "../../pages/login";
	}
	@RequestMapping("/findId_view.do")
	public String findidView(HttpServletRequest request, Model model) {
		System.out.println("findidView()");
	
		return "../../pages/findId_view";
	}
	@RequestMapping("/findId.do")
	public String findid(HttpServletRequest request, Model model) {
		System.out.println("findid()");
		
		model.addAttribute("request", request);
		command = new FindidCommand();	
		command.execute(model);
	
		return (String) request.getAttribute("viewpage");
	}
	@RequestMapping("/findPw_view.do")
	public String findpwView(HttpServletRequest request, Model model) {
		System.out.println("findpwView()");
		
	
		return "../../pages/findpw_view";
	}

	@RequestMapping("/findPw.do")
	public String findpw(HttpServletRequest request, Model model) {
		System.out.println("findpw()");
		
		model.addAttribute("request", request);
		command = new FindpwCommand();	
		command.execute(model);
	
		return (String) request.getAttribute("viewpage");
	}

	//CUSTOMER Function
	@RequestMapping("/funding_list_view.do")
	public String flistView(HttpServletRequest request, Model model) {
		System.out.println("flistView()");
		
		model.addAttribute("request", request);
		command = new FundingListViewCommand();	
		command.execute(model);
	
		return "../../pages/funding_list_view";
	}
	
	@RequestMapping("/fundingSearch.do")
	public String fsearch(HttpServletRequest request, Model model) {
		System.out.println("fsearch()");
		
		model.addAttribute("request", request);
		command = new SearchCommand();	
		command.execute(model);
	
		return "../../pages/funding_list_view";
	}

	@RequestMapping("/fundingContent_view.do")
	public String fcontentView(HttpServletRequest request, Model model) {
		System.out.println("fcontentView()");
		model.addAttribute("request", request);
		command = new FundingdetailCommand();	
		command.execute(model);
	
		return "../../pages/detail";
	}

	@RequestMapping("/fundingLike.do")
	public String flike(HttpServletRequest request, Model model) {
		System.out.println("flike()");
		model.addAttribute("request", request);
		command = new FundingLikeCommand();	
		command.execute(model);
	
		return (String) request.getAttribute("viewpage");
	}
	
	@RequestMapping("/fundingUnLike.do")
	public String funlike(HttpServletRequest request, Model model) {
		System.out.println("funlike()");
		model.addAttribute("request", request);
		command = new FundingUnlikeCommand();	
		command.execute(model);
		
		return (String) request.getAttribute("viewpage");
	}
	
	@RequestMapping("/fundingOrder.do")
	public String forder(HttpServletRequest request, Model model) {
		System.out.println("forder()");
		model.addAttribute("request", request);
		command = new FundingPaymentCommand();	
		command.execute(model);
		
		return "fundingOrder";
	}
	
	@RequestMapping("/fundingQuestion.do")
	public String fquestion(HttpServletRequest request, Model model) {
		System.out.println("fquestion()");
		model.addAttribute("request", request);
		command = new FundingQuestionCommand();	
		command.execute(model);
		
		return (String) request.getAttribute("viewpage");
	}

	@RequestMapping("/systemQuestion_list.do")
	public String sysQL(HttpServletRequest request, Model model) {
		System.out.println("sysQL()");
		model.addAttribute("request", request);
		command = new SystemQuestionlistCommand();	
		command.execute(model);
		
		return "../../pages/systemquestion_list";
	}

	@RequestMapping("/systemQuestion_search.do")
	public String sysQS(HttpServletRequest request, Model model) {
		System.out.println("sysQS()");
		model.addAttribute("request", request);
		command = new SystemQuestionSearchCommand();	
		command.execute(model);
		
		return "../../pages/systemquestion_list";
	}

	@RequestMapping("/systemQuestion.do")
	public String sysQ(HttpServletRequest request, Model model) {
		System.out.println("sysQ()");
		model.addAttribute("request", request);
		command = new SystemQuestionCommand();	
		command.execute(model);
		
		return "systemQuestion_list";
	}

	@RequestMapping("/systemQuestion_detail.do")
	public String sysQD(HttpServletRequest request, Model model) {
		System.out.println("sysQD()");
		model.addAttribute("request", request);
		command = new SystemQuestionDetailCommand();	
		command.execute(model);
		
		return "../../pages/systemquestion_detail";
	}

	@RequestMapping("/notice_list.do")
	public String nL(HttpServletRequest request, Model model) {
		System.out.println("nL()");
		model.addAttribute("request", request);
		command = new NoticeListCommand();	
		command.execute(model);
		
		return "../../pages/notice";
	}

	@RequestMapping("/notice_search.do")
	public String nS(HttpServletRequest request, Model model) {
		System.out.println("nS()");
		model.addAttribute("request", request);
		command = new NoticeSearchCommand();	
		command.execute(model);
		
		return "../../pages/notice";
	}

	@RequestMapping("/notice_detail.do")
	public String nD(HttpServletRequest request, Model model) {
		System.out.println("nD()");
		model.addAttribute("request", request);
		command = new NoticeDetailCommand();	
		command.execute(model);
		
		return "../../pages/notice_detail";
	}

	@RequestMapping("/mypage.do")
	public String mypage(HttpServletRequest request, Model model) {
		System.out.println("mypage()");
		model.addAttribute("request", request);
		command = new MypageCommand();	
		command.execute(model);
		
		return "../../pages/mypage";
	}

	@RequestMapping("/myorder_detail.do")
	public String myorderD(HttpServletRequest request, Model model) {
		System.out.println("myorderD()");
		model.addAttribute("request", request);
		command = new MyOrderDetailCommand();	
		command.execute(model);
		
		return "../../pages/myorder_detail";
	}

	@RequestMapping("/myinformation_modify.do")
	public String myinfoM(HttpServletRequest request, Model model) {
		System.out.println("myinfoM()");
		model.addAttribute("request", request);
		command = new MyinformationModifyCommand();	
		command.execute(model);
		
		return "logout.do?change=pw";
	}
	
	//--------------------------------------------------------------
	//SELLER Sign In/Out & Log In
	@RequestMapping("/slogin.do")
	public String slogin(HttpServletRequest request, Model model) {
		
		System.out.println("slogin()");
		model.addAttribute("request", request);
		command = new SLoginCommand();
		command.execute(model);
		
		return (String) request.getAttribute("viewpage");
	}
	
	@RequestMapping("/slogout.do")
	public String slogout(HttpServletRequest request, Model model) {
		System.out.println("slogout()");
		model.addAttribute("request", request);
		command = new SLogoutCommand();
		command.execute(model);
		
		return "../../pages/slogin";
	}
	
	@RequestMapping("/ssignup.do")
	public String ssignup(HttpServletRequest request, Model model) {
		System.out.println("ssignup()");
		model.addAttribute("request", request);
		command = new SSignUpCommand();
		command.execute(model);
		
		return "../../pages/slogin";
	}
	
	//SELLER Function
	@RequestMapping("/sFOApply")
	public String sfoapply(HttpServletRequest request ,Model model) {
		System.out.println("sfoapply()");
		model.addAttribute("request", request);
		command = new SFOApplyCommand();
		command.execute(model);
		
		return "main.do?sort=all";
	}
	
	@RequestMapping("/sQApply_view.do")
	public String sQApllyview(HttpServletRequest request, Model model) {
		System.out.println("sqapplyview()");
		model.addAttribute("request", request);
		command = new SQApplyCommand();
		command.execute(model);
		
		return "sQApply_view";
	}
	
	@RequestMapping("/sQApply.do")
	public String sqapply(Model model) {
		return "main.do?sort=all";
	}
	
	
	@RequestMapping("/sMypage.do")
	public String smypage(HttpServletRequest request, Model model) {
		System.out.println("smypage()");
		model.addAttribute("request", request);
		command = new SMypageCommand();
		command.execute(model);
		return "../../pages/Smypage";
	}
	
	@RequestMapping("/sMFDetail.do")
	public String smfdetail(HttpServletRequest request, Model model) {
		System.out.println("smfdetail()");
		model.addAttribute("request", request);
		command = new SMFDetailCommand();
		command.execute(model);
		return "../../pages/sMFDetail";
	}

	@RequestMapping("/sMFModify.do")
	public String smfmodify(HttpServletRequest request, Model model) {
		System.out.println("smfmodify()");
		model.addAttribute("request", request);
		command = new SMFDetailCommand();
		command.execute(model);
		
		return "sMFManage";
	}

	@RequestMapping("/sMFDDelete.do")
	public String smfddelete(HttpServletRequest request, Model model) {
		System.out.println("sfddelete()");
		model.addAttribute("request", request);
		command = new SMFDetailDeleteCommand();
		command.execute(model);
		
		return "sMFDDelete";
	}
	
	@RequestMapping("/sMFCApply.do")
	public String smfcapply(HttpServletRequest request, Model model) {
		System.out.println("smfcapply()");
		model.addAttribute("request", request);
		command = new SMFCApplyDetailCommand();
		command.execute(model);
		
		return "sMFCApply";
	}

	@RequestMapping("/sMFCApply_view.do")
	public String smfcapplyView(HttpServletRequest request, Model model) {
		System.out.println("smfcapplyView()");
		model.addAttribute("request", request);
		command = new SMFCApplyViewCommand();
		command.execute(model);
		
		return "sMFCApply_view";
	}
	
	@RequestMapping("/sFADetail.do")
	public String sfadetail(HttpServletRequest request, Model model) {
		System.out.println("sfadetail()");
		model.addAttribute("request", request);
		command = new SMFCApplyViewCommand();
		command.execute(model);
		
		return "sFAnswer";
	}
	
	@RequestMapping("/sFAnswer.do")
	public String sfanswer(HttpServletRequest request, Model model) {
		System.out.println("sfanswer()");
		model.addAttribute("request", request);
		command = new SFAnswerCommand();
		command.execute(model);
		
		return (String)request.getAttribute("viewpage");
	}
	
	@RequestMapping("/smyinformation_modify.do")
	public String smyinfoM(HttpServletRequest request, Model model) {
		System.out.println("smyinfoM()");
		model.addAttribute("request", request);
		command = new SMyinformationModifyCommand();
		command.execute(model);
		
		return "sMypage";
	}
	
	@RequestMapping("/movemycal.do")
	public String movemycal(HttpServletRequest request, Model model) {
		System.out.println("movemycal()");
		model.addAttribute("request", request);
		command = new SMFCApplyCommand();
		command.execute(model);
		
		return "../../pages/mycal";
	}




		// admin용 switch
//		switch (path) {
//		case ("/aLogin.do"):
//			command = new ALoginCommand();
//			command.execute(request, response);
//			viewpage = (String) request.getAttribute("viewPage");
//			break;
//		case ("/aLogout.do"):
//			command = new ALogoutCommand();
//			command.execute(request, response);
//			viewpage = "aLogin.jsp";
//			break;
//		case ("/aCList.do"):
//			command = new ACListCommand();
//			command.execute(request, response);
//			viewpage = "aCList.jsp";
//			break;
//		case ("/aCAWList.do"):
//			command = new ACAWListCommand();
//			command.execute(request, response);
//			viewpage = "aCAWList.jsp";
//			break;
////		case("/aCADetail.do"):
////			viewpage="";
////			break;
//		case ("/aCApprove.do"):
//			command = new ACApproveCommand();
//			command.execute(request, response);
//			viewpage = "aCAWList.do";
//			break;
//		case ("/aCReject.do"):
//			command = new ACRejectCommand();
//			command.execute(request, response);
//			viewpage = "aCAWList.do";
//			break;
//		case ("/aSQWList.do"):
//			command = new ASQWListCommand();
//			command.execute(request, response);
//			viewpage = "aSQWList.jsp";
//			break;
//		case ("/aSQDetail.do"):
//			command = new ASQDetailCommand();
//			command.execute(request, response);
//			viewpage = "aSQDetail.jsp";
//			break;
//		case ("/aSQualify.do"):
//			command = new ASQualifyCommand();
//			command.execute(request, response);
//			viewpage = "aSQWList.do";
//			break;
//		case ("/aSreject.do"):
//			command = new ASrejectCommand();
//			command.execute(request, response);
//			viewpage = "aSQWList.do";
//			break;
//		case ("/aFAWList.do"):
//			command = new AFAWListCommand();
//			command.execute(request, response);
//			viewpage = "aFAWList.jsp";
//			break;
//		case ("/aFADetail.do"):
//			command = new AFADetailCommand();
//			command.execute(request, response);
//			viewpage = "aFADetail.jsp";
//			break;
//		case ("/aFApprove.do"):
//			command = new AFApproveCommand();
//			command.execute(request, response);
//			viewpage = "aFAWList.do";
//			break;
//		case ("/aFreject.do"):
//			command = new AFRejectCommand();
//			command.execute(request, response);
//			viewpage = "aFAWList.do";
//			break;
//		case ("/aSAList.do"):
//			command = new SystemQuestionlistCommand();
//			command.execute(request, response);
//			viewpage = "aSAList.jsp";
//			break;
//		case ("/aSAListDetail.do"):
//			viewpage = "aSQAnswer.jsp";
//			break;
////		case("/aSACreate.do"):
////			viewpage="";
////			break;
//		case ("/aFList.do"):
//			command = new AFListCommand();
//			command.execute(request, response);
//			viewpage = "aFList.jsp";
//			break;
////		case("/aFDetail.do"):
////			viewpage="";
////			break;
////		case("/aFstateChange.do"):
////			viewpage="";
////			break;
//		case ("/anotice_list.do"):
//			command = new ANListCommand();
//			command.execute(request, response);
//			viewpage = "aNoticeList.jsp";
//			break;
//		case ("/anoticeCreate_view.do"):
//			viewpage = "aNoticeCreate.jsp";
//			break;
//		case ("/anoticeCreate.do"):
//			command = new ANCreateCommand();
//			command.execute(request, response);
//			viewpage = "anotice_list.do";
//			break;
//		case ("/anoticeContent_view.do"):
//			command = new ANContentCommand();
//			command.execute(request, response);
//			viewpage = "aNContentView.jsp";
//			break;
//		case ("/anoticeModify.do"):
//			command = new ANModifyCommand();
//			command.execute(request, response);
//			viewpage = "anotice_list.do";
//			break;
//		case ("/anoticeRemove.do"):
//			command = new ANRemoveCommand();
//			command.execute(request, response);
//			viewpage = "anotice_list.do";
//			break;
//		case ("/asystemqDetail.do"):
//			command = new ASystemQDetailCommand();
//			command.execute(request, response);
//			viewpage = "aSQAnswer.jsp";
//			break;
//
//		case ("/systemQuestionRemove.do"):
//			command = new ASystemQuestionRemoveCommand();
//			command.execute(request, response);
//			viewpage = "asystemqDetail.do";
//			break;
//		case ("/aSystemQAnswerInsert.do"):
//			command = new ASystemQAnswerInsertCommand();
//			command.execute(request, response);
//			viewpage = "asystemqDetail.do";
//			break;
//		}// admin.

		

		}
