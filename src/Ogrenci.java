import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Ogrenci {

    static Scanner scan = new Scanner(System.in);

    static Map<String, String> ogrenciListeMap = new HashMap<>();

    public static void feykOgrenciEkle() {

        ogrenciListeMap.put("123456987411", "Ali, Can, 2008, 3569, 12, A");
        ogrenciListeMap.put("123456987412", "Veli, Yan, 2008, 3559, 12, B");
        ogrenciListeMap.put("123456987413", "Ayse, Can, 2007, 4569, 12, A");
        ogrenciListeMap.put("123456987414", "Ali, San, 2009, 1569, 11, A");
        ogrenciListeMap.put("123456987415", "Alp, Yan, 2009, 3769, 11, A");
    }

    public static void ogrenciMenu() throws InterruptedException {
        int tercih = 0;
        do {
            System.out.println("============= YASAM KOLEJI =============\n" +
                    "=========== OGRENCI MENU ============\n" +
                    "\t   1- Ogrenci Listesi Yazdir\n" +
                    "\t   2- Soyisimden Ogrenci Bulma\n" +
                    "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                    "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                    "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t   6- ANAMENU\n" +
                    "\t   7- ÇIKIŞ");

            tercih = scan.nextInt();

            switch (tercih) {
                case 1: //Ogrenci Listesi Yazdir
                    ogrenciListesiYazdir();
                    break;
                case 2://Soyisimden Ogrenci Bulma
                    soyIsimdenOgrenciBulma();
                    break;
                case 3://Sinif ve Sube Ile Ogrenci Bulma
                    sinifVeSubeIleOrenciBulma();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    Depo.anaManu();
                    break;
                case 7:
                    Depo.cikiso();
                    break;

                default:
                    System.out.println("Hatali veri girdiniz...");
                    ogrenciMenu();

            }


        } while (tercih != 7);


    }

    private static void sinifVeSubeIleOrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin sinifini  yaziniz...");
        String sinif = scan.next();
        System.out.println("Aradiginiz ogrenci subesini yaziniz...");
        String sube = scan.next();

        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciListeMap.entrySet();

        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");

        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (sinif.equalsIgnoreCase(eachValuearr[4]) && sube.equalsIgnoreCase(eachValuearr[5])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s %3s %8s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3], eachValuearr[4], eachValuearr[5]);
                break;
            } else if (sinif != eachValuearr[4] || sinif != eachValuearr[5]) {
                System.out.println("Aradiginiz ogrenci bulunamadi");
                break;
            }
            else {

            }
        }
    }

    private static void soyIsimdenOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin soyismini giriniz...");
        String soyIsim = scan.next();

        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciListeMap.entrySet();

        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");

        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");


            if (soyIsim.equalsIgnoreCase(eachValuearr[1])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s %3s %5s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3], eachValuearr[4], eachValuearr[5]);
                break;
            } else if (soyIsim != eachValuearr[1]) {
                System.out.println("Aradiginiz ogrenci bulunamadi");
                break;
            } else {

            }
            Thread.sleep(5000);


        }
    }

    private static void ogrenciListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciListeMap.entrySet();

        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");

        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {


            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");


            System.out.printf("%8s %-7s %-8s %-4s  %s %3s %5s \n", eachKey, eachValuearr[0], eachValuearr[1],
                    eachValuearr[2], eachValuearr[3], eachValuearr[4], eachValuearr[5]);

        }
        Thread.sleep(5000);


    }
}