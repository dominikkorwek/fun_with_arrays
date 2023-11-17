import java.util.Random;

class Tablica_jednowymiarowa{
    private final int n;      //ilosc liczb w tablicy
    private final int[] T;    //tablica
    public Tablica_jednowymiarowa(int n){   //tworzenie tablicy

        this.n = n;
        this.T = new int[n];
    }
    public void random(){                   //uzupelnianie tablicy losowymi liczbami

        Random generator = new Random();

        for(int i=0;i<n;i++)
            T[i] = generator.nextInt(n);
    }
    public void write(){                    //wypisywanie liczb od poczatku

        System.out.print("liczby od poczatku: {");              //na poczatku wypisuje otwarcie zboru jako {

        for (int i=0;i<n;i++) {
            System.out.print(T[i]);         //wypisuje liczby z tablicy

            if (i < n - 1)
                System.out.print(",");      //jezeli liczba nie jest ostatnia to dopisuje przecinek ,aby dopisac kolejna liczbe
        }
        System.out.println("}");            //na koncu zamyka zbior jako }
    }
    public void write_reverse(){            //wypisywanie liczb od konca

        System.out.print("liczby od konca: {");              //na poczatku wypisuje otwarcie zboru jako {

        for (int i=0;i<n;i++) {
            System.out.print(T[n-i-1]);     //wypisuje liczby z tablicy

            if (i < n - 1)
                System.out.print(",");      //jezeli liczba nie jest ostatnia to dopisuje przecinek ,aby dopisac kolejna liczbe
        }
        System.out.println("}");            //na koncu zamyka zbior jako }
    }
    private static void sortowanie(int [] A,int lewy, int prawy){

        int i=lewy, j = prawy;                  //skrajne elementy
        int srodek = A[(lewy+prawy)/2];         //pivot

        do{                                     //szukanie elementu do zmiany
            while(A[i]<srodek) i++;             //wyszukiwanie liczby wiekszej  niz srodek
            while (srodek<A[j]) j--;            //wyszukiwanie liczby mniejszej niz srodek

            if(i<=j) {                          //jezeli para spelnia warunki to zamiana miejsc w tablicy
                int a = A[i];   A[i] = A[j];    A[j] = a;
                i++;    j--;
            }
        }while(i<=j);

        if(lewy<j) sortowanie(A,lewy,j);    //nastepne podciagi
        if(i<prawy) sortowanie(A,i,prawy);
    }
    public void max(){                      //wypisanie najwiekszej wartosci

        int[] A = new int[n];                               //stworzenie tablicy pomocniczej
        System.arraycopy(T, 0, A, 0, n);    //przepisanie wartosci z T do A
        sortowanie(A,0,n-1);                   //posortowanie tablicy
        System.out.println("maksymalna wartosc to: "+A[n-1]);
    }
    public void min(){                      //wypisanie najwiekszej wartosci

        int[] A = new int[n];                               //stworzenie tablicy pomocniczej
        System.arraycopy(T, 0, A, 0, n);     //przepisanie wartosci z T do A
        sortowanie(A,0,n-1);                    //posortowanie tablicy
        System.out.println("minimalna wartosc to: "+A[0]);
    }
    private int[] wyznaczanie(int k){   //metoda sluzy do wyznaczania tablic parzystych i nieparzystych

        int ilosc=0;                    //ilosc oznacza ilosc liczb, ktore beda w tabicy

        for(int i=0;i<n;i++)

            if(T[i]%2==k)               //jezeli znajdziemy liczbe to ilosc sie zwieksza o jeden
                ilosc++;

        int[] A = new int[ilosc];       //tworzenie tablicy
        ilosc=0;

        for(int i=0;i<n;i++)

            if(T[i]%2==k){
                A[ilosc]=T[i];          //jezeli znajdziemy liczbe to jest ona dodawana do tablicy
                ilosc++;
            }
        sortowanie(A,0,A.length-1);                  //sortowanie tablicy
        return A;
    }
    public int[] parzyste(){
        return wyznaczanie(0);
    }
    public int[] nieparzyste(){
        return wyznaczanie(1);
    }
}


public class zad1 {
    public static void main(String[] args) {
        int n= 10;
        Tablica_jednowymiarowa T = new Tablica_jednowymiarowa(n);
        T.random();
        T.write();
        T.write_reverse();
        T.max();
        T.min();

        int [] A = T.parzyste();
        System.out.print("\nliczby parzyste uporzadkowane: ");

        for (int j : A)
            System.out.print(j + " ");

        int [] B = T.nieparzyste();
        System.out.print("\nliczby nieparzyste uporzadkowane: ");

        for (int j : B)
            System.out.print(j + " ");

        System.out.println("\n");
        T.write();
    }
}