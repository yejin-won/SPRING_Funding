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
//import funding.command.MainCommand;
import funding.command.MyOrderDetailCommand;
import funding.command.MyinformationModifyCommand;
import funding.command.MypageCommand;
import funding.command.NoticeDetailCommand;
import funding.command.NoticeListCommand;
import funding.command.NoticeSearchCommand;
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
import funding.command.SearchCommand;
import funding.command.SignupCommand;
import funding.command.SocialLoginCommand;
import funding.command.SystemQuestionCommand;
import funding.command.SystemQuestionDetailCommand;
import funding.command.SystemQuestionSearchCommand;
import funding.command.SystemQuestionlistCommand;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	//------------------------
	@Autowired
	private SqlSession sqlSession;
	
	
	FCommand command = null;
	private FCommand sLoginCommand = null;
	private FCommand slogoutCommand = null;
	private FCommand mainCommand = null;
	
	@Autowired
	public void auto(FCommand Slogin, FCommand Slogout, FCommand Main) {
		this.sLoginCommand = Slogin;
		this.slogoutCommand = Slogout;
		this.mainCommand = Main;
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
			System.out.println("login()");
			model.addAttribute("request", request);
			command = new LoginCommand();
			command.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/socialLogin")
		public String sociallogin(HttpServletRequest request, Model model) {
			System.out.println("sociallogin()");
			model.addAttribute("request", request);
			command = new SocialLoginCommand();
			command.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request, Model model) {
			System.out.println("logout()");
			model.addAttribute("request", request);
			command = new LogoutCommand();
			command.execute(sqlSession, model);
			
			return "main.do?sort=all";
		}
		
		@RequestMapping("/leave")
		public String leave(HttpServletRequest request, Model model) {
			System.out.println("leave()");
			model.addAttribute("request", request);
			command = new LeaveCommand();
			command.execute(sqlSession, model);
			
			return "main.do?sort=all";
		}

		@RequestMapping("/main")
		public String mainscreen(HttpServletRequest request, Model model) {
			//sSystem.out.println("mainscreen()");
			
			//model.addAttribute("request", request);
//			command = new MainCommand();
//			command.execute(sqlSession, model);
			//mainCommand.execute(sqlSession, model);
			
			return "main";
		}

		@RequestMapping("/signUp")
		public String signup(HttpServletRequest request, Model model) {
			System.out.println("signup()");
			
			model.addAttribute("request", request);
			command = new SignupCommand();
			command.execute(sqlSession, model);
		
			return "../../pages/login";
		}
		@RequestMapping("/findId_view")
		public String findidView(HttpServletRequest request, Model model) {
			System.out.println("findidView()");
		
			return "../../pages/findId_view";
		}
		@RequestMapping("/findId")
		public String findid(HttpServletRequest request, Model model) {
			System.out.println("findid()");
			
			model.addAttribute("request", request);
			command = new FindidCommand();	
			command.execute(sqlSession, model);
		
			return (String) request.getAttribute("viewpage");
		}
		@RequestMapping("/findPw_view")
		public String findpwView(HttpServletRequest request, Model model) {
			System.out.println("findpwView()");
			
		
			return "../../pages/findpw_view";
		}

		@RequestMapping("/findPw")
		public String findpw(HttpServletRequest request, Model model) {
			System.out.println("findpw()");
			
			model.addAttribute("request", request);
			command = new FindpwCommand();	
			command.execute(sqlSession, model);
		
			return (String) request.getAttribute("viewpage");
		}

		//CUSTOMER FUNCTIONS
		@RequestMapping("/funding_list_view")
		public String flistView(HttpServletRequest request, Model model) {
			System.out.println("flistView()");
			
			model.addAttribute("request", request);
			command = new FundingListViewCommand();	
			command.execute(sqlSession, model);
		
			return "../../pages/funding_list_view";
		}
		
		@RequestMapping("/fundingSearch")
		public String fsearch(HttpServletRequest request, Model model) {
			System.out.println("fsearch()");
			
			model.addAttribute("request", request);
			command = new SearchCommand();	
			command.execute(sqlSession, model);
		
			return "../../pages/funding_list_view";
		}

		@RequestMapping("/fundingContent_view")
		public String fcontentView(HttpServletRequest request, Model model) {
			System.out.println("fcontentView()");
			model.addAttribute("request", request);
			command = new FundingdetailCommand();	
			command.execute(sqlSession, model);
		
			return "../../pages/detail";
		}

		@RequestMapping("/fundingLike")
		public String flike(HttpServletRequest request, Model model) {
			System.out.println("flike()");
			model.addAttribute("request", request);
			command = new FundingLikeCommand();	
			command.execute(sqlSession, model);
		
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/fundingUnLike")
		public String funlike(HttpServletRequest request, Model model) {
			System.out.println("funlike()");
			model.addAttribute("request", request);
			command = new FundingUnlikeCommand();	
			command.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}
		
		@RequestMapping("/fundingOrder")
		public String forder(HttpServletRequest request, Model model) {
			System.out.println("forder()");
			model.addAttribute("request", request);
			command = new FundingPaymentCommand();	
			command.execute(sqlSession, model);
			
			return "fundingOrder";
		}
		
		@RequestMapping("/fundingQuestion")
		public String fquestion(HttpServletRequest request, Model model) {
			System.out.println("fquestion()");
			model.addAttribute("request", request);
			command = new FundingQuestionCommand();	
			command.execute(sqlSession, model);
			
			return (String) request.getAttribute("viewpage");
		}

		@RequestMapping("/systemQuestion_list")
		public String sysQL(HttpServletRequest request, Model model) {
			System.out.println("sysQL()");
			model.addAttribute("request", request);
			command = new SystemQuestionlistCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/systemquestion_list";
		}

		@RequestMapping("/systemQuestion_search")
		public String sysQS(HttpServletRequest request, Model model) {
			System.out.println("sysQS()");
			model.addAttribute("request", request);
			command = new SystemQuestionSearchCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/systemquestion_list";
		}

		@RequestMapping("/systemQuestion")
		public String sysQ(HttpServletRequest request, Model model) {
			System.out.println("sysQ()");
			model.addAttribute("request", request);
			command = new SystemQuestionCommand();	
			command.execute(sqlSession, model);
			
			return "systemQuestion_list";
		}

		@RequestMapping("/systemQuestion_detail")
		public String sysQD(HttpServletRequest request, Model model) {
			System.out.println("sysQD()");
			model.addAttribute("request", request);
			command = new SystemQuestionDetailCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/systemquestion_detail";
		}

		@RequestMapping("/notice_list")
		public String nL(HttpServletRequest request, Model model) {
			System.out.println("nL()");
			model.addAttribute("request", request);
			command = new NoticeListCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/notice";
		}

		@RequestMapping("/notice_search")
		public String nS(HttpServletRequest request, Model model) {
			System.out.println("nS()");
			model.addAttribute("request", request);
			command = new NoticeSearchCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/notice";
		}

		@RequestMapping("/notice_detail")
		public String nD(HttpServletRequest request, Model model) {
			System.out.println("nD()");
			model.addAttribute("request", request);
			command = new NoticeDetailCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/notice_detail";
		}

		@RequestMapping("/mypage")
		public String mypage(HttpServletRequest request, Model model) {
			System.out.println("mypage()");
			model.addAttribute("request", request);
			command = new MypageCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/mypage";
		}

		@RequestMapping("/myorder_detail")
		public String myorderD(HttpServletRequest request, Model model) {
			System.out.println("myorderD()");
			model.addAttribute("request", request);
			command = new MyOrderDetailCommand();	
			command.execute(sqlSession, model);
			
			return "../../pages/myorder_detail";
		}

		@RequestMapping("/myinformation_modify")
		public String myinfoM(HttpServletRequest request, Model model) {
			System.out.println("myinfoM()");
			model.addAttribute("request", request);
			command = new MyinformationModifyCommand();	
			command.execute(sqlSession, model);
			
			return "logout.do?change=pw";
		}
		//---------------------CUSTOMER END-----------------------------
		
		
		//----------------------SELLER START----------------------------
		//SELLER Sign In/Out & Log In
		@RequestMapping("/slogin")
		public String slogin(HttpServletRequest request, Model model) {
			
			System.out.println("slogin()");
			model.addAttribute("request", request);
//			command = new SLoginCommand();
//			command.execute(sqlSession, model);
			sLoginCommand.execute(sqlSession, model);
			
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
			
			return "main.do?sort=all";
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
			return "main.do?sort=all";
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
