package com.election.electionBlockChain.controller;

import com.election.electionBlockChain.controller.dto.BlockChainDto;
import com.election.electionBlockChain.controller.dto.ResultadoDto;
import com.election.electionBlockChain.controller.dto.VotoDto;
import com.election.electionBlockChain.model.BlockChain;
import com.election.electionBlockChain.service.BlockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/block")
@AllArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @PostMapping
    public void criarBlock(@RequestBody VotoDto dto){

        blockService.createBlock(dto);
    }

    @GetMapping("/result")
    public ResponseEntity<List<ResultadoDto>> resultatdo(){

        return ResponseEntity.ok(blockService.resultado());
    }

    @GetMapping("/blockchain")
    public ResponseEntity<List<BlockChain>> getBlockChain(){

        return ResponseEntity.ok(blockService.getBlockChain());
    }
}
