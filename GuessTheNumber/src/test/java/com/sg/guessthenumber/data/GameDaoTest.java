/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.data;

import com.sg.guessthenumber.TestApplicationConfiguration;
import com.sg.guessthenumber.dto.Game;
import java.util.List;


//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 *
 * @author umair
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoTest {

    @Autowired
    GameDaoDB gameDao;

    public GameDaoTest() {
    }

    @Test
    public void testGetAllGames() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setStatus(false);
        gameDao.add(game);

        Game game2 = new Game();
        game2.setAnswer("5678");
        game2.setStatus(false);
        gameDao.add(game2);

        List<Game> games = gameDao.getAll();

        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));
    }

    @Test
    public void testAddGetGame() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setStatus(false);
        game = gameDao.add(game);

        Game fromDao = gameDao.findById(game.getGameId());

        assertEquals(game, fromDao);
    }


    @Test
    public void testUpdateGame() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setStatus(false);
        game = gameDao.add(game);

        Game fromDao = gameDao.findById(game.getGameId());

        assertEquals(game, fromDao);

        game.setStatus(true);

        gameDao.updateGame(game);

        assertNotEquals(game, fromDao);

        fromDao = gameDao.findById(game.getGameId());

        assertEquals(game, fromDao);
    }
}
