package com.es_plugins;

import com.service.ConfService;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.discovery.SeedHostsProvider;

import java.util.List;

/**
 * @author xhkyyy
 */
public class ApolloConfBasedSeedHostsProvider implements SeedHostsProvider {

    private final ConfService confService;

    ApolloConfBasedSeedHostsProvider(ConfService confService) {
        this.confService = confService;
    }

    @Override
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
        return confService.getSeedAddresses();
    }
}
