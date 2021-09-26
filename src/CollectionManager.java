import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager
{
    public static void exitManager()
    {
        System.out.println("Collection Manager terminated.");
        System.exit(0);
    }

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
