package com.yummyyum.Services.Menu;

import com.yummyyum.Model.Menu;

import java.util.Date;
import java.util.List;

public interface MenuService {

    List<Menu> getAllMenus();

    List<Menu> getMenuByMenuName(String menuName);

    List<Menu> getMenuByReleaseDate(Date releaseDate);

    Menu createNewMenu(Date releaseDate, String mealName,
                       String mealCategory, String menuName);

}
