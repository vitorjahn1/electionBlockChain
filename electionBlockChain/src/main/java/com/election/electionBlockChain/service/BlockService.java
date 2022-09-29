package com.election.electionBlockChain.service;

import com.election.electionBlockChain.controller.dto.ResultadoDto;
import com.election.electionBlockChain.controller.dto.VotoDto;
import com.election.electionBlockChain.model.BlockChain;
import com.election.electionBlockChain.model.BlockModel;
import com.election.electionBlockChain.model.ConfigModel;
import com.election.electionBlockChain.repository.BlockChainRepository;
import com.election.electionBlockChain.repository.BlockRepisotory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BlockService {

    private final BlockRepisotory blockRepisotory;

    private final BlockChainRepository blockChainRepository;


    public void createBlock(VotoDto votoDto) {

        BlockChain blockChain = blockChainRepository.findById(Long.valueOf(votoDto.getNumero())).orElseThrow();

        BlockModel blockModel = new BlockModel();
        if(!blockChain.getBlockChain().isEmpty()){
            List<BlockModel> blocks = blockChain.getBlockChain().stream().collect(Collectors.toList());

            BlockModel endBlock = blocks.get(blocks.size()-1);
            BlockModel.BlockModelBuilder blockModelBuilder = BlockModel.builder().nonce(0).previousHash(endBlock.getHash()).timeStamp(LocalDateTime.now());

            blockModel = blockModelBuilder.hash(blockModelBuilder.build().calculateBlockHash()).build();

        }else{

             blockModel = new BlockModel(null, LocalDateTime.now()
                    ,"",0,"");

        }
        blockModel.mineBlock(1);
        blockRepisotory.save(blockModel);
        blockChain.getBlockChain().add(blockModel);
        blockChainRepository.save(blockChain);
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    public List<ResultadoDto> resultado(){

        List<BlockChain> blockChains = blockChainRepository.findAll();

        return blockChains.stream().map(blockChain -> ResultadoDto.builder().resultado(blockChain.getBlockChain().size()).numero(blockChain.getId()).build()).collect(Collectors.toList());
    }

    public List<BlockChain> getBlockChain(){

        return blockChainRepository.findAllBlockChain();
    }
}
