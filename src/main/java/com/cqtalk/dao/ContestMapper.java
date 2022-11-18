package com.cqtalk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqtalk.entity.Contest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContestMapper extends BaseMapper<Contest> {

    Integer insertContest(Contest contest);

    List<Contest> findContest();

    Contest findById(int id);
//修改操作
    Integer updateContestById(Contest contest);

    Integer deleteById(Contest contest);

    Contest findByContestName(String name);
}
