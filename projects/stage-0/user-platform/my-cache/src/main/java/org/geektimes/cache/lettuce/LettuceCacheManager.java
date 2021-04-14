package org.geektimes.cache.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import org.geektimes.cache.AbstractCacheManager;

import javax.cache.Cache;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Properties;

/**
 * FileName: LettuceCacheManager
 *
 * @author Mozzie
 * @email: mozzie.zhou@gmail.com
 * @date 2021/4/13 10:48 下午
 * @Description
 */
public class LettuceCacheManager extends AbstractCacheManager {

    private final RedisClient redisClient;

    public LettuceCacheManager(CachingProvider cachingProvider, URI uri, ClassLoader classLoader, Properties properties) {
        super(cachingProvider, uri, classLoader, properties);
        this.redisClient = RedisClient.create(uri.toString());
    }

    @Override
    protected <K, V, C extends Configuration<K, V>> Cache doCreateCache(String cacheName, C configuration) {
        StatefulRedisConnection<K, V> connection = redisClient.connect(new GenericCodec<>());
        return new LettuceCache(this, cacheName, configuration, connection);
    }

    @Override
    protected void doClose() {
        redisClient.shutdown();
    }
}
