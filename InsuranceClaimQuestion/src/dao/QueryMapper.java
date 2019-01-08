package dao;

public interface QueryMapper
{
	public static String EXECUTE_QUERY = "Select * from question_table where  BUSINESS_SEGMENT=?";
	public static String INSERT_QUERY = "insert into claim values(claimNo.nextval,?,?,?,?,?,?,?)";
}
