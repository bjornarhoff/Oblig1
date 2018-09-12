import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;

import java.util.*;

public class Oblig1 {


    public static void skriv(int[] a)         //Skriver ut tabellen
    {
        System.out.println("Tabellen er nå: ");
        for (int item : a) {
            System.out.print(item + ", ");
        }
       // System.out.println("\n");
    }

    public static int[] randPerm(int n)         //Lager en tilfeldig permutasjon av tabellen
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

    public static void bytt(int[] a, int x, int y)     // Bytter om to verdier, x og y, i tabllen a
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
                //System.out.println("Bytter om " + a[i] + " og " + a[i + 1] + "\n");
            }
        }
        return a[a.length - 1];
    }


    // Vi kan finne gjennomsnittet av antall ombytninger ved å summere antall ombytninger delt på antall kjøringer.
    // Ved 10 kjøringer av metoden, med et array med lengde 10, ble det i gjennomsnitt 7,3 ombytninger.

    /**
     * Kan  du  på  grunnlag  av  dette  si  om  metodenmakser  bedre  (eller dårligere) enn de maks-metodene vi har sett på tidligere?
     */
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
                //ƒSystem.out.println("Bytter om " + a[i] + " og " + a[i + 1] + "\n");
            }
        }
        return antOmbytninger;
    }


    // OPPGAVE 2

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

            //System.out.print(list[i] + ", ");
        }
        //System.out.println("\n");
        return list;                        // Returner tabellen
    }


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


    public static void quickSort(int a[], int left, int right) {

        int index = partition1(a, left, right);

        if (left < index - 1)

            quickSort(a, left, index - 1);

        if (index < right)

            quickSort(a, index, right);

    }

    public static int partition1(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }


    public static int partition(int a[], int v, int h, int skilleverdi) {
        while (true) {
            while (v <= h && a[h] % 2 < skilleverdi) {
                h--;

            }
            while (v <= h && a[v] % 2 >= skilleverdi) {
                v++;
            }
            if (v < h) {
                bytt(a, v++, h--);
            } else return v;
        }

    }


    // OPPGAVE 3
    public static int antallUlikeUsortert(int[] a) {
        int different = 0;

        for (int i = 0; i < a.length; i++) {
            boolean same = false;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    same = true;
                    break;
                }
            }
            if (!same) {
                different++;
                //System.out.print(a[i] + ", ");
            }
        }
        return different;
    }


    // OPPGAVE 4

    public static void delsortering(int[] a) {

        int partall=0;
        int oddetall=0;

        if(a.length == 0)
        {
            return;
        }

        partition(a, 0, a.length - 1,1);

        for (int i = 0; i < a.length; i++) {

            if(a[i] < 0) {
                a[i] = a[i] * -1;
            }
            if (Math.floorMod(a[i],2) == 0) {
                partall = partall + 1;
            }
             else {
                oddetall = oddetall + 1;
            }

        }

        //System.out.println(Arrays.toString(a));
        quickSort(a, 0, oddetall - 1);
        quickSort(a, oddetall, a.length - 1);
        // System.out.println(Arrays.toString(a));

    }


    // OPPGAVE 5

    public static void rotasjon(char[] a) {
        int n = a.length;
        int d = 1;

        if (n < 1) {
            return;
        }

        if ((d = d % n) < 0) {
            d += n;
        }

        char[] b = Arrays.copyOfRange(a, n - d, n);     // Oppretter en hjelpetabell

        for (int i = n - 1; i >= d; i--) {
            a[i] = a[i - d];
        }                                 // Forskyver bokstavene en plass til høyre

        System.arraycopy(b, 0, a, 0, d);                      // Kopierer arrayet

    }


    // OPPGAVE 6
    public static void rotasjon(char[] a, int k) {
        int n = a.length;

        if (n < 1) {
            return;
        }

        if ((k = k % n) < 0) {
            k += n;
        }

        char[] b = Arrays.copyOfRange(a, n - k, n);     // Oppretter en hjelpetabell

        for (int i = n - 1; i >= k; i--) {
            a[i] = a[i - k];
        }                                 // Forskyver bokstavene en plass til høyre

        System.arraycopy(b, 0, a, 0, k);                      // Kopierer arrayet

    }


                //OPPGAVE 7 a

    public static String flett(String a, String b){
        StringBuilder c = new StringBuilder();
        int i = 0;

        for(; i< a.length(); ++i){
            c.append(a.charAt(i));
            if(i < b.length()){
                c.append(b.charAt(i));
            }
        }
        if(i < b.length()){
            for(; i<b.length(); ++i){
                c.append(b.charAt(i));
            }
        }
        return c.toString();
    }

                    //OPPGAVE 7 b

    public static String flett(String... s)
    {
        if (s.length == 1)
        {
            return s[0];

        }

        StringBuilder c = new StringBuilder();
        int i = 0;

        for (; i<=c.length(); i++)
        {
            for (int j = 0; j<s.length; j++)
            {
                if(i < s[j].length()) {
                    c.append(s[j].charAt(i));
                }
            }
        }
        return c.toString();
    }







    //OPPGAVE 8

    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Ulovlig intervall");

        int f = fra;
        int minverdi = a[fra];

        for (int i = fra + 1; i < til; i++)
            if (a[i] < minverdi) {

                f = i; // Indeksen til minste verdi oppdateres
                minverdi = a[f]; // Minste verdi oppdateres
            }

        return f; // Returnerer minste verdi
    }


    // METODE FOR Å SORTERE INDEKS MED ULIKE VERDIER

    public static int[] indekssortering(int[] a) {
        int[] indekstabell = new int[a.length];
        int[] a_clone = a.clone();

        for (int i = 0; i < a.length; i++) {
            indekstabell[i] = i;
        }


        for (int i = 0; i < a.length - 1; i++) {
            int indeks = min(a_clone, i, a.length);
            bytt(a_clone, i, indeks);
            bytt(indekstabell, i, indeks);
        }


        return indekstabell;
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

        return new int[] {m,nm,tm};
    }



                        // OPPGAVE 10

    public static boolean inneholdt(String a, String b) {
        boolean status = true;

        Map<String,Integer> WordA=new HashMap<>();  //Lagrer informasjon om antall unike bookstaver og antall forekomster
        Map <String,Integer> WordB=new HashMap<>();  //Lagrer informasjon om antall unike bookstaver og antall forekomster

        for(char i:a.toCharArray()){                   //kjørere gjennom første ordet A og lagrer unique bokstaver og antall forekomster i hashmap
            Integer valueA = WordA.get(""+i);
            if(valueA != null){
                WordA.put(""+i, valueA+1);
            } else {
                WordA.put(""+i, 1);
            }
        }

        for(char i: b.toCharArray()){               //kjørere gjennom første ordet B og lagrer unique bokstaver og antall forekomster i hashmap
            Integer valueB = WordB.get(""+i);
            if(valueB != null){
                WordB.put(""+i, valueB+1);
            } else {
                WordB.put(""+i,1);
            }
        }

        for(Map.Entry <String,Integer> entry: WordA.entrySet()){            //han går gjennom første ordet sine
            if (WordB.get(entry.getKey()) == null || entry.getValue() >
                    WordB.get(entry.getKey())) {
                status = false;
            }
        }
        return status;
    }






    public static void main(String[] args) {
                                        // OPPGAVE 1
        //int [] a = randPerm(10);  // Lager en tilfeldig tabell
        //skriv(a);                   // Skriver ut tabellen før bytte
        //maks(a);                    // Utfører metoden maks og flytter største tall til a[n]
        //System.out.println("Den maksimale verdi er: " + a[a.length-1] + "\n"); // Skriver ut største verdi i tabellen a
        //skriv(a);                                                           // Skriver ut tabellen på nytt, der største tall ligger i a[n]. Kommenter vekk maks(a) for å få en helt tilfeldig tabell.
        //System.out.println("Antall ombytninger er: " + ombytninger(a) + "\n"); // Skriver ut antall ombytninger som er utført



          /*                              // OPPGAVE 2

        int [] c = randomArray(10);      // Oppretter en tabell med tilfeldige tall
        quickSort(c,0,c.length-1);                      // Sorterer tabellen
        skriv(c);                           // Skriver ut den sorterte tabellen
        System.out.println("Antall: " + antallUlikeSortert(c));     // Skriver ut antall ulike verdier i tabellen
*/

                                        // OPPGAVE 3
        //int [] c = {1,2,1,3,5,2,1,1,6};
        //System.out.println("\n"+"Antall ulike verdier i tabellen er:  " + antallUlikeUSortert(c));


                                        // OPPGAVE 4

         /*int [] v = {1,2,4,1,4,5};
          delsortering(v);
          skriv(v); */



                                        // OPPGAVE 5
/*
        char [] a = {'N','L','B','D','F'};
        System.out.println(Arrays.toString(a));
        rotasjon(a);
        System.out.println(Arrays.toString(a));



*/

            String gg = "abc";
            String f = "defghi";
            String d = "hi";
            String a = "lmnopqrstuv";
            String q = "";

        System.out.println(flett(gg,f,d,a,q));


    }
}
