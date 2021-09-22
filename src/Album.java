public class Album
{
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album() {}

    @Override
    public boolean equals(Object object)
    {
        if (object == null || this == null) return false;

        if ((object instanceof Album)) return false;

        Album obj = (Album) object;

        if (obj.title == null || this.title == null) return false;
        if (obj.artist == null || this.artist == null) return false;

        return this.title.equals(obj.title) && this.artist.equals(obj.artist);
    }
    @Override
    public String toString()
    {
        String availability = "is not available";
        if (isAvailable)
        {
            availability = "is available";
        }

        return title + "::" + artist + "::" + genre + "::" + releaseDate.toString() + "::" + availability;
    }
}
