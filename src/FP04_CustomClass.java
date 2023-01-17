import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04_CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Frameword", 98, 20000), new Course("Spring Boot", "Frameword", 95, 18000), new Course("API", "Frameword", 97, 22000), new Course("Microservice", "Microservices", 96, 25000), new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000), new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 21000), new Course("Kubernetes", "Cloud", 91, 20000));

        Predicate<Course> coursePredicate = course -> course.getReviewScore() > 95;
        System.out.println(courses.stream().anyMatch(coursePredicate));

        Comparator comparingByNoOfStudent = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingByNoOfStudent.reversed()).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews));

        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews).limit(5).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndNoOfReviews).skip(3).collect(Collectors.toList()));

        courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList());
        courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList());

        System.out.println(courses.stream().max(comparingByNoOfStudentAndNoOfReviews));
        System.out.println(courses.stream().min(comparingByNoOfStudentAndNoOfReviews).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).findFirst());
        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).findAny());

        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).mapToInt(Course::getNoOfStudents).sum());
        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).mapToInt(Course::getNoOfStudents).average());
        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).mapToInt(Course::getNoOfStudents).count());
        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).mapToInt(Course::getNoOfStudents).max());
        System.out.println(courses.stream().filter(course -> course.getReviewScore() > 95).mapToInt(Course::getNoOfStudents).min());

        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));

    }
}

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + " : " + noOfStudents + " : " + reviewScore;
    }
}