package com.springular.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product", schema = "springular_commerce")
public class Product {
    @jakarta.persistence.Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID Id;
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;
    @Column(name = "sku", nullable = false)
    private String sku;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "unitPrice", nullable = false)
    @Builder.Default
    private BigDecimal unitPrice = BigDecimal.valueOf(0.00);
    @Column(name = "unitsInStock", nullable = false)
    @Builder.Default
    private int unitsInStock = 0;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "isActive")
    @Builder.Default
    private boolean isActive = true;
    @Column(name = "isDeleted")
    @Builder.Default
    private boolean isDeleted = false;
    @Builder.Default
    @Column(name="createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt = new Date();
    @Builder.Default
    @Column(name="updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt = new Date();

    @Column(name="deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deletedAt;
}
