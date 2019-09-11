package com.face.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class FaceApi {

    
    public static void main(String[] args) {
        try {
            HttpClientPost("http://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=http%3A%2F%2Fphotocdn.sohu.com%2F20120808%2FImg350129585.jpg&thumburl=http%3A%2F%2Fimg5.imgtn.bdimg.com%2Fit%2Fu%3D3297261154%2C2231661797%26fm%3D26%26gp%3D0.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void HttpClientPost(String path) throws Exception {
        // 获取默认的请求客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过HttpPost来发送post请求
        HttpPost httpPost = new HttpPost("https://api-cn.faceplusplus.com/facepp/v3/detect");
        /*
         * post带参数开始s
         */
        // 第三步：构造list集合，往里面丢数据
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("api_key", "vABmnV-d5KkN8kQVObQyLI1X4AgjeGo0");
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("api_secret", "zB3xsJ2JsugN035cJq0Es2fdmQKs7Kak");
        BasicNameValuePair basicNameValuePair3 = new BasicNameValuePair("image_url", path);
        list.add(basicNameValuePair);
        list.add(basicNameValuePair2);
        list.add(basicNameValuePair3);
        // 第二步：我们发现Entity是一个接口，所以只能找实现类，发现实现类又需要一个集合，集合的泛型是NameValuePair类型
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
        // 第一步：通过setEntity 将我们的entity对象传递过去
        httpPost.setEntity(formEntity);
        /*
         * post带参数结束
         */
        // HttpEntity
        // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
        // 通过client来执行请求，获取一个响应结果
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");
        System.out.println(str);
        // 关闭
        response.close();
    }

}
