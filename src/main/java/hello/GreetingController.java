package hello;

import hello.Greeting.GreetingType;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @PostConstruct
    public void storeGreetings() {
        greetingRepository.save(new Greeting(GreetingType.ANGRY, "You are not welcome here."));
        greetingRepository.save(new Greeting(GreetingType.HAPPY, "Wonderful to meet you."));
        greetingRepository.save(new Greeting(GreetingType.NEUTRAL, "Hello."));
        greetingRepository.save(new Greeting(GreetingType.SAD, "It's not very fun here, sorry"));
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="greetingType", defaultValue="World") GreetingType greetingType) {
        return greetingRepository.findByGreetingType(greetingType).map(Greeting::getContent).get();
    }

    @RequestMapping("/")
    public String defaultEndpoint() {
        return "Hello world";
    }
}
