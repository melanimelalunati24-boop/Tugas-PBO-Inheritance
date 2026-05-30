public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = new String[10]; // Kapasitas maks misal 10

    // Constructor
    public Teacher(String name, String address) {
        super(name, address);
    }

    // Menambahkan mata kuliah (Return false jika sudah ada)
    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                return false; // Kursus sudah ada
            }
        }
        if (numCourses < courses.length) {
            courses[numCourses] = course;
            numCourses++;
            return true;
        }
        return false;
    }

    // Menghapus mata kuliah (Return false jika tidak ditemukan)
    public boolean removeCourse(String course) {
        int indexFound = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                indexFound = i;
                break;
            }
        }
        
        if (indexFound == -1) {
            return false; // Kursus tidak ditemukan
        }

        // Pergeseran array untuk menghapus elemen
        for (int i = indexFound; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[numCourses - 1] = null;
        numCourses--;
        return true;
    }

    // Format output: "Teacher: name(address)"
    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}
