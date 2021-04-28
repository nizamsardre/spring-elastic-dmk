package com.dhamaka.pay.entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;

@Document("admins")
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String _id;
    private LocalDateTime createdAt;
    @Email
    private String email;
    private String name;
    @JsonIgnore
    private String password;
    private LocalDateTime updatedAt;
    private Boolean deleted;
    private String role;
    private Boolean active;
}