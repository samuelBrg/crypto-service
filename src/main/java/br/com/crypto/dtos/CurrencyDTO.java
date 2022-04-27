package br.com.crypto.dtos;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

public class CurrencyDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String code;
    private UUID id;
    private OffsetDateTime created_at;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getCreated_at() {return created_at;}

    public void setCreated_at(OffsetDateTime created_at){this.created_at = created_at;}
}
