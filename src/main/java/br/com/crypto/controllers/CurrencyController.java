package br.com.crypto.controllers;

import br.com.crypto.dtos.CurrencyDTO;
import br.com.crypto.mapper.CurrencyMapper;
import br.com.crypto.models.CurrencyModel;
import br.com.crypto.repositories.CurrencyRepository;
import br.com.crypto.services.CurrencyExitsValidator;
import br.com.crypto.services.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/crypto-ativo")
public class CurrencyController {
    final CurrencyService currencyService;
    final CurrencyExitsValidator currencyValidator;

    public CurrencyController(CurrencyService currencyService, CurrencyExitsValidator currencyValidator) {
        this.currencyService = currencyService;
        this.currencyValidator = currencyValidator;
    }


    @PostMapping
    public ResponseEntity<Object> saveCurrency(@RequestBody @Valid CurrencyDTO currencyDto) throws Exception {
        currencyValidator.validatorNameAndCode(currencyDto.getName(), currencyDto.getCode());
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.save(CurrencyMapper.INSTANCE.mapDtoToModel(currencyDto)));
    }

    @GetMapping
    public List<CurrencyDTO> getCurrency(@RequestParam @Nullable Optional<String> name, @RequestParam @Nullable Optional<String> code) {
        List<CurrencyDTO> currencyDto = CurrencyMapper.INSTANCE.mapModelToDtoList(currencyService.existsByNameOrCode(name, code));
        return currencyDto;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurrency(@PathVariable(value = "id") UUID id) throws Exception {
        currencyValidator.validatorId(id);
        currencyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putCurrency(@PathVariable(value = "id") UUID id,
                                              @RequestBody CurrencyDTO currencyDTO) throws Exception {
        currencyValidator.validatorId(id);
        currencyService.put(currencyDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
    }
}
