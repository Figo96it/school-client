package pl.sda;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class AppController {

    private static final Logger logger = getLogger(AppController.class);

    @Value("${welcome.message:test}")
    private String message;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        logger.debug("Welcome {}", "test" + message);
        model.put("message", this.message);
        return "studentLogged";
    }

}
