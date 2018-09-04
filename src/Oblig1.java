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
        }
        return a;
    }

    public static void bytt(int [] a, int x, int y)     // Bytter om to verdier, x og y, i tabllen a
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static int maks(int [] a)                // Sammenligner to nærliggende verdier og om den til venstre er størst, bytter plass
    {

    if (a == null)
    {
    throw new NoSuchElementException();
    }

    for (int i = 0; i < a.length -1; i++)           // Bruker a.length -1 fordi antall verdier i arrayet er en større en siste index
    {

        if(a[i]> a[i+1])
        {
            bytt(a,i, i+1);
            System.out.println("Bytter om " + a[i] + " og " + a[i+1] + "\n");
        }
    }
        return a[a.length-1];
    }


    public static void main(String[] args) {
        int [] a = {1,7,9,3,6,2};
        skriv(a);
        maks(a);
        System.out.println("Den maksimale verdi er: " + a[a.length-1] + "\n");
        skriv(a);



    }
}
