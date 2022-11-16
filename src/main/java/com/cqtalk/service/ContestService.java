package com.cqtalk.service;

import com.cqtalk.entity.Contest;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ContestService{

    List<Contest> addNewContest(Contest contest);

    List<Contest> findContest();

    Integer updateContestById(int id);

    Contest findById(int id);

    void deleteById(Contest contest);

    Contest findByContestName(String name);


}
