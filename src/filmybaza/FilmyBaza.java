package filmybaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FilmyBaza {
	public static Connection connection = null;
	public static Statement st = null;
	public static ResultSet rs = null;

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Nie znaleziono drivera Postgresa");
			e.printStackTrace();
			return;
		}
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/SDA", "postgres", "postgres");
		} catch (SQLException e) {
			System.err.println("Blad polaczenia do bazy danych");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("Polaczenie udane.");
		} else {
			System.err.println("Polaczenie nieudane!");
		}
		System.out.println("Witaj w BazieFilmow.");
		FilmyBaza.showMenu();
		Scanner sc = new Scanner(System.in);
		Integer option = 0;
		do {
			try{
			option = sc.nextInt();
			}
			catch(InputMismatchException e){
				break;
			}
			sc.nextLine();
		} while (option.equals(null) || option < 1 || option > 7);

		switch (option) {
		case 1: {

		}
		case 2: {
			showFilm();
		}
		case 3: {

		}
		case 4: {

		}
		case 5: {

		}
		case 6: {

		}
		case 7: {

		}
		default: {
			System.out.println("Nie wybrales poprawnej opcji!");
		}

		}
	}

	public static void showMenu() {
		System.out.println("Wybierz opcje:");
		System.out.println("1 - Rejestracja u¿ytkownika");
		System.out.println("2 - Wyszukanie filmu");
		System.out.println("3 - Pobranie filmu");
		System.out.println("4 - Wyœwietl pobrane filmy");
		System.out.println("5 - Wyszukanie klienta");
		System.out.println("6 - Zmiana imienia i nazwiska dla podaengo klienta (podane ID)");
		System.out.println("7 - Skasowanie u¿ytkownika");
	};
	public static void showFilm() {
		Scanner sc1 = new Scanner(System.in);
		String title = sc1.nextLine();
		PreparedStatement st = null;
		try {
			String sql = "SELECT * FROM filmy.film f WHERE f.tytul LIKE ?";
			st = connection.prepareStatement(sql);
			st.setString(1, title+"%");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        try {
			while (rs.next()) {
			    try {
					System.out.println(rs.getString(2));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}