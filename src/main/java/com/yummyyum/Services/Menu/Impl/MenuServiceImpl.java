package com.yummyyum.Services.Menu.Impl;

import com.yummyyum.Model.Menu;

import com.yummyyum.Repositories.MenuRepository;
import com.yummyyum.Services.Menu.MenuService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> getMenuByMenuName(String menuName) {
        return menuRepository.getMenuByMenuName(menuName);
    }

    @Override
    public List<Menu> getMenuByReleaseDate(Date releaseDate) {
        return menuRepository.getMenuByReleaseDate(releaseDate);
    }

    @Override
    public Menu createNewMenu(Date releaseDate, String mealName, String mealCategory, String menuName) {

        Menu menu = new Menu(releaseDate, mealName, mealCategory, menuName);

        return menuRepository.save(menu);
    }
}
