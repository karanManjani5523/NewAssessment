package Coursemanagement;

	import java.util.ArrayList;
	import java.util.Scanner;

	class Course {
	    private int courseId;
	    private String courseName;
	    private double courseFees;
	    private String courseDuration;
	    private String courseDetail;

	    public Course(int courseId, String courseName, double courseFees, String courseDuration, String courseDetail) {
	        this.courseId = courseId;
	        this.courseName = courseName;
	        this.courseFees = courseFees;
	        this.courseDuration = courseDuration;
	        this.courseDetail = courseDetail;
	    }

	    public int getCourseId() {
	        return courseId;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public double getCourseFees() {
	        return courseFees;
	    }

	    public String getCourseDuration() {
	        return courseDuration;
	    }

	    public String getCourseDetail() {
	        return courseDetail;
	    }

	    public void setCourseName(String courseName) {
	        this.courseName = courseName;
	    }

	    public void setCourseFees(double courseFees) {
	        this.courseFees = courseFees;
	    }

	    public void setCourseDuration(String courseDuration) {
	        this.courseDuration = courseDuration;
	    }

	    public void setCourseDetail(String courseDetail) {
	        this.courseDetail = courseDetail;
	    }

	    @Override
	    public String toString() {
	        return "Course ID: " + courseId + "\nCourse Name: " + courseName + "\nCourse Fees: " + courseFees + "\nCourse Duration: " + courseDuration + "\nCourse Detail: " + courseDetail + "\n";
	    }
	}

	public class CourseManagementSystem {
	    private static ArrayList<Course> courses = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        while (true) {
	            // Display main menu
	            System.out.println("Course Management System");
	            System.out.println("1. Add Course");
	            System.out.println("2. View Course");
	            System.out.println("3. Search Course");
	            System.out.println("4. Edit Course");
	            System.out.println("5. Delete Course");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addCourse();
	                    break;
	                case 2:
	                    viewCourses();
	                    break;
	                case 3:
	                    searchCourse();
	                    break;
	                case 4:
	                    editCourse();
	                    break;
	                case 5:
	                    deleteCourse();
	                    break;
	                case 6:
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	        }
	    }

	    private static void addCourse() {
	        System.out.print("Course ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        System.out.print("Course Name: ");
	        String name = scanner.nextLine();

	        System.out.print("Course Fees: ");
	        double fees = scanner.nextDouble();
	        scanner.nextLine(); // Consume newline

	        System.out.print("Course Duration: ");
	        String duration = scanner.nextLine();

	        System.out.print("Course Detail: ");
	        String detail = scanner.nextLine();

	        // Create new course and add to list
	        Course course = new Course(id, name, fees, duration, detail);
	        courses.add(course);

	        System.out.println("Course added successfully!");
	    }

	    private static void viewCourses() {
	        // Display all courses
	        if (courses.isEmpty()) {
	            System.out.println("No courses available.");
	        } else {
	            for (Course course : courses) {
	                System.out.println(course);
	            }
	        }
	    }

	    private static void searchCourse() {
	        System.out.print("Enter Course ID to search: ");
	        int id = scanner.nextInt();

	        for (Course course : courses) {
	            if (course.getCourseId() == id) {
	                System.out.println(course);
	                return;
	            }
	        }
	        System.out.println("Course not found!");
	    }

	    private static void editCourse() {
	        System.out.print("Enter Course ID for edit: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        for (Course course : courses) {
	            if (course.getCourseId() == id) {
	                System.out.print("Course Name: ");
	                String name = scanner.nextLine();
	                course.setCourseName(name);

	                System.out.print("Course Fees: ");
	                double fees = scanner.nextDouble();
	                scanner.nextLine(); // Consume newline
	                course.setCourseFees(fees);

	                System.out.print("Course Duration: ");
	                String duration = scanner.nextLine();
	                course.setCourseDuration(duration);

	                System.out.print("Course Detail: ");
	                String detail = scanner.nextLine();
	                course.setCourseDetail(detail);

	                System.out.println("Course updated successfully!");
	                return;
	            }
	        }
	        System.out.println("Course not found!");
	    }

	    private static void deleteCourse() {
	        System.out.print("Enter Course ID for delete: ");
	        int id = scanner.nextInt();

	        for (Course course : courses) {
	            if (course.getCourseId() == id) {
	                courses.remove(course);
	                System.out.println("Course deleted successfully!");
	                return;
	            }
	        }
	        System.out.println("Course not found!");
	    }
	}
