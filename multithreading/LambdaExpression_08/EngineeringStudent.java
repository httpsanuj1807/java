public class EngineeringStudent{
    public static void main(String[] args) {

        StudentInterface engStu = (name) -> name + " is a engineering student.";

        String bio = engStu.getBio("Ram");
        System.out.println(bio);

    }

}
