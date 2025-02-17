package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;
    @Column(name = "number")
    private Integer number;
    @Column(name = "github_url")
    private String githubUrl;
    @Column(name = "branch")
    private String branch;
    @Column(name = "review_video_url")
    private String reviewVideoUrl;
//    @Column(name = "user")
    @ManyToOne(optional = false)
    private User user;
    @Column(name = "code_reviewer")
    private User codeReviewer;

    public Assignment(String status,
                      Integer number, String githubUrl,
                      String branch, String reviewVideoUrl,
                      User user, User codeReviewer) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
        this.codeReviewer = codeReviewer;
    }
    public Assignment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public void setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
    }
    //Unnecessary, Springboot handles JSON serialization automatically \/
    public String toString() {
        return "- Assignment Object -\nstatus: " + this.status +
        "\nnumber: " + this.number +
        "\ngithubUrl: " + githubUrl +
        "\nbranch: " + branch +
        "\nreviewVideoUrl: " + reviewVideoUrl +
        "\nuser: " + user +
        "\ncodeReviewer: " + codeReviewer;
    }
}
