package com.cqtalk.service;

import com.cqtalk.entity.Contest;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ContestService{

    List<Contest> addNewContest(Contest contest);

    List<Contest> findContest();

    Integer updateContestById(Integer id);

    Contest findById(Integer id);

    void deleteById(Contest contest);

    Contest findByContestName(String name);

}
