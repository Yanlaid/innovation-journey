package com.tensquare.recruit.controller;
import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public ResultDTO findAll(){
		return new ResultDTO(true,1000,"查询成功",recruitService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public ResultDTO findById(@PathVariable String id){
		return new ResultDTO(true,1000,"查询成功",recruitService.findById(id));
	}


	/**
	 * 分页查询全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/{page}/{size}",method=RequestMethod.GET)
	public ResultDTO findPage(@PathVariable int page,@PathVariable int size){
		Page<Recruit> pageList = recruitService.findPage(page, size);
		return new ResultDTO(true,1000,"查询成功",new PageResultDTO<>(pageList.getTotalElements(), pageList.getContent() ) );
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/{page}/{size}",method=RequestMethod.POST)
	public ResultDTO findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
		return  new ResultDTO(true,1000,"查询成功",  new PageResultDTO<>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
	 * 增加
	 * @param recruit
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResultDTO add(@RequestBody Recruit recruit  ){
		recruitService.add(recruit);
		return new ResultDTO(true,1000,"增加成功");
	}
	
	/**
	 * 修改
	 * @param recruit
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public ResultDTO update(@RequestBody Recruit recruit, @PathVariable String id ){
		recruit.setId(id);
		recruitService.update(recruit);		
		return new ResultDTO(true,1000,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public ResultDTO delete(@PathVariable String id ){
		recruitService.deleteById(id);
		return new ResultDTO(true,1000,"删除成功");
	}
	/**
	 * 查找推荐
	 */
	@GetMapping("/search/recommend")
	public ResultDTO searchRecommendTop4(){
		return new ResultDTO(true,20000,"查询成功",recruitService.searchRecommendTop());
	}
	/**
	 * 查询最新的职位.查询12条记录
	 */
	@GetMapping("/search/newlist")
	public ResultDTO searchNewlist(){
		return new ResultDTO(true,20000,"查询成功",recruitService.searchNewlist());
	}
}
