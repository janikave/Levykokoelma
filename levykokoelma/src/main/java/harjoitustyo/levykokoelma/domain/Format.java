package harjoitustyo.levykokoelma.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long formatId;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "format")
    private List<Release> records;

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
