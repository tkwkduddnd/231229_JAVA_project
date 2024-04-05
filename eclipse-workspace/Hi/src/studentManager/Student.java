package studentManager;

public class Student {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;
    private Subject[] subjects = new Subject[10];
    private int count = 0;

    public Student(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public void addSubject(Subject subject) {
        if(count == subjects.length) {
            Subject[] temp = new Subject[subjects.length];
            for(int i = 0; i < subjects.length; i++) {
                temp[i] = subjects[i];
            }
            subjects = temp;
        }
        subjects[count] = subject;
        count++;
    }

    public void deleteSubject(Subject subject) {
        for(int i=0; i<count; i++) {
            if(subjects[i].equals(subject)) {
                for(int j = i; j < count-1; j++) {
                    subjects[j] = subjects[j+1];
                }
                subjects[count] = null;
                count--;
                return;
            }
        }
    }

    public void printSubjects() {
        System.out.println(name + " 학생이 수강하는 과목");
        for(int i=0; i<count; i++) {
            System.out.println(subjects[i].toString());
        }
    }
    public void modifyGrade(String subjectName, int newGrade) {
        if (subjects.contains(subjectName)) {
            grades.put(subjectName, newGrade);
            System.out.println(subjectName + " 과목의 성적이 " + newGrade + "로 수정되었습니다.");
        } else {
            System.out.println(subjectName + " 과목이 수강 과목에 없습니다.");
        }
    }

    public void printTotalAndAverage() {
        int total = 0;
        for (Integer grade : grades.values()) {
            total += grade;
        }
        double average = total / (double) grades.size();

        System.out.println(name + " 학생의 성적 합계: " + total);
        System.out.println(name + " 학생의 성적 평균: " + average);
    }
}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "학번: " + id +", 이름: " + name + ", 나이: " + age +", 전화번호: " + phone +", 주소: " + address;
    }
}
