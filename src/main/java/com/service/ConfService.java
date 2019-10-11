package com.service;

import org.elasticsearch.SpecialPermission;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Setting;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.function.Function;

/**
 * @author xhkyyy
 */
public interface ConfService {

    List<DiscoveryNode> getSeedAddresses();

    default <T> T doPrivileged(final PrivilegedAction<T> operation) {
        SpecialPermission.check();
        return AccessController.doPrivileged(operation);
    }


    Setting<String> CONF_APOLLO_APP_ID_SETTING = new Setting<>("discovery.conf.apollo.app_id", "public.ess",
            Function.identity(), Setting.Property.NodeScope);


    Setting<String> CONF_APOLLO_META_SETTING = new Setting<>("discovery.conf.apollo.meta", "public.ess",
            Function.identity(), Setting.Property.NodeScope);


    Setting<String> CONF_APOLLO_NS_SETTING = new Setting<>("discovery.conf.apollo.namespace", "public.ess",
            Function.identity(), Setting.Property.NodeScope);

    Setting<String> CONF_APOLLO_KEY_SETTING = new Setting<>("discovery.conf.apollo.key", "ess_seed_list",
            Function.identity(), Setting.Property.NodeScope);

}
