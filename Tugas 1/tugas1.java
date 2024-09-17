import java.util.Scanner; 

class tugas1 {
  public static void main(String[] args) {
    Scanner tugas = new Scanner(System.in); 
    System.out.print("Masukkan Nama: ");

    String nama = tugas.nextLine();  

    System.out.print("Masukkan Nim: ");
    String nim = tugas.nextLine();

    System.out.println("Nama: "+nama);
    System.out.println("Nama: "+nim);

  }
}