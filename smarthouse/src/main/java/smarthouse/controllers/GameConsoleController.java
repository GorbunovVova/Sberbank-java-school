package smarthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smarthouse.models.GameConsoleEntity;
import smarthouse.services.GameConsoleService;

import java.util.Date;

@RestController
public class GameConsoleController {
    long lastId = 0;
    @Autowired
    private GameConsoleService gameConsoleService;

    @GetMapping("/gameConsole/{id}")
    public GameConsoleEntity getGameConsole(@PathVariable("id") Long id) {
        return gameConsoleService.findById(id);
    }

    @PostMapping("/gameConsole")
    public GameConsoleEntity createGameConsole(@RequestParam boolean toggle) {
        GameConsoleEntity gameConsoleEntity = new GameConsoleEntity(toggle, new Date());
        gameConsoleService.create(gameConsoleEntity);
        lastId = gameConsoleEntity.getId();
        return gameConsoleEntity;
    }

    @GetMapping("/gameConsole")
    public Iterable<GameConsoleEntity> getGameConsoleHistory() {
        return gameConsoleService.getAll();
    }

    @GetMapping("/lastGameConsole")
    public String getLastGameConsole() {
        return lastId == 0 ? "" : getGameConsole(lastId).isToggle() ? "Приставка включена" : "Приставка выключена";
    }
}
