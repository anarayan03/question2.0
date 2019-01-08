package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import bean.ClaimBean;
import bean.QuestionBean;
import util.DbConnection;

public class CQuestionDaoImpl implements IQuestionDao
{

	static QuestionBean questionBean = new QuestionBean();
	static ClaimBean claimBean = new ClaimBean();
	@Override
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException
	{

		Connection connection = DbConnection.getConnection();
		PreparedStatement preparedStatement=null;
		
		ResultSet resultSet=null;
		
		try
		{
			preparedStatement = connection.prepareStatement(QueryMapper.EXECUTE_QUERY);
			preparedStatement.setString(1, businessSegment);
			resultSet = preparedStatement.executeQuery();
			List<QuestionBean> list = new ArrayList<>();
			//Iterator<QuestionBean> iterator = list.iterator();
			while(resultSet.next())
			{
				
				questionBean.setQuestionId(resultSet.getString(1));
				questionBean.setBusinessSegment(resultSet.getString(2));
				questionBean.setQuestionNo(resultSet.getInt(3));
				questionBean.setQuestion(resultSet.getString(4));
				questionBean.setAnswer1(resultSet.getString(5));
				questionBean.setAnswerWeightage1(resultSet.getInt(6));
				questionBean.setAnswer2(resultSet.getString(7));
				questionBean.setAnswerWeightage2(resultSet.getInt(8));
				questionBean.setAnswer3(resultSet.getString(9));
				questionBean.setAnswerWeightage3(resultSet.getInt(10));
								
				list.add(questionBean);
			}
			
			return list;
		}catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public ClaimBean getPolicy_Number(ClaimBean claimBean) throws Exception
	{
		Connection connection=null;
		PreparedStatement statement=null;
	
		
		try {
			 connection = DbConnection.getConnection();
			 statement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
			 
			 statement.setString(1, claimBean.getClaimReason());
			 statement.setString(2, claimBean.getAccidentLocationStreet());
			 statement.setString(3, claimBean.getAccidentCity());
			 statement.setString(4, claimBean.getAccidentState());
			 statement.setLong(5, claimBean.getAccidentZip());
			 statement.setString(6, claimBean.getClaimType());
			 statement.setLong(7, claimBean.getPolicyNumber());
			 
			 statement.executeUpdate();
			
		} catch (IOException e) {
			throw new Exception(" sorry no details found");
		}
		return claimBean ;		
	
	}

}
