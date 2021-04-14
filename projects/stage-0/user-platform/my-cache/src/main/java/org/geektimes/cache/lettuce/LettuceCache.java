package org.geektimes.cache.lettuce;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.geektimes.cache.AbstractCache;

import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import java.util.Iterator;

/**
 * FileName: LettuceCache
 *
 * @author Mozzie
 * @email: mozzie.zhou@gmail.com
 * @date 2021/4/13 10:52 下午
 * @Description
 */
public class LettuceCache<K, V> extends AbstractCache<K, V> {

    private final RedisCommands<K, V> redisCommands;

    protected LettuceCache(CacheManager cacheManager, String cacheName,
                           Configuration<K, V> configuration, StatefulRedisConnection<K, V> connection) {
        super(cacheManager, cacheName, configuration);
        this.redisCommands = connection.sync();
    }

    @Override
    protected V doGet(K key) throws CacheException, ClassCastException {
        return redisCommands.get(key);
    }

    @Override
    protected V doPut(K key, V value) throws CacheException, ClassCastException {
        return (V) redisCommands.set(key,value);
    }

    @Override
    protected V doRemove(K key) throws CacheException, ClassCastException {
        return (V) redisCommands.del(key);
    }

    @Override
    protected void doClear() throws CacheException {

    }

    @Override
    protected Iterator<Entry<K, V>> newIterator() {
        return null;
    }
}
