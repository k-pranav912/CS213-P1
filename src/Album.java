/**
 * Album Class, which handles the implementation of an Album system.
 * Each album instance contains the title, artist info, genre, date of release, and
 * whether the album is available to be borrowed.
 * @author Neel Prabhu, Saipranav Kalapala
 */
public class Album
{
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     * Constructor method which creates an Album instance
     * @param title Name of the album; is a String
     * @param artist Name of the artist; is a String
     * @param genre Name of the Genre; is a Genre instance
     * @param releaseDate Date of release; is a Date instance
     * @param isAvailable whether the title is available to be borrowed; boolean
     */
    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    /**
     * Helper constructor that creates an Album instance with just the title and artist info.
     * Used to compare albums for lend, compare, and return methods.
     * @param title Name of the album; is a String
     * @param artist Name of the artist; is a String
     */
    public Album(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Method to get the Index of the Genre of the Album.
     * Used for printing albums by genre.
     * @return Integer; index of Genre
     */
    public int getGenreIndex()
    {
        return this.genre.toIndex();
    }

    /**
     *  Checks and changes the instance variable isAvailable;
     * @param newValue boolean; true or false.
     * @return returns false if availability is the same as input,
     * else changes availability to input value and returns true
     */
    public boolean changeAvailability(boolean newValue)
    {
        if (isAvailable == newValue) return false;
        isAvailable = newValue;
        return true;
    }

    /**
     * Method to check whether two instances of Album are the same.
     * Checked based on artist name and title.
     * @param object Album instance.
     * @return boolean; true if artist and title are same, false otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        if (object == null || this == null) return false;

        if (!(object instanceof Album)) return false;

        Album obj = (Album) object;

        if (obj.title == null || this.title == null) return false;
        if (obj.artist == null || this.artist == null) return false;

        return this.title.equals(obj.title) && this.artist.equals(obj.artist);
    }

    /**
     * Method to check whether the album is available or not.
     * @return String to represent the lending status of the album.
     */
    public String availabilityToString()
    {
        String availability = "is not available";
        if (isAvailable)
        {
            availability = "is available";
        }
        return availability;
    }

    /**
     * Method to return a String representation of the Album;
     * Format: title:artist:genre:release-date:availability
     * @return String; in the aforementioned format.
     */
    @Override
    public String toString()
    {
        if (this.genre == null) return title + "::" + artist;
        return title + "::" + artist + "::" + genre.toString()
                + "::" + releaseDate.toString() + "::" + this.availabilityToString();
    }

    /**
     * Method to get the indexed integer representation of the releaseDate of an Album instance.
     * Used for print by release date.
     * @return Integer; yyyymmdd format.
     */
    public int getDate()
    {
        return this.releaseDate.getDateIndex();
    }
}
