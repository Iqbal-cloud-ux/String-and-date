import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SupermarketApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Simulasi Login
        boolean loginSuccess = false;
        while (!loginSuccess) {
            try {
                System.out.println("+-----------------------------------------------------+");
                System.out.print("Username : ");
                String username = scanner.nextLine();
                System.out.print("Password : ");
                String password = scanner.nextLine();
                System.out.print("Captcha  : ");
                String captchaInput = scanner.nextLine();
                String captcha = "1234"; // Captcha statis untuk contoh
                
                if (!captchaInput.equals(captcha)) {
                    throw new Exception("Captcha salah!");
                }
                if (username.equals("admin") && password.equals("admin123")) {
                    loginSuccess = true;
                    System.out.println("Login berhasil!");
                } else {
                    throw new Exception("Username atau password salah!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Silakan coba lagi.\n");
            }
        }
        
        // Menampilkan Informasi Supermarket
        System.out.println("+----------------------------------------------------+");
        System.out.println("Selamat Datang di Supermarket JavaMart");
        System.out.println("Tanggal dan Waktu : " + getCurrentDateTime());
        System.out.println("+----------------------------------------------------+");

        // Input Data Barang
        try {
            System.out.print("No. Faktur     : ");
            String noFaktur = scanner.nextLine();

            System.out.print("Kode Barang    : ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Nama Barang    : ");
            String namaBarang = scanner.nextLine();

            System.out.print("Harga Barang   : ");
            double hargaBarang = Double.parseDouble(scanner.nextLine());

            System.out.print("Jumlah Beli    : ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine());

            double total = hargaBarang * jumlahBeli;

            // Menampilkan Faktur
            System.out.println("+----------------------------------------------------+");
            System.out.println("No. Faktur     : " + noFaktur);
            System.out.println("Kode Barang    : " + kodeBarang);
            System.out.println("Nama Barang    : " + namaBarang);
            System.out.println("Harga Barang   : Rp " + formatCurrency(hargaBarang));
            System.out.println("Jumlah Beli    : " + jumlahBeli);
            System.out.println("TOTAL          : Rp " + formatCurrency(total));
            System.out.println("+----------------------------------------------------+");
            System.out.print("Kasir          : ");
            String namaKasir = scanner.nextLine();
            System.out.println("Kasir          : " + namaKasir);
            System.out.println("+----------------------------------------------------+");
        } catch (NumberFormatException e) {
            System.out.println("Input angka tidak valid. Program berhenti.");
        }
    }

    // Metode untuk mendapatkan tanggal dan waktu saat ini
    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(new Date());
    }

    // Metode untuk format angka menjadi format mata uang
    public static String formatCurrency(double value) {
        return String.format("%,.2f", value);
    }
}
