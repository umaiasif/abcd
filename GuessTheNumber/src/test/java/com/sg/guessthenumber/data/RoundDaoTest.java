/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.data;

import com.sg.guessthenumber.TestApplicationConfiguration;
import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author umair
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoundDaoTest {
    
    @Autowired
    RoundDaoDB roundDao;
    
    @Autowired
    GameDaoDB gameDao;
    
    public RoundDaoTest() {
    }
    
    @Test
    public void testAddGetGetAll() {
        int gameId = 1;
        
        Game game = new Game();
        game.setAnswer("5678");
        game.setStatus(false);
        game = gameDao.add(game);
        
        Round round = new Round();
        round.setGuessNum("1234");
        round.setResult("e:0:p:0");
        round.setGameId(gameId);
        roundDao.addRound(round);

        Round round2 = new Round();
        round2.setGuessNum("5678");
        round2.setResult("e:4:p:0");
        round2.setGameId(gameId);
        roundDao.addRound(round2);

        List<Round> rounds = roundDao.getRounds(gameId);

        assertEquals(2, rounds.size());
        assertNotNull(round = roundDao.getRoundById(round.getRoundId()));
    }
}
