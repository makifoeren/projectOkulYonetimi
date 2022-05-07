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

            try {
                tercih = scan.nextInt();
                if(tercih<=0 || tercih>=8)
                    System.out.println("1 ve 7 arsainda degerler giriniz.");
            } catch (Exception e) {
                String str=scan.nextLine();
                System.out.println("Lutfen numerik veri giriniz...");
            }

            switch (tercih) {

                case 1:
                    ogretmenListesiYazdir();
                    break;
                case 2:
                    soyismdenOgrtmnBulma();
                    break;
                case 3:
                    branstanOgrtmnBulma();
                    break;
                case 4:
                    bilgileriGirerekOgretmenEkle();
                    break;
                case 5:
                    kimlikNoileKayitSil();
                    break;
                case 6:
                    Depo.anaManu();
                    break;
                case 7:
                    Depo.cikiso();
                    break;
                default:
                    System.out.println("Lutfen gecerli bir menu seciniz...");
                    ogretmenMenu();
            }

        } while (tercih != 7);
    }

    private static void kimlikNoileKayitSil() throws InterruptedException {
        System.out.println("Silmek istedigniz ogrt kimlik no giriniz...");
        String silinecekNo = scan.next();

        String sonuc = ogrtListMap.remove(silinecekNo);

        Thread.sleep(3000);

        ogretmenListesiYazdir();

        Thread.sleep(2000);
    }

    private static void bilgileriGirerekOgretmenEkle() {
        System.out.println("TC no giriniz...");
        String tc = scan.next();

        System.out.println("Adini giriniz..");
        String ad = scan.next();

        System.out.println("Soyadini giriniz..");
        String soyad = scan.next();

        System.out.println("Dogum tarihi giriniz...");
        String dogmTrhi = scan.next();

        System.out.println("Brans giriniz...");
        String brans = scan.next();

        String ekleneckValue = ad + ", " + soyad + ", " + dogmTrhi + ", " + brans;
        ogrtListMap.put(tc, ekleneckValue);


    }

    private static void branstanOgrtmnBulma() throws InterruptedException {

        System.out.println("Aradiginiz ogretmenin brans ini giriniz...");
        scan.nextLine();
        String brans = scan.nextLine();


        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogrtListMap.entrySet();


        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== BRAS'TAN OGRETMEN BULMA ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");


        boolean kontrol = true;

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {


            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (brans.equalsIgnoreCase(eachValuearr[3])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
                kontrol = false;
            }

        }
        if (kontrol) {
            System.out.println("Aradiginiz bransta ogretmen bulunamadi.");
        }
        Thread.sleep(3000);


    }

    private static void soyismdenOgrtmnBulma() throws InterruptedException {

        System.out.println("Aradiginiz soyisimi giriniz...");
        scan.nextLine();
        String arananSoyisim = scan.nextLine();


        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogrtListMap.entrySet();


        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== SOYISIMDEN OGRETMEN BULMA ============\n" +
                "TcNo     Isim   Soyisim   D.Yili  Brans");

        int kontrol = 0;

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {


            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (arananSoyisim.equalsIgnoreCase(eachValuearr[1])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
                kontrol++;
            }

        }

        if (kontrol == 0) {
            System.out.println("Aradiginiz ogretmen bulunamadi.");
        }

        Thread.sleep(3000);


    }

    private static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogrtListMap.entrySet();

        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== OGRETMEN LISTESI ============\n" +
                "TcNo     Isim   Soyisim   D.Yili  Brans");

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {
            // System.out.println(each);

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            // System.out.println("eachKey : " + eachKey);
            // System.out.println("isim : " + eachValuearr[0]);
            // System.out.println("brans :" + eachValuearr[1]);

            System.out.printf("%8s %-7s %-8s %-4s %4s \n", eachKey, eachValuearr[0], eachValuearr[1],
                    eachValuearr[2], eachValuearr[3]);

        }

        Thread.sleep(3000);

    }
}
