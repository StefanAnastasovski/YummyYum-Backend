package com.yummyyum.Controllers;

import com.yummyyum.Model.ShouldCreateMenu;
import com.yummyyum.Repositories.ShouldCreateMenuRepository;
import com.yummyyum.Services.shouldCreateMenu.ShouldCreateMenuService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class controller {

    private final ShouldCreateMenuService shouldCreateMenuService;
    private final ShouldCreateMenuRepository shouldCreateMenuRepository;

    public controller(ShouldCreateMenuService shouldCreateMenuService, ShouldCreateMenuRepository shouldCreateMenuRepository) {
        this.shouldCreateMenuService = shouldCreateMenuService;
        this.shouldCreateMenuRepository = shouldCreateMenuRepository;
    }

    @GetMapping("/update")
    public ShouldCreateMenu getShouldCreateMenu() {
        return shouldCreateMenuRepository.getShouldCreateMenu();
    }


    @PutMapping("/update/{updateMenu}")
    public void  updateMenu(@PathVariable("updateMenu") Boolean shouldCreateMenu) {
        ShouldCreateMenu shouldCreateMenu1 = shouldCreateMenuRepository.getShouldCreateMenu();
        shouldCreateMenu1.setShouldCreateMenu(shouldCreateMenu);

        shouldCreateMenuRepository.saveAndFlush(shouldCreateMenu1);
    }


}
