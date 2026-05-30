import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== SIMULASI SISTEM AKADEMIK ===");
        
        // 1. Input Data Dosen (Teacher)
        System.out.print("Masukkan Nama Dosen: ");
        String teacherName = input.nextLine();
        System.out.print("Masukkan Alamat Dosen: ");
        String teacherAddress = input.nextLine();
        
        Teacher dosen = new Teacher(teacherName, teacherAddress);
        System.out.println("\nBerhasil membuat objek -> " + dosen);
        
        // Simulasi tambah matkul dosen
        System.out.print("Masukkan jumlah matkul yang diampu dosen: ");
        int jmlMatkul = input.nextInt();
        input.nextLine(); // consume newline
        
        for (int i = 0; i < jmlMatkul; i++) {
            System.out.print("Nama Matkul ke-" + (i+1) + ": ");
            String matkul = input.nextLine();
            if (dosen.addCourse(matkul)) {
                System.out.println("Matkul '" + matkul + "' berhasil ditambahkan.");
            } else {
                System.out.println("Gagal! Matkul '" + matkul + "' sudah ada.");
            }
        }

        System.out.println("\n-----------------------------------\n");

        // 2. Input Data Mahasiswa (Student)
        System.out.print("Masukkan Nama Mahasiswa: ");
        String studentName = input.nextLine();
        System.out.print("Masukkan Alamat Mahasiswa: ");
        String studentAddress = input.nextLine();
        
        Student mahasiswa = new Student(studentName, studentAddress);
        System.out.println("\nBerhasil membuat objek -> " + mahasiswa);
        
        // Simulasi tambah nilai matkul mahasiswa
        System.out.print("Masukkan jumlah nilai matkul mahasiswa: ");
        int jmlNilai = input.nextInt();
        input.nextLine(); // consume newline
        
        for (int i = 0; i < jmlNilai; i++) {
            System.out.print("Nama Matkul ke-" + (i+1) + ": ");
            String matkulMhs = input.nextLine();
            System.out.print("Nilai (0-100): ");
            int nilaiMhs = input.nextInt();
            input.nextLine(); // consume newline
            
            mahasiswa.addCourseGrade(matkulMhs, nilaiMhs);
        }
        
        // Tampilkan Hasil Akhir Mahasiswa
        System.out.println("\n=== Rekap Nilai Mahasiswa ===");
        mahasiswa.printGrades();
        System.out.printf("Rata-rata Nilai: %.2f\n", mahasiswa.getAverageGrade());
        
        input.close();
    }
}
