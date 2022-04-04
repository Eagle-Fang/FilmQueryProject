package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		 app.test();
//		app.launch();
	}

  private void test() throws SQLException {
//    Film film = db.SearchById(1);
    SearchById(1); 
//    System.out.println(film);
    }

//	private void launch() throws SQLException {
//		Scanner input = new Scanner(System.in);
//		int choice = 0;
//		do {
//				startUserInterface();
//				choice = ValidateInt("Choice >>");
//				switch (choice) {
//				case 1: 
//						int searchId = ValidateInt("Movie ID >>");
//						SearchById(searchId);
//						break;
//			
//				case 2: 
//					System.out.println("Search >>");	
//					String query = input.nextLine();
//					SearchByTitleOrDescription(query);
//					break;
//
//				case 3: 
//					System.out.println("Goodbye.");
//					
//				default:
//					System.out.println("Please select a valid option.");
//					break;
//				}
//				input.nextLine();
//		} while (choice!=3);
//		input.close();
//	}


	private void startUserInterface() {
		System.out.println("Please select from the options below by typing a number:");
		System.out.println("1. Look up film by ID");
		System.out.println("2. Look up film by Keyword");
		System.out.println("3. Quit");
		System.out.println();
	}

	private void SearchByTitleOrDescription(String searchQuery) throws SQLException {
		List<Film> films = db.findFilmByKeyword(searchQuery);
		if (films == null || films.size() == 0) {
			System.out.println("There are no movies that match your search.");
		} else {
			for (Film f : films) {
				System.out.println("***************");
				System.out.println(f.toString());

			}
		}
	}
	
	private void SearchById (int id) throws SQLException {
		Film film = db.findFilmById(id);
		if (film != null) {
			System.out.println(film.toString());
		}  else {
			System.out.println("There are no movies with this id");
		}
		
	}


	private int ValidateInt (String prompt)  {
		Scanner scan = new Scanner(System.in);
		int userNum;
		while (true)  {
			System.out.println(prompt);
			try {
					userNum = scan.nextInt();
					break;
			} catch (Exception e)  {
					System.out.println("Invalid number");
					System.out.println();
					scan.nextLine();
			}
		}
		scan.nextLine();
		return userNum;
	}
  }


//boolean keepMenu = true;
//
//while(keepMenu)
//{
//
//	String userInput = input.nextLine();
//
//	Film newFilm = null;
//	List<Film> films = new ArrayList<>();
//	switch (userInput) {
//
//	case "1":
//		System.out.println("Enter film ID: ");
//		int filmID = input.nextInt();
//		System.out.println("Results: ");
//		newFilm = db.findFilmById(filmID);
//		if (newFilm != null) {
//			System.out.println(newFilm.toString());
//			input.nextLine();
//		} else {
//			input.nextLine();
//			System.out.println("There is no film associated with this ID.");
//		}
//
//		break;
//
//	case "2":
//		System.out.println("Enter search keyword: ");
//		String keyword = input.nextLine();
//		System.out.println("Results: ");
//		films = db.findFilmByKeyword(keyword);
//
//		if (films.isEmpty()) {
//			System.out.println("There is no film associated with this keyword.");
//		} else {
//			for (int i = 0; i < films.size(); i++) {
//				System.out.println(films.get(i).toString());
//			}
//		}
//		break;
//	case "3":
//		System.out.println("Goodbye");
//		keepMenu = false;
//		break;
//	default:
//		System.out.println("Invalid input, try again");
//		break;
//	}
//
//}


