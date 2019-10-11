package com.es_plugins;


import com.es_plugins.util.ConfUtil;
import org.junit.Test;

public class ApolloTest {

    @Test
    public void testClient() {

        String json = ConfUtil.getProperty(
                "http://106.12.25.204:8080",
                "65533",
                "public.ess",
                "ess_seed_list"
        );

        System.out.println(json);
    }

}
