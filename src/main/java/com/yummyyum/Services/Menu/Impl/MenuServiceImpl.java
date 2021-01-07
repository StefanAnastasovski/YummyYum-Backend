package com.yummyyum.Services.Menu.Impl;

import com.yummyyum.Model.Menu;

import com.yummyyum.Repositories.MenuRepository;
import com.yummyyum.Services.Menu.MenuService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public Optional<Menu> getMenuByMenuName(String menuName) {
        return menuRepository.getMenuByMenuName(menuName);
    }

    @Override
    public Optional<Menu> getMenuByReleaseDate(LocalDate releaseDate) {
        return menuRepository.getMenuByReleaseDate(releaseDate);
    }

    @Override
    public Menu createNewMenu(Date releaseDate, String menuName) {

        Menu menu = new Menu(releaseDate, menuName);

        return menuRepository.save(menu);
    }

}
