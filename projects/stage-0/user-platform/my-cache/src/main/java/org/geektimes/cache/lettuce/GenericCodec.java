package org.geektimes.cache.lettuce;

import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.ToByteBufEncoder;
import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

/**
 * FileName: GenericCodec
 *
 * @author Mozzie
 * @email: mozzie.zhou@gmail.com
 * @date 2021/4/13 11:13 下午
 * @Description
 */
public class GenericCodec<K,V> implements  RedisCodec<K, V>, ToByteBufEncoder<K, V> {

    @Override
    public K decodeKey(ByteBuffer bytes) {
        return null;
    }

    @Override
    public V decodeValue(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encodeKey(K key) {
        return null;
    }

    @Override
    public ByteBuffer encodeValue(V value) {
        return null;
    }

    @Override
    public void encodeKey(K key, ByteBuf target) {

    }

    @Override
    public void encodeValue(V value, ByteBuf target) {

    }

    @Override
    public int estimateSize(Object keyOrValue) {
        return 0;
    }
}
