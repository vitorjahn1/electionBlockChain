package com.election.electionBlockChain.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResultadoDto implements Serializable {

    private Integer resultado;

    private Long numero;
}
