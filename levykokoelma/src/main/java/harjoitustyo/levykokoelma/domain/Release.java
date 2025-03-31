package harjoitustyo.levykokoelma.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long releaseId;
    private String title;
    private String artist;
    private long releaseYear;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "formatId")
    private Format format;

    @ManyToMany
    @JoinColumn(name = "genreId")
    private Genre genre;

    public Release() {
    }

    public Release(String title, String artist, Long releaseYear, Integer rating, Format format, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.format = format;
        this.genre = genre;
    }

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Release [title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear + ", rating=" + rating
                + ", format=" + format + "]";
    }

}
