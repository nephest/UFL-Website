package server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*TODO Remove when real backend is ready */
@RestController
@RequestMapping("/test")
public class TestController {

  public static final String TEST_STRING = "TEST_STRING";

  @GetMapping("/string")
  public String getTestString() {
    return TEST_STRING;
  }

}
