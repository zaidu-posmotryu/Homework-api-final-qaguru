package models;

import lombok.Data;

@Data
public class RegisterResponseModel {

    private String token, id, error;
}
