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



//    获取枚举类型的值
    private String roleType = Role.TYPE.getTypeName();


    //添加竞赛信息
    @ApiOperation("添加竞赛信息")
    @PostMapping("/insert")
    public ObjectResult<String> save(HttpServletRequest request, @ApiParam("竞赛信息") @RequestBody Contest contest){
        log.info("新增竞赛，竞赛信息：{}",contest.toString());
        Contest i = contestService.findByContestName(contest.getContestName());
        if (i != null) {
            return ObjectResult.error("400","竞赛信息已存在");
        }
//判断是否是管理员，根据在数据库中 区分管理员与用户存的字段为type,在redis中存的是type,所以这里获得type,type=0代表用户，type=1代表管理员
        //获取redis中的角色类型
        //判断是否是管理员,type为用户中的属性
        // 从前端请求头获取管理员信息
        String token = request.getHeader("authorization");
        Map<Object, Object> userMap = redisUtil.hmget("token");
        //判断是否是管理员(这里不会)暂时不写
//        使用userService查询数据库中的type，利用userMap中的id调用finduserbyid()
        String type=" ";
        if(type.equals(roleType)) {
                try {
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


        return ObjectResult.success(contests);
    }

//    修改竞赛信息
    @ApiOperation("修改竞赛信息")
    @PutMapping("/change")
    public ObjectResult<String> updateContestById(HttpServletRequest request,@ApiParam("竞赛id") @RequestBody Contest contest){
        Contest contest1 = contestService.findByContestName(contest.getContestName());
        if (contest1 == null) {
            return ObjectResult.error("400","竞赛信息不存在");
        }
        //判断是否是管理员,type为用户中的属性
        String token = request.getHeader("authorization");
        Map<Object, Object> userMap = redisUtil.hmget("token");
        //判断是否是管理员(这里不会)暂时不写
//        使用userService查询数据库中的type，利用userMap中的id调用finduserbyid()获取type
        String type=" ";
        if(type.equals(roleType)) {
            Integer i = contestService.updateContestById(contest1.getId());
            if (i != 1) {
                return ObjectResult.error("400","修改过程产生未知异常");
            }
            return ObjectResult.SUCCESS;
        }

        return ObjectResult.error("400","修改失败或执行人没有权限");

    }

//    删除竞赛信息
    @ApiOperation("删除竞赛信息")
    @DeleteMapping("/delete")
    public ObjectResult<String> deleteContestById(HttpServletRequest request,@ApiParam("竞赛")@RequestBody Contest contest){
        Contest contest1 = contestService.findByContestName(contest.getContestName());
        if (contest1 == null) {
            return ObjectResult.error("400","竞赛信息不存在");
        }
//获取请求头中的token,前端请求头的名字叫authorization
        String token = request.getHeader("authorization");
        //判断是否是管理员(这里不会)
        //判断是否是管理员(这里不会)暂时不写
//        使用userService查询数据库中的type，利用userMap中的id调用finduserbyid()获取type
        Map<Object, Object> userMap = redisUtil.hmget("token");
        String type=" ";
        if(type.equals(roleType)) {
            contestService.deleteById(contest1);
            return ObjectResult.SUCCESS;

        }

        return ObjectResult.error("400","删除失败或执行人没有权限删除");
    }



}
