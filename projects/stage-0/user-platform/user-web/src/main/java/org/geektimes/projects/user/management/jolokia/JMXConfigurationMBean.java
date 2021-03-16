package org.geektimes.projects.user.management.jolokia;

/**
 * 我就是我，那不一样的烟火～
 * FileName: JMXConfigurationMBean
 *
 * @author Mozzie
 * @date 2021/3/15 5:45 下午
 * @Description
 */
public class JMXConfigurationMBean implements JMXConfiguration {


    @Override
    public String printHello() {
        return "HELLO WORLD";
    }
}
