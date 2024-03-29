package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private static final long serialVersionUID = 1L;


    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String author;

    private Date launchDate;

    private Double price;

    private String title;

    @Override
    public String toString() {
        return "BooksVO{" +
                "key=" + key +
                ", author='" + author + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", " + super.toString() +
                "} ";
    }
}
