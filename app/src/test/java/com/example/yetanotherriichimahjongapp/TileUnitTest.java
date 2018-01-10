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
    //Valid input: ton
    @Test
    public void tileSingleArgumentConstructor_1() throws Exception {
        Tile tile = new Tile(Tile.Rank.TON);
        assertEquals(Tile.Rank.TON, tile.getRank());
        assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: nan
    @Test
    public void tileSingleArgumentConstructor_2() throws Exception {
        Tile tile = new Tile(Tile.Rank.NAN);
        assertEquals(Tile.Rank.NAN, tile.getRank());
        assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: sha
    @Test
    public void tileSingleArgumentConstructor_3() throws Exception {
        Tile tile = new Tile(Tile.Rank.SHA);
        assertEquals(Tile.Rank.SHA, tile.getRank());
        assertEquals(Tile.Suit.KAZEHAI,tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: pei
    @Test
    public void tileSingleArgumentConstructor_4() throws Exception {
        Tile tile = new Tile(Tile.Rank.PEI);
        assertEquals(Tile.Rank.PEI, tile.getRank());
        assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: haku
    @Test
    public void tileSingleArgumentConstructor_5() throws Exception {
        Tile tile = new Tile(Tile.Rank.HAKU);
        assertEquals(Tile.Rank.HAKU, tile.getRank());
        assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: haku
    @Test
    public void tileSingleArgumentConstructor_6() throws Exception {
        Tile tile = new Tile(Tile.Rank.HAKU);
        assertEquals(Tile.Rank.HAKU, tile.getRank());
        assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: hatsu
    @Test
    public void tileSingleArgumentConstructor_7() throws Exception {
        Tile tile = new Tile(Tile.Rank.HATSU);
        assertEquals(Tile.Rank.HATSU, tile.getRank());
        assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: chun
    @Test
    public void tileSingleArgumentConstructor_8() throws Exception {
        Tile tile = new Tile(Tile.Rank.CHUN);
        assertEquals(Tile.Rank.CHUN, tile.getRank());
        assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
        assertEquals(Tile.Type.JIHAI, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Valid input: unknown
    //Should produce an unknown tile
    @Test
    public void tileSingleArgumentConstructor_9() throws Exception {
        Tile tile = new Tile(Tile.Rank.UNKNOWN);
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Invalid input: 1 (a non-jihai rank)
    //Should produce an unknown tile
    @Test
    public void tileSingleArgumentConstructor_10() throws Exception {
        Tile tile = new Tile(Tile.Rank.NUM_1);
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Invalid input: 5 (a non-jihai rank)
    //Should produce an unknown tile
    @Test
    public void tileSingleArgumentConstructor_11() throws Exception {
        Tile tile = new Tile(Tile.Rank.NUM_5);
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false,tile.isRed());
    }

    //Invalid input: 8 (a non-jihai rank)
    //Should produce an unknown tile
    @Test
    public void tileSingleArgumentConstructor_12() throws Exception {
        Tile tile = new Tile(Tile.Rank.NUM_8);
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false, tile.isRed());
    }
}
