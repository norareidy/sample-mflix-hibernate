package com.mongodb;

import org.hibernate.Transaction;
import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {

		var sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// Read a document
		var searchTitle = "Little Women";
		var results = session.createQuery("from Movie m where m.title = :t", Movie.class)
				  .setParameter("t", searchTitle)
				  .getResultList();
		for (var m : results) {
			System.out.println("Movie: " + m.getTitle() + ", Year: " + m.getYear());
		}

        // Insert a document
		var title = "A Real Pain";
		var plot = "Mismatched cousins David and Benji tour Poland to honour their grandmother. " +
				"Their adventure becomes complicated as old tensions resurface while exploring their family history.";
		var year = 2024;
		var cast = new String[]{"Jesse Eisenberg", "Kieran Culkin", "Will Sharpe"};

		var movie = new Movie(title, plot, year, cast);
		session.persist(movie);
		System.out.println("Movie created with id = " + movie.getId());

		// Update a document
		var updatedCast = new String[]{"Jesse Eisenberg", "Kieran Culkin", "Will Sharpe", "Jennifer Grey"};
		movie.setCast(updatedCast);
		System.out.println("Movie updated with new cast member");

		// Delete a document
		session.remove(movie);
		System.out.println("Movie deleted with id = " + movie.getId());

		tx.commit();
		session.close();
		sf.close();
	}

}