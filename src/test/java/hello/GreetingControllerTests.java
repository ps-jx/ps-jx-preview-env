/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnGreetings() throws Exception {

    mockMvc.perform(get("/greeting?greetingType=ANGRY"))
        .andExpect(status().isOk())
        .andExpect(content().string("You are not welcome here."));

    mockMvc.perform(get("/greeting?greetingType=HAPPY"))
        .andExpect(status().isOk())
        .andExpect(content().string("Wonderful to meet you."));

    mockMvc.perform(get("/greeting?greetingType=NEUTRAL"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello."));

    mockMvc.perform(get("/greeting?greetingType=SAD"))
        .andExpect(status().isOk())
        .andExpect(content().string("It's not very fun here, sorry"));
  }
}
