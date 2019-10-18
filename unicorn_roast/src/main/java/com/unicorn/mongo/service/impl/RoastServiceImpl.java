package com.unicorn.mongo.service.impl;

import com.unicorn.mongo.dao.RoastDao;
import com.unicorn.mongo.pojo.Roast;
import com.unicorn.mongo.service.RoastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdUtil;

import java.util.Date;
import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 11:26
 */
@Service
public class RoastServiceImpl implements RoastService {
    @Autowired
    private RoastDao roastDao;
    @Autowired
    private IdUtil idUtil;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询全部吐槽内容
     * @return
     */
    public List<Roast> findAll(){
        return roastDao.findAll();
    }

    /**
     * 根据id查询吐槽内容
     * @param id
     * @return
     */
    public Roast findById(String id){
        return roastDao.findById(id).get();
    }

    /**
     * 新增吐槽
     * @param roast
     */
    public void save(Roast roast){
        roast.set_id(idUtil.nextId()+"");
        //初始化数据完善
        roast.setPublishtime(new Date());//发布日期
        roast.setVisits(0);//浏览量
        roast.setShare(0);//分享数
        roast.setThumbup(0);//点赞数
        roast.setComment(0);//回复数
        roast.setState("1");//状态
        //判断当前吐槽是否有父节点
        if(roast.getParentid()!=null && !"".equals(roast.getParentid())){
            //给父节点吐槽的回复数加一
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(roast.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "roast");
        }
        roastDao.save(roast);
    }

    /**
     * 更新吐槽
     * @param roast
     */
    public void update(Roast roast){
        roastDao.save(roast);
    }

    /**
     * 根据id删除吐槽
     * @param id
     */
    public void deleteById(String id){
        roastDao.deleteById(id);
    }


    public Page<Roast> pageQuery(String parentid, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return roastDao.findByParentid(parentid, pageable);
    }

    //db.spit.update({_id:"2"},{$inc:{visits:NumberInt(1)}} )
    public void addthumbup(String id){
        //方式一
//        Spit spit = roastDao.findById(id).get();
//        spit.setThumbup(spit.getThumbup()+1);
//        roastDao.save(spit);
        //存储过程和存储函数的优势？
        //存储过程相当于把业务逻辑写到数据库端。
        //加入java端有一个业务逻辑需要十次数据库操作，
        //那么我们正常来说就需要链接数据库十次
        //链接数据库频繁就意味要牺牲效率。
        //如果用存储过程把业务逻辑写到数据库端
        //只需要链接一次数据库就可以完成十步操作
        //默认情况下存储过程无法并发，但是可以优化。
        //而且存储过程和存储函数使用的编程语言是pl/sql是面向过程的。维护起来特别麻烦。
        //方式二
        //封装的是查询条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //封装修改的数据内容
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "roast");

    }


}
