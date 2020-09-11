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

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    IMemberRepository memberRepository;
/*
    public MemberController(IMemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
*/

    @GetMapping("/")
    public String index(HttpSession session){

        if(session.getAttribute("isLoggedIn") != null){
            return "secret";
        }
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Member member, Model model, HttpSession session){
        //Check if crediatils is in the arrayList
        Member m = memberRepository.read(member.getEmail());
        if(m != null){
            session.setAttribute("isLoggedIn", "yes");
            model.addAttribute("members", memberRepository.readAll());
            return "secret";
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.removeAttribute("isLoggedIn");
        return "index";
    }
}
