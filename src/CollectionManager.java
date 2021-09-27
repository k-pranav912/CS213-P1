/**
 * The Collection Manager class, which runs a while loop that takes command line inputs using the Scanner class, parses
 * them using the String Tokenizer class for valid commands to make changes to the album collection until the user runs
 * the quit command.
 * @author Saipranav Kalapala, Neel Prabhu
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager
{
    /**
     * Exits the process. Called when the user enters "Q"
     */
    public static void exitManager()
    {
        System.out.println("Collection Manager terminated.");
        System.exit(0);
    }

    /**
     * Creates and adds the user inputted album to the collection, if the date is valid and it is not
     * already in the collection
     * @param strTokens tokenized string of user input, starting after the command
     * @param userCollection the user's collection of albums
     */
    private void addToCollection(StringTokenizer strTokens, Collection userCollection)
    {
        String title = strTokens.nextToken();
        String artist = strTokens.nextToken();
        Genre genre = Genre.toGenre(strTokens.nextToken());
        Date releaseDate = new Date(strTokens.nextToken());

        if (releaseDate.isValid() == false)
        {
            System.out.println("Invalid Date!");
            return;
        }

        Album newAlbum = new Album(title, artist, genre, releaseDate, true);
        if (userCollection.add(newAlbum)) System.out.println(newAlbum.toString() + " >> added.");
        else System.out.println(newAlbum.toString() + " >> is already in the collection.");
    }

    /**
     * Deletes the user inputted album from the collection, if it exists in the collection
     * @param strTokens tokenized string of user input, starting after the command
     * @param userCollection the user's collection of albums
     */
    private void deleteFromCollection(StringTokenizer strTokens, Collection userCollection)
    {
        Album deleteAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
        if (userCollection.remove(deleteAlbum)) System.out.println(deleteAlbum.toString() + " >> deleted.");
        else System.out.println(deleteAlbum.toString() + " >> is not in the collection.");
    }

    /**
     * Lends the user inputted album from the collection, if available
     * @param strTokens tokenized string of user input, starting after the command
     * @param userCollection the user's collection of albums
     */
    private void lendFromCollection(StringTokenizer strTokens, Collection userCollection)
    {
        Album lendAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
        if (userCollection.lendingOut(lendAlbum)) System.out.println(lendAlbum.toString() +
                " >> lending out and set to not available.");
        else System.out.println(lendAlbum.toString() + " >> is not available.");
    }

    /**
     * Returns the user inputted album to the collection, if it was unavailable
     * @param strTokens tokenized string of user input, starting after the command
     * @param userCollection the user's collection of albums
     */
    private void returnToCollection(StringTokenizer strTokens, Collection userCollection)
    {
        Album returnAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
        if (userCollection.returnAlbum(returnAlbum)) System.out.println(returnAlbum.toString() +
                " >> returning and set to available.");
        else System.out.println(returnAlbum.toString() + " >> return cannot be completed.");
    }

    /**
     * Parses through the string the user inputted and calls the appropriate command from the collection class, sending
     * a newly made album that the user specified if necessary to be added, deleted, lent, or returned.
     * @param strTokens the tokenized string, by commas, the user inputted
     * @param userCollection the collection of albums for this user
     * @return false if the user entered an invalid command, true otherwise
     */
    public boolean parseTokens(StringTokenizer strTokens, Collection userCollection)
    {
        if(strTokens.hasMoreTokens() == false) return false;
        switch (strTokens.nextToken())
        {
            case "A":
                addToCollection(strTokens, userCollection);
                break;
            case "D":
                deleteFromCollection(strTokens, userCollection);
                break;
            case "L":
                lendFromCollection(strTokens, userCollection);
                break;
            case "R":
                returnToCollection(strTokens, userCollection);
                break;
            case "P":
                userCollection.print();
                break;
            case "PD":
                userCollection.printByReleaseDate();
                break;
            case "PG":
                userCollection.printByGenre();
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * The method called by RunProject1 that continuously runs in a while loop, taking in user inputs and calls
     * parseTokens for every line entered, until the user quits using "Q"
     */
    public void run()
    {
        Collection userCollection = new Collection();
        System.out.println("Collection Manager starts running.");
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            String input = sc.nextLine();
            if (input.equals("Q")) exitManager();
            StringTokenizer strTokens = new StringTokenizer(input, ",");

            if (parseTokens(strTokens, userCollection) == false) System.out.println("Invalid command!");
        }
    }
}
