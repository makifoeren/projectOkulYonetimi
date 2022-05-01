import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {

    static Scanner scan = new Scanner(System.in);
    static Map<String, String> ogrtListMap = new HashMap<>();

    public static void fakeOgretmenLIst() {

        ogrtListMap.put("12345678", "Ali, Can, 1980, Kimya");
        ogrtListMap.put("12349012", "Ali, Yilmaz, 1978, Kimya");
        ogrtListMap.put("12343456", "Mehmet, Gul, 1967, Fizik");
        ogrtListMap.put("12347890", "Gamze, Gul, 2000, Fizik");
        ogrtListMap.put("12341234", "Gamze, Yan, 1953, Turkce");
        ogrtListMap.put("12340987", "Yildiz, Sen, 1982, Muzik");


    }


    public static void ogretmenMenu() throws InterruptedException {

        int tercih = 0;

        do {

            System.out.println("============= YILDIZ KOLEJI =============\n" +
                    "=========== OGRETMEN MENU ============\n" +
                    "\n" +
                    "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                    "\t   2- Soyisimden Ogretmen Bulma\n" +
                    "\t   3- Branstan Ogretmen Bulma\n" +
                    "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                    "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t   6- ANAMENU\n" +
                    "\t   7- ÇIKIŞ\n");

            System.out.println("Lutfen Ogretmen Menu den yapmak istediginiz islemi seciniz..");

            tercih = scan.nextInt();

            switch (tercih) {

                case 1: // Ogretmenler Listesi Yazdir
                    ogretmenListesiYazdir();

                    break;
                case 2: // Soyisimden Ogretmen Bulma
                    soyismdenOgrtmnBulma();
                    break;
                case 3: //Branstan Ogretmen Bulma
                    branstanOgrtmnBulma();
                    break;
                case 4: //
                    break;
                case 5: //
                    break;
                case 6: //
                    break;
                case 7: //
                    break;
                default:
                    System.out.println("Hatali veri girisi vaptiniz...");

                    ogretmenMenu();


            }

        } while (tercih != 7);


    }

    private static void branstanOgrtmnBulma() throws InterruptedException {

        System.out.println("Aradiginiz ogretmenin brans ini giriniz...");
        scan.nextLine();
        String brans = scan.nextLine();


        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogrtListMap.entrySet();


        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== BRAS'TAN OGRETMEN BULMA ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {


            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (brans.equalsIgnoreCase(eachValuearr[3])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
            }

        }
        Thread.sleep(5000);


    }

    private static void soyismdenOgrtmnBulma() throws InterruptedException {

        System.out.println("Aradiginiz soyisimi giriniz...");
        scan.nextLine();
        String arananSoyisim = scan.nextLine();


        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogrtListMap.entrySet();


        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== SOYISIMDEN OGRETMEN BULMA ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {


            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (arananSoyisim.equalsIgnoreCase(eachValuearr[1])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
            }

        }
        Thread.sleep(5000);


    }

    private static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogrtListMap.entrySet();

        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== OGRETMEN LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {
            // System.out.println(each);

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            // System.out.println("eachKey : " + eachKey);
            // System.out.println("isim : " + eachValuearr[0]);
            // System.out.println("brans :" + eachValuearr[1]);

            System.out.printf("%8s %-7s %-8s %-4s  %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                    eachValuearr[2], eachValuearr[3]);

        }
        Thread.sleep(5000);
    }
}
