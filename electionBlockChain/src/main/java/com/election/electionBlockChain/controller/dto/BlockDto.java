package com.election.electionBlockChain.controller.dto;

import com.election.electionBlockChain.model.BlockChain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public interface BlockDto {

    Long getIndex();

    LocalDateTime getTimeStamp();

    String getPreviousHash();

    Integer getNonce();

    String getHash();

    BlockChain getBlockChain();
}
