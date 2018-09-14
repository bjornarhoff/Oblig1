import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;

import java.util.*;

public class Oblig1 {

    // Metode som er til hjelp for å skrive ut tabell
    public static void skriv(int[] a)
    {
        System.out.println("Tabellen er nå: ");
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
    public static int maks(int[] a)                // Sammenligner to nærliggende verdier og om den til venstre er størst, bytter plass
    {

        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom"); // Kaster en feilmelding om tabellen er tom
        }

        for (int i = 0; i < a.length - 1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en større en siste index
        {

            if (a[i] > a[i + 1]) {
                // Det blir gjort flest ombytninger når tabellen er sortert i synkende rekkefølge
                // Det blir gjort færrest ombytninger når tabellen er sortert i stigende rekkefølge
                bytt(a, i, i + 1);
            }
        }
        return a[a.length - 1];
    }


    // Vi kan finne gjennomsnittet av antall ombytninger ved å summere antall ombytninger delt på antall kjøringer.
    // Ved 10 kjøringer av metoden, med et array med lengde 10, ble det i gjennomsnitt 7,3 ombytninger.
    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom"); // Kaster en feilmelding om tabellen er tom
        }

        int antOmbytninger = 0;
        for (int i = 0; i < a.length - 1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en større en siste index
        {

            if (a[i] > a[i + 1]) {
                // Det blir gjort flest ombytninger når tabellen er sortert i synkende rekkefølge
                // Det blir gjort færrest ombytninger når tabellen er sortert i stigende rekkefølge
                bytt(a, i, i + 1);
                antOmbytninger++;   // Teller antall ombytninger
            }
        }
        return antOmbytninger;
    }


    // OPPGAVE 2
    // Metode som sjekker antall ulike sortert i en tabell
    public static int antallUlikeSortert(int[] a) {
        int teller = 1; // Teller satt til 1 fordi første verdi vil alltid være unik

        if (a.length < 1) {        // Sjekker om tabellen er tom, hvis den er tom returner den 0
            return 0;
        }

        for (int i = 0; i < a.length-1; i++)            // Looper gjennom lengden på tabellen
        {
            if (a[i] > a[i + 1]) {                      // Sjekker om tabellen er sortert
                throw new IllegalStateException("Tabellen er ikke sortert" + "\n");     // Gir tilbakemelding om den ikke er sortert
            }

        }

        for (int j = 0; j < a.length-1; j++)    // Looper gjennom lengden på tabellen
        {
                if (a[j] != a[j + 1])               // Sjekker om to nærliggende verdier er ulik
                {
                    teller++;                   // Om de er ulik, øker telleren med 1
                }
        }
        return teller;
    }


    // Metode som lager en tilfeldig tabell med tilfeldige verdier
    public static int[] randomArray(int a) {
        int[] list = new int[a];            // Lager en liste med størrelse 'a'
        for (int i = 0; i < a; i++)            // Looper gjennom lengden på tabellen
        {
            int n = (int) (Math.random() * 9 + 1); // Oppretter tilfeldige verdier
            list[i] = n;                        // Setter verdiene inn i tabellen

        } return list;                        // Returner tabellen
    }


    // Metode som bruker boblesortering til å sortere tabellen i stigende rekkefølge
    public static void bubbleSort(int[] a) {
        for (int n = a.length; n > 1; n--) // For å vite antallet ganger løkken skal kjøre
        {
            for (int i = 1; i < n; i++)        // Kjøre om i er mindre enn antallet
            {
                if (a[i - 1] > a[i])           // Sjekker om verdien foran er større enn neste
                {
                    bytt(a, i - 1, i);      // Bytter plass om verdien er større
                }
            }
        }
    }

    // Metode for å sortere tabellen på ved hjelp av quicksort
    public static void quickSort(int a[], int left, int right) {

        int index = partition1(a, left, right);     // Partisjonerer i tabell a, fra grense left til right

        if (left < index - 1)

            quickSort(a, left, index - 1);

        if (index < right)

            quickSort(a, index, right);

    }

    // Metode som partisjonerer ved hjelp av pivot. Sjekker verdier fra venstre og høyre for pivot, og bytter om de
    // er plassert på feil side av pivot. Metoden skal til slutt ha partisjonert tabellen i stigende rekkefølge.
    public static int partition1(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];    // Oppretter en pivot (midtverdien i tabellen)

