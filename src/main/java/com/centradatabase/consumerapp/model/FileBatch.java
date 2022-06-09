package com.centradatabase.consumerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Long userId;
}
