package funding.HomeController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import funding.command.FCommand;
//ADMIN
import funding.command.ACAWListCommand;
import funding.command.ACApproveCommand;
import funding.command.ACListCommand;
import funding.command.ACRejectCommand;
import funding.command.AFADetailCommand;
import funding.command.AFAWListCommand;
import funding.command.AFApproveCommand;
import funding.command.AFListCommand;
import funding.command.AFRejectCommand;
import funding.command.ALoginCommand;
import funding.command.ALogoutCommand;
import funding.command.ANContentCommand;
import funding.command.ANCreateCommand;
import funding.command.ANListCommand;
import funding.command.ANModifyCommand;
import funding.command.ANRemoveCommand;
import funding.command.ASQDetailCommand;
import funding.command.ASQWListCommand;
import funding.command.ASQualifyCommand;
import funding.command.ASrejectCommand;
import funding.command.ASystemQAnswerInsertCommand;
import funding.command.ASystemQDetailCommand;
import funding.command.ASystemQuestionRemoveCommand;
//CUSTOMER
import funding.command.FindpwCommand;
//SELLER
import funding.command.SFAnswerCommand;
import funding.command.SFOApplyCommand;
//import funding.command.SLoginCommand;
//import funding.command.SLogoutCommand;
import funding.command.SMFCApplyCommand;
import funding.command.SMFCApplyDetailCommand;
import funding.command.SMFCApplyViewCommand;
import funding.command.SMFDetailCommand;
import funding.command.SMFDetailDeleteCommand;
import funding.command.SMyinformationModifyCommand;
import funding.command.SMypageCommand;
import funding.command.SQApplyCommand;
import funding.command.SSignUpCommand;
import funding.command.SystemQuestionlistCommand;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	//------------------------
	@Autowired
	private SqlSession sqlSession;
	
	
	FCommand command = null;
	private FCommand sloginCommand = null;
	private FCommand slogoutCommand = null;
	private FCommand mainCommand = null;
	private FCommand loginCommand = null;
	private FCommand logoutCommand = null;
	private FCommand socialLoginCommand =null;
	private FCommand leaveCommand =null;
	private FCommand signUpCommand =null;
	private FCommand findIdCommand =null;
	private FCommand findPwCommand =null;
	private FCommand funding_list_viewCommand =null;
	private FCommand fundingSearchCommand =null;
	private FCommand fundingContent_viewCommand =null;
	private FCommand fundingLikeCommand =null;
	private FCommand fundingUnLikeCommand =null;
	private FCommand fundingPaymentCommand =null;
	private FCommand fundingQuestionCommand =null;
	private FCommand systemQuestion_listCommand =null;
	private FCommand systemQuestion_searchCommand =null;
	private FCommand systemQuestionCommand =null;
	private FCommand systemQuestion_detailCommand =null;
	private FCommand notice_listCommand =null;
	private FCommand notice_searchCommand =null;
	private FCommand notice_detailCommand =null;
	private FCommand mypageCommand =null;
	private FCommand myorder_detailCommand =null;
	private FCommand myinformation_modifyCommand =null;

	
	@Autowired
	public void auto(FCommand slogin, FCommand slogout, FCommand main, FCommand login, FCommand logout,
			FCommand socialLogin, FCommand leave, FCommand signUp,
			FCommand findId, FCommand findPw,
			FCommand funding_list_view, FCommand fundingSearch,
			FCommand fundingContent_view, FCommand fundingLike,
			FCommand fundingUnLike,FCommand fundingOrder,
			FCommand fundingQuestion,FCommand systemQuestion_list,
			FCommand systemQuestion_search,
			FCommand systemQuestion, FCommand systemQuestion_detail,
			FCommand notice_list,FCommand notice_search, FCommand notice_detail,
			FCommand mypage,FCommand myorder_detail, FCommand myinformation_modify
			) {
		this.sloginCommand = slogin;
		this.slogoutCommand = slogout;
		this.mainCommand = main;
		this.loginCommand = login;
		this.logoutCommand = logout;
		this.socialLoginCommand = socialLogin;
		this.leaveCommand = leave;
		this.signUpCommand = signUp;
		this.findIdCommand = findId;
		this.findPwCommand = findPw;
		this.funding_list_viewCommand = funding_list_view;
		this.fundingSearchCommand =fundingSearch;
		this.fundingContent_viewCommand = fundingContent_view;
		this.fundingLikeCommand =fundingLike;
		this.fundingUnLikeCommand =fundingUnLike;
		this.fundingPaymentCommand =fundingOrder;
		this.fundingQuestionCommand =fundingQuestion;
		this.systemQuestion_listCommand =systemQuestion_list;
		this.systemQuestion_searchCommand =systemQuestion_search;
		this.systemQuestionCommand =systemQuestion;
		this.systemQuestion_detailCommand =systemQuestion_detail;
		this.notice_listCommand =notice_list;
		this.notice_searchCommand =notice_search;
		this.notice_detailCommand =notice_detail;
		this.mypageCommand =mypage;
		this.myorder_detailCommand =myorder_detail;
		this.myinformation_modifyCommand =myinformation_modify;
		
	}
	
	String viewpage = null;
	//-------------------------
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "hello";
	}
	
	
		//---------------------CUSTOMER START-----------------------------
		//CUSTOMER Sign In/Out & Log In
		@RequestMapping("/login")
		public String login(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			loginCommand.execute(sqlSession, model);
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/socialLogin")
		public String sociallogin(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			socialLoginCommand.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			logoutCommand.execute(sqlSession, model);
			return "redirect:/main";
		}
		
		@RequestMapping("/leave")
		public String leave(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			leaveCommand.execute(sqlSession, model);
			
			return "redirect:/main";
		}

		@RequestMapping("/main")
		public String mainscreen(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			mainCommand.execute(sqlSession, model);
			return "main";
		}

		@RequestMapping("/signUp")
		public String signup(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			signUpCommand.execute(sqlSession, model);
		
			return "../../pages/login";
		}
		@RequestMapping("/findId_view")
		public String findidView(HttpServletRequest request, Model model) {
			return "../../pages/findId_view";
		}
		
		@RequestMapping("/findId")
		public String findid(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			findIdCommand.execute(sqlSession, model);
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/findPw_view")
		public String findpwView(HttpServletRequest request, Model model) {
			return "../../pages/findpw_view";
		}

		@RequestMapping("/findPw")
		public String findpw(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			command = new FindpwCommand();	
			findPwCommand.execute(sqlSession, model);
		
			return (String) request.getAttribute("viewpage");
		}

		//CUSTOMER FUNCTIONS
		@RequestMapping("/funding_list_view")
		public String flistView(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			funding_list_viewCommand.execute(sqlSession, model);
			return "../../pages/funding_list_view";
		}
		
		@RequestMapping("/fundingSearch")
		public String fsearch(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			fundingSearchCommand.execute(sqlSession, model);
		
			return "../../pages/funding_list_view";
		}

		@RequestMapping("/fundingContent_view")
		public String fcontentView(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			fundingContent_viewCommand.execute(sqlSession, model);
		
			return "../../pages/detail";
		}

		@RequestMapping("/fundingLike")
		public String flike(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			fundingLikeCommand.execute(sqlSession, model);
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/fundingUnLike")
		public String funlike(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			fundingUnLikeCommand.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/fundingOrder")
		public String forder(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			fundingPaymentCommand.execute(sqlSession, model);
			
			return "fundingOrder";
		}
		
		@RequestMapping("/fundingQuestion")
		public String fquestion(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			fundingQuestionCommand.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}

		@RequestMapping("/systemQuestion_list")
		public String sysQL(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			systemQuestion_listCommand.execute(sqlSession, model);
			
			return "../../pages/systemquestion_list";
		}

		@RequestMapping("/systemQuestion_search")
		public String sysQS(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			systemQuestion_searchCommand.execute(sqlSession, model);
			
			return "../../pages/systemquestion_list";
		}

		@RequestMapping("/systemQuestion_view")
		public String sysQV(HttpServletRequest request, Model model) {
			return "../../pages/systemquestion_create";
		}
		
		@RequestMapping("/systemQuestion")
		public String sysQ(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			systemQuestionCommand.execute(sqlSession, model);
			
			return "redirect:/systemQuestion_list";
		}

		@RequestMapping("/systemQuestion_detail")
		public String sysQD(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			systemQuestion_detailCommand.execute(sqlSession, model);
			
			return "../../pages/systemquestion_detail";
		}

		@RequestMapping("/notice_list")
		public String nL(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			notice_listCommand.execute(sqlSession, model);
			
			return "../../pages/notice";
		}

		@RequestMapping("/notice_search")
		public String nS(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			notice_searchCommand.execute(sqlSession, model);
			
			return "../../pages/notice";
		}

		@RequestMapping("/notice_detail")
		public String nD(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			notice_detailCommand.execute(sqlSession, model);
			
			return "../../pages/notice_detail";
		}

		@RequestMapping("/mypage")
		public String mypage(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			mypageCommand.execute(sqlSession, model);
			
			return "../../pages/mypage";
		}

		@RequestMapping("/myorder_detail")
		public String myorderD(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			myorder_detailCommand.execute(sqlSession, model);
			
			return "../../pages/myorder_detail";
		}

		@RequestMapping("/myinformation_modify")
		public String myinfoM(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			myinformation_modifyCommand.execute(sqlSession, model);
			
			return "logout?change=pw";
		}
		//---------------------CUSTOMER END-----------------------------
		
		
		//----------------------SELLER START----------------------------
		//SELLER Sign In/Out & Log In
		@RequestMapping("/slogin")
		public String slogin(HttpServletRequest request, Model model) {
			System.out.println("login");
			model.addAttribute("request", request);
			sloginCommand.execute(sqlSession, model);
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/slogout")
		public String slogout(HttpServletRequest request, Model model) {
			System.out.println("slogout()");
			model.addAttribute("request", request);
//			command = new SLogoutCommand();
//			command.execute(sqlSession, model);
			slogoutCommand.execute(sqlSession, model);
			
			return "../../pages/slogin";
		}
		
		@RequestMapping("/ssignup")
		public String ssignup(HttpServletRequest request, Model model) {
			System.out.println("ssignup()");
			model.addAttribute("request", request);
			command = new SSignUpCommand();
			command.execute(sqlSession, model);
			
			return "../../pages/slogin";
		}
		
		//SELLER FUNCTIONS
		@RequestMapping("/sFOApply")
		public String sfoapply(HttpServletRequest request ,Model model) {
			System.out.println("sfoapply()");
			model.addAttribute("request", request);
			command = new SFOApplyCommand();
			command.execute(sqlSession, model);
			
			return "/main";
		}
		
		@RequestMapping("/sQApply_view")
		public String sQApllyview(HttpServletRequest request, Model model) {
			System.out.println("sqapplyview()");
			model.addAttribute("request", request);
			command = new SQApplyCommand();
			command.execute(sqlSession, model);
			
			return "sQApply_view";
		}
		
		@RequestMapping("/sQApply")
		public String sqapply(Model model) {
			return "/main";
		}
		
		
		@RequestMapping("/sMypage")
		public String smypage(HttpServletRequest request, Model model) {
			System.out.println("smypage()");
			model.addAttribute("request", request);
			command = new SMypageCommand();
			command.execute(sqlSession, model);
			return "../../pages/Smypage";
		}
		
		@RequestMapping("/sMFDetail")
		public String smfdetail(HttpServletRequest request, Model model) {
			System.out.println("smfdetail()");
			model.addAttribute("request", request);
			command = new SMFDetailCommand();
			command.execute(sqlSession, model);
			return "../../pages/sMFDetail";
		}

		@RequestMapping("/sMFModify")
		public String smfmodify(HttpServletRequest request, Model model) {
			System.out.println("smfmodify()");
			model.addAttribute("request", request);
			command = new SMFDetailCommand();
			command.execute(sqlSession, model);
			
			return "sMFManage";
		}

		@RequestMapping("/sMFDDelete")
		public String smfddelete(HttpServletRequest request, Model model) {
			System.out.println("sfddelete()");
			model.addAttribute("request", request);
			command = new SMFDetailDeleteCommand();
			command.execute(sqlSession, model);
			
			return "sMFDDelete";
		}
		
		@RequestMapping("/sMFCApply")
		public String smfcapply(HttpServletRequest request, Model model) {
			System.out.println("smfcapply()");
			model.addAttribute("request", request);
			command = new SMFCApplyDetailCommand();
			command.execute(sqlSession, model);
			
			return "sMFCApply";
		}

		@RequestMapping("/sMFCApply_view")
		public String smfcapplyView(HttpServletRequest request, Model model) {
			System.out.println("smfcapplyView()");
			model.addAttribute("request", request);
			command = new SMFCApplyViewCommand();
			command.execute(sqlSession, model);
			
			return "sMFCApply_view";
		}
		
		@RequestMapping("/sFADetail")
		public String sfadetail(HttpServletRequest request, Model model) {
			System.out.println("sfadetail()");
			model.addAttribute("request", request);
			command = new SMFCApplyViewCommand();
			command.execute(sqlSession, model);
			
			return "sFAnswer";
		}
		
		@RequestMapping("/sFAnswer")
		public String sfanswer(HttpServletRequest request, Model model) {
			System.out.println("sfanswer()");
			model.addAttribute("request", request);
			command = new SFAnswerCommand();
			command.execute(sqlSession, model);
			
			return (String)request.getAttribute("viewpage");
		}
		
		@RequestMapping("/smyinformation_modify")
		public String smyinfoM(HttpServletRequest request, Model model) {
			System.out.println("smyinfoM()");
			model.addAttribute("request", request);
			command = new SMyinformationModifyCommand();
			command.execute(sqlSession, model);
			
			return "sMypage";
		}
		
		@RequestMapping("/movemycal")
		public String movemycal(HttpServletRequest request, Model model) {
			System.out.println("movemycal()");
			model.addAttribute("request", request);
			command = new SMFCApplyCommand();
			command.execute(sqlSession, model);
			
			return "../../pages/mycal";
		}
		//---------------------SELLER END-----------------------------
		
		//---------------------ADMIN START----------------------------
		//ADMIN Sign In/Out & Log In
		@RequestMapping("/aLogin")
		public String aLogin(HttpServletRequest request, Model model) {
			System.out.println("aLogin()");
			model.addAttribute("request", request);
			command = new ALoginCommand();
			command.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewPage");
		}
		
		@RequestMapping("/aLogout")
		public String aLogout(HttpServletRequest request, Model model) {
			System.out.println("aLogout()");
			model.addAttribute("request", request);
			command = new ALogoutCommand();
			command.execute(sqlSession, model);
			
			return "aLogin";
		}
		
		//ADMIN FUNCTIONS
		@RequestMapping("/aCList")
		public String aCList(HttpServletRequest request, Model model) {
			System.out.println("aCList()");
			model.addAttribute("request", request);
			command = new ACListCommand();
			command.execute(sqlSession, model);
			
			return "aCList";
		}
		
		@RequestMapping("/aCAWList")
		public String aCAWList(HttpServletRequest request, Model model) {
			System.out.println("aCAWList()");
			model.addAttribute("request", request);
			command = new ACAWListCommand();
			command.execute(sqlSession, model);
			
			return "aCAWList";
		}
		
		@RequestMapping("/aCApprove")
		public String aCApprove(HttpServletRequest request, Model model) {
			System.out.println("aCApprove()");
			model.addAttribute("request", request);
			command = new ACApproveCommand();
			command.execute(sqlSession, model);
			
			return "aCAWList";
		}
		
		@RequestMapping("/aCReject")
		public String aCReject(HttpServletRequest request, Model model) {
			System.out.println("aCReject()");
			model.addAttribute("request", request);
			command = new ACRejectCommand();
			command.execute(sqlSession, model);
			
			return "aCAWList";
		}
			
		@RequestMapping("/aSQWList")
		public String aSQWList(HttpServletRequest request, Model model) {
			System.out.println("aSQWList()");
			model.addAttribute("request", request);
			command = new ASQWListCommand();
			command.execute(sqlSession, model);
			
			return "aSQWList";
		}
		
		@RequestMapping("/aSQDetail")
		public String aSQDetail(HttpServletRequest request, Model model) {
			System.out.println("aSQDetail()");
			model.addAttribute("request", request);
			command = new ASQDetailCommand();
			command.execute(sqlSession, model);
			
			return "aSQDetail";
		}
		
		@RequestMapping("/aSQualify")
		public String aSQualify(HttpServletRequest request, Model model) {
			System.out.println("aSQualify()");
			model.addAttribute("request", request);
			command = new ASQualifyCommand();
			command.execute(sqlSession, model);
			
			return "aSQWList";
		}
		
		@RequestMapping("/aSreject")
		public String aSreject(HttpServletRequest request, Model model) {
			System.out.println("aSreject()");
			model.addAttribute("request", request);
			command = new ASrejectCommand();
			command.execute(sqlSession, model);
			
			return "aSQWList";
		}
			
		@RequestMapping("/aFAWList")
		public String aFAWList(HttpServletRequest request, Model model) {
			System.out.println("aFAWList()");
			model.addAttribute("request", request);
			command = new AFAWListCommand();
			command.execute(sqlSession, model);
			
			return "aFAWList";
		}	
		
		@RequestMapping("/aFADetail")
		public String aFADetail(HttpServletRequest request, Model model) {
			System.out.println("aFADetailt()");
			model.addAttribute("request", request);
			command = new AFADetailCommand();
			command.execute(sqlSession, model);
			
			return "aFADetail";
		}	
			
		@RequestMapping("/aFApprove")
		public String aFApprove(HttpServletRequest request, Model model) {
			System.out.println("aFApprove()");
			model.addAttribute("request", request);
			command = new AFApproveCommand();
			command.execute(sqlSession, model);
			
			return "aFAWList";
		}		
		
		@RequestMapping("/aFreject")
		public String aFreject(HttpServletRequest request, Model model) {
			System.out.println("aFreject()");
			model.addAttribute("request", request);
			command = new AFRejectCommand();
			command.execute(sqlSession, model);
			
			return "aFAWList";
		}		
		
		@RequestMapping("/aSAList")
		public String aSAList(HttpServletRequest request, Model model) {
			System.out.println("aSAList()");
			model.addAttribute("request", request);
			command = new SystemQuestionlistCommand();
			command.execute(sqlSession, model);
			
			return "aSAList";
		}		
		
		@RequestMapping("/aSAListDetail")
		public String aSAListDetail(HttpServletRequest request, Model model) {
			System.out.println("aSAListDetail()");
			
			return "aSQAnswer";
		}		
		
		@RequestMapping("/aFList")
		public String aFList(HttpServletRequest request, Model model) {
			System.out.println("aFList()");
			model.addAttribute("request", request);
			command = new AFListCommand();
			command.execute(sqlSession, model);
			
			return "aFList";
		}
		
		@RequestMapping("/anotice_list")
		public String anotice_list(HttpServletRequest request, Model model) {
			System.out.println("anotice_list()");
			model.addAttribute("request", request);
			command = new AFListCommand();
			command.execute(sqlSession, model);
			
			return "aNoticeList";
		}	
		
		@RequestMapping("/anoticeCreate_view")
		public String anoticeCreate_view(HttpServletRequest request, Model model) {
			System.out.println("anoticeCreate_view()");
			
			return "aNoticeCreate";
		}	
			
		@RequestMapping("/anoticeCreate")
		public String anoticeCreate(HttpServletRequest request, Model model) {
			System.out.println("anoticeCreate()");
			model.addAttribute("request", request);
			command = new ANCreateCommand();
			command.execute(sqlSession, model);
			
			return "anotice_list";
		}	
		
		@RequestMapping("/anoticeContent_view")
		public String anoticeContent_view(HttpServletRequest request, Model model) {
			System.out.println("anoticeContent_view()");
			model.addAttribute("request", request);
			command = new ANContentCommand();
			command.execute(sqlSession, model);
			
			return "aNContentView";
		}

		@RequestMapping("/anoticeModify")
		public String anoticeModify(HttpServletRequest request, Model model) {
			System.out.println("anoticeModify()");
			model.addAttribute("request", request);
			command = new ANModifyCommand();
			command.execute(sqlSession, model);
			
			return "anotice_list";
		}
		
		@RequestMapping("/anoticeRemove")
		public String anoticeRemove(HttpServletRequest request, Model model) {
			System.out.println("anoticeRemove()");
			model.addAttribute("request", request);
			command = new ANRemoveCommand();
			command.execute(sqlSession, model);
			
			return "anotice_list";
		}
			
		@RequestMapping("/asystemqDetail")
		public String asystemqDetail(HttpServletRequest request, Model model) {
			System.out.println("asystemqDetail()");
			model.addAttribute("request", request);
			command = new ASystemQDetailCommand();
			command.execute(sqlSession, model);
			
			return "aSQAnswer";
		}
		
		@RequestMapping("/systemQuestionRemove")
		public String systemQuestionRemove(HttpServletRequest request, Model model) {
			System.out.println("systemQuestionRemove()");
			model.addAttribute("request", request);
			command = new ASystemQuestionRemoveCommand();
			command.execute(sqlSession, model);
			
			return "asystemqDetail";
		}	
		
		@RequestMapping("/aSystemQAnswerInsert")
		public String aSystemQAnswerInsert(HttpServletRequest request, Model model) {
			System.out.println("aSystemQAnswerInsert()");
			model.addAttribute("request", request);
			command = new ASystemQAnswerInsertCommand();
			command.execute(sqlSession, model);
			
			return "asystemqDetail";
		}	
		//---------------------ADMIN END----------------------------
	
}
