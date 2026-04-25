public class Student extends Person {
    // Private attributes
    private int numCourses = 0;
    private String[] courses = new String[100];
    private int[] grades = new int[100];

    // Constructor
    public Student(String name, String address) {
        super(name, address);
    }

    // Tambahkan mata kuliah beserta nilainya
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
        System.out.println("Mata kuliah \"" + course + "\" dengan nilai " + grade + " berhasil ditambahkan.");
    }

    // Cetak semua mata kuliah dan nilai
    public void printGrades() {
        if (numCourses == 0) {
            System.out.println("Belum ada mata kuliah yang terdaftar.");
            return;
        }
        System.out.println("Daftar Nilai Mahasiswa: " + getName());
        System.out.println("----------------------------------");
        for (int i = 0; i < numCourses; i++) {
            System.out.println("  " + courses[i] + " : " + grades[i]);
        }
        System.out.println("----------------------------------");
        System.out.printf("  Rata-rata Nilai : %.2f%n", getAverageGrade());
    }

    // Hitung rata-rata nilai
    public double getAverageGrade() {
        if (numCourses == 0) return 0.0;
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            total += grades[i];
        }
        return (double) total / numCourses;
    }

    // toString sesuai diagram: "Student: name(address)"
    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
