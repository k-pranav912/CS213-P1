public enum Genre
{
    CLASSICAL, COUNTRY, JAZZ, POP, UNKNOWN;
    public static final int numGenres = 5;

    public int toIndex()
    {
        switch(this) {
            case CLASSICAL:
                return 0;
            case COUNTRY:
                return 1;
            case JAZZ:
                return 2;
            case POP:
                return 3;
            default:
                return 4;
        }
    }

    public static Genre toGenre(String genreString)
    {
        switch (genreString)
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
