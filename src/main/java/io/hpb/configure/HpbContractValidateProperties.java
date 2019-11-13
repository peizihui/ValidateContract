package io.hpb.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static  io.hpb.configure.HpbContractValidateProperties.HPB_CONTRACT_PREFIX;


/**
 * web3 property container.
 */
@Component
@ConfigurationProperties(prefix = HPB_CONTRACT_PREFIX)
public class HpbContractValidateProperties {

    public static final String HPB_CONTRACT_PREFIX = "hpb.contract";
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
