package cn.tensquare.spit.service;

import cn.tensquare.spit.dao.SpitRepository;
import cn.tensquare.spit.po.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.IdWorker;

import java.util.Date;
import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitRepository spitRepository;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 增加
     *
     * @param spit
     */
    public void saveSpit(Spit spit) {
        spit.setId(idWorker.nextId() + "");
        //默认值
        spit.setPublishtime(new Date());//发布时间为当前时间
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享数
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态
        spitRepository.save(spit);
        /*此方法也可能是回复别人的吐槽，需要判断父ID存在与否*/
        if (!StringUtils.isEmpty(spit.getParentid())) {
            mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("_id").is(spit.getParentid())),
                                      new Update().inc("comment", 1),
                        "spit");
        }
    }

    /**
     * 修改
     *
     * @param spit
     */
    public void updateSpit(Spit spit) {
        spitRepository.save(spit);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteSpitById(String id) {
        spitRepository.deleteById(id);
    }

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Spit> findSpitList() {
        return spitRepository.findAll();
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Spit findSpitById(String id) {
        /**
         * 增加浏览数
         */
        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("_id").is(id)),
                new Update().inc("visits", 1),
                "spit");
        return spitRepository.findById(id).get();
    }

    /**
     * 依据父ID查找评论且分页
     *
     * @param parentId
     * @param page
     * @param size
     * @return
     */
    public Page findListByParentIdWithPage(String parentId, Integer page, Integer size) {
        return spitRepository.findByParentid(parentId, PageRequest.of(page - 1, size));
    }

    /**
     * 点赞功能
     */
    public void updateSpitThumbupToIncrementing(String id) {
        /*构建条件对象*/
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        /*构建修改的·对象*/
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");

    }

}

