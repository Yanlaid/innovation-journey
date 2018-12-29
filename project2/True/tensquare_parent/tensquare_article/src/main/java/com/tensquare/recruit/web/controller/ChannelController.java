package com.tensquare.recruit.web.controller;

import com.tensquare.recruit.pojo.Channel;
import com.tensquare.recruit.service.ChannelService;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultDTO findAll() {
        return new ResultDTO(true, 1000, "查询成功", channelService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultDTO findById(@PathVariable String id) {
        return new ResultDTO(true, 1000, "查询成功", channelService.findById(id));
    }


    /**
     * 分页查询全部数据
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public ResultDTO findPage(@PathVariable int page, @PathVariable int size) {
        Page<Channel> pageList = channelService.findPage(page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<Channel>(pageList.getTotalElements(), pageList.getContent()));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.POST)
    public ResultDTO findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Channel> pageList = channelService.findSearch(searchMap, page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<Channel>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 增加
     *
     * @param channel
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO add(@RequestBody Channel channel) {
        channelService.add(channel);
        return new ResultDTO(true, 1000, "增加成功");
    }

    /**
     * 修改
     *
     * @param channel
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultDTO update(@RequestBody Channel channel, @PathVariable String id) {
        channel.setId(id);
        channelService.update(channel);
        return new ResultDTO(true, 1000, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultDTO delete(@PathVariable String id) {
        channelService.deleteById(id);
        return new ResultDTO(true, 1000, "删除成功");
    }

}
