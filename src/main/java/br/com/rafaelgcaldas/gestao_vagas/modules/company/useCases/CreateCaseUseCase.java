package br.com.rafaelgcaldas.gestao_vagas.modules.company.useCases;

import br.com.rafaelgcaldas.gestao_vagas.exceptions.UserFoundException;
import br.com.rafaelgcaldas.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.rafaelgcaldas.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCaseUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((company) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}
