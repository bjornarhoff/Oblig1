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




    public static void main(String[] args) {
        int [] a = randPerm(10);  // Lager en tilfeldig tabell
        skriv(a);                   // Skriver ut tabellen før bytte
        maks(a);                    // Utfører metoden maks og flytter største tall til a[n]
        System.out.println("Den maksimale verdi er: " + a[a.length-1] + "\n"); // Skriver ut største verdi i tabellen a
        //skriv(a);                                                           // Skriver ut tabellen på nytt, der største tall ligger i a[n]. Kommenter vekk maks(a) for å få en helt tilfeldig tabell.
        //System.out.println("Antall ombytninger er: " + ombytninger(a) + "\n"); // Skriver ut antall ombytninger som er utført


    }
}
