package org.geektimes.microprofile.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigBuilder;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 我就是我，那不一样的烟火～
 * FileName: JavaEEConfigProviderResolver
 *
 * @author Mozzie
 * @date 2021/3/22 2:29 下午
 * @Description
 */
public class JavaEEConfigProviderResolver extends ConfigProviderResolver {



    @Override
    public Config getConfig() {
        return getConfig(null);
    }

    @Override
    public Config getConfig(ClassLoader loader) {
        ClassLoader classLoader = loader;
        if (classLoader == null) {
            loader = Thread.currentThread().getContextClassLoader();
        }
        // 装载classloader, 将classloader与config绑定
        ServiceLoader<Config> serviceLoader = ServiceLoader.load(Config.class, loader);
        Iterator<Config> iterator = serviceLoader.iterator();

        // 获取conifg SPI的第一个实现
        return iterator.hasNext() ? iterator.next() : null;
    }

    @Override
    public ConfigBuilder getBuilder() {
        return null;
    }

    @Override
    public void registerConfig(Config config, ClassLoader classLoader) {

    }

    @Override
    public void releaseConfig(Config config) {

    }
}
