import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private ArrayList<String> schedule;
    private int enrolledStudents;

    public Course(String code, String title, String description, int capacity, ArrayList<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<String> getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void dropStudent() {
        enrolledStudents--;
    }
}

class Student {
    private int id;
    private String name;
    private ArrayList<String> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class CourseRegistrationSystem {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        initializeCourses();
        showCourseListing();

        // Simulate student registration
        Student student1 = new Student(101, "John Doe");
        student1.registerCourse("CSE101");
        student1.registerCourse("MATH201");

        Student student2 = new Student(102, "Alice Smith");
        student2.registerCourse("ENG101");

        students.add(student1);
        students.add(student2);

        displayRegisteredCourses(student1);
        displayRegisteredCourses(student2);

        // Simulate dropping a course
        student1.dropCourse("CSE101");
        displayRegisteredCourses(student1);
    }

    public static void initializeCourses() {
        ArrayList<String> cseSchedule = new ArrayList<>();
        cseSchedule.add("Mon 9-11");
        cseSchedule.add("Wed 9-11");
        courses.add(new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 30, cseSchedule));

        ArrayList<String> mathSchedule = new ArrayList<>();
        mathSchedule.add("Tue 10-12");
        mathSchedule.add("Thu 10-12");
        courses.add(new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 40, mathSchedule));

        ArrayList<String> engSchedule = new ArrayList<>();
        engSchedule.add("Mon 10-12");
        engSchedule.add("Wed 10-12");
        courses.add(new Course("ENG101", "English Composition", "Writing skills and composition", 25, engSchedule));
    }

    public static void showCourseListing() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.getCode() + " - " + course.getTitle() + " (" + course.getEnrolledStudents() + "/" + course.getCapacity() + ")");
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println();
        }
    }

    public static void displayRegisteredCourses(Student student) {
        System.out.println("Registered courses for " + student.getName() + ":");
        for (String courseCode : student.getRegisteredCourses()) {
            Course course = findCourse(courseCode);
            if (course != null) {
                System.out.println(course.getCode() + " - " + course.getTitle());
            }
        }
        System.out.println();
    }

    public static Course findCourse(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }
}
    
