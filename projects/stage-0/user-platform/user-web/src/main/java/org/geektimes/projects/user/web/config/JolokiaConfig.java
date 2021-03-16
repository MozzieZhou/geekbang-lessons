package org.geektimes.projects.user.web.config;

import org.jolokia.client.J4pClient;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;

import java.util.Map;

/**
 * 我就是我，那不一样的烟火～
 * FileName: JolokiaConfig
 *
 * @author Mozzie
 * @date 2021/3/15 11:33 下午
 * @Description
 */
public class JolokiaConfig {

    public static void main(String[] args) throws Exception {

        J4pClient j4pClient = new J4pClient("http://localhost:8080/jolokia");
        J4pReadRequest req = new J4pReadRequest("java.lang:type=Memory",
                "HeapMemoryUsage");
        J4pReadResponse resp = j4pClient.execute(req);
        Map<String,Long> vals = resp.getValue();
        long used = vals.get("used");
        long max = vals.get("max");
        int usage = (int) (used * 100 / max);
        System.out.println("Memory usage: used: " + used +
                " / max: " + max + " = " + usage + "%");
    }
}
