import java.util.Random;

class Macierze{
    private final int n;
    private final double[][] A;
    private final double[][] B;
    public  Macierze(int n){    //tworzenie macierzy
        this.n = n;
        A = new double[n][n];   //tablice dwuwymiarowe reprezentujace macierze
        B = new double[n][n];

        Random rand = new Random();

        for(int i=0;i<n;i++)    //nadawanie macierzom liczb losowych

            for(int j=0;j<n;j++){
                A[i][j] = rand.nextDouble(2*n)-n;   //nadawanie liczb od -n do n gdzie
                B[i][j] = rand.nextDouble(2*n)-n;   //n to stopien tablicy
            }
    }
    public void write(){
        System.out.print("\nmacierz A:");

        for(int i=0;i<n;i++){               //wyspisywanie macierzy A
            System.out.println();           //po dojsciu do konca wierszu przechodzi do nastepnej tabelki

            for(int j=0;j<n;j++)
                System.out.print(A[i][j]+ "  ");//kolejne liczby w wierszu są oddzielane
        }

        System.out.print("\n\nmacierz B:");

        for(int i=0;i<n;i++){               //wyspisywanie macierzy B
            System.out.println();           //po dojsciu do konca wierszu przechodzi do nastepnej tabelki

            for(int j=0;j<n;j++)
                System.out.print(B[i][j]+ "   ");//kolejne liczby w wierszu są oddzielane
        }
    }
    public void suma(){
        System.out.print("\n\n suma macierzy A i B");

        for(int i=0;i<n;i++) {
            System.out.println();           //po dojsciu do konca wierszu przechodzi do nastepnej tabelki

            for (int j = 0; j < n; j++)      //liczenie sumy z definicji
                System.out.print((A[i][j] + B[i][j]) + "   ");//kolejne liczby w wierszu są oddzielane
        }
    }
    public void iloczyn(){
        System.out.print("\n\n iloczyn macierzy A i B");

        for(int i=0;i<n;i++) {
            System.out.println();           //po dojsciu do konca wierszu przechodzi do nastepnej tabelki

            for (int j = 0; j < n; j++){
                double liczba = 0;             //bedac w komorce zaczynamy liczenie

                for(int w=0;w<n;w++)        //zgodnie z definicja obliczamy iloczyn
                    liczba+=A[i][w]*B[w][j];

                System.out.print(liczba+"   ");//kolejne liczby w wierszu są oddzielane
            }
        }
    }
}

public class zad3 {
    public static void main(String[] args) {
        int n = 3;
        Macierze macierze = new Macierze(n);
        macierze.write();
        macierze.suma();
        macierze.iloczyn();
    }
}
