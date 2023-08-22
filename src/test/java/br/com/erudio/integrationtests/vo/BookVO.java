package br.com.erudio.integrationtests.vo;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@XmlRootElement
public class BookVO implements Serializable {

    private static final long serialVersionUID = 1L;



    private Long id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    @Override
    public String toString() {
        return "BooksVO{" +
                "key=" + id +
                ", author='" + author + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", " + super.toString() +
                "} ";
    }
}
