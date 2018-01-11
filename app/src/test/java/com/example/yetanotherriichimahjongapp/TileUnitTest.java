package com.example.yetanotherriichimahjongapp;

import android.util.Log;

import org.junit.Test;
import mahjong.Tile;

import static org.junit.Assert.*;

public class TileUnitTest {

    /*
     * Tests the no-argument constructor
     */
    //Essentially also tests the unknown tile
    @Test
    public void tileNoArgumentConstructor() throws Exception {
        Tile tile = new Tile();
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false,tile.isRed());
    }


    /*
     * Tests the single argument constructor
     */
    //Valid input: all jihai
    @Test
    public void tileSingleArgumentConstructor_1() throws Exception {
        Tile.Rank ranks[];

        ranks = new Tile.Rank[] {
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.isRed());
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.isRed());
        }
    }

    //Valid input: unknown
    //Should produce an unknown tile
    @Test
    public void tileSingleArgumentConstructor_2() throws Exception {
        Tile tile = new Tile(Tile.Rank.UNKNOWN);
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Invalid input: a non-jihai rank
    //Should produce an unknown tile
    @Test
    public void tileSingleArgumentConstructor_3() throws Exception {
        Tile.Rank ranks[] = new Tile.Rank[] {
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false,tile.isRed());
        }
    }



    /*
     * Tests the two argument constructor
     */
    //Valid input: any num rank + manzu, pinzu or souzu suit
    @Test
    public void tileTwoArgumentConstructor_1() throws Exception {

        Tile.Rank ranks[];

        Tile.Suit suits[] = new Tile.Suit[] {
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        ranks = new Tile.Rank[] {
                Tile.Rank.NUM_2, Tile.Rank.NUM_3, Tile.Rank.NUM_4, Tile.Rank.NUM_5,
                Tile.Rank.NUM_6, Tile.Rank.NUM_7, Tile.Rank.NUM_8
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.CHUNCHANHAI, tile.getType());
                assertEquals(false, tile.isRed());
            }
        }

        ranks = new Tile.Rank[] { Tile.Rank.NUM_1, Tile.Rank.NUM_9};

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.ROUTOUHAI, tile.getType());
                assertEquals(false, tile.isRed());
            }
        }
    }

    //Valid input: jihai rank + its appropriate suit
    @Test
    public void tileTwoArgumentConstructor_2() throws Exception {

        Tile.Rank ranks[];

        ranks = new Tile.Rank[] {
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.KAZEHAI);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.isRed());
        }

        ranks = new Tile.Rank[] {
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.SANGENPAI);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.isRed());
        }
    }

    //Valid input: 1st argument is unknown
    @Test
    public void tileTwoArgumentConstructor_3() throws Exception {

        Tile.Suit suits[] = new Tile.Suit[] {
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Suit s : suits) {
            Tile tile = new Tile(Tile.Rank.UNKNOWN, s);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.isRed());
        }
    }

    //Valid input: 2nd argument is unknown
    @Test
    public void tileTwoArgumentConstructor_4() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[] {
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.UNKNOWN);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.isRed());
        }
    }

    //Invalid input: non-jihai rank + jihai suit
    //should produce an unknown tile
    @Test
    public void tileTwoArgumentConstructor_5() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[] {
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        Tile.Suit suits[] = new Tile.Suit[] {
            Tile.Suit.KAZEHAI, Tile.Suit.SANGENPAI
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
                assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
                assertEquals(Tile.Type.UNKNOWN, tile.getType());
                assertEquals(false, tile.isRed());
            }
        }
    }

    //Invalid input: jihai rank + non-jihai suit
    //should produce an unknown tile
    @Test
    public void tileTwoArgumentConstructor_6() throws Exception {

        Tile.Rank[] ranks = new Tile.Rank[] {
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI,
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        Tile.Suit suits[] = new Tile.Suit[] {
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
                assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
                assertEquals(Tile.Type.UNKNOWN, tile.getType());
                assertEquals(false, tile.isRed());
            }
        }
    }
}
