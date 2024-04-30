package org.fasttrack.domain.company;

import feign.FeignException;
import feign.RetryableException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;
import org.fasttrack.domain.company.exceptions.NotFoundInDatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@AllArgsConstructor
public class CompanyFacade {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyFetchable companyFetchable;

    public CompanyResponseDto findCompanyByKrsIfNotExistInDbFetchAndSave(String krs) {

        final Optional<Company> byKRSnumberFromDb = companyRepository.findByKRSnumber(krs);
        if (byKRSnumberFromDb.isPresent()) {
            return companyMapper.toCompanyResponseDto(byKRSnumberFromDb.get());
        } else {
            final CompanyResponseFromServerDto fetchByKrsFromExternalSerevr;

            try {
                fetchByKrsFromExternalSerevr = companyFetchable.fetch(krs);
                log.error(fetchByKrsFromExternalSerevr);
                final Company save = companyRepository.save(companyMapper.toCompany(fetchByKrsFromExternalSerevr));
                return companyMapper.toCompanyResponseDto(save);
            } catch (FeignException.FeignClientException feignClientException) {
                log.error("Company not found in external server: {}", feignClientException.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found in external server", feignClientException);
            } catch (FeignException.FeignServerException feignServerException) {
                log.error("Feign server exception: {}", feignServerException.getMessage());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "FeignServerException: ", feignServerException);
            } catch (RetryableException retryableException) {
                log.error("Retryable Exception exception: {}", retryableException.getMessage());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "FeignServerException: ", retryableException);
            } catch (FeignException feignException) {
                log.error("Error fetching company data from external server: {}", feignException.getMessage());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", feignException);
            }

        }
    }

    public CompanyResponseDto findCompanyByName(String name) {
        final Company company = companyRepository.findByName(name)
                .orElseThrow(() -> new NotFoundInDatabaseException("Not found in database: " + name));
        return companyMapper.toCompanyResponseDto(company);
    }

    public CompanyResponseDto findCompanyByKrs(String Krs) {
        final Company company = companyRepository.findByKRSnumber(Krs)
                .orElseThrow(() -> new NotFoundInDatabaseException("Not found in database: " + Krs));
        return companyMapper.toCompanyResponseDto(company);
    }

    private Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<CompanyResponseDto> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::toCompanyResponseDto)
                .collect(Collectors.toList());
    }
}
