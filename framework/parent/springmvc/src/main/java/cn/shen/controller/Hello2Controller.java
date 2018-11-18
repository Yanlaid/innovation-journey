package cn.shen.controller;

import cn.shen.domain.User;
import cn.shen.domain.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * @Controller：表示此类是一个model。并不是C层（对于MVC思想来说）
 * */
@SuppressWarnings("ALL")
@Controller
// @RequestMapping("test")
public class Hello2Controller {
    //可以省略 / 和 .do
    @RequestMapping("mav1")
    public ModelAndView mav1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "这是第一个基于注解的springMVC样例");
        return modelAndView;
    }

    /**
     * ant 风格
     * ? 代表任意一个字符
     *
     * @return
     */
    @RequestMapping("ab?/mav2")
    public ModelAndView mav2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "ant 风格\n" +
                "     <br>  ? 代表任意一个字符;作用于路径");
        return modelAndView;
    }

    /**
     * ant 风格
     * * 代表 0 或多个字符
     *
     * @return
     */
    @RequestMapping("ab*/mav3")
    public ModelAndView mav3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "ant 风格\n" +
                "     <br>  * 代表 0 或多个字符;作用于路径");
        return modelAndView;
    }

    /**
     * ant 风格
     * ** 代表 0 或多个路径
     *
     * @return
     */
    @RequestMapping("**/mav4")
    public ModelAndView mav4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "ant 风格\n" +
                "     <br>  ** 代表 0 或多个路径");
        return modelAndView;
    }

    /**
     * 占位符映射
     * /{id}/{xxx}/....
     * 可以起到传递参数的功能
     * {xx}的xx 要和@PthVaariable("xx")的相同
     *
     * @return
     */
    @RequestMapping("mav5/{id}/{name}")
    public ModelAndView mav5(@PathVariable("id") int id, @PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "占位符：id: " + id + "。name: " + name);
        return modelAndView;
    }

    /**
     * 限定请求方法映射
     * 指定请求方式
     */
    @RequestMapping(value = "mav6", method = RequestMethod.POST)
    public ModelAndView mav6() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法映射:method = RequestMethod.POST");
        return modelAndView;
    }

    /**
     * 限定请求方法映射
     * 指定请求方式
     *
     * @return
     */
    @RequestMapping(value = "mav7", method = RequestMethod.DELETE)
    public ModelAndView mav7() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法映射:method = RequestMethod.DELETE");
        return modelAndView;
    }

    /**
     * 限定请求方法参数映射
     * 对请求中的参数进行控制操作
     *
     * @return
     */
    @RequestMapping(value = "mav8", params = "id")
    public ModelAndView mav8() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法参数映射：必须要有 id");
        return modelAndView;
    }

    /**
     * 限定请求方法参数映射
     * 对请求中的参数进行控制操作
     *
     * @return
     */
    @RequestMapping(value = "mav9", params = "!id")
    public ModelAndView mav9() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法参数映射：!id 参数中不能有 id");
        return modelAndView;
    }

    /**
     * 限定请求方法参数映射
     * 对请求中的参数进行控制操作
     *
     * @return
     */
    @RequestMapping(value = "mav10", params = "id=10")
    public ModelAndView mav10() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法参数映射：id=10 参数中 id必须等于10");
        return modelAndView;
    }

    /**
     * 限定请求方法参数映射
     * 对请求中的参数进行控制操作
     *
     * @return
     */
    @RequestMapping(value = "mav11", params = "id!=10")
    public ModelAndView mav11() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法参数映射：id!=10 参数中 id必须不等于10");
        return modelAndView;
    }

    /**
     * 限定请求方法参数映射
     * 对请求中的参数进行控制操作
     *
     * @return
     */
    @RequestMapping(value = "mav12", params = {"id", "name"})
    public ModelAndView mav12() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "限定请求方法参数映射：params = {\"id\",\"name\"} 参数中 必须要有id 和 name 属性");
        return modelAndView;
    }

    /**
     * 组合注解
     * 简化 method = RequestMethod.DELETE 等等
     *
     * @return
     */
    // @RequestMapping(value = "mav12",method = RequestMethod.DELETE)
    @GetMapping(value = "mav13")
    public ModelAndView mav13() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "组合注解：@GetMapping(value = \"mav13\") 限定请求方式为 GET");
        return modelAndView;
    }

    /**
     * 组合注解
     * 简化 method = RequestMethod.DELETE 等等
     *
     * @return
     */
    // @RequestMapping(value = "mav12",method = RequestMethod.DELETE)
    @PostMapping(value = "mav14")
    public ModelAndView mav14() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "组合注解：@PostMapping(value = \"mav14\") 限定请求方式为 POST");
        return modelAndView;
    }

    /**
     * 组合注解
     * 简化 method = RequestMethod.DELETE 等等
     *
     * @return
     */
    // @RequestMapping(value = "mav12",method = RequestMethod.DELETE)
    @PutMapping("mav15")
    public ModelAndView mav15() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "组合注解：@PutMapping(\"mav15\") 限定请求方式为 PUT");
        return modelAndView;
    }

    /**
     * 组合注解
     * 简化 method = RequestMethod.DELETE 等等
     *
     * @return
     */
    @DeleteMapping("mav16")
    public ModelAndView mav16() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "组合注解：@DeleteMapping(\"mav16\") 限定请求方式为 DELETE");
        return modelAndView;
    }

    /**
     * 接收普通的请求参数
     * 获取请求中参数
     * value:请求中的参数名
     * required：此参数是否必须存在
     * defaultValue：默认值
     *
     * @return
     */
    @GetMapping("mav17")
    public ModelAndView mav17(@RequestParam(value = "name", required = true) String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "接收普通的请求参数:name :" + name);
        return modelAndView;
    }

    /**
     * 接收普通的请求参数
     *
     * @return
     */
    @GetMapping("mav18")
    public ModelAndView mav18(@RequestParam(value = "name", required = false, defaultValue = "shen") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("msg", "接收普通的请求参数:name :" + name);
        return modelAndView;
    }

    /**
     * 纯单个获取参数
     *
     * @param
     * @return
     */
    @RequestMapping("mav19")
    public ModelAndView mav19(@RequestParam("username") String username,
                              @RequestParam("age") Integer age,
                              @RequestParam("isMarry") Boolean isMarry,
                              @RequestParam("income") Double income,
                              @RequestParam(value = "hobby", defaultValue = "football") String[] hobby
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        StringBuffer sb = new StringBuffer();
        sb.append(username + "," + age + "," + isMarry + "," + income);
        if (hobby != null) {
            for (String s : hobby) {
                sb.append("," + s);
            }
        }
        modelAndView.addObject("msg", sb);
        return modelAndView;
    }

    /**
     * 表单中的数据会自动注入到实体类中（前提：表单的属性名需要与实体类属性名相同）
     *
     * @param user
     * @return
     */
    @RequestMapping("mav20")
    public ModelAndView mav20(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", user);
        modelAndView.setViewName("hello2");
        return modelAndView;
    }

    /**
     * 若有多个实体类需要保存
     *
     * @param user
     * @return
     */
    @RequestMapping("mav21")
    public ModelAndView mav21(UserVO userVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", userVO);
        modelAndView.setViewName("hello2");
        return modelAndView;
    }

    @RequestMapping("mav22")
    public ModelAndView mav22(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(request.toString() + "<br>");
        stringBuffer.append(response.toString() + "<br>");
        stringBuffer.append(session.toString() + "<br>");
        modelAndView.addObject("msg", stringBuffer);
        return modelAndView;
    }

    @RequestMapping("mav23")
    public String mav23(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(request.toString() + "<br>");
        stringBuffer.append(response.toString() + "<br>");
        stringBuffer.append(session.toString() + "<br>");

        model.addAttribute("msg", stringBuffer);
        return "hello2";
    }

    @RequestMapping("mav24")
    public String mav24(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(request.toString() + "<br>");
        stringBuffer.append(response.toString() + "<br>");
        stringBuffer.append(session.toString() + "<br>");

        modelMap.addAttribute("msg", stringBuffer);
        return "hello2";
    }

    @RequestMapping("mav25")
    public String mav25(Model model, @CookieValue("JSESSIONID") String jsessionid) {
        model.addAttribute("msg", jsessionid);
        return "hello2";
    }
}
