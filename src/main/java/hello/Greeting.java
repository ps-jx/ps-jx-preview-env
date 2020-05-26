package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greeting")
public class Greeting {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private GreetingType greetingType = GreetingType.NEUTRAL;

    @Column(name = "content")
    private String content;

    public Greeting() {
    }

    public Greeting(GreetingType greetingType, String content) {
        this.greetingType = greetingType;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public GreetingType getGreetingType() {
        return greetingType;
    }

    public void setGreetingType(GreetingType greetingType) {
        this.greetingType = greetingType;
    }

    public static enum GreetingType {
        NEUTRAL, HAPPY, SAD, ANGRY
    }
}
