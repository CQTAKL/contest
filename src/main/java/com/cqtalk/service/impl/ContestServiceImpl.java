package com.cqtalk.service.impl;

import com.cqtalk.dao.ContestMapper;
import com.cqtalk.entity.Contest;
import com.cqtalk.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    private ContestMapper contestMapper;

//增加竞赛信息
    @Override
    public List<Contest> addNewContest(Contest contest) {



        Integer integer = contestMapper.insertContest(contest);

        List<Contest> contests = contestMapper.findContest();
        return contests;


    }
//查询所有
    @Override
    public List<Contest> findContest() {
        List<Contest> contests = contestMapper.findContest();
        return contests;
    }
//修改竞赛信息
    @Override
    public Integer updateContestById(Integer id) {

        /*contest.setContestName(contest.getContestName());
        contest.setAbbreviation(contest.getAbbreviation());
        contest.setCollegeName(contest.getCollegeName());
        contest.setLevelName(contest.getLevelName());
        contest.setCommentLink(contest.getCommentLink());
        contest.setCreatedUser(contest.getCreatedUser());
        contest.setDetailInformation(contest.getDetailInformation());
        contest.setOtherInformation(contest.getOtherInformation());*/

        Integer result = contestMapper.updateContestById(id);

        return result;
    }

    @Override
    public Contest findById(Integer id) {
        Contest contest = contestMapper.findById(id);

        return contest;
    }

    @Override
    public void deleteById(Contest contest) {



        contestMapper.deleteById(contest);

    }

    @Override
    public Contest findByContestName(String name) {
        return  contestMapper.findByContestName(name);
    }


}
