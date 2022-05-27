package com.augmentolabs.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.augmentolabs.api.utils.Utils.DB_NAME;

@Entity
@Table(schema = DB_NAME, name = "facilities")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Facilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long cityId;

    private boolean enabled;
    private boolean active;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "facilities", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("facilities")
    private List<Buildings> buildings = new ArrayList<>();

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

}