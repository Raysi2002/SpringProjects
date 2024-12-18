package com.raysi.blogmanagementsystem.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(length = 500)
    private String title;
    @Lob
    private String content;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(
                    name = "post_id",
                    referencedColumnName = "postId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "tagId"
            )
    )
    private List<Tag> tags;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "catId"
    )
    private Category category;
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updatedTime;
}
