// studentManager: tính điểm final; lấy status;  print transcript

abstract public class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
class Student extends Person{
    public Student(String id, String name){
        super(id,name);
    }
}
class TeachingAssistant extends Person {
    public TeachingAssistant(String id, String name) {
        super(id, name);
    }
}
class Course{
    private String courseId;
    private String courseName;
    private int credits;
    public Course(String courseId, String courseName, int credits){
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }
    public String getCourseId(){
        return this.courseId;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public int getCredits(){
        return this.credits;
    }
}
class GradeSheet{
    private double midtermScore;
    private double finalScore;
    private double assignmentScore;
    public GradeSheet(double midterm, double finalS, double assignment) {
        this.midtermScore = midterm;
        this.finalScore = finalS;
        this.assignmentScore = assignment;
    }
    public double calculateFinalGrade() {
        return assignmentScore * 0.2 + midtermScore * 0.3 + finalScore * 0.5;
    }
    public String getAcademicStatus() {
        double grade = calculateFinalGrade();
        if (grade >= 8.5) return "Giỏi";
        if (grade >= 7.0) return "Khá";
        if (grade >= 5.5) return "Trung bình";
        return "Yếu";
    }
    public double getMidtermScore(){
        return this.midtermScore;
    }
    public double getFinalScore(){
        return this.finalScore;
    }
    public double getAssignmentScore(){
        return this.assignmentScore;
    }
    public String getScoresInfo() {
        return "Điểm GK: " + midtermScore + " | Điểm CK: " + finalScore + " | Điểm BT: " + assignmentScore;
    }
}

class StudentManager {
    Student student;
    GradeSheet grade;
    Course course;

    public StudentManager(Student student, GradeSheet grade, Course course) {
        this.course = course;
        this.grade = grade;
        this.student = student;
    }

    public void printTranscript() {
        System.out.println("Sinh viên: " + student.name + " (" + student.id + ")");
        System.out.println("Môn học: " + course.getCourseName() + " (" + course.getCourseId() + ") - " + course.getCredits() + " tín chỉ");
        System.out.println(grade.getScoresInfo());
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                grade.calculateFinalGrade(), grade.getAcademicStatus());
    }
}