package com.face.http.domain;

import java.util.List;

public class DetectHttpResponse {

    
    private String face_num;
    private String time_used;
    private String request_id;
    private String image_id;
    
    
    private List<Face> faces;


    public String getFace_num() {
        return face_num;
    }


    public void setFace_num(String face_num) {
        this.face_num = face_num;
    }


    public String getTime_used() {
        return time_used;
    }


    public void setTime_used(String time_used) {
        this.time_used = time_used;
    }


    public String getRequest_id() {
        return request_id;
    }


    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }


    public String getImage_id() {
        return image_id;
    }


    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }


    public List<Face> getFaces() {
        return faces;
    }


    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }
    
    
}
