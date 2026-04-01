import javax.swing.JOptionPane;

public class InputBelajar {
    public static void main(String[] args) {
        String belajar = JOptionPane.showInputDialog("Anda sedang belajar apa?");
        JOptionPane.showMessageDialog(null, "Belajar " + belajar + " sangat mudah");
    }
}