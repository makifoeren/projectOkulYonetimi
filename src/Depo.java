import java.util.Scanner;

public class Depo {

    static Scanner scan = new Scanner(System.in);

    public static void anaManu() throws InterruptedException {
        Ogretmen.fakeOgretmenLIst();
        Ogrenci.feykOgrenciEkle();



        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        System.out.println(" ");

        int tercih = 0;

        do {
            System.out.println("============= YASAM KOLEJI =============\n" +
                    "==============  ANA MENU ==============\n" +
                    "\n" +
                    "\t   1- Okul Bilgileri Goruntule\n" +
                    "\t   2- Ogretmen Menu\n" +
                    "\t   3- Ogrenci Menu\t\t \n" +
                    "\t   4- ÇIKIS\n");

            System.out.println("Lutfen yapmak istediniz islemi seciniz...");

            try {
                tercih = scan.nextInt();
                if(tercih<=0 || tercih>=5)
                    System.out.println("1 ile 4 arsainda degerler giriniz.");
            } catch (Exception e) {
                String str=scan.nextLine();
                System.out.println("Lutfen numerik veri giriniz...");
            }

            Thread.sleep(3000);

            switch (tercih) {
                case 1:
                   Okul.okulBilgileri();
                   Thread.sleep(3000);
                    break;
                case 2:
                    Ogretmen.ogretmenMenu();
                    break;
                case 3:
                    Ogrenci.ogrenciMenu();
                    break;
                case 4:
                    cikiso();
                    break;
                default:
                    System.out.println("Lutfen gecerli bir menu seciniz...");

            }


        } while (tercih != 4);


    }

    protected static void cikiso() {

        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        System.out.println(" ");

        System.out.println("Isleminizi sonlandirdiniz... Tesekkur ederiz...");
        System.exit(0);
    }
}
