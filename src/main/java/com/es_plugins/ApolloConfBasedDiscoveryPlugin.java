package com.es_plugins;

import com.service.ApolloConfServiceImpl;
import com.service.ConfService;
import org.elasticsearch.common.network.NetworkService;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.zen.UnicastHostsProvider;
import org.elasticsearch.plugins.DiscoveryPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.transport.TransportService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author xhkyyy
 */
public class ApolloConfBasedDiscoveryPlugin extends Plugin implements DiscoveryPlugin {

    private Settings settings;

    private final String CONF_KEY = "conf-apollo";

    public ApolloConfBasedDiscoveryPlugin(Settings settings) {
        this.settings = settings;
    }

    @Override
    public List<Setting<?>> getSettings() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        ConfService.CONF_APOLLO_NS_SETTING,
                        ConfService.CONF_APOLLO_KEY_SETTING
                )
        );
    }

    ConfService createHttpService() {
        return new ApolloConfServiceImpl(settings);
    }

    @Override
    public Map<String, Supplier<UnicastHostsProvider>> getZenHostsProviders(
            TransportService transportService, NetworkService networkService
    ) {
        return Collections.singletonMap(CONF_KEY, () -> new ApolloConfBasedSeedHostsProvider(settings, createHttpService()));
    }
}
