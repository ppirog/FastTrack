package org.fasttrack.domain.company;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.dto.CompanyResponseDto;

import java.util.Collections;
import java.util.List;

@Log4j2
@AllArgsConstructor
public class CompanyFacade {


    public List<CompanyResponseDto> findAllCompanies(){
        return Collections.emptyList();
    }

    public CompanyResponseDto findCompanyByKrsIfNotExistInDbFetchAndSave(String krs){
        return CompanyResponseDto.builder().build();
    }

    public CompanyResponseDto findCompanyByName(String name){
        return CompanyResponseDto.builder().build();
    }
}
