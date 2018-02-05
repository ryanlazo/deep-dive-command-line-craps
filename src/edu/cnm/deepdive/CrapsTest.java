package edu.cnm.deepdive;

import edu.cnm.deepdive.Craps.State;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrapsTest {

  Craps craps;

  @BeforeEach
  void setUp() {
    craps = new Craps();
    Assertions.assertNotNull(craps);
  }


  @Test
  void play() {
    Assertions.assertEquals(0, craps.getRolls().size());
    for (int i = 0; i < 30; i++) {
      Craps.State state = craps.play();
      List<int[]> rolls = craps.getRolls();
      Assertions.assertNotEquals(0, craps.getRolls().size());
      Assertions.assertTrue(state == Craps.State.WIN || state == Craps.State.LOSS);
      Assertions.assertTrue(
          state != Craps.State.WIN
              || rolls.size() > 1
              || rolls.get(0)[0] + rolls.get(0)[1] == 7
              || rolls.get(0)[0] + rolls.get(0)[1] == 11
      );
      Assertions.assertTrue(
          state != Craps.State.WIN
              || rolls.size() == 1
              || rolls.get(0)[0] + rolls.get(0)[1] == 7
      );
      Assertions.assertTrue(
          state != Craps.State.LOSS
              || rolls.size() > 1
              || rolls.get(0)[0] + rolls.get(0)[1] == 2
              || rolls.get(0)[0] + rolls.get(0)[1] == 3
              || rolls.get(0)[0] + rolls.get(0)[1] == 12
      );
      Assertions.assertTrue(
          state != Craps.State.LOSS
              || rolls.size() == 1
              || rolls.get(0)[0] + rolls.get(0)[1] == 7
      );
    }

  }
}

