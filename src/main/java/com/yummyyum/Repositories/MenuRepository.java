package com.yummyyum.Repositories;

import com.yummyyum.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> getMenuByMenuName(String menuName);

    @Query(value = "SELECT * FROM menu WHERE release_date LIKE %:releaseDate%",
            nativeQuery = true)
    Optional<Menu> getMenuByReleaseDate(LocalDate releaseDate);


}
