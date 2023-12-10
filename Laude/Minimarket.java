import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Minimarket {
    public static void main(String[] args) {
        // Username dan password yang benar
        String username = "user123";
        String password = "pass123";

        // Generate Captcha (misal: 3 + 7 = ?)
        int num1 = 3;
        int num2 = 7;
        int captchaResult = num1 + num2;

        // Meminta input dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();
        System.out.print("Captcha (Isi hasil penjumlahan " + num1 + " + " + num2 + "): ");
        int inputCaptcha = scanner.nextInt();
        scanner.nextLine(); 

        // Memeriksa apakah input username dan password sesuai (tanpa memperhatikan huruf besar/kecil)
        if (username.equalsIgnoreCase(inputUsername) && password.equals(inputPassword)) {
            // Memeriksa apakah hasil captcha sesuai
            if (captchaResult == inputCaptcha) {
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Captcha salah. Login gagal.");
            }
        } else {
            System.out.println("Username atau password salah. Login gagal.");
        }
         // Mendapatkan tanggal dan waktu sekarang
        LocalDateTime currentDateTime = LocalDateTime.now();

         // Memisahkan tanggal dan waktu
        String date = currentDateTime.toLocalDate().toString();
        String time = currentDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        //Scanner scanner = new Scanner(System.in);
          // Input dari pengguna
        System.out.print("Masukkan nomor faktur: ");
        String noFaktur = scanner.nextLine();

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("Masukkan nomor HP pelanggan: ");
        String nomorHP = scanner.nextLine();

        System.out.print("Masukkan alamat pelanggan: ");
        String alamat = scanner.nextLine();

        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan nama kasir: ");
        String Kasir = scanner.nextLine();

        System.out.print("Masukkan harga barang: ");
        double hargaBarang = scanner.nextDouble();

        

        // Input dari pengguna
        // (kode input sebelumnya)

        int jumlahBarang = 0; // Inisialisasi dengan nilai default
        boolean validInput = false;

        // Exception handling untuk memastikan input yang valid
        while (!validInput) {
            try {
                System.out.print("Masukkan jumlah barang: ");
                jumlahBarang = scanner.nextInt();
                if (jumlahBarang <= 0) {
                    throw new IllegalArgumentException("Jumlah barang harus lebih dari 0!");
                }
                validInput = true; // Input valid, keluar dari loop
            } catch (InputMismatchException e) {
                System.out.println("Jumlah barang harus berupa angka!");
                scanner.next(); // Membersihkan buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Barang barang = new Barang(namaBarang, hargaBarang, Kasir);
        Pelanggan pelanggan = new Pelanggan(namaPelanggan,nomorHP, alamat);
        Penjualan penjualan = new Penjualan(noFaktur, pelanggan, barang, jumlahBarang);

        System.out.println("\nACIAK MART LUBUK BUAYA");
        System.out.println("Tanggal: " + date);
        System.out.println("Waktu: " + time);
        System.out.println("========================");
        System.out.println("Data Pembelian Pelanggan");
        System.out.println(penjualan.getInfoTransaksi());

        scanner.close();
    }
}
