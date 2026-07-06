import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String sourceFile = "D:\\new_students.csv";
        String targetFile = "D:\\students_backup.csv";

        System.out.println("Memulai proses penyalinan file...");

        // Membuka BufferedReader untuk membaca dan BufferedWriter untuk menulis
        // sekaligus
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line); // Salin baris teks
                bw.newLine(); // Berikan baris baru di file target
            }

            System.out.println("Penyalinan selesai! File berhasil dicopy ke: " + targetFile);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyalin file.");
            e.printStackTrace();
        }
    }
}