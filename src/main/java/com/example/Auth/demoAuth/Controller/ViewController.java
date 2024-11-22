package com.example.Auth.demoAuth.Controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ViewController {


    @GetMapping("/profile")
    public String profile(OAuth2AuthenticationToken token, Model model) {
        Map<String, Object> attributes = token.getPrincipal().getAttributes();

        if (token.getAuthorizedClientRegistrationId().equals("google")) {
            model.addAttribute("name", attributes.get("name"));
            model.addAttribute("email", attributes.get("email"));
            model.addAttribute("picture", attributes.get("picture"));
        } else if (token.getAuthorizedClientRegistrationId().equals("github")) {
            model.addAttribute("name", attributes.get("login"));
            model.addAttribute("email", attributes.get("email"));
            model.addAttribute("picture", attributes.get("avatar_url"));
        } else {
            model.addAttribute("error", "Unsupported login provider");
        }

        return "user-profile";
    }


    @GetMapping("/login")
    public String login(){
        return "custom_login";
    }
}
