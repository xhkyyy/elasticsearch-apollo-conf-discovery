package com.es_plugins;

import com.es_plugins.service.ApolloConfServiceImpl;
import com.es_plugins.service.ConfService;
import com.es_plugins.util.ConfUtil;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.network.NetworkService;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.zen.UnicastHostsProvider;
import org.elasticsearch.plugins.DiscoveryPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.transport.TransportService;

import java.security.PrivilegedAction;
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
        ConfUtil.doPrivileged((PrivilegedAction<String>) () -> {
            initProperty(settings);
            return null;
        });

    }

    @Override
    public List<Setting<?>> getSettings() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        ConfUtil.CONF_APOLLO_APP_ID_SETTING,
                        ConfUtil.CONF_APOLLO_META_SETTING,
                        ConfUtil.CONF_APOLLO_NS_SETTING,
                        ConfUtil.CONF_APOLLO_KEY_SETTING
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
        return Collections.singletonMap(
                CONF_KEY, () -> new ApolloConfBasedSeedHostsProvider(settings, createHttpService())
        );
    }

    private void initProperty(Settings settings) {
        setProperty(ConfUtil.CONF_APOLLO_APP_ID_SETTING, settings, ConfUtil.APOLLO_PROPERTY_NAME_APP_ID);
        setProperty(ConfUtil.CONF_APOLLO_META_SETTING, settings, ConfUtil.APOLLO_PROPERTY_NAME_META);
    }

    private void setProperty(Setting<String> pluginSettings, Settings settings, String propertyName) {
        if (StringUtils.isBlank(System.getProperty(propertyName))) {
            System.setProperty(propertyName, pluginSettings.get(settings));
        }
    }
}
