package ex;

import java.util.HashMap;
import java.util.Objects;

public class PatientInfo {
    private String name;
    private int age;
    private String gender;
    private String phone;
    private HashMap<String, String> department = new HashMap<>();  

    // 기본 생성자
    public PatientInfo() {}

    public PatientInfo(String name, int age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // 진료과와 진료 목적을 추가하는 메소드
    public void addDepartment(String dep, String purpose) {
        department.put(dep, purpose);
    }
    
    // 예약 정보를 저장하는 메소드
    public void makeReservation(String department, String purpose) {
        this.department.put(department, purpose);
        System.out.println(department + " 예약이 완료되었습니다.");
    }


    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public HashMap<String, String> getDepartment() {
		return department;
	}

	public void setDepartment(HashMap<String, String> department) {
		this.department = department;
	}

	@Override
    public int hashCode() {
        return Objects.hash(name, age, gender, phone, department);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PatientInfo other = (PatientInfo) obj;
        return Objects.equals(name, other.name)
                && age == other.age
                && Objects.equals(gender, other.gender)
                && Objects.equals(phone, other.phone)
                && Objects.equals(department, other.department);
    }

    
    @Override
    public String toString() {
        return "PatientInfo [name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", department=" + department + "]";
    }
}
