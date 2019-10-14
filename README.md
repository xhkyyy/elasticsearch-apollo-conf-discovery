elasticsearch-apollo-conf-discovery
=============================

The elasticsearch-apollo-conf-discovery plugin uses the Apollo Configuration to identify the addresses of seed hosts.

Versions
--------

Plugin branch | ES version | Release
-----------|-----------|-----------
master | 7.3.x | [elasticsearch-apollo-conf-discovery-v7.3.2](https://github.com/xhkyyy/elasticsearch-apollo-conf-discovery/releases/tag/v7.3.2)
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

+ [elasticsearch-7.3.x.yml](test/elasticsearch-7.3.x.yml)

+ [elasticsearch-6.2.x.yml](test/elasticsearch-6.2.x.yml)

Build
--------

```
./gradlew build
```


