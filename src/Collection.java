/**
 * The Collection class is the class that contains the array of all albums the user has added and not deleted. The
 * class contains methods is called by Collection Manager based on the user's command. The class contains methods
 * to create, change, and print the album array in several ways.
 */

public class Collection {
    private static final int ALBUM_INCREASE_SIZE = 4;
    private static final int NOT_FOUND = -1;

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    /**
     * Constructor method that initiates the collection instance by making the album array and the number of albums in
     * the collection
     */
    public Collection()
    {
        numAlbums = 0;
        albums = new Album[ALBUM_INCREASE_SIZE];
    }

    /**
     * Searches through the album array for the specified album by its title and author
     * @param album the target album
     * @return the index of the target album, or NOT_FOUND if it is not in the array
     */
    private int find(Album album)
    {
        for(int i = 0; i < albums.length; i++)
        {
            if (albums[i] != null && albums[i].equals(album)) return i;
        }
        return NOT_FOUND;
    } //find the album index, or return NOT_FOUND

    /**
     * Searches for the next empty element in the album array, if any exist
     * @return the empty element index, or NOT_FOUND if it is full
     */
    private int findNextEmpty()
    {
        for(int i = 0; i < albums.length; i++)
        {
            if (albums[i] == null) return i;
        }
        return NOT_FOUND;
    }

    /**
     * Grows the array by ALBUM_INCREASE_SIZE if the album is full
     */
    private void grow()
    {
        Album[] tempAlbums = new Album[albums.length];
        tempAlbums = albums;
        albums = new Album[tempAlbums.length + ALBUM_INCREASE_SIZE];
        for(int i = 0; i < tempAlbums.length; i++)
        {
            albums[i] = tempAlbums[i];
        }
    } //increase the capacity of the array list by 4

    /**
     * Adds an album to the collection, if it does not already exist in the album. Calls grow if the album is full, and
     * adds the album to the next empty element in the array
     * @param album the album to be added to the array
     * @return false if the album already exists in the album, true otherwise (it was added)
     */
    public boolean add(Album album)
    {
        if(find(album) >= 0) return false;
        int indexOfNewAlbum = findNextEmpty();
        if (indexOfNewAlbum < 0)
        {
            indexOfNewAlbum = numAlbums;
            grow();
        }
        numAlbums++;
        albums[indexOfNewAlbum] = album;
        return true;
    }

    /**
     * Removes the specified album from the array, unless the album does not exist in the collection.
     * @param album the album to be deleted
     * @return false if the album does not already exist in the collection, true otherwise (it was deleted)
     */
    public boolean remove(Album album)
    {
        int indexOfDeletion = find(album);
        if (indexOfDeletion < 0) return false;
        numAlbums--;
        albums[indexOfDeletion] = null;
        return true;
    }

    public boolean lendingOut(Album album)
    {
        int indexToLend = find(album);
        if (indexToLend < 0) return false;
        if(albums[indexToLend].changeAvailability(false) == false) return false;
        return true;
    } //set to not available

    public boolean returnAlbum(Album album)
    {
        int indexToReturn = find(album);
        if(indexToReturn < 0) return false;
        if(albums[indexToReturn].changeAvailability(true) == false) return false;
        return true;
    } //set to available

    public void print()
    {
        if(numAlbums <= 0)
        {
            System.out.println("The collection is empty!");
            return;
        }

        System.out.println("*List of albums in the collection.");
        for(int i = 0; i < albums.length; i++)
        {
            if (albums[i] != null) System.out.println(albums[i]);
        }
        System.out.println("*End of list");
    } //display the list without specifying the order

    public static int[] arrSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                int temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    private boolean checkArray(int[] arr, int key)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == key) return true;
        }
        return false;
    }

    private int[] genDateArray()
    {
        int[] tempArr = new int[numAlbums];
        int arrIndex = 0;

        for (int i = 0; i < albums.length; i++)
        {
            if (albums[i] != null && !checkArray(tempArr, albums[i].getDate()))
            {
                tempArr[arrIndex] = albums[i].getDate();
                arrIndex++;
            }
        }

        tempArr = arrSort(tempArr);

        return tempArr;
    }

    public void printByReleaseDate()
    {
        if (numAlbums <= 0)
        {
            System.out.println("The collection is empty!");
            return;
        }

        int[] releaseDates = genDateArray();

        System.out.println("*List of albums in the collection.");
        for (int i = 0; i < releaseDates.length; i++)
        {
            if (releaseDates[i] == 0) continue;

            for (int j = 0; j < albums.length; j++)
            {
                if (albums[j] != null && albums[j].getDate() == releaseDates[i]) System.out.println(albums[j]);
            }
        }
        System.out.println("*End of list");

    }

    public void printByGenre()
    {
        if(numAlbums <= 0)
        {
            System.out.println("The collection is empty!");
            return;
        }

        System.out.println("*List of albums in the collection.");
        for (int i = 0; i < Genre.numGenres; i++)
        {
            for (int j = 0; j < albums.length; j++)
            {
                if (albums[j] != null && albums[j].getGenreIndex() == i) System.out.println(albums[j]);
            }
        }
        System.out.println("*End of list");
    }
}