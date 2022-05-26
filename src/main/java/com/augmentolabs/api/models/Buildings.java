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

import static com.augmentolabs.api.utils.utils.DB_NAME;

@Entity
@Table(schema = DB_NAME, name = "buildings")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Buildings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean enabled;

    private boolean active;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    @JsonIgnoreProperties("buildings")
    private Facilities facilities;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "buildings", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("buildings")
    private List<Floors> floors = new ArrayList<>();

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

}