package by.rolles.sensorsmonitor.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AuthenticationDto implements Serializable {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
