package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		 app.test();
		app.launch();
	}
//
//	private void test() throws SQLException {
//		SearchByTitleOrDescription("TRAIN");
	// SearchById(3);

//	}

	private void launch() throws SQLException {
		startUserInterface();
	}

	private void startUserInterface() throws SQLException {
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		boolean flag = true;
		Film film;

		System.out.println("======= Film Database Search Main Menu  =======");
		System.out.println("Enter (1) to look up film by ID");
		System.out.println("Enter (2) to look up film by Keyword");
		System.out.println("Enter (3) to Quit");
		System.out.println("=========================================");

			while (flag) {
			System.out.println();
			System.out.println("Please select (1 - 3) >>");
			int choice = 0;
			try {
				choice = input2.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input mismatch, please enter (1 - 3) only");
				input2.reset();
				input2.next();
			}

			switch (choice) {
			case 1:
				System.out.println("Movie ID >>");
				film = db.findFilmById(input.nextInt());
				if (film == null) {
					System.out.println("There are no movies matching that ID.");
					System.out.println("Please search again.");
				} else {
					System.out.println(film.toString());
				}

				break;

			case 2:
				System.out.println("Enter search term >>");
				String query = input.nextLine();
				SearchByTitleOrDescription(query);
				break;

			case 3:
				System.out.println("Goodbye.");
				flag = false;
				break;

			default:
				System.out.println("Please enter a valid number (1 - 3).");
				break;
			}
			
		}
			while (flag);
		input.close();
		input2.close();
	}

	private void SearchByTitleOrDescription(String searchQuery) throws SQLException {
		List<Film> filmlist = db.findFilmByKeyword(searchQuery);
		if (filmlist == null || filmlist.size() == 0) {
			System.out.println("There are no movies that match your search.");
		} else {
			for (Film f : filmlist) {
				System.out.println("***************");
				System.out.println(f.toString());

			}
		}
	}

}
