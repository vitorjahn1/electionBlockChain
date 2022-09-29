package com.election.electionBlockChain.model;

import lombok.*;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import static java.nio.charset.StandardCharsets.UTF_8;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BlockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long index;

    private LocalDateTime timeStamp;

    private String previousHash;

    private Integer nonce;

    @Column(unique = true, updatable = false)
    private String hash;

    @ManyToOne
    private BlockChain blockChain;

    public BlockModel(Long index, LocalDateTime timeStamp, String previousHash, Integer nonce, String hash) {
        this.index = index;
        this.timeStamp = timeStamp;
        this.previousHash = previousHash;
        this.nonce = nonce;
        this.hash = calculateBlockHash();

    }

    public String calculateBlockHash() {
        String dataToHash = previousHash
                + timeStamp.toString()
                + nonce.toString();
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {

        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            nonce++;
            hash = calculateBlockHash();
        }
        return hash;
    }
}
