public class Album
{
    public static void main(String[] args)
    {
        Date testDate = new Date();
        Album newAlbum = new Album("I don't have one",
                "Everyone", Genre.toGenre("stuff"), testDate, true);
        Album secondAlbum = new Album(" don't have one",
                "Everyone", Genre.toGenre("stuff"), testDate, false);

        System.out.println(newAlbum.equals(secondAlbum));
        System.out.println(newAlbum);
    }
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
}
