package com.cqtalk.mapper;

import com.cqtalk.dao.ContestMapper;
import com.cqtalk.entity.Contest;
import com.cqtalk.util.levelName;
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
        contest.setId(4);
        contest.setContestName("大学生结构设计竞赛");
        contest.setAbbreviation("结构设计");
        contest.setCollegeName("建工学院");
        contest.setLevelName(levelName.levelNameA);
        Integer i = contestMapper.insert(contest);
        System.out.println(i);
    }

    @Test
    public void select(){
        List<Contest> contest = contestMapper.selectList(null);
        System.out.println(contest);

    }

    @Test
    public void updateContestById(){
        Contest contest = new Contest();
        contest.setId(1);
        contest.setContestName("大学生数学建模竞赛");
        contest.setAbbreviation("结构设计");
        contest.setCollegeName("建工学院");
        contest.setLevelName(levelName.levelNameB);
        contestMapper.update(contest,null);
    }

    @Test
    public void findById(){
        Contest i = contestMapper.selectById(1);
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
