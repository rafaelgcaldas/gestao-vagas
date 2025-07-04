package br.com.rafaelgcaldas.gestao_vagas.modules.candidate.useCases;

import br.com.rafaelgcaldas.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDto;
import br.com.rafaelgcaldas.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDto execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return ProfileCandidateResponseDto.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

    }
}
