package cn.shen.travleIntegration.service;

import cn.shen.travleIntegration.pojo.PageBean;
import cn.shen.travleIntegration.pojo.Route;

import java.util.HashMap;
import java.util.List;

public interface IRouteService {
    HashMap<String, List<Route>> getRouteCareChoose();

    PageBean queryPageBean(Integer cid, Integer curpage, String rname);
}
