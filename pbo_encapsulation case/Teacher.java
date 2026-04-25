public class Teacher extends Person {
    // Private attributes
    private int numCourses = 0;
    private String[] courses = new String[100];

    // Constructor
    public Teacher(String name, String address) {
        super(name, address);
    }

    // Tambah mata kuliah yang diampu
    // Return false jika mata kuliah sudah ada
    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                System.out.println("Gagal: Mata kuliah \"" + course + "\" sudah ada.");
                return false;
            }
        }
        courses[numCourses] = course;
        numCourses++;
        System.out.println("Mata kuliah \"" + course + "\" berhasil ditambahkan.");
        return true;
    }

    // Hapus mata kuliah yang diampu
    // Return false jika mata kuliah tidak ditemukan
    public boolean removeCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                // Geser elemen ke kiri
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                numCourses--;
                System.out.println("Mata kuliah \"" + course + "\" berhasil dihapus.");
                return true;
            }
        }
        System.out.println("Gagal: Mata kuliah \"" + course + "\" tidak ditemukan.");
        return false;
    }

    // Cetak daftar mata kuliah yang diampu
    public String tpString() {
        if (numCourses == 0) {
            return "Dosen " + getName() + " belum mengampu mata kuliah apapun.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Daftar Mata Kuliah yang diampu ").append(getName()).append(":\n");
        for (int i = 0; i < numCourses; i++) {
            sb.append("  ").append(i + 1).append(". ").append(courses[i]).append("\n");
        }
        return sb.toString();
    }

    // toString sesuai diagram: "Teacher: name(address)"
    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}
