package top.aiprogram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.aiprogram.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/9/28.
 */

@Controller
//RequeMappin的路径是spring-mvc配置里视图解析器的路径，相当于"./WEB-INF/view/XXX.jsp"
@RequestMapping("user")
public class UserController {
//  相当于将下面的方法配为test,方便jsp调用
//   将数据拿到前端，这里一个方法控制了一个jsp页面，/user/test
    @RequestMapping("test")
    public ModelAndView testUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        User user = new User();
        user.setId(12);
        user.setName("laoli");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping("demo")
    public String demoUser(ModelMap modelMap) {
        User user = new User();
        user.setId(13);
        user.setName("xiaoxu");
        modelMap.addAttribute("user",user);
        return "redirect:/user/red";            //重定向
    }

    @RequestMapping("postdemo")
    public String postdemoUser() {
        return "postdemo";
    }


//
//    请求转发和重定向
//    get & post传递参数
    @RequestMapping("red")
    public String redUser(ModelMap modelMap, HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
//        modelMap.addAttribute("red");
        return "red";
    }

    @RequestMapping("getApost")
    public String getApostUser(ModelMap modelMap, User user) {
        modelMap.addAttribute("red",user);
        return "red";
    }


//   将前台数据传到后台
    @RequestMapping("forepage/{id}/{name}")
    public String foreUser (ModelMap modelMap, HttpServletRequest request, @PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println(id + " " + name);
        User user = new User();
        user.setId(13);
        user.setName("xiaoxu");
        modelMap.addAttribute("forepage",user);
        return "forepage";
    }

    @RequestMapping("json")
//  加载返回体对象
    @ResponseBody
    public User jsonUser() {
        User user = new User();
        user.setId(17);
        user.setName("xiaoxin");
        return user;
    }



}
