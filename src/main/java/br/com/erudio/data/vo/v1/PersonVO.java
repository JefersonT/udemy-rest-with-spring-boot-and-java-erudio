package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersionUID = 1L;


    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    @Override
    public String toString() {
        return "PersonVO{" +
                "key=" + key +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", " + super.toString() +
                "} ";
    }
}
