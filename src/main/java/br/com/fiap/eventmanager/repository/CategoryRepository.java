package br.com.fiap.eventmanager.repository;

import br.com.fiap.eventmanager.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
