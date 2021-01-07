package com.yummyyum.Services.Menu;

import com.yummyyum.Model.Menu;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MenuService {

    List<Menu> getAllMenus();

    Optional<Menu> getMenuByMenuName(String menuName);

    Optional<Menu> getMenuByReleaseDate(LocalDate releaseDate);

    Menu createNewMenu(Date releaseDate, String menuName);

}
