package cn.tensquare.spit.web.controller;

import cn.tensquare.spit.po.Spit;
import cn.tensquare.spit.service.SpitService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 增加
     */
    @PostMapping
    public ResultDTO add(@RequestBody Spit spit) {
        spitService.saveSpit(spit);
        return new ResultDTO(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param spit
     */
    @PutMapping("/{id}")
    public ResultDTO edit(@RequestBody Spit spit, @PathVariable String id) {
        spit.setId(id);
        spitService.updateSpit(spit);
        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResultDTO remove(@PathVariable String id) {
        spitService.deleteSpitById(id);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @GetMapping
    public ResultDTO list() {
        return new ResultDTO(true, StatusCode.OK, "查询成功", spitService.findSpitList());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public ResultDTO listById(@PathVariable String id) {
        return new ResultDTO(true, StatusCode.OK, "查询成功", spitService.findSpitById(id));
    }

    /**
     * 根据上级ID查询吐槽数据（分页)
     */
    @GetMapping("/comment/{parentid}/{page}/{size}")
    public ResultDTO listPageByParentid(@PathVariable String parentid, @PathVariable int page, @PathVariable int size) {
        {
            Page pageInfo = spitService.findListByParentIdWithPage(parentid, page, size);
            return new ResultDTO(true, StatusCode.OK, "查询成功",
                    new PageResultDTO<Spit>(pageInfo.getTotalElements(), pageInfo.getContent()));
        }
    }

    /**
     * 点赞t
     */
    @PutMapping("thumbup/{spitId}")
    public ResultDTO updateSpitThumbupToIncrementing(@PathVariable String spitId) {
        Integer spitThumbStatus = (Integer) redisTemplate.opsForValue().get("SpitThumbStatus_" + spitId);
        if (null == spitThumbStatus) {
            spitService.updateSpitThumbupToIncrementing(spitId);
            redisTemplate.opsForValue().set("SpitThumbStatus_" + spitId,1,1, TimeUnit.DAYS);
            return new ResultDTO(true, StatusCode.OK, "点赞成功");
        }else {
            return new ResultDTO(false, StatusCode.REPERROR, "一天只能点一次赞哦");
        }

    }
}

