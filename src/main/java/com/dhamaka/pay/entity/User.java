package com.dhamaka.pay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(value = "users")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    private String _id;
    private List<ObjectId> addresses;
    private Boolean deleted;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private String role;
    private BigDecimal rewardedPoint;
    private BigDecimal rewardedPrice;
    private Boolean active;
    private String email;
    private String status;
    private String token;
    private Boolean emailVerified;
    private String avatar;
    private Date createdAt;
    private Date updatedAt;
}
