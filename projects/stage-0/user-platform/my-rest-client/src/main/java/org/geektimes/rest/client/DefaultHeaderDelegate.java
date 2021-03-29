package org.geektimes.rest.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.RuntimeDelegate;

/**
 * FileName: DefaultHeaderDelegate
 *
 * @author Mozzie
 * @email: mozzie.zhou@gmail.com
 * @date 2021/3/29 5:18 下午
 * @Description
 */
public class DefaultHeaderDelegate<T> implements RuntimeDelegate.HeaderDelegate<T> {


    @Override
    public T fromString(String value) {

        String[] split = value.split("/");

        return (T) new MediaType(split[0], split[1]);
    }

    @Override
    public String toString(T value) {
        return value.toString();
    }
}
