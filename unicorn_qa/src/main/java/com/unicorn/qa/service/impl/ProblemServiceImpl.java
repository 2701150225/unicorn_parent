package com.unicorn.qa.service.impl;

import com.unicorn.qa.dao.ProblemDao;
import com.unicorn.qa.pojo.Problem;
import com.unicorn.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 10:25
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemDao problemDao;

    @Resource
    private IdWorker idWorker;

    @Override
    public Page<Problem> newlist(String labelid, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return problemDao.newList(labelid, pageable);
    }

    @Override
    public Page<Problem> hotlist(String labelid, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return problemDao.hotList(labelid, pageable);
    }

    @Override
    public Page<Problem> waitlist(String labelid, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return problemDao.waitList(labelid, pageable);
    }

    @Override
    public List<Problem> findAll() {
        return problemDao.findAll();
    }

    @Override
    public Page<Problem> findSearch(Map whereMap, int page, int size) {
        Specification<Problem> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return problemDao.findAll(specification, pageRequest);
    }

    @Override
    public List<Problem> findSearch(Map whereMap) {
        Specification<Problem> specification = createSpecification(whereMap);
        return problemDao.findAll(specification);
    }

    @Override
    public Problem findById(String id) {

        return problemDao.findById(id).get();
    }

    @Override
    public void add(Problem problem) {
        problem.setId(idWorker.nextId() + "");
        problemDao.save(problem);
    }

    @Override
    public void update(Problem problem) {

        problemDao.save(problem);
    }

    @Override
    public void deleteById(String id) {
        problemDao.deleteById(id);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<Problem> createSpecification(Map searchMap) {

        return new Specification<Problem>() {

            @Override
            public Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
                if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                    predicateList.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
                }
                // 标题
                if (searchMap.get("title") != null && !"".equals(searchMap.get("title"))) {
                    predicateList.add(cb.like(root.get("title").as(String.class), "%" + (String) searchMap.get("title") + "%"));
                }
                // 内容
                if (searchMap.get("content") != null && !"".equals(searchMap.get("content"))) {
                    predicateList.add(cb.like(root.get("content").as(String.class), "%" + (String) searchMap.get("content") + "%"));
                }
                // 用户ID
                if (searchMap.get("userid") != null && !"".equals(searchMap.get("userid"))) {
                    predicateList.add(cb.like(root.get("userid").as(String.class), "%" + (String) searchMap.get("userid") + "%"));
                }
                // 昵称
                if (searchMap.get("nickname") != null && !"".equals(searchMap.get("nickname"))) {
                    predicateList.add(cb.like(root.get("nickname").as(String.class), "%" + (String) searchMap.get("nickname") + "%"));
                }
                // 是否解决
                if (searchMap.get("solve") != null && !"".equals(searchMap.get("solve"))) {
                    predicateList.add(cb.like(root.get("solve").as(String.class), "%" + (String) searchMap.get("solve") + "%"));
                }
                // 回复人昵称
                if (searchMap.get("replyname") != null && !"".equals(searchMap.get("replyname"))) {
                    predicateList.add(cb.like(root.get("replyname").as(String.class), "%" + (String) searchMap.get("replyname") + "%"));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

    }
}
