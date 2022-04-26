package br.com.crypto.services;

import br.com.crypto.dtos.CurrencyDTO;
import br.com.crypto.mapper.CurrencyMapper;
import br.com.crypto.models.CurrencyModel;
import br.com.crypto.repositories.CurrencyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CurrencyService {

    final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Transactional
    public CurrencyModel save(CurrencyModel currencyModel) {
        return currencyRepository.save(currencyModel);
    }

    public Optional<CurrencyModel> findById(UUID id) {
        return currencyRepository.findById(id);
    }

    @Transactional
    public void delete(UUID id) {
        currencyRepository.deleteById(id);
    }

    public List<CurrencyModel> existsByNameOrCode(Optional<String> name, Optional<String> code) {
        if (name.isPresent() || code.isPresent()) {
            return currencyRepository.existsByNameOrCode(name, code);
        }
        return currencyRepository.findAll();
    }

    @Transactional
    public void put(CurrencyDTO currencyDTO) {
        Optional<CurrencyModel> currencyModelOptional = currencyRepository.findById(currencyDTO.getId());
        if (currencyDTO.getName() == null) {
            currencyDTO.setName(currencyModelOptional.get().getName());
        }
        if (currencyDTO.getCode() == null) {
            currencyDTO.setCode(currencyModelOptional.get().getCode());
        }

        CurrencyModel currencyModel = currencyModelOptional.get();
        currencyRepository.save(currencyModel);
    }

}
