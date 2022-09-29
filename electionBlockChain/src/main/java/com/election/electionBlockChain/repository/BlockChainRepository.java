package com.election.electionBlockChain.repository;

import com.election.electionBlockChain.controller.dto.BlockChainDto;
import com.election.electionBlockChain.model.BlockChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlockChainRepository extends JpaRepository<BlockChain, Long> {


    @Query("select bc from BlockChain bc inner join bc.blockChain b")
    List<BlockChain> findAllBlockChain();
}
