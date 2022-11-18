package com.cqtalk.controller;

import com.cqtalk.entity.Contest;
import com.cqtalk.service.ContestService;
import com.cqtalk.util.ObjectResult;
import com.cqtalk.util.RedisUtil;
import com.cqtalk.util.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
//
@Api("竞赛管理api")
@RestController
@RequestMapping("/contest")
@Slf4j
public class ContestController {
    @Autowired
    private ContestService contestService;

    @Autowired
    private RedisUtil redisUtil;

//    @Autowired
//    private userService userService;


    //添加竞赛信息
    @ApiOperation("添加竞赛信息")
    @PostMapping("/insert/{id}")
    public ObjectResult<String> save(@PathVariable int id, @ApiParam("竞赛信息") @RequestBody Contest contest){
        log.info("新增竞赛，竞赛信息：{}",contest.toString());
        Contest i = contestService.findById(contest.getId());
        if (i != null) {
            return ObjectResult.error("400","竞赛信息已存在");
        }
//判断是否是管理员，根据在数据库中 区分管理员与用户存的字段为status
        //目前没拉取user，所有无法使用userService
        //        String type = userService.getStatusById(id);
        String type=" ";
        if(type.equals(Role.state1.getStatus())) {
                try {
                    contest.setAdministrators(id);
                    contestService.addNewContest(contest);
                } catch (Exception ex) {
                    return ObjectResult.error("400","新增失败");
                }
                return ObjectResult.SUCCESS;

        }

        return ObjectResult.error("400","新增失败或执行人没有权限");

    }

//查询竞赛信息
    @ApiOperation("查询竞赛信息")
    @GetMapping
    public ObjectResult<List<Contest>> findContest(){
        List<Contest> contests = contestService.findContest();
        return ObjectResult.success("200",contests);
    }

//    修改竞赛信息
    @ApiOperation("修改竞赛信息")
//    id为用户的id
    @PostMapping("/change/{id}")
    public ObjectResult<String> updateContestById(@PathVariable int id,@ApiParam("竞赛id") @RequestBody Contest contest){
        Contest contest1 = contestService.findById(contest.getId());
        if (contest1 == null) {
            return ObjectResult.error("400","竞赛信息不存在");
        }
        //目前没拉取user，所有无法使用userService
        //        String type = userService.getStatusById(id);
         String type=" ";
        if(type.equals(Role.state1.getStatus())) {
            contest.setAdministrators(id);
            Integer i = contestService.updateContestById(contest);
            if (i != 1) {
                return ObjectResult.error("400","修改过程产生未知异常");
            }
            return ObjectResult.SUCCESS;
        }

        return ObjectResult.error("400","修改失败或执行人没有权限");

    }

//    删除竞赛信息
    @ApiOperation("删除竞赛信息")
    @DeleteMapping("/delete/{id}")
    public ObjectResult<String> deleteContestById(@PathVariable int id, @ApiParam("竞赛")@RequestBody Contest contest){
        Contest contest1 = contestService.findById(contest.getId());
        if (contest1 == null) {
            return ObjectResult.error("400","竞赛信息不存在");
        }
//目前没拉去user，所有无法使用userService
//        String type = userService.getStatusById(id);
        String type=" ";
        if(type.equals(Role.state1.getStatus())) {
            contest.setStatus(Role.state1.getStatus());
            contestService.deleteById(contest);
            return ObjectResult.SUCCESS;
        }

        return ObjectResult.error("400","删除失败或执行人没有权限删除");
    }

}
