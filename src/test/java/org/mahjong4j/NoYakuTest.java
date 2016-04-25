package org.mahjong4j;

import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.hands.Kotsu;
import org.mahjong4j.hands.MahjongHands;
import org.mahjong4j.hands.Shuntsu;
import org.mahjong4j.tile.MahjongTile;
import org.mahjong4j.yaku.normals.MahjongYakuEnum;
import org.mahjong4j.yaku.yakuman.MahjongYakumanEnum;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mahjong4j.tile.MahjongTile.P4;
import static org.mahjong4j.tile.MahjongTile.PEI;

/**
 * @author yu1ro
 */
public class NoYakuTest {
    MahjongHands hands;
    Mahjong mahjong;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            3, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 3,
            0, 0, 2, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0
        };
        MahjongTile last = MahjongTile.M6;
        List<MahjongTile> dora = new ArrayList<>(1);
        dora.add(MahjongTile.PEI);
        List<MahjongTile> uradora = new ArrayList<>(2);
        uradora.add(MahjongTile.M9);
        uradora.add(MahjongTile.P4);
        GeneralSituation generalSituation = new GeneralSituation(false, false, MahjongTile.TON, dora, uradora);
        PersonalSituation personalSituation = new PersonalSituation(false, false, false, true, false, false, false, MahjongTile.NAN);
        hands = new MahjongHands(tiles, last, new Kotsu(true, PEI), new Shuntsu(true, P4));
        mahjong = new Mahjong(hands, generalSituation, personalSituation);
        mahjong.calculate();
    }

    @Test
    public void testGetYakumanList() throws Exception {
        List<MahjongYakumanEnum> actual = mahjong.getYakumanList();

        assertEquals(0, actual.size());
    }

    @Test
    public void testGetNormalYakuList() throws Exception {
        List<MahjongYakuEnum> actual = mahjong.getNormalYakuList();

        assertEquals(0, actual.size());
    }
}