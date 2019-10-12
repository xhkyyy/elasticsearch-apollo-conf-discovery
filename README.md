elasticsearch-apollo-conf-discovery
=============================

The elasticsearch-apollo-conf-discovery plugin uses the Apollo Configuration to identify the addresses of seed hosts.

Versions
--------

Plugin branch | ES version | Release
-----------|-----------|-----------
master | 7.3.x | 
6.2.x| 6.2.x | [elasticsearch-apollo-conf-discovery-v6.2.2](https://github.com/xhkyyy/elasticsearch-apollo-conf-discovery/releases/tag/v6.2.2)

Prerequisites
--------

[Apollo configuration management system](https://github.com/ctripcorp/apollo)


How To Use
--------

installation:

```sh
bin/elasticsearch-plugin --verbose install [url]
```

elasticsearch.yml:

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

Test
--------

[test/elasticsearch.yml](test/elasticsearch.yml)

Build
--------

```
./gradlew build
```


