package com.kyle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * project name   :blog-01
 * project version:1.0
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/6,21:49,星期一
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;//昵称
    private String email;
    private String content;
    private String avatar;//头像
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;//评论时间

    //评论和博客，多对一关系
    @ManyToOne
    private Blog blog;

    //父评论和子评论，一个父评论有多个子评论
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComment = new ArrayList<>();//子评论
    @ManyToOne
    private Comment parentComment;//父评论
}
