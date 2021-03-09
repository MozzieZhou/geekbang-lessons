package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 我就是我，那不一样的烟火～
 * FileName: RegisterController
 *
 * @author Mozzie
 * @date 2021/2/28 下午4:45
 * @Description
 */
@Path("/register")
public class RegisterController implements PageController {

    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "register.jsp";
    }
}
