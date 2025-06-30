package tn.starter.mongoShared.dto;

import lombok.Builder;
import lombok.With;

import java.time.Instant;

@Builder
public record LivreDTO(long id, String titre, String genre,Instant createdAt,Instant updatedAt) {
}