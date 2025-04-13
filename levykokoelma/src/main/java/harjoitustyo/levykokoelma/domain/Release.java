package harjoitustyo.levykokoelma.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long releaseId;
    @NotBlank(message = "Add the album title here")
    private String title;
    @NotBlank(message = "Add the artist here")
    private String artist;
    @NotNull(message = "Add the release year here")
    @Min(value = 1900, message = "Release year can't be earlier than 1900")
    @Max(value = 2025, message = "Release year can't be later than current year")
    private Long releaseYear;
    @Min(1)
    @Max(5)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "formatId")
    private Format format;

    @ManyToMany
    @JoinTable(name = "release_genre", joinColumns = @JoinColumn(name = "releaseId"), inverseJoinColumns = @JoinColumn(name = "genreId"))
    private List<Genre> genres = new ArrayList<>();

    public Release() {
    }

    public Release(String title, String artist, long releaseYear, Integer rating, Format format,
            List<Genre> genres) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.format = format;
        this.genres = genres;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Release [title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear + ", rating=" + rating
                + ", format=" + format + "]";
    }

}
