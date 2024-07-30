package com.appsec.demo_001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableHystrixDashboard
@RestController
@SpringBootApplication
public class Demo001Application {

    /**
     * @return
     */
    @RequestMapping("/welcome")
    String home() {
        return "Hello, I'm a microservice 1337";
    }

    @PostMapping("/noroute")
    String hide() {
        return "Hello Appsec, vc e o bixao";
    }

    @RequestMapping(value = "/text4shell/biblio", method = RequestMethod.GET)
	@ResponseBody
	public String attack(@RequestParam(defaultValue="pesquisa") String search) {
		StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
		// String pocstring = "${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/foo')}";
		try{
			String pwn = interpolator.replace(search);
		} catch(Exception e) {
			System.out.println(e);
		}
		return "Search results for: " + search;
    }




    public static void main(String[] args) {
        SpringApplication.run(Demo001Application.class, args);
    }

}

