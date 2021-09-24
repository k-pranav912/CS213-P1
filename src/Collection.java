public class Collection {
    private static final int ALBUM_INCREASE_SIZE = 4;
    private static final int NOT_FOUND = -1;

    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    public Collection()
    {
        numAlbums = 0;
        albums = new Album[ALBUM_INCREASE_SIZE];
    }

    private int find(Album album) {
        for(int i = 0; i < albums.length; i++)
        {
            if (albums[i] != null && albums[i].equals(album)) return i;
        }
        return NOT_FOUND;
    } //find the album index, or return NOT_FOUND

    private int findNextEmpty()
    {
        for(int i = 0; i < albums.length; i++)
        {
            if (albums[i] == null) return i;
        }
        return NOT_FOUND;
    }
    private void grow() {
        Album[] tempAlbums = new Album[albums.length];
        tempAlbums = albums;
        albums = new Album[tempAlbums.length + ALBUM_INCREASE_SIZE];
        for(int i = 0; i < tempAlbums.length; i++)
        {
            albums[i] = tempAlbums[i];
        }
    } //increase the capacity of the array list by 4

    public boolean add(Album album) {
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

    public boolean remove(Album album) {
        int indexOfDeletion = find(album);
        if (indexOfDeletion < 0) return false;
        numAlbums--;
        albums[indexOfDeletion] = null;
        return true;
    }

    public boolean lendingOut(Album album) {
        int indexToLend = find(album);
        if (indexToLend < 0) return false;
        if(albums[indexToLend].changeAvailability(false) == false) return false;
        return true;
    } //set to not available

    public boolean returnAlbum(Album album) {
        int indexToReturn = find(album);
        if(indexToReturn < 0) return false;
        if(albums[indexToReturn].changeAvailability(true) == false) return false;
        return true;
    } //set to available

    public void print() {
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
        System.out.println("*End of List");
    } //display the list without specifying the order

    public void printByReleaseDate() {
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
        System.out.println("*End of List");
    }
}