package com.Railworld.SpringJobAppRest.repo;

import com.Railworld.SpringJobAppRest.model.JobPost;
import com.Railworld.SpringJobAppRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

}

