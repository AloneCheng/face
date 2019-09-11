package com.face.http;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.face.http.domain.DetectHttpResponse;
import com.face.http.domain.FaceRectangle;
import com.face.http.domain.ImageUtil;
import com.face.http.domain.MerageHttpResponse;

public class ChangeFace {

    private static final String detectFaceUrl = "https://api-cn.faceplusplus.com/facepp/v3/detect";
    private static final String merageFaceUrl = "https://api-cn.faceplusplus.com/imagepp/v1/mergeface";
    private static final String api_key = "vABmnV-d5KkN8kQVObQyLI1X4AgjeGo0";
    private static final String api_secret = "zB3xsJ2JsugN035cJq0Es2fdmQKs7Kak";
    private static final String image_file = "C:/Users/gouquancheng/Desktop/face/vedioChange/";
    
    public static void main(String[] args) {
        merageFace(image_file+"face.jpg",image_file+"body.jpg");
    }
    public static DetectHttpResponse detectFace(String facePath) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("api_key", api_key);
        param.put("api_secret", api_secret);
        String responseStr = HttpUtil.doPost(detectFaceUrl, param,facePath);
        DetectHttpResponse detectHttpResponse = JSON.parseObject(responseStr, DetectHttpResponse.class);
        return detectHttpResponse;
    }
    public static void merageFace(String facePath,String bodyPath) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("api_key", api_key);
        param.put("api_secret", api_secret);
        DetectHttpResponse faceParam = JSON.parseObject(HttpUtil.doPost(detectFaceUrl, param,facePath), DetectHttpResponse.class);
        FaceRectangle rectangle = faceParam.getFaces().get(0).getFace_rectangle();
        String merge_rectangle = rectangle.getTop()+","+rectangle.getLeft()+","+rectangle.getWidth()+","+rectangle.getHeight();
        param.put("merge_rectangle",merge_rectangle);
        String responseStr = HttpUtil.doMeragePost(merageFaceUrl, param, facePath, bodyPath);
        MerageHttpResponse merageHttpResponse = JSON.parseObject(responseStr, MerageHttpResponse.class);
        ImageUtil.GenerateImage(merageHttpResponse.getResult(), image_file+"ALL.jpeg");
    }
    
}
