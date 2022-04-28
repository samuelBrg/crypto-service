package br.com.crypto.services;

import br.com.crypto.exceptions.CustomException;
import br.com.crypto.exceptions.RequestException;
import br.com.crypto.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CurrencyExitsValidator {

    final CurrencyRepository currencyRepository;

    public CurrencyExitsValidator(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void validatorNameAndCode(String name, String code) throws RequestException {
        if (currencyRepository.existsByNameAndCode(name, code)) {
            throw new RequestException("Currency Already Exists!");
        }
    }

    public void validatorId(UUID id) throws RequestException {
        if (!currencyRepository.existsById(id)) {
            throw new RequestException("Currency not found!");
        }
    }
}
