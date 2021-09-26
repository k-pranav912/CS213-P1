public class Album
{
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }
    public Album(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    public int getGenreIndex()
    {
        return this.genre.toIndex();
    }

    public boolean changeAvailability(boolean newValue)
    {
        if (isAvailable == newValue) return false;
        isAvailable = newValue;
        return true;
    }

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
    public String availabilityToString()
    {
        String availability = "is not available";
        if (isAvailable)
        {
            availability = "is available";
        }
        return availability;
    }

    @Override
    public String toString()
    {
        if (this.genre == null) return title + "::" + artist;
        return title + "::" + artist + "::" + genre.toString()
                + "::" + releaseDate.toString() + "::" + this.availabilityToString();
    }

    public int getDate()
    {
        return this.releaseDate.getDateIndex();
    }
}
