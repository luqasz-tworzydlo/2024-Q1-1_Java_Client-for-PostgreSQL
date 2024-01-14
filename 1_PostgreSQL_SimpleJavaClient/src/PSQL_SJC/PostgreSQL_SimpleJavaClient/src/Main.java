import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

//////////////////////////////////////////////////
//
// => Imię i nazwisko: Łukasz Tworzydło
// => Numer albumu: gd29623
// => Nr. kierunku: INIS5_PR2
// => Przedmiot: Zaawansowane technologie bazodanowe
//
//////////////////////////////////////////////////
// [prosta aplikacja do łączenia się z bazą danych]
//////////////////////////////////////////////////
//
// Łukasz Tworzydło - nr albumu: gd29623
//
//////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        // dane użytkownika dotyczące bazy danych
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n=> Wprowadź nazwę bazy danych | Enter database name: ");
        String dbName = scanner.nextLine();
        System.out.print("=> Wprowadź nazwę użytkownika | Enter username: ");
        String user = scanner.nextLine();
        System.out.print("=> Wprowadź hasło użytkownika | Enter password: ");
        String password = scanner.nextLine();
        System.out.print("=> Wprowadź adres IP serwera | Enter host IP: ");
        String host = scanner.nextLine();
        System.out.print("=> Wprowadź numer portu | Enter port: ");
        String port = scanner.nextLine();

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("\n[PL]Pomyślnie połączono z bazą danych PostgreSQL! ^_^\n" +
                    "\n[ENG] Successfully connected to the database! ^_^");

            connection.close();
        } catch (Exception e) {
            System.out.println("\n[PL] Wystąpił błąd poczas łączenia się z bazą danych!" +
                    "\nSprawdź dane dla serwera PostgreSQL i spróbuj ponownie...\n" +
                    "\n[ENG] An error occurred while connecting to the database!" +
                    "\nCheck the data for the PostgreSQL i try again...\n" + e.getMessage());
        }

        scanner.close();
    }
}
