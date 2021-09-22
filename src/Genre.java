public enum Genre
{
    CLASSICAL, COUNTRY, JAZZ, POP, UNKNOWN;


    public static Genre toGenre(String genreString)
    {
        switch (genreString)
        {
            case "Classical": return CLASSICAL;
            case "Country": return COUNTRY;
            case "Jazz": return JAZZ;
            case "Pop": return POP;
            default: return UNKNOWN;
        }
    }

    @Override
    public String toString()
    {
        switch (this)
        {
            case CLASSICAL: return "Classical";
            case COUNTRY: return "Country";
            case JAZZ: return "Jazz";
            case POP: return "Pop";
            default: return "Unknown";
        }
    }
}
