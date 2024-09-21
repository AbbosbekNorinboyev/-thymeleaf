package uz.pdp.task1.entity;

import java.time.LocalDateTime;

public record Todo(Integer id, String title, String priority, LocalDateTime createdAt) {
}
