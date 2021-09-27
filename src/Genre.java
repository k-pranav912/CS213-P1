/**
 * The enumertated class Genre, which contains the different genres, as well as methods to convert
 * a string into a genre and a genre into an index or string
 * @author Saipranav Kalapala, Neel Prabhu
 */
public enum Genre
{
    CLASSICAL, COUNTRY, JAZZ, POP, UNKNOWN;
    public static final int numGenres = 5;
    private static final int CLASSICALINDEX = 0;
    private static final int COUNTRYINDEX = 1;
    private static final int JAZZINDEX = 2;
    private static final int POPINDEX = 3;
    private static final int UNKNOWNINDEX = 4;

    /**
     * Takes a genre and returns its appropriate index. Used when printing by genre order. The order that print by
     * genre is printed in may be changed by changing the constant index values above, in ascending order.
     * @return the genre index
     */
    public int toIndex()
    {
        switch(this)
        {
            case CLASSICAL:
                return CLASSICALINDEX;
            case COUNTRY:
                return COUNTRYINDEX;
            case JAZZ:
                return JAZZINDEX;
            case POP:
                return POPINDEX;
            default:
                return UNKNOWNINDEX;
        }
    }

    /**
     * Takes a string from user input and converts the string into a genre. If the user inputted a genre that is
     * not in this enumerated class, it gets set to Unknown.
     * @param genreString the user inputted string that specifies the genre of the album
     * @return the genre that the string represents, or Unknown if it does not exist in this class
     */
    public static Genre toGenre(String genreString)
    {
        switch (genreString.toLowerCase())
        {
            case "classical":
                return CLASSICAL;
            case "country":
                return COUNTRY;
            case "jazz":
                return JAZZ;
            case "pop":
                return POP;
            default:
                return UNKNOWN;
        }
    }

    /**
     * Converts a genre into the string for printing the album's genre.
     * @return the string name of the genre given
     */
    @Override
    public String toString()
    {
        switch (this)
        {
            case CLASSICAL:
                return "Classical";
            case COUNTRY:
                return "Country";
            case JAZZ:
                return "Jazz";
            case POP:
                return "Pop";
            default:
                return "Unknown";
        }
    }
}
