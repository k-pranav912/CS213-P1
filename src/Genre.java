import java.util.Locale;

/**
 *
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
