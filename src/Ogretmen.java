import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ogretmen {

    static Scanner scan = new Scanner(System.in);
    static Map<String, String> ogrtListMap = new HashMap<>();

    public static void fakeOgretmenLIst() {
        ogrtListMap.put("12345678", "Ali,Can,1980,Kimya");
        ogrtListMap.put("12349012", "Ali,Yilmaz,1978,Kimya");
        ogrtListMap.put("12343456", "Mehmet,Gul,1967,Fizik");
        ogrtListMap.put("12347890", "Gamze,Gul,2000,Fizi");
        ogrtListMap.put("12341234", "Gamze,Yan,1953,Turkce");
        ogrtListMap.put("12340987", "Yildiz,Sen,1982,Muzik");


    }


    public static void ogretmenMenu() {

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

            tercih = scan.nextInt();


        } while (tercih!=7);


    }
}
