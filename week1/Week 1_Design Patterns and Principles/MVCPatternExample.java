public class MVCPatternExample {
    public static void main(String[] args) {
        Student model = new Student("John Doe", "123", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.displayView();

        controller.updateStudentName("Jane Doe");
        controller.updateStudentGrade("B");
        controller.updateStudentId("321");
        
        controller.displayView();
    }

    static class Student {
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    static class StudentView {
        public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
            System.out.println("Student: ");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    static class StudentController {
        private final Student model;
        private final StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void updateStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void updateStudentId(String id) {
            model.setId(id);
        }

        public String getStudentId() {
            return model.getId();
        }

        public void updateStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void displayView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }
}
