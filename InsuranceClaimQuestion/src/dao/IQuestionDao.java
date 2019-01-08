package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.QuestionBean;

public interface IQuestionDao 
{
	QuestionBean getPolicy_Number(QuestionBean insuranceClaimBean) throws ClassNotFoundException, SQLException, Exception;
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
}
