package com.skilldistillery.filmquery.database;

import java.sql.DriverManager;

import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

  @Override
  public Film findFilmById(int filmId) {
    return null;
  }

  @Override
  public List<Actor> findActorsByFilmId(int filmId) {
	  List<Actor> actors = new ArrayList <> ();
	  
	  try {
		  Connection conn = DriverManager.getConnection(URL, user, pass);
		  String sql = "SELECT id, title, description, release_year, language_id,"
                  + " rental_duration, rental_rate, length, replacement_cost,"
			         + " rating, special_features "
               +"FROM film WHERE id = ?";
		  
	  }
  }
  
}
