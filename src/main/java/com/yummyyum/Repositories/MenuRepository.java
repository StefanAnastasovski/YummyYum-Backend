package com.yummyyum.Repositories;

import com.yummyyum.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> getMenuByMenuName(String menuName);

    List<Menu> getMenuByReleaseDate(Date releaseDate);

}
