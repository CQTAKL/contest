package com.cqtalk.service;

import com.cqtalk.entity.Contest;
import com.cqtalk.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        contest.setId(6);
        contest.setContestName("大学生英语演讲与写作比赛");
        contest.setAbbreviation("英语演讲");
        contest.setCollegeName("外国语学院");
        contest.setLevelName("国家级、省级");

        List<Contest> contests = contestService.addNewContest(contest);

        System.out.println(contests);
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
        contest.setId(8);
        contest.setContestName("大学生英语演讲与写作比赛");
        contest.setAbbreviation("英语演讲");
        contest.setCollegeName("外国语学院");
        contest.setLevelName("国家级、省级");

        contestService.updateContestById(contest.getId());
    }

    @Test
    public void deleteById(){
        Contest contest = new Contest();
        contest.setId(1);


        contestService.deleteById(contest);
    }
}
