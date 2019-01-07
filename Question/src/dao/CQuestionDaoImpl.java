package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.QuestionBean;
import util.DbConnection;

public class CQuestionDaoImpl implements IQuestionDao
{

	static QuestionBean questionBean = new QuestionBean();
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
			Iterator<QuestionBean> iterator = list.iterator();
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
	public QuestionBean getPolicy_Number(QuestionBean insuranceClaimBean) throws Exception
	{
		Connection connection=null;
		PreparedStatement statement=null;
	
		
		try {
			 connection = DbConnection.getConnection();
			 statement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
			 
			 statement.setString(1, questionBean.getClaim_Reason());
			 statement.setString(2, questionBean.getAccident_Location());
			 statement.setString(3, questionBean.getAccident_City());
			 statement.setString(4, questionBean.getAccident_State());
			 statement.setLong(5, questionBean.getAccident_Zip());
			 statement.setString(6, questionBean.getClaim_Type());
			 statement.setInt(7, questionBean.getPolicy_Number());
			 
			 statement.executeUpdate();
			
		} catch (IOException e) {
			throw new Exception(" sorry no details found");
		}
		return questionBean ;		
	
	}

}
