package AddressChecker;

import AddressChecker.ExcelReader.ExcelReader;
import AddressChecker.Model.Person;

import java.util.ArrayList;
import java.util.List;

import static AddressChecker.Helper.AddressCheckerHelper.*;
import static AddressChecker.SeleniumChecker.Checker.checkAddresses;

public class Main {
    private static List<Person> people = new ArrayList<>();
    public static void main(String[] args) {
        //people = ExcelReader.readFromExcel();
        //people.forEach(a -> System.out.println(a.getName() + " " + a.getAddress()));
        //checkAddresses(people);
        List<String> addresses = List.of(
                "Koralgatan     25 lgh 1201",
                "Börringegatan 6 B",
                "Bangatan 5 C",
                "Lertegelvägen 58",
                "Gymnasistgatan 11 A",
                "Stadiongatan 55 A lgh 1302",
                "Kulladalsgatan 6c",
                "Guldbaggegatan 52",
                "Limhamnsvägen 107 D lgh 1003",
                "Tornfalksgatan 10 A",
                "Rönnhageg. 24",
                "Vårmätaregatan 10",
                "Sjöblads väg 27 lgh 1501",
                "Korsörvägen 25 lgh 1005",
                "Tullstorpsv. 89",
                "Klörupsvägen 31 D lgh 1201",
                "Sjöbladsv. 15",
                "Lönnebergagatan 61 lgh 1305",
                "Sankta Gertruds väg 12 B lgh 1102",
                "Arkitektg. 1",
                "Berguvsgatan 20 D",
                "Duvhöksg. 4 A",
                "Bellevuevägen 3 B lgh 1101",
                "Karl XII Gatan 20 A lgh 1102",
                "Norra Vallg. 19",
                "Lilla Varvsgatan 25 A lgh 1003",
                "Knopgränd 4",
                "Svea Olofssons väg 4 C lgh 0025",
                "Gullregnsg. 2 A",
                "Eriksdalsgatan 3 B lgh 1101",
                "Idaborgsgatan 57 A lgh 1203",
                "Zenithgatan 36 lgh 1602",
                "Lergodsv. 85",
                "Magnoliagatan 7",
                "Glimtvägen 26",
                "Eriksdalsgatan 3 B lgh 1203",
                "Lönngatan    52 E lgh 1302",
                "Elisetorpsv. 15 E",
                "Bullerbygatan 89 lgh 1101",
                "Liljegatan    3 A lgh 1002",
                "Klagshamnsv.142a",
                "Skegrie byväg 49",
                "Nikolaigatan 4 A",
                "Fylkinggatan 25 C lgh 1302",
                "Folksångsg. 58",
                "Axel Danielssons väg 59",
                "Dalslandsgatan 1 lgh 1003",
                "Ishockeygränd 2",
                "Eriksgatan 4 lgh 1203",
                "Serenadg. 23",
                "Hårds väg 66",
                "Hyllie Vattenparksgata 25 E",
                "Persborgsgatan 11 A lgh 1001",
                "Augustenborgsgatan 22 B",
                "Västra Skrävlingevägen 175 lgh 1001",
                "Branteviksg. 14 A",
                "Gamla Bo Björkvägen 6",
                "Claesgatan 10 B lgh 1105",
                "Sjöbladsv.5",
                "Koristgatan 20",
                "Kalkbrottsgatan 64 B lgh 1302",
                "Pilåsg.13",
                "Tegelv.44",
                "Köpenhamnsv.2",
                "Kulladalsgatan 12 A lgh 1203",
                "Söderg.38g",
                "Stadiongatan 57 G lgh 1201",
                "Landålettg.32",
                "Trelleborgsg.23",
                "Fylkingg.27b",
                "Vittemölegatan 18e",
                "Särlagatan 13c",
                "Rydbergs väg 14",
                "Fajansvägen 112",
                "Torggatan 4",
                "Dalbyvägen 23 lgh 1201",
                "Eriksfältsgatan 101 C lgh 1604",
                "Munkhätteg.186",
                "Producentgatan 11 lgh 1402",
                "Västra Rönneholmsvägen 42 A",
                "Segemöllegatan 113",
                "Järnsvagsg.21",
                "S:t Jakobs väg 12",
                "Grönv.3b",
                "Ormvråksgatan 46 lgh 1001",
                "Serenadg.1",
                "Katrinelundsg.4a",
                "Elisetorpsv.11b",
                "Fabriksg.12",
                "Hyacintg.29",
                "Kronetorpsg.42b",
                "Blåvingev.76",
                "Poppelgatan 18a",
                "Stora Kvarngatan 26",
                "Västra Rönneholmsvägen 42 A lgh 1203",
                "Kulladalsgatan 26 C lgh 1301",
                "Frejagången 4",
                "Konsultgatan 5 lgh 1403",
                "Balladgatan 29 lgh 1203",
                "Fänkålsvägen 76"
        );
        for(String s : addresses){
            String a = formatAddress(s);
            System.out.println(a);
        }
    }
}
