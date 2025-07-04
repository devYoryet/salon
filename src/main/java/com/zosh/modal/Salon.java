package com.zosh.modal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "salons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salon {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salons_seq_gen")
        @SequenceGenerator(name = "salons_seq_gen", sequenceName = "salons_seq", allocationSize = 1)
        private Long id;

        @Column(nullable = false, length = 255)
        private String name;

        @Column(nullable = false, length = 500)
        private String address;

        @Column(name = "phone_number", length = 20)
        private String phoneNumber;

        @Column(length = 255)
        private String email;

        @Column(length = 100)
        private String city;

        @Column(name = "is_open")
        private boolean isOpen = true;

        @Column(name = "home_service")
        private boolean homeService = false;

        @Column(name = "active")
        private boolean active = true;

        @Column(name = "owner_id", nullable = false)
        private Long ownerId;

        @Column(name = "open_time")
        private LocalTime openTime;

        @Column(name = "close_time")
        private LocalTime closeTime;

        // Para Oracle: mapear imágenes como JSON o String separado por comas
        @ElementCollection
        @CollectionTable(name = "salon_images", joinColumns = @JoinColumn(name = "salon_id"))
        @Column(name = "image_url")
        private List<String> images;

        @Column(name = "created_at", nullable = false, updatable = false)
        @CreationTimestamp
        private LocalDateTime createdAt;

        @Column(name = "updated_at", nullable = false)
        @UpdateTimestamp
        private LocalDateTime updatedAt;

        // Getters adicionales para compatibilidad
        public boolean isOpen() {
                return isOpen;
        }

        public boolean isHomeService() {
                return homeService;
        }

        public boolean isActive() {
                return active;
        }
}