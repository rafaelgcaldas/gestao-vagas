package br.com.rafaelgcaldas.gestao_vagas.modules.candidate.useCases;

import br.com.rafaelgcaldas.gestao_vagas.exceptions.UserFoundException;
import br.com.rafaelgcaldas.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.rafaelgcaldas.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        System.out.println("opa" + candidateEntity);

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        System.out.println("test" + candidateEntity);

        return this.candidateRepository.save(candidateEntity);
    }
}
