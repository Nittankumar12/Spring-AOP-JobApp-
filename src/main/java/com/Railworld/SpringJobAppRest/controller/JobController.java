package com.Railworld.SpringJobAppRest.controller;

import com.Railworld.SpringJobAppRest.model.JobPost;
import com.Railworld.SpringJobAppRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping(path = "jobPosts", produces = {"application/json"})
    public List<JobPost> viewalljobs(Model model) {
        List<JobPost> jobPostList = jobService.getAllJobs();
        return jobPostList;
    }

    @GetMapping("/getJob/{id}")
    public JobPost getJob(@PathVariable int id){
        return jobService.getJob(id);
    }

    @PostMapping("/addJob")
    public JobPost addJob(@RequestBody JobPost jobPost){
        return jobService.addJob(jobPost);
    }

    @PutMapping(path = "/updateJob")
    public JobPost updateJob(@RequestBody JobPost jobPost){
       jobService.updateJob(jobPost);
       return jobService.getJob(jobPost.getPostId());
    }
    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable int id){
		JobPost jobPost = jobService.getJob(id);
        jobService.delete(jobPost.getPostId());
        return "Deleted";
    }
    @GetMapping("/load")
    public String load(){
        jobService.load();
        return "loaded";
    }

}
