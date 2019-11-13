package io.hpb.service;


import io.hpb.web3.protocol.core.DefaultBlockParameterName;

public abstract class AbstractBaseService implements BaseService {

    public DefaultBlockParameterName fromString(String name) {
        if (name != null) {
            for (DefaultBlockParameterName defaultBlockParameterName :
                    DefaultBlockParameterName.values()) {
                if (name.equalsIgnoreCase(defaultBlockParameterName.name())) {
                    return defaultBlockParameterName;
                }
            }
        }
        return DefaultBlockParameterName.valueOf(name);
    }
}
