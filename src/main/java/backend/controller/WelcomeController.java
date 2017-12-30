package backend.controller;

import backend.configuration.BasicConfiguration;
import backend.service.ProfilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.service.WelcomeService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @Autowired
    private ProfilerService profilerService;

    @Autowired
    private BasicConfiguration configuration;

    @RequestMapping("/welcome")
    public String welcome(){
        return welcomeService.retrieveWelcomeMessage() +"\t"+ profilerService.getProfileName();
    }

    @RequestMapping("/dynamic-configuration")
    public Map getConfiguration(){
        Map map =  new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;
    }
}
