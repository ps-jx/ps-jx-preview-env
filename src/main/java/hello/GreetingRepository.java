package hello;

import hello.Greeting.GreetingType;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

  Optional<Greeting> findByGreetingType(GreetingType greetingType);
}
