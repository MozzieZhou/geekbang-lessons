package org.geektimes.cache.lettuce;

import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.ToByteBufEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

import javax.cache.CacheException;
import java.io.*;
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
        System.out.println("decodeKey");
        return null;
    }

    @Override
    public V decodeValue(ByteBuffer bytes) {
        System.out.println("decodeValue");

        return null;
    }

    @Override
    public ByteBuffer encodeKey(K key) {
        System.out.println("encodeKey1");
        return null;
    }

    @Override
    public ByteBuffer encodeValue(V value) {
        System.out.println("value1");
        return null;
    }

    @Override
    public void encodeKey(K key, ByteBuf target) {
        target.writeBytes(serialize(key));
    }

    @Override
    public void encodeValue(V value, ByteBuf target) {
        target.writeBytes(serialize(value));
    }

    @Override
    public int estimateSize(Object keyOrValue) {
        return 0;
    }

    private byte[] serialize(Object value) throws CacheException {
        byte[] bytes = null;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            // Key -> byte[]
            objectOutputStream.writeObject(value);
            bytes = outputStream.toByteArray();
        } catch (IOException e) {
            throw new CacheException(e);
        }
        return bytes;
    }

    private V deserialize(byte[] bytes) throws CacheException {
        if (bytes == null) {
            return null;
        }
        V value = null;
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {
            // byte[] -> Value
            value = (V) objectInputStream.readObject();
        } catch (Exception e) {
            throw new CacheException(e);
        }
        return value;
    }
}
