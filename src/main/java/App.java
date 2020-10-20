import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String hotelName = "Overlook";
        int systemVersion = 2;
        boolean isDeveloperVersion = true;
        Scanner input = new Scanner(System.in);
        int option ;

        System.out.print("Witam w systemie rezerwacji dla hotelu : ");
        System.out.println(hotelName);
        System.out.print("Aktualna wersja systemu : ");
        System.out.println(systemVersion);
        System.out.println("Wersja developerska : ");
        System.out.println(isDeveloperVersion);

        System.out.println("\n===================================\n");

        System.out.println("1. Dodaj nowego gościa");
        System.out.println("2. Dodaj nowy pokuj");
        System.out.println("3. Znajdx goscia");
        System.out.println("Wybierz opcje");


        try{
            option = input.nextInt();
        }catch (Exception e){
            System.out.println("Niepoprawne dane wejsciowe, wybierz liczbe");
            System.err.println(e.getMessage());
            e.printStackTrace();
            option=0;
        }

        if (option==1){
            System.out.println("Tworzymy nowego goscia");
            Guest newGuest = new Guest();

        }else if(option ==2){
            System.out.println("Wybrana opcja: 2");
        }else if (option==3){
            System.out.println("Wybrano opcje: 3 ");
        }else System.out.println("Wybrano nieprawidlowo");


    }
}
