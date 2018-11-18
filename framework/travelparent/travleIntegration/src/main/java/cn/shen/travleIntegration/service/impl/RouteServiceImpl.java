package cn.shen.travleIntegration.service.impl;

import cn.shen.travleIntegration.mapper.RouteMapper;
import cn.shen.travleIntegration.pojo.PageBean;
import cn.shen.travleIntegration.pojo.Route;
import cn.shen.travleIntegration.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public HashMap<String, List<Route>> getRouteCareChoose() {

        HashMap<String, List<Route>> hm = new HashMap<>();
        //
        List<Route> popularity = routeMapper.queryPopularityRouteList();
        //
        List<Route> news = routeMapper.queryNewsRouteList();
        //
        List<Route> themes = routeMapper.queryThemesRouteList();

        hm.put("popularity", popularity);
        hm.put("news", news);
        hm.put("themes", themes);
        return hm;
    }

    @Override
    public PageBean queryPageBean(Integer cid, Integer curpage, String rname) {

        int pageSize = 5;
        int firstResult = (curpage-1)*pageSize;
        int count = routeMapper.queryRouteCount(cid,rname);
        List<Route> routes = routeMapper.queryRouteListPage(cid,rname,firstResult,pageSize);
        PageBean pageBean = new PageBean();
        pageBean.setCount(count);
        pageBean.setCurPage(curpage);
        pageBean.setPageSize(pageSize);
        pageBean.setData(routes);
        return pageBean;

    }
}
