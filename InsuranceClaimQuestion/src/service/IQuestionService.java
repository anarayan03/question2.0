package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.ClaimBean;
import bean.QuestionBean;
import exception.QuestionException;

public interface IQuestionService
{
	boolean validateDetails(ClaimBean claimBean) throws QuestionException;

	ClaimBean getPolicy_Number(ClaimBean claimBean) throws SQLException, QuestionException, ClassNotFoundException, Exception;
	
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
}
