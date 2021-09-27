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
                String title = strTokens.nextToken();
                String artist = strTokens.nextToken();
                Genre genre = Genre.toGenre(strTokens.nextToken());
                Date releaseDate = new Date(strTokens.nextToken());
                if (releaseDate.isValid() == false)
                {
                    System.out.println("Invalid Date!");
                    break;
                }

                Album newAlbum = new Album(title, artist, genre, releaseDate, true);
                if (userCollection.add(newAlbum)) System.out.println(newAlbum.toString() + " >> added.");
                else System.out.println(newAlbum.toString() + " >> is already in the collection.");
                break;

            case "D":
                Album deleteAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
                if (userCollection.remove(deleteAlbum)) System.out.println(deleteAlbum.toString() + " >> deleted.");
                else System.out.println(deleteAlbum.toString() + " >> is not in the collection.");
                break;

            case "L":
                Album lendAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
                if (userCollection.lendingOut(lendAlbum)) System.out.println(lendAlbum.toString() +
                        " >> lending out and set to not available.");
                else System.out.println(lendAlbum.toString() + " >> is not available.");
                break;

            case "R":
                Album returnAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
                if (userCollection.returnAlbum(returnAlbum)) System.out.println(returnAlbum.toString() +
                        " >> returning and set to available.");
                else System.out.println(returnAlbum.toString() + " >> return cannot be completed.");
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
