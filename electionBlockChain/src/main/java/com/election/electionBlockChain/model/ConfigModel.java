package com.election.electionBlockChain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class ConfigModel {

    @Value("number.value")
    public final Integer numberConfig;
}
