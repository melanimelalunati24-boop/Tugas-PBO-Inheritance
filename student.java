public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = new String[30]; // Kapasitas maks misal 30
    private int[] grades = new int[30];

    // Constructor menggunakan super() untuk memanggil constructor Person
    public Student(String name, String address) {
        super(name, address);
    }

    // Menambahkan mata kuliah dan nilai
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    // Mencetak semua mata kuliah dan nilai
    public void printGrades() {
        if (numCourses == 0) {
            System.out.println("Belum ada mata kuliah yang diambil.");
            return;
        }
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + ": " + grades[i]);
        }
    }

    // Menghitung rata-rata nilai
    public double getAverageGrade() {
        if (numCourses == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    // Format output: "Student: name(address)"
    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
