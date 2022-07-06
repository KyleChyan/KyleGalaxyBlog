package com.kyle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * project name   :blog-01
 * project version:1.0
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/6,21:31,星期一
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message="分类的名称不可为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs= new ArrayList<>();
}
