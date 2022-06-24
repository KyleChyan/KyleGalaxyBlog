package com.kyle.controller.admin;

import com.kyle.pojo.User;
import com.kyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/15,16:21,星期三
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/gologin")
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String loginPage(@RequestParam String username, @RequestParam String password,
                            HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "redirect:/admin/bloglist";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin/gologin";
        }
    }
    @GetMapping("/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin/gologin";
    }
}
