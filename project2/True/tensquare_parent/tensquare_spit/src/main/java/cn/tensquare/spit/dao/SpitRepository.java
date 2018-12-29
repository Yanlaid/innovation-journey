package cn.tensquare.spit.dao;

import cn.tensquare.spit.po.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽数据访问层
 */
public interface SpitRepository extends MongoRepository<Spit,String> {

    /**
     * findListByParentIdWithPage
     */
    public Page<Spit> findByParentid(String parentId, Pageable pageable);
}
