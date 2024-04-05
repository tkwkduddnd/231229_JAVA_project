package ex;

public class RecommenDepartment {
    public String recommendDepartment(String purpose) {
        switch (purpose) {
            case "두통": 
            case "뇌졸중": 
            case "치매":
                return "신경과";  
            case "충치":
            case "사랑니": 
            case "이빨깨짐":
                return "치과";  
            case "하지정맥류":
            case "폐암":
            case "역류성 식도염":
                return "흉부외과";  
            case "허리통증":
            case "손가락 골절":
            case "머리 깨짐":
            	return "정형외과";  
            case "요실금":
            case "요로결석":
            case "성기능 장애":
            	return "비뇨기과";  
            default:
                return "";  // default에서 빈 문자열을 반환
        }
    }
}
