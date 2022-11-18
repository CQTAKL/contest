package com.cqtalk.mapper;

import com.cqtalk.dao.ContestMapper;
import com.cqtalk.entity.Contest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class mapperTest {

    @Autowired
    ContestMapper contestMapper;

    @Test
    public void insert(){
        Contest contest = new Contest();
        contest.setId(2);
        contest.setContestName("大学生结构设计竞赛");
        contest.setAbbreviation("结构设计");
        contest.setCollegeName("建工学院");
        contest.setLevelName(1);
        Integer i = contestMapper.insertContest(contest);
        System.out.println(i);
    }

    @Test
    public void select(){
        List<Contest> contest = contestMapper.findContest();
        System.out.println(contest);

    }

    @Test
    public void updateContestById(){
        Contest contest = new Contest();
        contest.setId(1);
        contest.setContestName("大学生数学建模竞赛");
        contest.setAbbreviation("结构设计");
        contest.setCollegeName("建工学院");
        contest.setLevelName(2);
        contestMapper.updateContestById(contest);



    }

    @Test
    public void findById(){
        Contest i = contestMapper.findById(1);
        System.out.println(i);
    }

    @Test
    public void deleteById(){
        Contest contest = new Contest();
        contest.setId(2);
        contest.setStatus(0);
        Integer i = contestMapper.deleteById(contest);
        System.out.println(i);
    }


}
