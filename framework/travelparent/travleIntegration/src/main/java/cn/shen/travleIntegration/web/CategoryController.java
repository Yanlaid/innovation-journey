package cn.shen.travleIntegration.web;

import cn.shen.travleIntegration.pojo.ResultInfo;
import cn.shen.travleIntegration.service.ICategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("queryCategoryList")
    @ResponseBody
    public String getCategoryList() {
        ResultInfo resultInfo;
        String jsonDate = null;
        try {
            jsonDate = categoryService.getCategoryList();
            resultInfo = new ResultInfo(true, jsonDate, null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, "服务器错误，请稍后再试");
            try {
                jsonDate = new ObjectMapper().writeValueAsString(resultInfo);
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        }
        return jsonDate;
    }
}
