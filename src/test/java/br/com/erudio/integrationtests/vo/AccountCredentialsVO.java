package br.com.erudio.integrationtests.vo;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class AccountCredentialsVO implements Serializable {

    private static final long serilVersionUID = 1L;

    private String username;
    private String password;
}
