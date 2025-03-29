package harjoitustyo.levykokoelma.domain;

public class Record {

    private Long recordId;
    private String title;
    private String artist;
    private Long releaseYear;
    private Integer rating;

    public Record() {
    }

    public Record(String title, String artist, Long releaseYear, Integer rating) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    @Override
    public String toString() {
        return "Record [title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear + ", rating=" + rating
                + "]";
    }

}
