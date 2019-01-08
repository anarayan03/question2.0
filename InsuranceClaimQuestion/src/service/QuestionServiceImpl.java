package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.QuestionBean;
import dao.CQuestionDaoImpl;
import dao.IQuestionDao;
import exception.QuestionException;

public class QuestionServiceImpl implements IQuestionService {

	static QuestionBean questionBean = new QuestionBean();
	IQuestionDao iQuestionDao = null;

	@Override
	public List<QuestionBean> getQuestions(String businessSegment)
			throws ClassNotFoundException, IOException, SQLException {
		iQuestionDao = new CQuestionDaoImpl();
		List<QuestionBean> list = new ArrayList<>();
		list = iQuestionDao.getQuestions(businessSegment);

		return list;
	}

	@Override
	public boolean validateDetails(QuestionBean questionBean) throws QuestionException {
		List<String> list = new ArrayList<>();

		boolean result = true;

		// if (!isNumberValid(claimBean.getClaim_Number())) {
		//
		// list.add("Claim Number should be greater that 0");
		// }
		if (!isReasonValid(questionBean.getClaim_Reason())) {
			list.add("claim reason should be valid");
		}
		if (!isAccidentLocationValid(questionBean.getAccident_Location())) {
			list.add("Location should be valid without numerics");
		}
		if (!isAccidentCityValid(questionBean.getAccident_City())) {
			list.add("city should be valid without numerics");
		}
		if (!isAccidentStateValid(questionBean.getAccident_State())) {
			list.add("state should be valid without numerics");
		}
		if (!isAccidentZipValid(questionBean.getAccident_Zip())) {
			list.add("Enter valid ZIP Code");
		}
		// if (!isClaimTypeValid(claimBean.getClaim_Type())) {
		// list.add("enter valid claim type");
		// }
		if (!isPolicyNumberValid(questionBean.getPolicy_Number())) {
		list.add("policy number should be greater than 0");
		 }
		if (!list.isEmpty()) {

			System.out.println("Errors" + list);
			result = false;
		}

		return result;

	}

	private boolean isPolicyNumberValid(int policy_Number) {

		return policy_Number > 0;
	}

	/*private boolean isClaimTypeValid(String claim_Type) {
		String RegEx = "[a-z]{3,20}";
		Pattern pattern = Pattern.compile(RegEx);

		Matcher matcher = pattern.matcher(claim_Type);
		return matcher.matches();
	}*/

	private boolean isAccidentZipValid(long accident_Zip) {
		return accident_Zip > 0;
	}

	private boolean isAccidentStateValid(String accident_State) {
		String RegEx = "[a-z]{3,20}";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accident_State);
		return matcher.matches();
	}

	private boolean isAccidentCityValid(String accident_City) {
		String RegEx = "[a-z]{3,20}";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accident_City);
		return matcher.matches();
	}

	private boolean isAccidentLocationValid(String accident_Location) {
		String RegEx = "[a-z]{3,20}";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accident_Location);
		return matcher.matches();
	}

	private boolean isReasonValid(String claim_Reason) {
		String RegEx = "[a-z]{3,20}";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(claim_Reason);
		return matcher.matches();
	}

	/*private boolean isNumberValid(int claim_Number) {

		return claim_Number > 0;
	}*/

	@Override
	public QuestionBean getPolicy_Number(QuestionBean questionBean) throws ClassNotFoundException, Exception {
		iQuestionDao = new CQuestionDaoImpl();
		return iQuestionDao.getPolicy_Number(questionBean);
	}

}
