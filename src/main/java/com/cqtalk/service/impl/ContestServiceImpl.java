package com.cqtalk.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqtalk.dao.ContestMapper;
import com.cqtalk.entity.Contest;
import com.cqtalk.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestServiceImpl extends ServiceImpl<ContestMapper,Contest> implements ContestService {

    @Autowired
    private ContestMapper contestMapper;

//增加竞赛信息
    @Override
    public void addNewContest(Contest contest) {
        int i = contestMapper.insert(contest);
    }
//查询所有
    @Override
    public List<Contest> findContest() {
        List<Contest> contests = contestMapper.selectList(null);
        return contests;
    }
//修改竞赛信息
    @Override
    public Integer updateContestById(Contest contest) {

        int i = contestMapper.update(contest, null);

        return i;
    }

    @Override
    public Contest findById(int id) {
        Contest contest = contestMapper.selectById(id);

        return contest;
    }

    @Override
    public void deleteById(Contest contest) {
        contestMapper.updateById(contest);
    }



}
