package com.election.electionBlockChain.repository;

import com.election.electionBlockChain.model.BlockModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepisotory extends JpaRepository<BlockModel, Long> {

}
