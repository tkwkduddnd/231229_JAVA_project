package problem;

public class Quiz {
    private String problem;
    private String Write;// 문제를 저장
    private String ox;

    public Quiz() {}

    public Quiz(String problem) {
        this.problem = problem;
    }
    
    
    public Quiz(String Problem, String Write) {
       this.problem = Problem;
       this.Write = Write;
    }


    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Quiz [Problem=" + problem + "]";
    }
}