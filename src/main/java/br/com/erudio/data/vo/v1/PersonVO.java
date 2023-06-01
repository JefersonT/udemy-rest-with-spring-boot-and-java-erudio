package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"id", "gender", "first_Name", "last_Name", "address"})
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;



    private Long id;
    @JsonProperty("first_Name")
    private String firstName;

    @JsonProperty("last_Name")
    private String lastName;
    private String address;

    @JsonIgnore
    private String gender;
}
