import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Laptop laptop;

        System.out.println("Pilih Laptop:");
        System.out.println("1. Toshiba");
        System.out.println("2. MacBook");
        System.out.print("Pilihan: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) {
            laptop = new Toshiba();
        } else {
            laptop = new MacBook();
        }

        while (true) {
            System.out.print("\nInput (ON / OFF / UP / DOWN / EXIT): ");
            String command = input.nextLine().toUpperCase();

            switch (command) {
                case "ON":
                    laptop.turnOn();
                    break;
                case "OFF":
                    laptop.turnOff();
                    break;
                case "UP":
                    laptop.volumeUp();
                    break;
                case "DOWN":
                    laptop.volumeDown();
                    break;
                case "EXIT":
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Perintah tidak valid!");
            }
        }
    }
}