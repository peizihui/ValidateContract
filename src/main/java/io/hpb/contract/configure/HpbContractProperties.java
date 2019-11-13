package io.hpb.contract.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static io.hpb.contract.configure.HpbContractProperties.CONTRACT_PREFIX;

/**
 * web3 property container.
 */
@Component
@ConfigurationProperties(prefix = CONTRACT_PREFIX)
public class HpbContractProperties {

    public static final String CONTRACT_PREFIX = "contract";
    private String cpath;

	public String getCpath() {
		return cpath;
	}

	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
}
