package com.service;

import com.es_plugins.util.ConfUtil;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.Version;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

/**
 * @author xhkyyy
 */
public class ApolloConfServiceImpl implements ConfService {

    private final Pattern compile = Pattern.compile(",");

    private Settings settings;

    public ApolloConfServiceImpl(Settings settings) {
        this.settings = settings;
    }

    @Override
    public List<DiscoveryNode> getSeedAddresses() {
        AtomicInteger index = new AtomicInteger();
        String value = ConfUtil.doPrivileged(() -> ConfUtil.getProperty(
                ConfUtil.CONF_APOLLO_META_SETTING.get(settings),
                ConfUtil.CONF_APOLLO_APP_ID_SETTING.get(settings),
                ConfUtil.CONF_APOLLO_NS_SETTING.get(settings),
                ConfUtil.CONF_APOLLO_KEY_SETTING.get(settings)
        ));
        return Stream.of(value)
                .flatMap(compile::splitAsStream)
                .filter(StringUtils::isNotBlank)
                .map(s -> buildDiscoveryNode(index, s))
                .collect(Collectors.toList());
    }

    private DiscoveryNode buildDiscoveryNode(AtomicInteger index, String bindAddr) {
        String[] arr = bindAddr.split(":");
        TransportAddress address = new TransportAddress(
                new InetSocketAddress(arr[0].trim(), Integer.parseInt(arr[1].trim()))
        );
        return new DiscoveryNode(
                "conf-apollo-provider-" + (index.getAndIncrement()),
                address,
                emptyMap(),
                emptySet(),
                Version.CURRENT.minimumCompatibilityVersion()
        );
    }
}
