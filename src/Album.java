public class Album
{
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album() {}
    @Override
    public boolean equals(Object obj)
    {
        if (obj == NULL || this == NULL) return false;
        if (obj.title == NULL || this.title == NULL) return false;
        if (obj.artist == NULL || this.artist == NULL) return false;

        return this.title.equals(obj.title) && this.artist.equals(obj.artist);
    }
    @Override
    public String toString()
    {
        if (isAvailable)
        {
            String availability = "is available";
        }
        else
        {
            String availability = "is not available";
        }
        return title + "::" + artist + "::" + genre + "::" + releaseDate.toString() + "::" + availability;
    }
}
