package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.QuestionBean;
import exception.QuestionException;

public interface IQuestionService
{
	boolean validateDetails(QuestionBean questionBean) throws QuestionException;

	QuestionBean getPolicy_Number(QuestionBean questionBean) throws SQLException, QuestionException, ClassNotFoundException, Exception;
	
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
}
