import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
    public static void exitManager()
    {
        System.out.println("Collection Manager terminated");
        System.exit(0);
    }

    public boolean parseTokens(StringTokenizer strTokens, Collection userCollection)
    {
        switch (strTokens.nextToken())
        {
            case "A":
                Album newAlbum = new Album(strTokens.nextToken(), strTokens.nextToken(), Genre.toGenre(strTokens.nextToken()),
                        new Date(strTokens.nextToken()), true);
                if (userCollection.add(newAlbum)) System.out.println(newAlbum.toString() + " >> added.");
                else System.out.println(newAlbum.toString() + " >> is already in the collection");
                break;
            case "D":
                Album deleteAlbum = new Album(strTokens.nextToken(), strTokens.nextToken());
                if (userCollection.remove(deleteAlbum)) System.out.println(deleteAlbum.toString() + " >> deleted");
                break;
            default: return false;
        }
        return true;
    }

    public void run()
    {
        Collection userCollection = new Collection();
        System.out.println("Collection Manager starts running");
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
