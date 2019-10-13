package com.es_plugins.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
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

    public static <T> T doPrivileged(final PrivilegedAction<T> operation) {
        SpecialPermission.check();
        return AccessController.doPrivileged(operation);
    }

    public static String getProperty(
            String configServerUrl,
            String appId,
            String namespace,
            String key

    ) {
        String url = String.format("%s/configs/%s/default/%s?releaseKey=&ip=", configServerUrl, appId, namespace);
        try {
            Response res = Request.Get(url).execute();
            return StringUtils.trim(
                    JSON.parseObject(StringUtils.trim(res.returnContent().asString()))
                            .getJSONObject("configurations")
                            .getString(key)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
