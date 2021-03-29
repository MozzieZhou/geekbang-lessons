package org.geektimes.rest.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.geektimes.rest.core.DefaultResponse;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * FileName: HttpPostInvocation
 *
 * @author Mozzie
 * @email: mozzie.zhou@gmail.com
 * @date 2021/3/29 11:26 上午
 * @Description
 */
public class HttpPostInvocation implements Invocation {

    private final URI uri;

    private final URL url;

    private final MultivaluedMap<String, Object> headers;

    private final Entity<?> entity;

    public HttpPostInvocation(URI uri, MultivaluedMap<String, Object> headers, Entity<?> entity) {
        this.uri = uri;
        this.headers = headers;
        this.entity = entity;
        try {
            this.url = uri.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }

    private void setRequestHeaders(HttpURLConnection connection) {
        for (Map.Entry<String, List<Object>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            for (Object headerValue : entry.getValue()) {
                connection.setRequestProperty(headerName, headerValue.toString());
            }
        }
    }

    private void setPostMethodHttpConnection(HttpURLConnection connection){
        try {
            //  设置post方法
            connection.setRequestMethod(HttpMethod.POST);

            // 设置请求头
            setRequestHeaders(connection);

            // 打开权限，为设置消息体作准备
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);

            // 强制设置接受类型，否则报错 415
            connection.setRequestProperty("accept","application/json");
        } catch (ProtocolException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Invocation property(String name, Object value) {
        return this;
    }

    @Override
    public Response invoke() {
        HttpURLConnection connection;

        try {
            // 设置Post属性
            connection = (HttpURLConnection) url.openConnection();
            setPostMethodHttpConnection(connection);

            // 设置消息体
            Object entity = this.entity.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            String bodyJson = mapper.writeValueAsString(entity);
            if (StringUtils.isNotBlank(bodyJson)) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(bodyJson.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            }

            DefaultResponse response = new DefaultResponse();
            response.setConnection(connection);
            response.setStatus(response.getStatus());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T invoke(Class<T> responseType) {
        Response response = invoke();
        return response.readEntity(responseType);
    }

    @Override
    public <T> T invoke(GenericType<T> responseType) {
        Response response = invoke();
        return response.readEntity(responseType);
    }

    @Override
    public Future<Response> submit() {
        return null;
    }

    @Override
    public <T> Future<T> submit(Class<T> responseType) {
        return null;
    }

    @Override
    public <T> Future<T> submit(GenericType<T> responseType) {
        return null;
    }

    @Override
    public <T> Future<T> submit(InvocationCallback<T> callback) {
        return null;
    }
}
