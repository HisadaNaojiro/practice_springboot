package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.GroupOrder;

@Controller
public class SignupController {
    //ポイント１：ラジオボタンの実装
    private Map<String,String> radioMarriage;

    //ラジオボタンの初期化メソッド
    private Map<String,String> initRadioMarrige() {
        Map<String, String> radio = new LinkedHashMap<>();
        //既婚、未婚をMapに格納
        radio.put("既婚", "true");
        radio.put("未婚", "false");
        return radio;
    }

    @GetMapping("/signup")
    public String getSignup(@ModelAttribute SignupForm form, Model model) {

        // ラジオボタンの初期化メソッド呼び出し
        radioMarriage = initRadioMarrige();

        // ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage);


        return "login/signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return getSignup(form, model);
        }

        System.out.println(form);
        // login.htmlにリダイレクト
        return "redirect:/login";
    }
}
