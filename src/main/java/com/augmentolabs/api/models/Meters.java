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
import java.util.Date;

import static com.augmentolabs.api.utils.utils.DB_NAME;

@Entity
@Table(schema = DB_NAME, name = "meters")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Meters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean enabled;
    private boolean active;

    private String type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    @JsonIgnoreProperties("meters")
    private Zones zones;


    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

}