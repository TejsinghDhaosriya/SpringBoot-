package com.augmentolabs.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(schema = DB_NAME, name = "zones")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Zones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean enabled;
    private boolean active;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    @JsonIgnoreProperties("zones")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Floors floors;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "zones", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zones")
    private List<Meters> meters = new ArrayList<>();

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

}