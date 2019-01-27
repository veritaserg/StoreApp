package com.store.springwebapp.controller;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TwilioController {
    public static final String ACCOUNT_SID = "ACd9897e6bf466f905d42bf733b7425833";
    public static final String AUTH_TOKEN = "a27e565b2c5925b8539c278f97a14151";
    public String password;


    @RequestMapping(value = "/security", method = RequestMethod.POST)
    public String getPhoneNumber(@ModelAttribute("phonenumber") String phonenumber) {
        com.twilio.Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        password = String.valueOf((int) (Math.random() * (10000 - 1000) + 1000));
        password = "user";
        Message.creator(new PhoneNumber("+380636284578"), new PhoneNumber("+19159955399"),
                password).create();

        return "confirmpassword";
    }

    @RequestMapping(value = "/confirmpassword", method = RequestMethod.POST)
    public String confirmPassword(@ModelAttribute("password") String password) {

        if (password.equals(this.password))
            return "redirect:/product";

        return "redirect:/registration";
    }

 }