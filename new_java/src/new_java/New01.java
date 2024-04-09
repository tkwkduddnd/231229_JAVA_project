package new_java;

public class New01 {

   public static void main(String[] args) {
      String Number = "881122-2234567";
      String birthdate = Number.substring(0, 6);

      int genderNum = Integer.parseInt(Number.substring(7, 8));
      String gender = (genderNum == 1 || genderNum == 3) ? "남자" : "여자";

      
      System.out.println("생년월일: " + birthdate + ", 성별: " + gender);
   }
}