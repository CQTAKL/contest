package com.cqtalk.service;

import com.cqtalk.entity.Contest;

import java.util.List;

public interface ContestService{

    List<Contest> addNewContest(Contest contest);

    List<Contest> findContest();

    Integer updateContestById(Contest contest);

    Contest findById(Integer id);

    void deleteById(Contest contest);
}
