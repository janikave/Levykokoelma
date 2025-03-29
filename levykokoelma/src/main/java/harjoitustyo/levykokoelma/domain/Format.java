package harjoitustyo.levykokoelma.domain;

public class Format {

    private Long formatId;
    private String type;

    public Format() {
    }

    public Format(String type) {
        this.type = type;
    }

    public Long getFormatId() {
        return formatId;
    }

    public void setFormatId(Long formatId) {
        this.formatId = formatId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Format [type=" + type + "]";
    }

}
