import com.sun.deploy.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;

import java.util.*;

/*
 SVEN DANEEL (s325867)
 BJOERNAR HOFF (s325858)
 STEFFEN BRUVIK (s325874)

 KLASSEN ER TESTET OG GIR BESKJEDEN:
    Gratulerer!! Du passerte testen!
  */
public class Oblig1 {

    // Metode som er til hjelp for aa skrive ut tabell
    public static void skriv(int[] a)
    {
        System.out.println("Tabellen er naa: ");
        for (int item : a) {
            System.out.print(item + ", ");
        }
    }

    // Metode som lager en tilfeldig permutasjon av tabellen
    public static int[] randPerm(int n)
    {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
        return a;
    }

    // Metode som bytter om to verdier, x og y, i tabllen a
    public static void bytt(int[] a, int x, int y)
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    // Det blir gjort (n-1) sammenligninger
    public static int maks(int[] a)                // Sammenligner to naerliggende verdier og om den til venstre er stoerst, bytter plass
    {

        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom"); // Kaster en feilmelding om tabellen er tom
        }

        for (int i = 0; i < a.length - 1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en stoerre en siste index
        {

            if (a[i] > a[i + 1]) {
                // Det blir gjort flest ombytninger naar tabellen er sortert i synkende rekkefoelge
                // Det blir gjort faerrest ombytninger naar tabellen er sortert i stigende rekkefoelge
                bytt(a, i, i + 1);
            }
        }
        return a[a.length - 1];
    }


