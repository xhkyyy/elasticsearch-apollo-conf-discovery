package com.service;

import org.elasticsearch.common.transport.TransportAddress;

import java.util.List;

/**
 * @author xhkyyy
 */
public interface ConfService {
    List<TransportAddress> getSeedAddresses();
}
