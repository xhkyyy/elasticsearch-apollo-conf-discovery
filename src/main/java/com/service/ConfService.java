package com.service;

import org.elasticsearch.cluster.node.DiscoveryNode;

import java.util.List;

/**
 * @author xhkyyy
 */
public interface ConfService {
    List<DiscoveryNode> getSeedAddresses();
}
