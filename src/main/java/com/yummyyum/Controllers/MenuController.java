package com.yummyyum.Controllers;

import com.yummyyum.Model.Menu;
import com.yummyyum.Services.Menu.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;

    }

    @GetMapping("/getallmenus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/getmenubymenuname/{menuname}")
    public List<Menu> getMenuByMenuName(@PathVariable("menuname") String menuName) {
        return menuService.getMenuByMenuName(menuName);
    }

     @GetMapping("/getmenubyreleasedate/{releasedate}")
    public List<Menu> getMenuByReleaseDate(@PathVariable("releasedate") Date releaseDate) {
        return menuService.getMenuByReleaseDate(releaseDate);
    }

    @PostMapping("/createmenu")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Menu createNewMenu(@RequestBody Menu menu,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        Menu menu1 = menuService.createNewMenu(menu.getReleaseDate(), menu.getMealName(),
                menu.getMealCategory(), menu.getMenuName());

        response.setHeader("Location", builder.path("/api/createmenu/" + menu.getId()).
                buildAndExpand(menu1.getId()).toUriString());

        return menu1;
    }
}
