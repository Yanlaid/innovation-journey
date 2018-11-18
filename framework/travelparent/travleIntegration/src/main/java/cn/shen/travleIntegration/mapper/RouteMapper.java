package cn.shen.travleIntegration.mapper;

import cn.shen.travleIntegration.pojo.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteMapper {
    List<Route> queryPopularityRouteList();

    List<Route> queryNewsRouteList();

    List<Route> queryThemesRouteList();


    int queryRouteCount(@Param("cid") Integer cid, @Param("rname") String rname);

    List<Route> queryRouteListPage(@Param("cid") Integer cid, @Param("rname") String rname, @Param("firstResult") int firstResult, @Param("pageSize") int pageSize);

}
