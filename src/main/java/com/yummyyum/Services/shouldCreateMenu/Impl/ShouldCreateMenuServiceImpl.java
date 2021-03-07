package com.yummyyum.Services.shouldCreateMenu.Impl;

import com.yummyyum.Repositories.ShouldCreateMenuRepository;
import com.yummyyum.Services.shouldCreateMenu.ShouldCreateMenuService;
import org.springframework.stereotype.Service;

@Service
public class ShouldCreateMenuServiceImpl implements ShouldCreateMenuService {

    private final ShouldCreateMenuRepository shouldCreateMenuRepository;

    public ShouldCreateMenuServiceImpl(ShouldCreateMenuRepository shouldCreateMenuRepository) {
        this.shouldCreateMenuRepository = shouldCreateMenuRepository;
    }


    @Override
    public void updateShouldCreateMenu(Boolean shouldCreateMenu) {
        shouldCreateMenuRepository.updateShouldCreateMenu(shouldCreateMenu);
    }
}
