package com.yummyyum.Repositories;

import com.yummyyum.Model.ShouldCreateMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShouldCreateMenuRepository extends JpaRepository<ShouldCreateMenu, Long> {

    @Modifying
    @Query(value = "UPDATE should_create_menu AS scm SET scm.should_create_menu = :shouldCreateMenu WHERE id = 1",
            nativeQuery = true)
    void updateShouldCreateMenu(Boolean shouldCreateMenu);

    @Query(value = "SELECT * FROM should_create_menu WHERE id = 1",
            nativeQuery = true)
    ShouldCreateMenu getShouldCreateMenu();
}
