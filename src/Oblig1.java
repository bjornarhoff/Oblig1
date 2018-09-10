import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {


    public static void skriv (int [] a)         //Skriver ut tabellen
    {
        System.out.println("Tabellen er nå: ");
        for (int item:a)
        {
            System.out.print(item + ", ");
        }
        System.out.println("\n");
    }

    public static int[] randPerm(int n)         //Lager en tilfeldig permutasjon av tabellen
    {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i +1);

        for(int k = n -1; k > 0; k--)
        {
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }
        return a;
    }

    public static void bytt(int [] a, int x, int y)     // Bytter om to verdier, x og y, i tabllen a
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    // Det blir gjort (n-1) sammenligninger
    public static int maks(int [] a)                // Sammenligner to nærliggende verdier og om den til venstre er størst, bytter plass
    {

    if (a == null)
    {
    throw new NoSuchElementException("Tabellen er tom"); // Kaster en feilmelding om tabellen er tom
    }

    for (int i = 0; i < a.length -1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en større en siste index
    {

        if(a[i]> a[i+1])
        {
            // Det blir gjort flest ombytninger når tabellen er sortert i synkende rekkefølge
            // Det blir gjort færrest ombytninger når tabellen er sortert i stigende rekkefølge
            bytt(a,i, i+1);
            System.out.println("Bytter om " + a[i] + " og " + a[i+1] + "\n");
        }
    }
        return a[a.length-1];
    }


    // Vi kan finne gjennomsnittet av antall ombytninger ved å summere antall ombytninger delt på antall kjøringer.
    // Ved 10 kjøringer av metoden, med et array med lengde 10, ble det i gjennomsnitt 7,3 ombytninger.
    /**  Kan  du  på  grunnlag  av  dette  si  om  metodenmakser  bedre  (eller dårligere) enn de maks-metodene vi har sett på tidligere? */
    public static int ombytninger(int [] a)
    {
        if (a == null)
        {
            throw new NoSuchElementException("Tabellen er tom"); // Kaster en feilmelding om tabellen er tom
        }

        int antOmbytninger=0;
        for (int i = 0; i < a.length -1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en større en siste index
        {

            if(a[i]> a[i+1])
            {
                // Det blir gjort flest ombytninger når tabellen er sortert i synkende rekkefølge
                // Det blir gjort færrest ombytninger når tabellen er sortert i stigende rekkefølge
                bytt(a,i, i+1);
                antOmbytninger++;   // Teller antall ombytninger
                System.out.println("Bytter om " + a[i] + " og " + a[i+1] + "\n");
            }
        }
        return antOmbytninger;
    }



                                    // OPPGAVE 2

    public static int antallUlikeSortert(int [] a) {
        int teller=1;                                  // Teller satt til 1 fordi første verdi vil alltid være unik
        for (int i = 0; i < a.length - 1; i++) {        // Looper gjennom lengden på tabellen
            if (a[i] > a[i + 1]) {                      // Sjekker om tabellen er sortert
                throw new IllegalStateException("Tabellen er ikke sortert" + "\n");     // Gir tilbakemelding om den ikke er sortert
            }
            if (a.length == 0) {        // Sjekker om tabellen er tom, hvis den er tom returner den 0
                return 0;
            }
            for(i=0;i<a.length-1;i++)          // Looper igjennom tabellen
            {
                if(a[i]!=a[i+1])               // Sjekker om to nærliggende verdier er ulik
                {
                    teller++;                   // Om de er ulik, øker telleren med 1
                }
            }

        } return teller;
    }

    // Metode som lager en tilfeldig tabell med tilfeldige verdier
    public static int[] randomArray(int a)
    {
        int[] list = new int[a];            // Lager en liste med størrelse 'a'
         for (int i=0; i<a; i++)            // Looper gjennom lengden på tabellen
        {
            int n = (int)(Math.random()*9 + 1); // Oppretter tilfeldige verdier
            list[i] = n;                        // Setter verdiene inn i tabellen

            System.out.print(list[i] + ", ");
        }
        System.out.println("\n");
        return list;                        // Returner tabellen
    }



    
    public static void bubbleSort(int [] a)
    {
        for (int n = a.length; n > 1; n--) // For å vite antallet ganger løkken skal kjøre
        {
            for (int i=1; i<n; i++)        // Kjøre om i er mindre enn antallet
            {
                if (a[i-1]>a[i])           // Sjekker om verdien foran er større enn neste
                {
                    bytt(a,i-1,i);      // Bytter plass om verdien er større
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

   public static int partition1(int arr[], int left, int right)
    {
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


   public static int partition(int a[], int v, int h, int skilleverdi)
   {
       while (true)
    {
        while (v<= h && a[h] % 2 < skilleverdi)
        {
            h--;

        }
        while (v<= h && a[v] % 2 >= skilleverdi)
        {
            v++;
        }
        if (v<h)
        {
            bytt(a,v++,h--);
        }
    else return v;
    }
   }



                                    // OPPGAVE 3
    public static int antallUlikeUSortert(int []a) {
        int different = 0;

        for (int i = 1; i < a.length; i++) {
            boolean same = false;
            for (int j=0; j<i; j++) {
                if (a[i] == a[j]) {
                    same = true;
                    break;
                }
                 }   if(!same) {
                    different++;
                    System.out.print(a[i] + ", ");
                }
            }
        return different;
    }


                                // OPPGAVE 4

    public static void delsortering(int [] a) {

        int partall = 0;
        int oddetall = 0;

        partition(a, 0, a.length - 1, 1);

        for (int i = 0; i < a.length; i++) {

            if (a[i] % 2 == 0) {
                partall = partall +1;
            }
            else
                {
                    oddetall = oddetall +1;
                }



    }
        System.out.println(Arrays.toString(a));
        quickSort(a,0,oddetall-1);
        quickSort(a,oddetall,a.length-1);
        System.out.println(Arrays.toString(a));

    }


                            // OPPGAVE 5

    public static void rotasjon(char[] a) {
        int n = a.length;
        int d = 1;

        if (n == 1) {
            return;
        }

        if ((d = d%n) < 0) {
            d += n;
        }

        char[] b = Arrays.copyOfRange(a, n - d, n);     // Oppretter en hjelpetabell

        for (int i = n - 1; i >= d; i--) {
            a[i] = a[i - d]; }                                 // Forskyver bokstavene en plass til høyre

            System.arraycopy(b, 0, a, 0, d);                      // Kopierer arrayet

    }





               
    public static void main(String[] args) {
                                        // OPPGAVE 1
        //int [] a = randPerm(10);  // Lager en tilfeldig tabell
        //skriv(a);                   // Skriver ut tabellen før bytte
        //maks(a);                    // Utfører metoden maks og flytter største tall til a[n]
        //System.out.println("Den maksimale verdi er: " + a[a.length-1] + "\n"); // Skriver ut største verdi i tabellen a
        //skriv(a);                                                           // Skriver ut tabellen på nytt, der største tall ligger i a[n]. Kommenter vekk maks(a) for å få en helt tilfeldig tabell.
        //System.out.println("Antall ombytninger er: " + ombytninger(a) + "\n"); // Skriver ut antall ombytninger som er utført



                                        // OPPGAVE 2
/**
        int [] c = randomArray(10);      // Oppretter en tabell med tilfeldige tall
        quickSort(c,0,c.length-1);                      // Sorterer tabellen
        skriv(c);                           // Skriver ut den sorterte tabellen
        System.out.println("Antall: " + antallUlikeSortert(c));     // Skriver ut antall ulike verdier i tabellen */


                                        // OPPGAVE 3
        //int [] c = {1,2,1,3,5,2,1,1,6};
        //System.out.println("\n"+"Antall ulike verdier i tabellen er:  " + antallUlikeUSortert(c));


                                        // OPPGAVE 4

        // delsortering(randomArray(10));


                                        // OPPGAVE 5

        char [] a = {'N','L','B','D','F'};
        System.out.println(Arrays.toString(a));
        rotasjon(a);
        System.out.println(Arrays.toString(a));







    }
}
