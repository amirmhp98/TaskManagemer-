package main.java.entity;

/**
 * Created by amirmhp on 12/21/2018.
 */
public class RequestObject {
    String requesterId;
    BaseEntity content;


    public String getRequesterId() {
        return requesterId;
    }
    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }
    public BaseEntity getContent() {
        return content;
    }
    public void setContent(BaseEntity content) {
        this.content = content;
    }
}
