package org.geektimes.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 我就是我，那不一样的烟火～
 * FileName: JavaSystermPropertiesConfigSource
 *
 * @author Mozzie
 * @date 2021/3/22 3:54 下午
 * @Description
 */
public class JavaSystemPropertiesConfigSource implements ConfigSource {

    /**
     * Java 系统属性最好通过本地变量保存，使用Map保存，尽可能运行期间不去调整
     */
    private Map<String, String> properties;

    public JavaSystemPropertiesConfigSource() {
        this.properties = new HashMap<>();
        for (String propertyName : System.getProperties().stringPropertyNames()) {
            this.properties.put(propertyName, System.getProperties().getProperty(propertyName));
        }
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "Java System Properties";
    }
}
