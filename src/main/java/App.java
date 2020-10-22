import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String hotelName = "Overlook";
        int systemVersion = 2;
        boolean isDeveloperVersion = true;

        showSystemInfo(hotelName, systemVersion, isDeveloperVersion);

        Scanner input = new Scanner(System.in);

        try {
            performAction(input);
        } catch (WrongOptionException | OnlyNumberException e) {
            System.out.println("Wystapił niespodzewany bład");
            System.out.println("kod bledu : " + e.getCode());
            System.out.println("Komunikat bledu : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystapił niespodzewany bład");
            System.out.println("Nieznany kod bledu");
            System.out.println("Komunikat bledu : " + e.getMessage());
        }finally {
            System.out.println("Wychodze z aplikacji");
        }


    }

    private static void performAction(Scanner input) {
        int option = showMenu(input);

        if (option == 1) {
            Guest newGuest = createNewGuest(input);
        } else if (option == 2) {
            Room newRoom = createNewRoom(input);
        } else if (option == 3) {
            System.out.println("Wybrano opcje: 3 ");
        } else throw new WrongOptionException("Wrong option in main menu");
    }

    public static void showSystemInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {
        System.out.println("Witam w systemie rezerwacji dla hotelu : " + hotelName);
        System.out.println("Aktualna wersja systemu : " + systemVersion);
        System.out.println("Wersja developerska : " + isDeveloperVersion);
        System.out.println("\n===================================\n");
    }

    public static Room createNewRoom(Scanner input) {

        try {
            System.out.print("Podaj nr pokoju : ");
            int number = input.nextInt();
            System.out.print("podaj ilosc ludzek : ");
            BedType[] beds = chooseBedType(input);
            Room room = new Room(number, beds);
            System.out.println(room.getInfo());
            return room;

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use number when creating new room");
        }
    }

    private static Guest createNewGuest(Scanner input) {
        try {
            System.out.print("Podaj Imie : ");
            String name = input.next();
            System.out.print("Podaj nazwisko : ");
            String lastName = input.next();
            System.out.print("Podaj wiek : ");
            int age = input.nextInt();
            System.out.println("Podaj plec : \n1. Men\n2. Women");
            Gender gender = chooseGender(input);
            Guest newGuest = new Guest(name, lastName, age, gender);
            System.out.println(newGuest.getInfo());
            return newGuest;
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers when choosing gender");
        }
    }

    private static int showMenu(Scanner input) {
        System.out.println("1. Dodaj nowego gościa");
        System.out.println("2. Dodaj nowy pokuj");
        System.out.println("3. Znajdz goscia");
        System.out.println("Wybierz opcje");
        int option;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only number in main menu");
        }
        return option;
    }

    private static BedType[] chooseBedType(Scanner input) {

        int size = input.nextInt();
        BedType[] beds = new BedType[size];
        for (int i = 0; i < beds.length; i++) {
            System.out.print("""
                    Podaj typ luzka\s
                    1. Single\s
                    2. Double
                    3. King Size
                    """);
            int j = input.nextInt();
            if (j == 1) {
                beds[i] = BedType.SINGLE;
            } else if (j == 2) {
                beds[i] = BedType.DOUBLE;
            } else if (j == 3) {
                beds[i] = BedType.KING_SIZE;
            } else throw new OnlyNumberException("Wrong option in bed type");

        }


        return beds;
    }

    private static Gender chooseGender(Scanner info) {
        int i = info.nextInt();
        Gender gender;
        if (i == 1) {
            gender = Gender.MEN;
        } else if (i == 2) {
            gender = Gender.WOMEN;
        } else throw new OnlyNumberException("Wrong option in gender selection");
        return gender;
    }
}
