import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MoviesList {

	public static void main(String[] args) {
		
		ArrayList<Movie> moviesList = new ArrayList<Movie>();
		
		Scanner scan = new Scanner(System.in);
		String option;
		String proceed = "yes";
		
		for(int i = 0; i < 100; i++){
			moviesList.add(MoviesIO.getMovie(i));
		}
	
		//sort code stolen from the internet
		Collections.sort(moviesList, new Comparator<Movie>(){
			public int compare (Movie m1, Movie m2){
				return m1.getTitle().compareToIgnoreCase(m2.getTitle());
			}
		});
		
		//prompt
		
		System.out.println("Welcome to the Movies List Application!");
		System.out.println("There are 100 movies in this list");
		do {
			System.out.print("What category are you interested in? ");
			option = scan.nextLine();
			
			for (Movie s : moviesList) {
				if (s.getCategory().equals(option)) {
					System.out.println(s.getTitle());
				}
			}
			
			System.out.print("\nContinue? (y/n): ");
			proceed = scan.nextLine();
			System.out.println();
			
		} while (Character.toLowerCase(proceed.charAt(0)) == 'y');
		System.out.println("Goodbye");
		scan.close();
		
	}


}


