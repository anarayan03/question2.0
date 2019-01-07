package bean;

public class QuestionBean
{
	
	private String questionId;
	private String businessSegment;
	private int questionNo;
	private String question;
	private String answer1;
	private int answerWeightage1;
	private String answer2;
	private int answerWeightage2;
	private String answer3;
	private int answerWeightage3;
	
	private String claim_number;
	private String claim_Reason;
	private String accident_Location;
	private String accident_City;
	private String accident_State;
	private long accident_Zip;
	private String claim_Type;

	private int policy_Number;
	
	public String getClaim_Reason() {
		return claim_Reason;
	}
	public void setClaim_Reason(String claim_Reason) {
		this.claim_Reason = claim_Reason;
	}
	public String getAccident_Location() {
		return accident_Location;
	}
	public void setAccident_Location(String accident_Location) {
		this.accident_Location = accident_Location;
	}
	public String getAccident_City() {
		return accident_City;
	}
	public void setAccident_City(String accident_City) {
		this.accident_City = accident_City;
	}
	public String getAccident_State() {
		return accident_State;
	}
	public void setAccident_State(String accident_State) {
		this.accident_State = accident_State;
	}
	public long getAccident_Zip() {
		return accident_Zip;
	}
	public void setAccident_Zip(long accident_Zip) {
		this.accident_Zip = accident_Zip;
	}
	public String getClaim_Type() {
		return claim_Type;
	}
	public void setClaim_Type(String claim_Type) {
		this.claim_Type = claim_Type;
	}
	public int getPolicy_Number() {
		return policy_Number;
	}
	public void setPolicy_Number(int policy_Number) {
		this.policy_Number = policy_Number;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getBusinessSegment() {
		return businessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public int getAnswerWeightage1() {
		return answerWeightage1;
	}
	public void setAnswerWeightage1(int answerWeightage1) {
		this.answerWeightage1 = answerWeightage1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public int getAnswerWeightage2() {
		return answerWeightage2;
	}
	public void setAnswerWeightage2(int answerWeightage2) {
		this.answerWeightage2 = answerWeightage2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public int getAnswerWeightage3() {
		return answerWeightage3;
	}
	public void setAnswerWeightage3(int answerWeightage3) {
		this.answerWeightage3 = answerWeightage3;
	}
	
	
	
	public String getClaim_number() {
		return claim_number;
	}
	public void setClaim_number(String claim_number) {
		this.claim_number = claim_number;
	}
	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", businessSegment=" + businessSegment + ", questionNo="
				+ questionNo + ", question=" + question + ", answer1=" + answer1 + ", answerWeightage1="
				+ answerWeightage1 + ", answer2=" + answer2 + ", answerWeightage2=" + answerWeightage2 + ", answer3="
				+ answer3 + ", answerWeightage3=" + answerWeightage3 + ", claim_number=" + claim_number
				+ ", claim_Reason=" + claim_Reason + ", accident_Location=" + accident_Location + ", accident_City="
				+ accident_City + ", accident_State=" + accident_State + ", accident_Zip=" + accident_Zip
				+ ", claim_Type=" + claim_Type + ", policy_Number=" + policy_Number + "]";
	}
	
	
	
}
