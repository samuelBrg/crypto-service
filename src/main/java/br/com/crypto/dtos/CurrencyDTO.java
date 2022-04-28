package br.com.crypto.dtos;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class CurrencyDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String code;
    private UUID id;
    private OffsetDateTime created_at;

}
