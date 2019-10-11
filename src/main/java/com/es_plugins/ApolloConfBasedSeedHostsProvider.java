package com.es_plugins;

import com.service.ConfService;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.zen.UnicastHostsProvider;

import java.util.List;

/**
 * @author xhkyyy
 */
public class ApolloConfBasedSeedHostsProvider extends AbstractComponent implements UnicastHostsProvider {

    private ConfService confService;

    ApolloConfBasedSeedHostsProvider(Settings settings, ConfService confService) {
        super(settings);
        this.confService = confService;
    }


    @Override
    public List<DiscoveryNode> buildDynamicNodes() {
        return confService.getSeedAddresses();
    }
}
