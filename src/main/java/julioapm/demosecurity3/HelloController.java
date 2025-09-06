package julioapm.demosecurity3;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/public/health")
  public String health() {
    return "Hello controller";
  }

  @GetMapping("/api/hello")
  public String hello(Authentication authentication) {
    return "Hello, "+authentication.getName();
  }

  @GetMapping("/api/admin")
  public String admin() {
    return "Hello, admin!";
  }
}
