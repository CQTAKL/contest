package com.cqtalk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqtalk.entity.Contest;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ContestService extends IService<Contest> {

    void addNewContest(Contest contest);

    List<Contest> findContest();

    Integer updateContestById(Contest contest);

    Contest findById(int id);

    void deleteById(Contest contest);



}
