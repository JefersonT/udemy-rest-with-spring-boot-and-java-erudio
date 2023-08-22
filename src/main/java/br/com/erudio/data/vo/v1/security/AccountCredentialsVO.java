package br.com.erudio.data.vo.v1.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCredentialsVO implements Serializable {

    private static final long serilVersionUID = 1L;

    private String username;
    private String password;
}
