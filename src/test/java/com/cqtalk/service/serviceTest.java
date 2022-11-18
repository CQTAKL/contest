package com.cqtalk.service;

import com.cqtalk.entity.Contest;
import com.cqtalk.util.RedisUtil;
import com.cqtalk.util.levelName;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class serviceTest {

    @Autowired
    private ContestService contestService;
    
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void insertContest(){

        Contest contest = new Contest();
        contest.setId(3);
        contest.setContestName("英语演讲与写作比赛");
        contest.setAbbreviation("英语演讲");
        contest.setCollegeName("外国语学院");
        contest.setLevelName(levelName.levelNameA);
        contestService.addNewContest(contest);


    }

    @Test
    public void findContest(){
        List<Contest> contest = contestService.findContest();
        System.out.println(contest);

    }

    @Test
    public void findBYId(){
        Contest byId = contestService.findById(1);
        System.out.println(byId);
    }

    @Test
    public void updateById(){
//        redisUtil.setString("type", "1");
        Contest contest = new Contest();
        contest.setId(3);
        contest.setContestName("大学生英语演讲与写作比赛");
        contest.setAbbreviation("英语演讲");
        contest.setCollegeName("外国语学院");
        contest.setLevelName(levelName.levelNameB);

        contestService.updateContestById(contest);
    }

    @Test
    public void deleteById(){
        Contest contest = new Contest();
        contest.setId(1);
        contest.setStatus(1);

        contestService.deleteById(contest);
    }
}
