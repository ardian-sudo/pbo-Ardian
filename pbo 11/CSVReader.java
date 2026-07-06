import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        // Silakan sesuaikan path file sesuai dengan kondisi di komputer Anda
        String csvFile = "D:\\new_students.csv";
        String line;
        String csvSplitBy = ",";
        int indeks = 0;
        int jumlahData = 0; // Variabel untuk menghitung jumlah baris data

        System.out.println("NIM, NAMA, UMUR, PRODI");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                indeks++;
                // Melewati baris pertama (header)
                if (indeks > 1) {
                    String[] student = line.split(csvSplitBy);
                    System.out.println(student[0] + ", " + student[1] + ", " + student[2] + ", " + student[3]);
                    jumlahData++; // Increment setiap kali membaca baris data
                }
            }
            System.out.println("-----------------------------------");
            System.out.println("Total jumlah baris data: " + jumlahData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}