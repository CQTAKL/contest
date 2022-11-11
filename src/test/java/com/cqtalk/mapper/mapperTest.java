package com.cqtalk.mapper;

import com.cqtalk.dao.ContestMapper;
import com.cqtalk.entity.Contest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class mapperTest {

    @Autowired
    ContestMapper contestMapper;

    @Test
    public void insert(){
        Contest contest = new Contest();
        contest.setId(10);
        contest.setContestName("大学生结构设计竞赛");
        contest.setAbbreviation("结构设计");
        contest.setCollegeName("建工学院");
        contest.setLevelName("国家级、省级");
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
        contest.setId(4);
        contest.setContestName("大学生结构设计竞赛");
        contest.setAbbreviation("设计");
        contest.setCollegeName("建工学院");
        contest.setLevelName("国家级、省级");
        contestMapper.updateContestById(contest);


    }

    @Test
    public void findById(){
        Contest i = contestMapper.findById(1);
        System.out.println(i);
    }

    @Test
    public void deleteById(){
        Integer i = contestMapper.deleteById(7);
        System.out.println(i);
    }


}