    // Vi kan finne gjennomsnittet av antall ombytninger ved aa summere antall ombytninger delt paa antall kjoeringer.
    // Ved 10 kjoeringer av metoden, med et array med lengde 10, ble det i gjennomsnitt 7,3 ombytninger.
    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom"); // Kaster en feilmelding om tabellen er tom
        }

        int antOmbytninger = 0;
        for (int i = 0; i < a.length - 1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en stoerre en siste index
        {

            if (a[i] > a[i + 1]) {
                // Det blir gjort flest ombytninger naar tabellen er sortert i synkende rekkefoelge
                // Det blir gjort faerrest ombytninger naar tabellen er sortert i stigende rekkefoelge
                bytt(a, i, i + 1);
                antOmbytninger++;   // Teller antall ombytninger
            }
        }
        return antOmbytninger;
    }


    // OPPGAVE 2
    // Metode som sjekker antall ulike sortert i en tabell
    public static int antallUlikeSortert(int[] a) {
        int teller = 1; // Teller satt til 1 fordi foerste verdi vil alltid vaere unik

        if (a.length < 1) {        // Sjekker om tabellen er tom, hvis den er tom returner den 0
            return 0;
        }

        for (int i = 0; i < a.length-1; i++)            // Looper gjennom lengden paa tabellen
        {
            if (a[i] > a[i + 1]) {                      // Sjekker om tabellen er sortert
                throw new IllegalStateException("Tabellen er ikke sortert" + "\n");     // Gir tilbakemelding om den ikke er sortert
            }

        }

        for (int j = 0; j < a.length-1; j++)    // Looper gjennom lengden paa tabellen
        {
                if (a[j] != a[j + 1])               // Sjekker om to naerliggende verdier er ulik
                {
                    teller++;                   // Om de er ulik, oeker telleren med 1
                }
        }
        return teller;
    }


    // Metode som lager en tilfeldig tabell med tilfeldige verdiƒer
    public static int[] randomArray(int a) {
        int[] list = new int[a];            // Lager en liste med stoerrelse 'a'
        for (int i = 0; i < a; i++)            // Looper gjennom lengden paa tabellen
        {
            int n = (int) (Math.random() * 9 + 1); // Oppretter tilfeldige verdier
            list[i] = n;                        // Setter verdiene inn i tabellen

        } return list;                        // Returner tabellen
    }


    // Metode som bruker boblesortering til aa sortere tabellen i stigende rekkefoelge
    public static void bubbleSort(int[] a) {
        for (int n = a.length; n > 1; n--) // For aa vite antallet ganger loekken skal kjoere
        {
            for (int i = 1; i < n; i++)        // Kjoere om i er mindre enn antallet
            {
                if (a[i - 1] > a[i])           // Sjekker om verdien foran er stoerre enn neste
                {
                    bytt(a, i - 1, i);      // Bytter plass om verdien er stoerre
                }
            }
        }
    }

    // Metode for aa sortere tabellen paa ved hjelp av quicksort
    public static void quickSort(int a[], int left, int right) {

        int index = partition1(a, left, right);     // Partisjonerer i tabell a, fra grense left til right

        if (left < index - 1)

            quickSort(a, left, index - 1);

        if (index < right)

            quickSort(a, index, right);

    }

    // Metode som partisjonerer ved hjelp av pivot. Sjekker verdier fra venstre og hoeyre for pivot, og bytter om de
    // er plassert paa feil side av pivot. Metoden skal til slutt ha partisjonert tabellen i stigende rekkefoelge.
    public static int partition1(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];    // Oppretter en pivot (midtverdien i tabellen)

        while (i <= j) {                    // Sjekker om left er mindre eller er lik hoeyre
            while (arr[i] < pivot)          // Hvis grensen til venstre er mindre enn pivot, oek venstre med 1
                i++;

            while (arr[j] > pivot)       // Sjekker om right er stoerre enn pivot
                j--;                    // Minker hoeyre med 1

            if (i <= j) {               // Hvis venstre er mindre eller lik hoeyre, bytt om. Og oek venstre med 1
                tmp = arr[i];           // og mink hoeyre med 1
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    // Metode som partisjonerer uten pivot. Partisjonerer ut i fra partall og oddetall
    public static void partition(int a[], int v, int h) {
        while (true) {
            while (v <= h && a[h] % 2 == 0) {
                h--;

            }
            while (h >= v && a[v] % 2 != 0) {
                v++;
            }
            if (v < h) {
                bytt(a, v++, h--);
            }
            if (v >= h) {
                break;
            }
        }


    }



    // OPPGAVE 3
    // Metode som sjekker antall ulike usorterte verdier i tabellen
    public static int antallUlikeUsortert(int[] a) {
        int different = 0;

        for (int i = 0; i < a.length; i++) { // Looper igjennom tabellen
            boolean same = false;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {  // Sjekker om naerliggende er lik
                    same = true;
                    break;
                }
            }
            if (!same) {        // Hvis ikke naerliggende er lik, oek antall ulike med 1
                different++;
            }
        }
        return different;
    }


    // OPPGAVE 4
    // Metode som sorterer partall og oddetall paa hver sin side av tabellen
    public static void delsortering(int[] a) {

        int partall = 0;
        int oddetall = 0;

        if (a.length == 0) {        // Sjekker om tabellen har lengde 0
            return;
        }

        partition(a, 0, a.length - 1);  // Kaller paa metoden partisjon, for aa partisjonere tabellen

        for (int i = 0; i < a.length; i++) {    // Looper igjennom tabellen


            if (Math.floorMod(a[i], 2) == 0) {  // Sjekker tallet mot modulo 2 til aa finne ut om tallet er partall, oek partall med 1
                partall = partall + 1;          // Math.floorMod bruker vi for aa sjekke negative tall mot modulo.
            } else {
                oddetall = oddetall + 1;        // Hvis ikke partall, oek oddetall med 1
            }

        }

        quickSort(a, 0, oddetall - 1);      // Kvikksorterer oddetallene
        quickSort(a, oddetall, a.length - 1);   // Kvikksorterer partallene


    }




    // OPPGAVE 5
    // Metode som roterer en char tabell med èn rotasjon til hoeyre
    public static void rotasjon(char[] a) {
        int n = a.length;
        int d = 1;

        if (n < 1) {        // Sjekker om tabellen er mindre enn 1, hvis ja, returner
            return;
        }

        if ((d = d % n) < 0) {      // Sjekker om modulo av lengden er mindre enn 0, hvis ja, setter lengden til rotasjonen
            d += n;
        }

        char[] b = Arrays.copyOfRange(a, n - d, n);     // Oppretter en hjelpetabell

        for (int i = n - 1; i >= d; i--) {
                a[i] = a[i - d];        // Forskyver bokstavene en plass til hoeyre
        }

        System.arraycopy(b, 0, a, 0, d);                      // Kopierer arrayet

    }


    // OPPGAVE 6
    // Metode som roterer en char tabell med oensket antall rotasjoner
    public static void rotasjon(char[] a, int k) {
        int n = a.length;

        if (n < 1) {
            return;
        }

        if ((k = k % n) < 0) {      // Sjekker om modulo av lengden er mindre enn 0, hvis ja, setter lengden til rotasjonen
            k += n;
        }

        char[] b = Arrays.copyOfRange(a, n - k, n);     // Oppretter en hjelpetabell

        for (int i = n - 1; i >= k; i--) {
            a[i] = a[i - k];            // Forskyver bokstavene en plass til hoeyre
        }

        System.arraycopy(b, 0, a, 0, k);                      // Kopierer arrayet

    }


    // OPPGAVE 7 a
    // Metode som fletter sammen bokstaver fra to forskjellige ord
    public static String flett(String a, String b){
        StringBuilder c = new StringBuilder(); // Oppretter stringbuilder for aa holde paa utfallet
        int i = 0;

        for(; i< a.length(); ++i){
            c.append(a.charAt(i));
            if(i < b.length()){
                c.append(b.charAt(i));
            }                                           // Looper igjennom lengden paa begge string verdiene,
        }                                               // sjekker om indeksen til hver bokstav,
            if(i < b.length()){                         // og plasserer bokstavene i stringbuilder. oeker 'i' for hver indeks
            for(; i<b.length(); ++i){
                c.append(b.charAt(i));
            }
        }
        return c.toString();                           // Returnerer innholdet til stringbuilder
    }


    //OPPGAVE 7 b
    // Metoden som fletter sammen bokstaver fra flere String-input av bruker
    public static String flett(String... s)
    {
        if (s.length == 1)          // Sjekker om tabell-lengden er lik 1, returner hele stringen
        {
            return s[0];

        }

        StringBuilder c = new StringBuilder();  // Oppretter stringbuilder
        int i = 0;

        for (; i<=c.length(); i++)                  // Looper saa lenge i er mindre enn Stringbuilders lengde
        {
            for (int j = 0; j<s.length; j++)        // Definerer to variabler i og j. i er antall ord/string.
            {                                       // j er indeksen i hvert ord
                if(i < s[j].length()) {             // Hvis i er mindre enn verdien til lengden j, saa plasser verdien
                    c.append(s[j].charAt(i));       // i Stringbuilder
                }
            }
        }
        return c.toString();                    // Returner innholdet til Stringbuilder
    }







    //OPPGAVE 8
    // Metode som finner minsteverdi i en tabell
    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Ulovlig intervall"); // Kaster feilmelding om intervallet er ugyldig

        int f = fra;
        int minverdi = a[fra];

        for (int i = fra + 1; i < til; i++)
            if (a[i] < minverdi) {

                f = i; // Indeksen til minste verdi oppdateres
                minverdi = a[f]; // Minste verdi oppdateres
            }

        return f; // Returnerer minste verdi
    }


    // Metode for aa sortere indeks med ulike verdier
    public static int[] indekssortering(int[] a) {
        int[] indekstabell = new int[a.length];         // Oppretter en indeks tabell med lengden av tabellen a
        int[] a_clone = a.clone();                      // Kloner av for aa ikke gjoere endringer paa tabellen a

        for (int i = 0; i < a.length; i++) {            // Looper igjennom for aa angi hver indeks
            indekstabell[i] = i;
        }

        // Finner minsteverdi, og gir minsteverdi den minste indeksen. Looper igjennom og gir hver verdi indeks i riktig rekkfoelge
        for (int i = 0; i < a.length - 1; i++) {
            int indeks = min(a_clone, i, a.length);
            bytt(a_clone, i, indeks);
            bytt(indekstabell, i, indeks);
        }


        return indekstabell;            // Returnerer tabellen med indeksene
    }


                        // OPPGAVE 9

    public static int[] tredjeMin(int[] a) {
        int n = a.length;       // Lengden til tabellen

        if (n < 3)     // Maa ha minst 3 verdier
        {
            throw new NoSuchElementException("Tabellen er ugyldig. Maa ha minst 3 verdier");
        }

        int m = 0;              // Posisjonen til den minste verdien
        int nm = 1;             // Posisjonen til nest minste verdi
        int tm = 2;             // Posisjonen til den tredje minste verdi


        // Sjekker verdiene for aa finne minsteverdi, nestminste og tredjeminste
        // Utfoerer byttinger for hver verdi som ikke tilfredstiller kravene
        // Faar minsteverdi plassert foerst
        if (a[m] > a[nm])
        {
            m = 1;
            nm = 0;
        }

        for (int i = 0; i < n; i++)
        {

        if (a[i] < a[m])
        {
            tm = nm;
            nm = m;
            m = i;
        }

        else if (a[i] < a[nm] && a[i] > a[m])
        {
            tm = nm;
            nm = i;
        }
        if (a[i] < a[tm] && a[i] > a[nm])
        {
            tm = i;
        }

        }

        return new int[] {m,nm,tm};   // Returnerer en ny int tabell med minsteverdi, nestminsteverdi og tredjeminste verdi
    }



    // OPPGAVE 10
    // Metoden sjekker om en String a er representert i en String b
    public static boolean inneholdt(String a, String b)
    {
         char [] first = a.toCharArray();       // Splitter String inn i en char tabell
         char [] second = b.toCharArray();

        if (a.length() > b.length())      // Sjekker om lengden av a er større enn b
        {
            return false;
        }

        int [] hTabell1 = new int[256];   // Oppretter hjelpetabeller
        int [] hTabell2 = new int[256];

        for (char x : first)
        {
            hTabell1[x]++;     // Teller tegnene i 'first'. Feks: ordet ABBA. Stor A har unicode verdi 41 og da vil hTabell1[41] ha verdien 2 etter denne for løkken
        }
        for (char x : second)
        {
            hTabell2[x]++;     // Teller tegnene i 'second'
        }

        for (int i = 0; i < 256; i++)           // Looper igjennom 256 indekser for å sjekke opp mot alle aktuelle unicode verdier
        {
            if (hTabell1[i] > hTabell2[i])      // Sjekker om antallet av en forekomst i det første ordet er større enn antallet av samme forekomst i det andre ordet.
            {
                return false;
            }
        }
        return true;
    }

}
