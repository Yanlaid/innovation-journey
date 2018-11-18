package cn.shen.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;

/**
 * <p>Title:      tesss. </p>
 * <p>Description TODO </p>
 * 
 *
 * @Author 沈欣然
 * @CreateDate     2018/10/11 1:46
 */
@Controller
public class tesss {
    
    /**
     * <p>Title:      . </p>
     * <p>Description TODO</p>
     *
     * @param         
     * @Author        沈欣然
     * @CreateDate    2018/10/11 1:48
     * @return        
     */
    public String show1(Model model, @CookieValue("JSESSIONID")String JESSIONID){

        model.addAttribute("aaa", "fasdfa");
        return "hello2";
    }
}
