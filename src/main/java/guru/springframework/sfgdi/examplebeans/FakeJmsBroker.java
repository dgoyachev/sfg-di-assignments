package guru.springframework.sfgdi.examplebeans;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by morgan on 04.03.2020
 */

public class FakeJmsBroker {

    private String jmsuser;
    private String jmspassword;
    private String jmsurl;

    public FakeJmsBroker() {
    }

    public FakeJmsBroker(String jmsuser, String jmspassword, String jmsurl) {
        this.jmsuser = jmsuser;
        this.jmspassword = jmspassword;
        this.jmsurl = jmsurl;
    }

    public String getJmsuser() {
        return jmsuser;
    }

    public void setJmsuser(String jmsuser) {
        this.jmsuser = jmsuser;
    }

    public String getJmspassword() {
        return jmspassword;
    }

    public void setJmspassword(String jmspassword) {
        this.jmspassword = jmspassword;
    }

    public String getJmsurl() {
        return jmsurl;
    }

    public void setJmsurl(String jmsurl) {
        this.jmsurl = jmsurl;
    }

    @Override
    public String toString() {
        return "FakeJmsBroker{" +
                "jmsuser='" + jmsuser + '\'' +
                ", jmspassword='" + jmspassword + '\'' +
                ", jmsurl='" + jmsurl + '\'' +
                '}';
    }
}
