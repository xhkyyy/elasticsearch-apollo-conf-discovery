# elasticsearch-apollo-conf-discovery

### Prerequisites

[Apollo configuration management system](https://github.com/ctripcorp/apollo)

###

```yaml
discovery.zen.hosts_provider: conf-apollo

# apollo: the apollo.meta of the config
discovery.conf.apollo.meta:

# apollo: the app.id of the config
discovery.conf.apollo.app_id:

# apollo: the namespace of the config
discovery.conf.apollo.namespace: 

# apollo: the property name
discovery.conf.apollo.key: 
```

bin/elasticsearch-plugin --verbose install  
