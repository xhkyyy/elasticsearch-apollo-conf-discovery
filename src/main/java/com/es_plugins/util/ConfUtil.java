package com.es_plugins.util;

import org.elasticsearch.SpecialPermission;
import org.elasticsearch.common.settings.Setting;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.function.Function;

/**
 * @author xhkyyy
 */
public class ConfUtil {

    public static Setting<String> CONF_APOLLO_APP_ID_SETTING = new Setting<>("discovery.conf.apollo.app_id", "public.ess",
            Function.identity(), Setting.Property.NodeScope);


    public static Setting<String> CONF_APOLLO_META_SETTING = new Setting<>("discovery.conf.apollo.meta", "public.ess",
            Function.identity(), Setting.Property.NodeScope);


    public static Setting<String> CONF_APOLLO_NS_SETTING = new Setting<>("discovery.conf.apollo.namespace", "public.ess",
            Function.identity(), Setting.Property.NodeScope);

    public static Setting<String> CONF_APOLLO_KEY_SETTING = new Setting<>("discovery.conf.apollo.key", "ess_seed_list",
            Function.identity(), Setting.Property.NodeScope);

    public static String APOLLO_PROPERTY_NAME_APP_ID = "app.id";

    public static String APOLLO_PROPERTY_NAME_META = "apollo.meta";

    public static <T> T doPrivileged(final PrivilegedAction<T> operation) {
        SpecialPermission.check();
        return AccessController.doPrivileged(operation);
    }


}
