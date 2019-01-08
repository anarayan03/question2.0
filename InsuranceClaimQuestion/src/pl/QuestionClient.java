package pl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import bean.QuestionBean;
import exception.QuestionException;
import service.IQuestionService;
import service.QuestionServiceImpl;

public class QuestionClient {

	static Scanner scanner = new Scanner(System.in);
	static IQuestionService iQuestionService = null;
	static QuestionServiceImpl questionServiceImpl = null;
	static QuestionBean questionBean = new QuestionBean();

	public static void main(String[] args) throws Exception {
		int weightage = 0;
		String str = null;
		String claimNo = null;

		while (true) {
			// System.out.println("Enter the Claim Number");
			// claimBean.setClaim_Number(sc.nextInt());
			System.out.println("Enter claim Reason");
			questionBean.setClaim_Reason(scanner.next());
			System.out.println("Enter Accident Location");
			questionBean.setAccident_Location(scanner.next());
			System.out.println("Enter Accident City");
			questionBean.setAccident_City(scanner.next());
			System.out.println("Enter Accident State");
			questionBean.setAccident_State(scanner.next());
			System.out.println("Enter Accident Zip");
			questionBean.setAccident_Zip(scanner.nextLong());
			System.out.println("Choose the below optoin to select the claim type");
			int key = 0;
			loop: do {
				try {

					System.out.println("1.Road Accident Claims");
					System.out.println("2.Medical Negligence Claims");
					System.out.println("3.Trip Accident Claims");

					key = scanner.nextInt();
					switch (key) {
					case 1:
						str = "Road Accident Claims";
						questionBean.setClaim_Type(str);

						break;
					case 2:
						str = "Medical Negligence Claims";
						questionBean.setClaim_Type(str);

						break;
					case 3:
						str = "Trip Accident Claims";
						questionBean.setClaim_Type(str);

						break;
					default:

						System.out.println("Please enter from the above options again");
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println("try again...");
					scanner.nextLine();
					continue loop;

				}
			} while (key > 3);
			System.out.println("Enter Policy Number");
			questionBean.setPolicy_Number(scanner.nextInt());

			iQuestionService = new QuestionServiceImpl();
			try {
				boolean a = iQuestionService.validateDetails(questionBean);
				if (a == true) {
					questionBean = iQuestionService.getPolicy_Number(questionBean);
				}
				System.out.println("data inserted successfully");
			} catch (QuestionException e) {
				e.printStackTrace();
			}
			// }

			System.out.println("Enter Business Segment from Business Auto, Apartment, Restaurant, General Merchant");

			System.out.println("1.	Business Auto" + "\n" + "2.	Apartment" + "\n" + "3.	Restaurant" + "\n"
					+ "4.	General Merchant" + "\n");
			int ch1 = scanner.nextInt();

			switch (ch1) {
			case 1:

				str = "Business Auto";
				questionBean.setQuestion(str);
				break;

			case 2:

				str = "Apartment";
				questionBean.setQuestion(str);
				break;

			case 3:

				str = "Restaurant";
				questionBean.setQuestion(str);
				break;

			case 4:

				str = "General Merchant";
				questionBean.setQuestion(str);
				break;

			default:

				System.out.println("Wrong choice");
				break;
			}
			QuestionBean questionBean = null;

			questionBean = new QuestionBean();
			questionServiceImpl = new QuestionServiceImpl();
			List<QuestionBean> list = new ArrayList<>();
			list = questionServiceImpl.getQuestions(str);

			ListIterator<QuestionBean> iterator = list.listIterator();
			if (list.isEmpty()) {
				System.out.println("No questions....");
			} else {

				while (iterator.hasNext()) {
					QuestionBean questionBean1 = new QuestionBean();
					questionBean1 = iterator.next();
					System.out.println(questionBean1.getQuestion() + "?");
					System.out.println("1.	" + questionBean1.getAnswer1());
					System.out.println("2.	" + questionBean1.getAnswer2());
					System.out.println("3.	" + questionBean1.getAnswer3());
					int choice;
					System.out.println("Select your answer");
					choice = scanner.nextInt();
					switch (choice) {
					case 1:

						weightage = weightage + questionBean1.getAnswerWeightage1();
						System.out.println(weightage + "\n");

						break;

					case 2:

						weightage = weightage + questionBean1.getAnswerWeightage2();
						System.out.println(weightage + "\n");

						break;

					case 3:

						weightage = weightage + questionBean1.getAnswerWeightage3();
						System.out.println(weightage + "\n");

						break;

					default:

						System.out.println("wrong answer");
						iterator.previous();
						break;
					}
				}
				if (weightage >= 1600 && weightage <= 2600) {
					claimNo = "A";
					System.out.println(claimNo);
					claimNo += questionBean.getClaim_number();
				}

				else if (weightage > 2600 && weightage <= 3600) {
					claimNo = "B";
					System.out.println(claimNo);
					claimNo += questionBean.getClaim_number();
				} else if (weightage > 3600 && weightage <= 4600) {
					claimNo = "C";
					System.out.println(claimNo);
					claimNo += questionBean.getClaim_number();
				} else if (weightage > 4600 && weightage <= 5600) {
					claimNo = "D";
					System.out.println(claimNo);
					claimNo += questionBean.getClaim_number();
				} else if (weightage > 5600) {
					claimNo = "E";
					System.out.println(claimNo);
					claimNo += questionBean.getClaim_number();
				} else {
					claimNo = null;
				}

			}
		}
	}
}
