package com.centradatabase.consumerapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileBatch {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long fileBatchId;
    private String zipFileName;
    private String batchNumber;
    private LocalDateTime uploadDate;
    private String status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Facility facility;
}
