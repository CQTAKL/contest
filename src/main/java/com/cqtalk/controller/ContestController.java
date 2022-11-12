package com.cqtalk.controller;

import com.cqtalk.common.R;
import com.cqtalk.entity.Contest;
import com.cqtalk.service.ContestService;
import com.cqtalk.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contest")
@Slf4j
public class ContestController {
    @Autowired
    private ContestService contestService;

    @Autowired
    private RedisUtil redisUtil;
//添加竞赛信息
    @PostMapping("/insert")
    public R<List<Contest>> save(@RequestBody Contest contest){
        log.info("新增竞赛，竞赛信息：{}",contest.toString());

        String type = redisUtil.getString("type");
        if(type.equals("1")) {

            try {
                contestService.addNewContest(contest);
            } catch (Exception ex) {
                return R.error("新增竞赛失败");
            }
            //        查询新增后的竞赛信息，并保存到redis中
            List<Contest> contests = contestService.findContest();

            redisUtil.setString("contest",contests.toString());

            return R.success(contests);

        }

        return R.error("新增失败或执行人没有权限");

    }
//查询竞赛信息
    @GetMapping
    public R<List<Contest>> findContest(){

        List<Contest> contests = contestService.findContest();


        return R.success(contests);
    }

//    修改竞赛信息
    @PutMapping("/change")
    public R updateContestById(@RequestBody Contest contest){
        Contest result = contestService.findById(contest.getId());
        if(result==null){
            return R.error("竞赛信息不存在");
        }
        String type = redisUtil.getString("type");
        if(type.equals("1")) {
            Integer i = contestService.updateContestById(contest);

            if (i != 1) {
                return R.error("修改过程产生未知异常");
            }

            //        查询更新后的竞赛信息，并保存到redis中
            List<Contest> contests = contestService.findContest();
            redisUtil.setString("contest", contests.toString());
            return R.success("修改竞赛信息成功");
        }

        return R.error("修改失败或执行人没有权限");

    }

//    删除竞赛信息
    @DeleteMapping("/delete")
    public R deleteContestById(@RequestBody Contest contest){
        String type = redisUtil.getString("type");
        if(type.equals("1")) {
            contestService.deleteById(contest);
//        查询删除后的竞赛信息，并保存到redis中
            List<Contest> contests = contestService.findContest();
            redisUtil.setString("contest", contests.toString());
            return R.success("删除成功");
        }

        return R.error("删除失败或执行人没有权限删除");
    }



}
