package problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PgManager {
    HashMap<String, String> problems = new HashMap<>(); // HashMap<String, String>으로 변경
    Map<String, HashMap<String, String>> subjects  = new HashMap<>();
    Map<String, String> users = new HashMap<>();
    String loggedInId = null;
    private static int idCounter = 1;
    private HashMap<String, Double> subjectPercentages = new HashMap<>();
    HashMap<String, ArrayList<String>> problemsBySubject = new HashMap<>();
    String loggedInUserType = null;
    HashMap<String, String> userAnswers = new HashMap<>();
    HashMap<String, String> problemAnswers = new HashMap<>();
    
    public void createProblems() {
        int totalProblems = 20;  

        for (String subject : subjectPercentages.keySet()) {
            int numProblems = (int) Math.round(totalProblems * subjectPercentages.get(subject));  // 해당 과목의 문제 수
            for (int i = 0; i < numProblems; i++) {
                // 문제를 출제하는 코드를 여기에 작성합니다.
                // 이 부분은 문제 출제 방식에 따라 다르게 구현해야 합니다.
            }
        }
    }

    public void WorkbookRegister(Scanner scan) {
    	if(loggedInUserType == null || !loggedInUserType.equals("admin")) {
    	    System.out.println("관리자의 권한이 없습니다.");
    	    return;
    	}
    	try {
            System.out.println("문장 단위로 ox문제를 기입해주세요 .");
            String ox = scan.nextLine();
            while (!ox.endsWith(".")) {
                System.out.println("문장의 끝에 '.'를 붙여주세요.");
                ox += " " + scan.nextLine();
            }
            
            System.out.println("문제를 등록한 과목 이름을 입력해주세요.");
            String subject = scan.nextLine();
            System.out.println("문제를 등록한 단원을 입력해주세요.");
            String chapter = "단원" + scan.nextLine();
            
            if(subjects.containsKey(subject) && subjects.get(subject).containsKey(chapter)) {
               String id = "Q" + idCounter++;
                this.problems.put(id, ox); // String 형태의 문제 직접 저장
                if (!problemsBySubject.containsKey(subject)) {
                    problemsBySubject.put(subject, new ArrayList<>());
                }
                problemsBySubject.get(subject).add(id);
                subjects.get(subject).put(chapter, id);
                System.out.println("문제가 등록되었습니다. 문제 ID: " + id);
            }
            else {
               System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\r\n"
                     + "████▌▄▌▄▐▐▌█████\r\n"
                     + "████▌▄▌▄▐▐▌▀████\r\n"
                     + "████████████████");
            }
            
        }
        catch (NumberFormatException e) {
           System.out.println("단원 번호는 숫자로 입력해주세요.");
        }
    }
   
   //ox문제 단원입력 메서드
   public void SubjectRegister(Scanner scan) {
	 //1.단원의 수 입력 2. 그 단원의 출제비율 입력
	      //단원은 등록되는 만큼 그 단원의 문제출제 비중을 입력 
	      //총 문제수에서 입력된 비중만큼 비율로 나누어서 출제
	   if(loggedInUserType == null || !loggedInUserType.equals("admin")) {
		    System.out.println("관리자의 권한이 없습니다.");
		    return;
		}   
	   try {
	      System.out.println("과목 이름을 입력해주세요.");
	       scan = new Scanner(System.in);
	      String subject = scan.nextLine();
	       
	       System.out.println("단원 시작 범위를 입력해주세요.");
	       scan = new Scanner(System.in);
	       int startChap = Integer.parseInt(scan.nextLine());
	       
	       System.out.println("단원 끝 범위를 입력해주세요.");
	       scan = new Scanner(System.in);
	       int endChap = Integer.parseInt(scan.nextLine());
	       // 과목에 해당하는 단원이 없으면 새로 생성
	       if(!subjects.containsKey(subject)) {
	          subjects.put(subject, new HashMap<String, String>());
	       }
	       // 단원에 문제 등록
	       HashMap<String, String> chapters = subjects.get(subject);
	       for(int i=startChap; i<=endChap; i++) {
	          chapters.put("단원"+i, null);
	       }
	       subjects.put(subject, chapters);
	       System.out.println(subject + " 과목의 " + startChap + " 단원부터 " + endChap +"단원까지 등록되었습니다.");

	      
	   }
	    catch (NumberFormatException e) {
	       System.out.println("단원 범위는 숫자로 입력해주세요.");
	    }

   }

   //ox문제 검색 메서드
   public void Search(Scanner scan) {
      //1. 입력된 문제 검색 및 출력
      //2. 풀이한 문제 검색 및 출력
      //3. 변형한 문제 검색 및 출력
	   String problemId = "";
       while (problemId.isEmpty()) {
           scan.nextLine();  // 버퍼에 남아있는 개행 문자를 처리
           System.out.println("검색하고자 하는 문제의 ID를 입력해주세요 ");
           problemId = scan.nextLine().trim();
           if (problemId.isEmpty()) {
               System.out.println("문제 ID를 입력하지 않으셨습니다. 다시 입력해주세요.");
           }
       }

       if(problems.containsKey(problemId)){
           System.out.println("문제 Id : "+problemId);
           System.out.println("문제 : "+problems.get(problemId)); 
           for(String sub : subjects.keySet()) {
               for(String chap : subjects.get(sub).keySet()) {
            	   String chapProblemId = subjects.get(sub).get(chap);
            	   // 단원에 등록된 문제 ID와 일치하는 경우
                   if(chapProblemId != null && chapProblemId.equals(problemId)) { 
                       System.out.println("과목 : "+sub+" / 단원 : "+chap);
                       return;
                   }
               }
           }
       } else {
           System.out.println("해당 Id의 문제를 찾을 수 없습니다.");
       }
   }
   
   
   public void SolvingPb(Scanner scan) {
	// 모든 문제 ID를 리스트에 저장
	   List<String> allProblemIds = new ArrayList<>(problems.keySet());
	    Collections.shuffle(allProblemIds);

	    int numProblems = Math.min(20, allProblemIds.size());
	    for(int i = 0; i < numProblems; i++) {
	        String problemId = allProblemIds.get(i);
	        String problem = problems.get(problemId);

	        System.out.println("문제 Id : "+problemId);
	        System.out.println("문제 : "+problem);
	        String answer = " ";
	        while (!(answer.equals("O") || answer.equals("X"))) {
	            System.out.println("답을 입력하세요: (O/X)");
	            answer = scan.nextLine().toUpperCase();
	            if (!(answer.equals("O") || answer.equals("X"))) {
	                System.out.println("답변은 'O' 또는 'X'로 입력해주세요.");
	            }
	        }

	        userAnswers.put(problemId, answer);
	    }
	    System.out.println("문제를 다 풀었습니다.");
	    }
	
   
   
   public void loadProblems() {
	   String fileName = "problems.txt";

	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] split = line.split(",");
	            String problemId = split[0];
	            String subject = split[1];
	            String problem = split[2];
	            String answer = split[3].trim(); // 앞뒤 공백 제거
	            problems.put(problemId, problem);
	            problemAnswers.put(problemId, answer);

	            ArrayList<String> subjectProblems = problemsBySubject.get(subject);
	            if (subjectProblems == null) {
	                subjectProblems = new ArrayList<>();
	                problemsBySubject.put(subject, subjectProblems);
	            }
	            subjectProblems.add(problemId);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}



   public void Resert(Scanner scan) {
	   int total = 0;
	    int correct = 0;

	    for (String problemId : userAnswers.keySet()) {
	        String correctAnswer = problemAnswers.get(problemId);
	        String userAnswer = userAnswers.get(problemId);

	        if (correctAnswer != null && correctAnswer.toUpperCase().equals(userAnswer+".")) {
	            correct++;
	        }
	        total++;
	    }
	    System.out.println(userAnswers);
	    System.out.println(problemAnswers);
	    System.out.println("총 문제 수: " + total);
	    System.out.println("정답 수: " + correct);

	}

  
   //ox문제 입력한것을 변형문제 생성 메서드
   public void WorkbookModify(Scanner scan) {
      
      //ox문제 유형 3가지
      //1.입력된 문제를 숫자를 지워서 빈칸화
      //2.입력된 문제를 숫자를 대체
      //3.텍스트를 입력 및 특정텍스트를 변환
      
   }

   public void signUp(Scanner scan) {
	   String role = "";
	   System.out.println("[회원가입] 아이디 입력 >");
	   String id = scan.nextLine();
	   
	   System.out.println("[회원가입] 비밀번호 입력 >");
	   String password = scan.nextLine();
	   
	   System.out.println("관리자 계정이면 'admin', 일반 사용자 계정이면 'user'를 입력해주세요.");
	   String usertype = scan.nextLine();
	   
	   if(usertype.equals("admin") || usertype.equals("user")){
		   users.put(id, password + ","+usertype);
		   System.out.println("┌───────────────────┐\r\n"
	               + "      회원가입 완료!\r\n"
	               + "└───────────────────┘\r\n"
	               + "");

	   }
	   else {
		   System.out.println("사용자 유형을 제대로 입력해주세요.");
	   }
	   if(usertype.equals("admin")) {
		   this.loggedInUserType = "admin";
	   }
	   else {
		   this.loggedInUserType = "user";
	   }
	   System.out.println("회원가입이 완료되었습니다.");
	   	
	   
   }
   
   public void signIn(Scanner scan) {
	   boolean loginSuccess = false;

	   while(!loginSuccess) {
	       System.out.println("[로그인] 아이디 입력 >");
	       String id = scan.nextLine();

	       System.out.println("[로그인] 비밀번호 입력 >");
	       String password = scan.nextLine();

	       if(users.containsKey(id)) {
	           String[] userInfo = users.get(id).split(",");
	           if(userInfo[0].equals(password)) {
	               loggedInId = id;
	               String userType = userInfo[1];
	               System.out.println("┌───────────────────┐\r\n"
	                             + "      로그인 성공!\r\n"
	                             + "└───────────────────┘\r\n"
	                             + ""); 
	               loginSuccess = true;
	           }
	           else {
	               System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\r\n"
	                       + "████▌▄▌▄▐▐▌█████\r\n"
	                       + "████▌▄▌▄▐▐▌▀████\r\n"
	                       + "████████████████");
	           }
	       }
	       else {
	           System.out.println("해당 Id가 존재하지 않습니다.");
	       }
	   }
   }
}

