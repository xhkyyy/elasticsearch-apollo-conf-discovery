# elasticsearch-apollo-conf-discovery

> branch (master) : 7.3.x

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


```
bin/elasticsearch-plugin --verbose install https://github.com/xhkyyy/elasticsearch-apollo-conf-discovery/releases/download/v6.2.2/elasticsearch-apollo-conf-discovery-plugin-v6.2.2.zip
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
git clone https://github.com/xhkyyy/elasticsearch-apollo-conf-discovery.git
$ cd elasticsearch-apollo-conf-discovery/
$ ./gradlew build
```


