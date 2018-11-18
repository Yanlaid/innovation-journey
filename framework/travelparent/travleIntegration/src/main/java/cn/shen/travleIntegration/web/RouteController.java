package cn.shen.travleIntegration.web;

import cn.shen.travleIntegration.pojo.PageBean;
import cn.shen.travleIntegration.pojo.ResultInfo;
import cn.shen.travleIntegration.pojo.Route;
import cn.shen.travleIntegration.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("route")
public class RouteController {
    @Autowired
    private IRouteService routeService;

    @RequestMapping("routeCareChoose")
    @ResponseBody
    public ResultInfo getRouteCareChoose() {
        ResultInfo resultInfo;
        try {
            HashMap<String, List<Route>> routeHashMap = routeService.getRouteCareChoose();
            resultInfo = new ResultInfo(true, routeHashMap, null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器错误，请稍后");
        }
        return resultInfo;
    }

    @RequestMapping("queryPageBean")
    @ResponseBody
    public ResultInfo queryPageBean(@RequestParam(value = "cid", required = false) Integer cid,
                                    @RequestParam(value = "curPage", defaultValue = "1") Integer curpage,
                                    @RequestParam(value = "rname", required = false) String rname) {
        ResultInfo resultInfo;
        try {
            PageBean pageBean = routeService.queryPageBean(cid,curpage,rname);
            resultInfo = new ResultInfo(true, pageBean, null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器正忙，请稍后再试");
        }
        return resultInfo;
    }
}
