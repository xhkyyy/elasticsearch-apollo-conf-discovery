# elasticsearch-apollo-conf-discovery

### Prerequisites

[Apollo configuration management system](https://github.com/ctripcorp/apollo)

###

```yaml
discovery.seed_providers: conf-apollo

# apollo: the namespace of the config
discovery.conf.apollo.namespace: 

# apollo: the property name
discovery.conf.apollo.key: 
```

bin/elasticsearch-plugin --verbose install  
