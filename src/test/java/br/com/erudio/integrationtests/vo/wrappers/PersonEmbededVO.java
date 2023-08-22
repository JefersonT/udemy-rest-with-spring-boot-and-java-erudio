package br.com.erudio.integrationtests.vo.wrappers;

import br.com.erudio.integrationtests.vo.PersonVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonEmbededVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("personVOList")
    private List<PersonVO> persons;
}
