package com.unicorn.recruit.dao;

import com.unicorn.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 16:57
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
