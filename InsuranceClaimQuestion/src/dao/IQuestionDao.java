package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.ClaimBean;
import bean.QuestionBean;

public interface IQuestionDao 
{
	ClaimBean getPolicy_Number(ClaimBean claimBean) throws ClassNotFoundException, SQLException, Exception;
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
}
