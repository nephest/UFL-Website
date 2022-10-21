package server;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Verifies that Spring Boot application is actually runnable
 */
@SpringBootTest
public class SpringBootContextIT {

  private static MockMvc mvc;

  @BeforeEach
  public void beforeEach(@Autowired WebApplicationContext webApplicationContext) {
    mvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .alwaysDo(print())
        .build();
  }

  /*TODO replace with some real REST call when the backend is ready */
  @Test
  public void testSpringBootContext() throws Exception {
    mvc.perform(get("/test/string").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("TEST_STRING"));
  }

}
