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
                    ogrenciListesiYazdir();
                    break;
                case 2:
                    soyIsimdenOgrenciBulma();
                    break;
                case 3:
                    sinifVeSubeIleOrenciBulma();
                    break;
                case 4:
                    bilgileriGirerekOgrenciEkle();
                    break;
                case 5:
                    kimlikNoIleSilmeIslemi();
                    break;
                case 6:
                    Depo.anaManu();
                    break;
                case 7:
                    Depo.cikiso();
                    break;

                default:
                    System.out.println("Lutfen gecerli bir menu seciniz...");
                    ogrenciMenu();

            }


        } while (tercih != 7);


    }

    private static void kimlikNoIleSilmeIslemi() throws InterruptedException {
        System.out.println("Silmek istediginiz ogrencinin tc ");
        String no = scan.next();

        String sonuc = ogrenciListeMap.remove(no);

        Thread.sleep(3000);
        ogrenciListesiYazdir();

        Thread.sleep(2000);


    }

    private static void bilgileriGirerekOgrenciEkle() throws InterruptedException {
        System.out.println("Ogrencinin TcNo giriniz...");
        String TcNo = scan.next();

        System.out.println("Ogrencinin adini giriniz...");
        String adi = scan.next();

        System.out.println("Ogrencinin soyadini giriniz...");
        String soyadi = scan.next();

        System.out.println("Ogrencinin dogum tarihi giriniz...");
        String dTari = scan.next();

        System.out.println("Ogrencinin numara giriniz...");
        String numara = scan.next();

        System.out.println("Ogrencinin sinifi giriniz...");
        String sinif = scan.next();

        System.out.println("Ogrencinin sube giriniz...");
        String sube = scan.next();

        String ekleneckValue = adi + ", " + soyadi + ", " + dTari + ", " + numara + ", " + sinif + ", " + sube;
        ogrenciListeMap.put(TcNo, ekleneckValue);

        Thread.sleep(3000);

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

        boolean kontrol = true;

        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (sinif.equalsIgnoreCase(eachValuearr[4]) && sube.equalsIgnoreCase(eachValuearr[5])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s %3s %8s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3], eachValuearr[4], eachValuearr[5]);
                kontrol = false;
            }
        }
        if (kontrol) {
            System.out.println("Aradiginiz ogrenci bulunamadi.");
        }
        Thread.sleep(3000);

    }

    private static void soyIsimdenOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin soyismini giriniz...");
        String soyIsim = scan.next();

        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciListeMap.entrySet();

        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D Yili  Okul No  Sinif  Sube");

        boolean kontrol = true;

        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (soyIsim.equalsIgnoreCase(eachValuearr[1])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s %3s %5s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3], eachValuearr[4], eachValuearr[5]);
                kontrol = false;
            }
        }
        if (kontrol) {
            System.out.println("Aradiginiz ogrenci bulunamadi.");
        }
        Thread.sleep(3000);
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
        Thread.sleep(3000);

    }
}