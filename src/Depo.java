import java.util.Scanner;

public class Depo {

    static Scanner scan = new Scanner(System.in);

    public static void anaManu() throws InterruptedException {
        Ogretmen.fakeOgretmenLIst();

        int tercih = 0;

        do {
            System.out.println("============= YASAM KOLEJI =============\n" +
                    "==============  ANA MENU ==============\n" +
                    "\n" +
                    "\t   1- Okul Bilgileri Goruntule\n" +
                    "\t   2- Ogretmen Menu\n" +
                    "\t   3- Ogrenci Menu\t\t \n" +
                    "\t   4- ÇIKIS\n");

            System.out.println("Lutfen yapmak istediniz islemi seciniz..");
            tercih = scan.nextInt();

            switch (tercih) {
                case 1: // Okul Bilgileri
                   Okul.okulBilgileri();
                    break;
                case 2: // Ogretmen Menu
                    Ogretmen.ogretmenMenu();
                    break;
                case 3: //Ogrenci Menu
                    break;
                case 4: //ÇIKIS
                    cikiso();
                    break;
                default:
                    System.out.println("Lutfen gecerli bir menu seciniz...");

            }


        } while (tercih != 4);


    }

    protected static void cikiso() {

        System.out.println("Isleminizi sonlandirdiniz... Tesekkur ederiz...");
    }
}
