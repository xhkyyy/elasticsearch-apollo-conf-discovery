package com.es_plugins;

import com.es_plugins.util.ConfUtil;
import com.service.ApolloConfServiceImpl;
import com.service.ConfService;
import org.elasticsearch.common.network.NetworkService;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.SeedHostsProvider;
import org.elasticsearch.plugins.DiscoveryPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.ReloadablePlugin;
import org.elasticsearch.transport.TransportService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author xhkyyy
 */
public class ApolloConfBasedDiscoveryPlugin extends Plugin implements DiscoveryPlugin, ReloadablePlugin {

    private Settings settings;

    private final String CONF_KEY = "conf-apollo";

    public ApolloConfBasedDiscoveryPlugin(Settings settings) {
        this.settings = settings;
    }

    @Override
    public List<Setting<?>> getSettings() {
        return List.of(
                ConfUtil.CONF_APOLLO_APP_ID_SETTING,
                ConfUtil.CONF_APOLLO_META_SETTING,
                ConfUtil.CONF_APOLLO_NS_SETTING,
                ConfUtil.CONF_APOLLO_KEY_SETTING
        );
    }

    ConfService createHttpService() {
        return new ApolloConfServiceImpl(settings);
    }

    @Override
    public void reload(Settings settings) throws Exception {
        // TODO
    }

    @Override
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {
        return Collections.singletonMap(
                CONF_KEY, () -> new ApolloConfBasedSeedHostsProvider(createHttpService())
        );
    }
}
