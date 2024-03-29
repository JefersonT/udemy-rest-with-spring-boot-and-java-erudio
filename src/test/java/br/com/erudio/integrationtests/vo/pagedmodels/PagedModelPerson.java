package br.com.erudio.integrationtests.vo.pagedmodels;

import br.com.erudio.integrationtests.vo.PersonVO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement
@Data
@NoArgsConstructor
public class PagedModelPerson {

    @XmlElement(name = "content")
    private List<PersonVO> content;

}
