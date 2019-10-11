package com.es_plugins;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.junit.Assert;
import org.junit.Test;

public class ApolloTest {

    @Test
    public void testClient() {
        String somePublicNamespace = "public.ess";
        Config config = ConfigService.getConfig(somePublicNamespace);
        String someKey = "ess_seed_list";
        String value = config.getProperty(someKey, null);
        Assert.assertNotNull(value);
    }

}