        while (i <= j) {                    // Sjekker om left er mindre eller er lik høyre
            while (arr[i] < pivot)          // Hvis grensen til venstre er mindre enn pivot, øk venstre med 1
                i++;

            while (arr[j] > pivot)       // Sjekker om right er større enn pivot
                j--;                    // Minker høyre med 1

            if (i <= j) {               // Hvis venstre er mindre eller lik høyre, bytt om. Og øk venstre med 1
                tmp = arr[i];           // og mink høyre med 1
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
                if (a[i] == a[j]) {  // Sjekker om nærliggende er lik
                    same = true;
                    break;
                }
            }
            if (!same) {        // Hvis ikke nærliggende er lik, øk antall ulike med 1
                different++;
            }
        }
        return different;
    }


    // OPPGAVE 4
    // Metode som sorterer partall og oddetall på hver sin side av tabellen
    public static void delsortering(int[] a) {

        int partall = 0;
        int oddetall = 0;

        if (a.length == 0) {        // Sjekker om tabellen har lengde 0
            return;
        }

        partition(a, 0, a.length - 1);  // Kaller på metoden partisjon, for å partisjonere tabellen

        for (int i = 0; i < a.length; i++) {    // Looper igjennom tabellen


            if (Math.floorMod(a[i], 2) == 0) {  // Sjekker tallet mot modulo 2 til å finne ut om tallet er partall, øk partall med 1
                partall = partall + 1;          // Math.floorMod bruker vi for å sjekke negative tall mot modulo.
            } else {
                oddetall = oddetall + 1;        // Hvis ikke partall, øk oddetall med 1
            }

        }

        quickSort(a, 0, oddetall - 1);      // Kvikksorterer oddetallene
        quickSort(a, oddetall, a.length - 1);   // Kvikksorterer partallene


    }




    // OPPGAVE 5
    // Metode som roterer en char tabell med èn rotasjon til høyre
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
                a[i] = a[i - d];        // Forskyver bokstavene en plass til høyre
        }

        System.arraycopy(b, 0, a, 0, d);                      // Kopierer arrayet

    }


    // OPPGAVE 6
    // Metode som roterer en char tabell med ønsket antall rotasjoner
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
            a[i] = a[i - k];            // Forskyver bokstavene en plass til høyre
        }

        System.arraycopy(b, 0, a, 0, k);                      // Kopierer arrayet

    }


    // OPPGAVE 7 a
    // Metode som fletter sammen bokstaver fra to forskjellige ord
    public static String flett(String a, String b){
        StringBuilder c = new StringBuilder(); // Oppretter stringbuilder for å holde på utfallet
        int i = 0;

        for(; i< a.length(); ++i){
            c.append(a.charAt(i));
            if(i < b.length()){
                c.append(b.charAt(i));
            }                                           // Looper igjennom lengden på begge string verdiene,
        }                                               // sjekker om indeksen til hver bokstav,
            if(i < b.length()){                         // og plasserer bokstavene i stringbuilder. Øker 'i' for hver indeks
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

        for (; i<=c.length(); i++)                  // Looper så lenge i er mindre enn Stringbuilders lengde
        {
            for (int j = 0; j<s.length; j++)        // Definerer to variabler i og j. i er antall ord/string.
            {                                       // j er indeksen i hvert ord
                if(i < s[j].length()) {             // Hvis i er mindre enn verdien til lengden j, så plasser verdien
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


    // Metode for å sortere indeks med ulike verdier
    public static int[] indekssortering(int[] a) {
        int[] indekstabell = new int[a.length];         // Oppretter en indeks tabell med lengden av tabellen a
        int[] a_clone = a.clone();                      // Kloner av for å ikke gjøre endringer på tabellen a

        for (int i = 0; i < a.length; i++) {            // Looper igjennom for å angi hver indeks
            indekstabell[i] = i;
        }

        // Finner minsteverdi, og gir minsteverdi den minste indeksen. Looper igjennom og gir hver verdi indeks i riktig rekkfølge
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

        if (n < 3)     // Må ha minst 3 verdier
        {
            throw new NoSuchElementException("Tabellen er ugyldig. Må ha minst 3 verdier");
        }

        int m = 0;              // Posisjonen til den minste verdien
        int nm = 1;             // Posisjonen til nest minste verdi
        int tm = 2;             // Posisjonen til den tredje minste verdi


        // Sjekker verdiene for å finne minsteverdi, nestminste og tredjeminste
        // Utfører byttinger for hver verdi som ikke tilfredstiller kravene
        // Får minsteverdi plassert først
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

    public static boolean inneholdt(String a, String b) {
        boolean status = true;

        Map<String,Integer> WordA=new HashMap<>();  // Lagrer informasjon om antall unike bookstaver og antall forekomster
        Map <String,Integer> WordB=new HashMap<>();  // Lagrer informasjon om antall unike bookstaver og antall forekomster

        for(char i:a.toCharArray()){                   // Looper gjennom første ordet A og lagrer unike bokstaver og antall forekomster i hashmap
            Integer valueA = WordA.get(""+i);
            if(valueA != null){
                WordA.put(""+i, valueA+1);
            } else {
                WordA.put(""+i, 1);
            }
        }

        for(char i: b.toCharArray()){               // Looper gjennom første ordet B og lagrer unike bokstaver og antall forekomster i hashmap
            Integer valueB = WordB.get(""+i);
            if(valueB != null){
                WordB.put(""+i, valueB+1);
            } else {
                WordB.put(""+i,1);
            }
        }

        for(Map.Entry <String,Integer> entry: WordA.entrySet()){            // 
            if (WordB.get(entry.getKey()) == null || entry.getValue() >
                    WordB.get(entry.getKey())) {
                status = false;
            }
        }
        return status;
    }







    public static void main(String[] args) {

            String gg = "abc";
            String f = "defghi";
            String d = "hi";
            String a = "lmnopqrstuv";
            String q = "";

        System.out.println(flett(gg,f,d,a,q));


    }
}
