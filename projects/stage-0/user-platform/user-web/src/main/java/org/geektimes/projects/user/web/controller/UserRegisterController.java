package org.geektimes.projects.user.web.controller;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 我就是我，那不一样的烟火～
 * FileName: UserRegisterController
 *
 * @author Mozzie
 * @date 2021/2/28 下午5:34
 * @Description
 */
@Path("/register")
public class UserRegisterController implements PageController {

    private final UserService userService = ComponentContext.getInstance().getComponent("bean/UserService");

    @POST
    @Path("/userRegister")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        // 获取表单信息
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        // 封装用户属性
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        // 新建用户
        userService.register(user);

        return "success.jsp";
    }
}
