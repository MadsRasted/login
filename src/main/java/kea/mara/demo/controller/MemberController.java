package kea.mara.demo.controller;

import kea.mara.demo.model.Member;
import kea.mara.demo.repository.IMemberRepository;
import kea.mara.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    IMemberRepository memberRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Member m, Model model){

        model.addAttribute("members", memberRepository.readAll());
        //System.out.println(m.getEmail());
        //System.out.println(m.getPassword());
        return "secret";
    }
}
