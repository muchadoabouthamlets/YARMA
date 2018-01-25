package com.example.yetanotherriichimahjongapp;

import org.junit.Test;

import mahjong.Tile;

import static org.junit.Assert.*;

public class TileUnitTest {



    /**
     * Test for the no-argument constructor
     */

    //Should produce an unknown tile
    //Essentially also tests the unknown tile
    @Test
    public void noArgumentConstructor() throws Exception {
        Tile tile = new Tile();
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false, tile.is(Tile.Attribute.AKADORA));
        assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
    }



    /**
     * Tests for the single argument constructor
     */

    //Valid input: any jihai related rank
    //Should produce a tile of the corresponding jihai rank
    @Test
    public void singleArgumentConstructor_1() throws Exception {
        Tile.Rank ranks[];

        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }

    //Valid input: unknown
    //Should produce an unknown tile
    @Test
    public void singleArgumentConstructor_2() throws Exception {
        Tile tile = new Tile(Tile.Rank.UNKNOWN);
        assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
        assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
        assertEquals(Tile.Type.UNKNOWN, tile.getType());
        assertEquals(false, tile.is(Tile.Attribute.AKADORA));
        assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
    }

    //Invalid input: a non-jihai rank
    //Should produce an unknown tile
    @Test
    public void singleArgumentConstructor_3() throws Exception {
        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }



    /**
     * Tests the two argument constructor
     */

    //Valid input: any num rank + manzu, pinzu or souzu suit
    //Should produce a tile of the corresponding rank
    @Test
    public void twoArgumentConstructor_1() throws Exception {

        Tile.Rank ranks[];

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        ranks = new Tile.Rank[]{
                Tile.Rank.NUM_2, Tile.Rank.NUM_3, Tile.Rank.NUM_4, Tile.Rank.NUM_5,
                Tile.Rank.NUM_6, Tile.Rank.NUM_7, Tile.Rank.NUM_8
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.CHUNCHANHAI, tile.getType());
                assertEquals(false, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }

        ranks = new Tile.Rank[]{Tile.Rank.NUM_1, Tile.Rank.NUM_9};

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.ROUTOUHAI, tile.getType());
                assertEquals(false, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }
    }

    //Valid input: jihai rank + its appropriate suit
    //Should produce a tile of the corresponding jihai rank
    @Test
    public void twoArgumentConstructor_2() throws Exception {

        Tile.Rank ranks[];

        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.KAZEHAI);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.KAZEHAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.SANGENPAI);
            assertEquals(r, tile.getRank());
            assertEquals(Tile.Suit.SANGENPAI, tile.getSuit());
            assertEquals(Tile.Type.JIHAI, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }

    //Valid input: 1st argument is unknown
    //Should produce an unknown tile
    @Test
    public void twoArgumentConstructor_3() throws Exception {

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Suit s : suits) {
            Tile tile = new Tile(Tile.Rank.UNKNOWN, s);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }

    //Valid input: 2nd argument is unknown
    //Should produce an unknown tile
    @Test
    public void twoArgumentConstructor_4() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.UNKNOWN);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }

    //Invalid input: non-jihai rank + jihai suit
    //Should produce an unknown tile
    @Test
    public void twoArgumentConstructor_5() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.KAZEHAI, Tile.Suit.SANGENPAI
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
                assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
                assertEquals(Tile.Type.UNKNOWN, tile.getType());
                assertEquals(false, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }
    }

    //Invalid input: jihai rank + non-jihai suit
    //Should produce an unknown tile
    @Test
    public void twoArgumentConstructor_6() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI,
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s);
                assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
                assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
                assertEquals(Tile.Type.UNKNOWN, tile.getType());
                assertEquals(false, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }
    }

    //Invalid input: jihai rank + conflicting jihai suit
    //Should produce an unknown tile
    @Test
    public void twoArgumentConstructor_7() throws Exception {

        Tile.Rank ranks[];

        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.SANGENPAI);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.KAZEHAI);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }



    /**
     * Tests for the three argument (single attribute) constructor
     */

    //Valid input: akadora attribute with non-jihai
    //Should produce a non-jihai tile with the akadora attribute
    @Test
    public void threeArgumentConstructor_1() throws Exception {

        Tile.Attribute a = Tile.Attribute.AKADORA;
        Tile.Rank ranks[];

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        ranks = new Tile.Rank[]{
                Tile.Rank.NUM_2, Tile.Rank.NUM_3, Tile.Rank.NUM_4, Tile.Rank.NUM_5,
                Tile.Rank.NUM_6, Tile.Rank.NUM_7, Tile.Rank.NUM_8
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s, a);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.CHUNCHANHAI, tile.getType());
                assertEquals(true, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }

        ranks = new Tile.Rank[]{Tile.Rank.NUM_1, Tile.Rank.NUM_9};

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s, a);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.ROUTOUHAI, tile.getType());
                assertEquals(true, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }
    }

    //Valid input: non-akadora attribute with non-jihai
    //Should produce a non-jihai tile without the akadora attribute
    @Test
    public void threeArgumentConstructor_2() throws Exception {

        Tile.Attribute a = Tile.Attribute.VISIBLE_TO_ALL_PLAYERS; //dummy non-akadora attribute
        Tile.Rank ranks[];

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        ranks = new Tile.Rank[]{
                Tile.Rank.NUM_2, Tile.Rank.NUM_3, Tile.Rank.NUM_4, Tile.Rank.NUM_5,
                Tile.Rank.NUM_6, Tile.Rank.NUM_7, Tile.Rank.NUM_8
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s, a);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.CHUNCHANHAI, tile.getType());
                assertNotEquals(true, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_ALL_PLAYERS));
            }
        }

        ranks = new Tile.Rank[]{Tile.Rank.NUM_1, Tile.Rank.NUM_9};

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile tile = new Tile(r, s, a);
                assertEquals(r, tile.getRank());
                assertEquals(s, tile.getSuit());
                assertEquals(Tile.Type.ROUTOUHAI, tile.getType());
                assertNotEquals(true, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_ALL_PLAYERS));
            }
        }
    }

    //Invalid input: akadora attribute with jihai
    //Should produce an unknown tile
    @Test
    public void threeArgumentConstructor_3() throws Exception {

        Tile.Attribute a = Tile.Attribute.AKADORA;
        Tile.Rank ranks[];

        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI,
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.KAZEHAI, a);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            Tile tile = new Tile(r, Tile.Suit.SANGENPAI, a);
            assertEquals(Tile.Rank.UNKNOWN, tile.getRank());
            assertEquals(Tile.Suit.UNKNOWN, tile.getSuit());
            assertEquals(Tile.Type.UNKNOWN, tile.getType());
            assertEquals(false, tile.is(Tile.Attribute.AKADORA));
            assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
        }
    }



    /**
     * Tests for the three argument (multiple attributes) constructor
     */

    //Valid input: Multiple valid attributes
    //Should produce the tile with all the attributes added regardless of the order of the
    //attributes in the array used for the Tile constructor's third argument
    @Test
    public void threeArgumentConstructor_4() throws Exception {

        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS
        };

        for (Tile.Attribute a1 : attributes) {
            for (Tile.Attribute a2 : attributes) {
                if (a1 != a2) {

                    Tile t;
                    Tile.Attribute attributesArray[];

                    attributesArray = new Tile.Attribute[]{a1, Tile.Attribute.AKADORA};
                    t = new Tile(Tile.Rank.NUM_5, Tile.Suit.PINZU, attributesArray);

                    assertEquals(true, t.is(Tile.Attribute.AKADORA));
                    assertEquals(true, t.is(a1));
                    assertEquals(false, t.is(a2));

                    //tests different order of attributes in array
                    attributesArray = new Tile.Attribute[]{Tile.Attribute.AKADORA, a1};
                    t = new Tile(Tile.Rank.NUM_5, Tile.Suit.PINZU, attributesArray);

                    assertEquals(true, t.is(Tile.Attribute.AKADORA));
                    assertEquals(true, t.is(a1));
                    assertEquals(false, t.is(a2));
                }
            }
        }
    }

    //Valid input: Duplicate attributes
    //Should produce the tile with duplicate attribute as part of its attributes
    //(Shouldn't be done but still valid; ideally the attribute should only be added once but
    // because the array is private, there is currently no way to check if it was)
    @Test
    public void threeArgumentConstructor_5() throws Exception {

        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS,
                Tile.Attribute.AKADORA
        };

        for (Tile.Attribute a : attributes) {

            Tile.Attribute attributesArray[] = new Tile.Attribute[]{a, a};
            Tile t = new Tile(Tile.Rank.NUM_5, Tile.Suit.SOUZU, attributesArray);
            assertEquals(true, t.is(a));

            if (a == Tile.Attribute.AKADORA) {
                assertEquals(true, t.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
            }
        }
    }

    //Invalid input: Conflicting attributes (multiple visibilities) were provided
    //Should produce unknown tiles
    @Test
    public void threeArgumentConstructor_6() throws Exception {

        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS,
        };

        //2 visibilities
        for (Tile.Attribute a1 : attributes) {
            for (Tile.Attribute a2 : attributes) {
                if (a1 != a2) {
                    Tile.Attribute attributesArray[] = new Tile.Attribute[]{a1, a2};

                    Tile t = new Tile(Tile.Rank.NUM_5, Tile.Suit.MANZU, attributesArray);
                    assertEquals(Tile.Rank.UNKNOWN, t.getRank());
                    assertEquals(Tile.Suit.UNKNOWN, t.getSuit());
                    assertEquals(Tile.Type.UNKNOWN, t.getType());
                    assertEquals(true, t.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
                    assertEquals(false, t.is(Tile.Attribute.AKADORA));
                }
            }
        }

        //3 visibilities
        for (Tile.Attribute a1 : attributes) {
            for (Tile.Attribute a2 : attributes) {
                for (Tile.Attribute a3 : attributes) {
                    if ((a1 != a2) && (a1 != a3) && (a2 != a3)) {
                        Tile.Attribute attributesArray[] = new Tile.Attribute[]{a1, a2, a3};

                        Tile t = new Tile(Tile.Rank.NUM_5, Tile.Suit.MANZU, attributesArray);
                        assertEquals(Tile.Rank.UNKNOWN, t.getRank());
                        assertEquals(Tile.Suit.UNKNOWN, t.getSuit());
                        assertEquals(Tile.Type.UNKNOWN, t.getType());
                        assertEquals(true, t.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
                        assertEquals(false, t.is(Tile.Attribute.AKADORA));
                    }
                }
            }
        }
    }

    //Invalid input: jihai cannot be akadora
    //Should produce unknown tiles
    @Test
    public void threeArgumentConstructor_7() throws Exception {

        Tile.Rank ranks[];
        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI
        };
        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Attribute a : attributes) {
                Tile.Attribute attributesArray[] = new Tile.Attribute[]{a, Tile.Attribute.AKADORA};
                Tile t = new Tile(r, Tile.Suit.KAZEHAI, attributesArray);
                assertEquals(Tile.Rank.UNKNOWN, t.getRank());
                assertEquals(Tile.Suit.UNKNOWN, t.getSuit());
                assertEquals(Tile.Type.UNKNOWN, t.getType());
                assertEquals(true, t.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
                assertEquals(false, t.is(Tile.Attribute.AKADORA));
            }
        }
        ranks = new Tile.Rank[]{
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Attribute a : attributes) {
                Tile.Attribute attributesArray[] = new Tile.Attribute[]{a, Tile.Attribute.AKADORA};
                Tile t = new Tile(r, Tile.Suit.SANGENPAI, attributesArray);
                assertEquals(Tile.Rank.UNKNOWN, t.getRank());
                assertEquals(Tile.Suit.UNKNOWN, t.getSuit());
                assertEquals(Tile.Type.UNKNOWN, t.getType());
                assertEquals(true, t.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
                assertEquals(false, t.is(Tile.Attribute.AKADORA));
            }
        }

    }



    /**
     * Tests the equals method
     */

    //Tests the overridden 1-argument equals method using 2 tiles equal in rank, suit and type
    //Should return true
    @Test
    public void equals_1() throws Exception {

        Tile.Rank ranks[];
        Tile.Suit suits[];

        ranks = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        suits = new Tile.Suit[]{Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU};

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile t1 = new Tile(r, s);
                Tile t2 = new Tile(r, s);
                assertEquals(true, t1.equals(t2));
                assertEquals(true, t2.equals(t1));
                assertEquals(t1, t2);
                assertEquals(t2, t1);
            }
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI,
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };
        for (Tile.Rank r : ranks) {
            Tile t1 = new Tile(r);
            Tile t2 = new Tile(r);
            assertEquals(true, t1.equals(t2));
            assertEquals(true, t2.equals(t1));
            assertEquals(t1, t2);
            assertEquals(t2, t1);
        }
    }

    //Tests the 2-argument equals method using 2 tiles both equal in rank, suit and type,
    //but one tile is an akadora and the other is not.
    //Should return true if the akadora boolean is false; false if the akadora boolean is true
    @Test
    public void equals_2() throws Exception {
        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                Tile t1 = new Tile(r, s);
                Tile t2 = new Tile(r, s, Tile.Attribute.AKADORA);

                //akadora boolean is false
                assertEquals(true, t1.equals(t2));
                assertEquals(true, t2.equals(t1));
                assertEquals(t1, t2);
                assertEquals(t2, t1);

                //akadora boolean is true
                assertNotEquals(true, t1.equals(t2, true));
                assertNotEquals(true, t2.equals(t1, true));

            }
        }
    }

    //Tests the 3-argument equals method using 2 tiles both equal in rank, suit, type
    //and whether the tile is an akadora or not but the with different visibilities.
    //Should return true if the allAttributes boolean is false;
    //false if the allAttributes boolean is true
    @Test
    public void equals_3() throws Exception {
        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };
        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_OWNER
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                for (Tile.Attribute a1 : attributes) {
                    for (Tile.Attribute a2 : attributes) {
                        if (a1 != a2) {
                            Tile.Attribute attributesArray1[] = new Tile.Attribute[]{
                                    Tile.Attribute.AKADORA, a1
                            };
                            Tile.Attribute attributesArray2[] = new Tile.Attribute[]{
                                    Tile.Attribute.AKADORA, a2
                            };

                            Tile t1 = new Tile(r, s, attributesArray1);
                            Tile t2 = new Tile(r, s, attributesArray2);

                            //allAttributes boolean is false
                            assertEquals(true, t1.equals(t2, true, false));
                            assertEquals(true, t1.equals(t2, true, false));

                            //allAttributes boolean is true
                            assertNotEquals(true, t1.equals(t2, true, true));
                            assertNotEquals(true, t2.equals(t1, true, true));
                        }
                    }
                }
            }
        }
    }

    //Tests the 3-argument equals method using 2 tiles equal in rank, suit, type and attributes
    //but the order of attributes given to each tiles' constructors are not the same.
    //Should return true
    //(the order of the attributes should not be taken into consideration for equality)
    @Test
    public void equals_4() throws Exception {
        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };
        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_OWNER
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                for (Tile.Attribute a : attributes) {
                    Tile.Attribute attributesArray1[] = new Tile.Attribute[]{
                            a, Tile.Attribute.AKADORA
                    };
                    Tile.Attribute attributesArray2[] = new Tile.Attribute[]{
                            Tile.Attribute.AKADORA, a
                    };
                    Tile t1 = new Tile(r, s, attributesArray1);
                    Tile t2 = new Tile(r, s, attributesArray2);

                    assertEquals(true, t1.equals(t2, true, true));
                    assertEquals(true, t2.equals(t1, true, true));
                }
            }
        }
    }

    //Tests all equals methods using 2 tiles which have different ranks
    //Should return false for all methods
    @Test
    public void equals_5() throws Exception {
        Tile.Rank ranks[];

        ranks = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Rank r1 : ranks) {
            for (Tile.Rank r2 : ranks) {
                for (Tile.Suit s : suits) {
                    if (r1 != r2) {
                        Tile t1 = new Tile(r1, s);
                        Tile t2 = new Tile(r2, s);
                        assertNotEquals(t1, t2);
                        assertNotEquals(t2, t1);
                        assertNotEquals(true,t1.equals(t2,true));
                        assertNotEquals(true,t2.equals(t1,true));
                        assertNotEquals(true,t1.equals(t2,true, true));
                        assertNotEquals(true,t2.equals(t1,true, true));
                    }
                }
            }
        }

        ranks = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI,
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        for (Tile.Rank r1 : ranks) {
            for (Tile.Rank r2 : ranks) {
                if (r1 != r2) {
                    Tile t1 = new Tile(r1);
                    Tile t2 = new Tile(r2);
                    assertNotEquals(t1, t2);
                    assertNotEquals(t2, t1);
                    assertNotEquals(true,t1.equals(t2,true));
                    assertNotEquals(true,t2.equals(t1,true));
                    assertNotEquals(true,t1.equals(t2,true, true));
                    assertNotEquals(true,t2.equals(t1,true, true));

                }
            }
        }
    }

    //Tests all equals methods using 2 tiles which have different suits
    //Should return false for all methods
    @Test
    public void equals_6() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s1 : suits) {
                for (Tile.Suit s2 : suits) {
                    if (s1 != s2) {
                        Tile t1 = new Tile(r, s1);
                        Tile t2 = new Tile(r, s2);
                        assertNotEquals(t1, t2);
                        assertNotEquals(t2, t1);
                        assertNotEquals(true,t1.equals(t2,true));
                        assertNotEquals(true,t2.equals(t1,true));
                        assertNotEquals(true,t1.equals(t2,true, true));
                        assertNotEquals(true,t2.equals(t1,true, true));
                    }
                }
            }
        }
    }

    //Tests all equals methods using 2 tiles which have different types (jihai and nonjihai)
    //Should return false for all methods
    @Test
    public void equals_7() throws Exception {

        Tile.Rank ranks1[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };

        Tile.Rank ranks2[] = new Tile.Rank[]{
                Tile.Rank.TON, Tile.Rank.NAN, Tile.Rank.SHA, Tile.Rank.PEI,
                Tile.Rank.HAKU, Tile.Rank.HATSU, Tile.Rank.CHUN
        };

        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };

        for (Tile.Rank r1 : ranks1) {
            for (Tile.Rank r2 : ranks2) {
                for (Tile.Suit s : suits) {
                    Tile t1 = new Tile(r1, s);
                    Tile t2 = new Tile(r2, s);
                    assertNotEquals(t1, t2);
                    assertNotEquals(t2, t1);
                    assertNotEquals(true,t1.equals(t2,true));
                    assertNotEquals(true,t2.equals(t1,true));
                    assertNotEquals(true,t1.equals(t2,true, true));
                    assertNotEquals(true,t2.equals(t1,true, true));
                }
            }
        }
    }

    //Tests the 3-argument equals method using 2 tiles which have the same rank, suit, type
    //and number of attributes but the attributes are different
    //Should return false
    @Test
    public void equals_8() throws Exception {
        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };
        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_OWNER
        };

        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                for (Tile.Attribute a1 : attributes) {
                    for (Tile.Attribute a2 : attributes) {
                        if (a1 != a2) {
                            Tile t1;
                            Tile t2;
                            Tile.Attribute attributesArray1[];
                            Tile.Attribute attributesArray2[];

                            //1 attribute in array
                            attributesArray1 = new Tile.Attribute[]{a1};
                            attributesArray2 = new Tile.Attribute[]{a2};
                            t1 = new Tile(r,s,attributesArray1);
                            t2 = new Tile(r,s,attributesArray2);

                            assertNotEquals(true,t1.equals(t2,true,true));
                            assertNotEquals(true,t2.equals(t1,true,true));

                            //2 attributes in array
                            attributesArray1 = new Tile.Attribute[]{a1, Tile.Attribute.AKADORA};
                            attributesArray2 = new Tile.Attribute[]{a2, Tile.Attribute.AKADORA};
                            t1 = new Tile(r,s,attributesArray1);
                            t2 = new Tile(r,s,attributesArray2);

                            assertNotEquals(true,t1.equals(t2,true,true));
                            assertNotEquals(true,t2.equals(t1,true,true));
                        }
                    }
                }
            }
        }
    }

    //Tests the 3-argument equals method using 2 tiles which have the same rank, suit, type
    //and attributes but the number of attributes given are different
    //(essentially a duplicate attribute was passed to one of the tile's constructor)
    //Should return true
    @Test
    public void equals_9() throws Exception {

        Tile.Rank ranks[] = new Tile.Rank[]{
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3,
                Tile.Rank.NUM_4, Tile.Rank.NUM_5, Tile.Rank.NUM_6,
                Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile.Suit suits[] = new Tile.Suit[]{
                Tile.Suit.MANZU, Tile.Suit.PINZU, Tile.Suit.SOUZU
        };
        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.AKADORA
        };
        for (Tile.Rank r : ranks) {
            for (Tile.Suit s : suits) {
                for (Tile.Attribute a : attributes) {
                    Tile t1;
                    Tile t2;
                    Tile.Attribute attributesArray1[];
                    Tile.Attribute attributesArray2[];

                    //Tests 1-2 arguments
                    attributesArray1 = new Tile.Attribute[]{a}; //1
                    attributesArray2 = new Tile.Attribute[]{a, a}; //2
                    t1 = new Tile(r,s,attributesArray1);
                    t2 = new Tile(r,s,attributesArray2);
                    assertEquals(true,t1.equals(t2,true,true));
                    assertEquals(true,t2.equals(t1,true,true));

                    //Tests 1-3 arguments
                    attributesArray1 = new Tile.Attribute[]{a}; //1
                    attributesArray2 = new Tile.Attribute[]{a, a, a}; //3
                    t1 = new Tile(r,s,attributesArray1);
                    t2 = new Tile(r,s,attributesArray2);
                    assertEquals(true,t1.equals(t2,true,true));
                    assertEquals(true,t2.equals(t1,true,true));

                    //Tests 2-3 arguments
                    attributesArray1 = new Tile.Attribute[]{a, a}; //2
                    attributesArray2 = new Tile.Attribute[]{a, a, a}; //3
                    t1 = new Tile(r,s,attributesArray1);
                    t2 = new Tile(r,s,attributesArray2);
                    assertEquals(true,t1.equals(t2,true,true));
                    assertEquals(true,t2.equals(t1,true,true));

                    //Tests 2-3 (mixed) arguments
                    attributesArray1 = new Tile.Attribute[]{a, Tile.Attribute.AKADORA}; //2
                    attributesArray2 = new Tile.Attribute[]{a, Tile.Attribute.AKADORA, a}; //3
                    t1 = new Tile(r,s,attributesArray1);
                    t2 = new Tile(r,s,attributesArray2);
                    assertEquals(true,t1.equals(t2,true,true));
                    assertEquals(true,t2.equals(t1,true,true));
                }
            }
        }
    }


    /**
     * Tests the getName method
     */
    //Tests the no argument getName method (or getName(false))
    //Should return the tile's name (with numerals for the tiles with numeric ranks)
    @Test
    public void toName_1() throws Exception {

        //create all possible tiles

        Tile.Rank ranks[] = new Tile.Rank[] {
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3, Tile.Rank.NUM_4, Tile.Rank.NUM_5,
                Tile.Rank.NUM_6, Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile manzuTiles[] = new Tile[9]; //all manzu
        Tile manzuTilesAka[] = new Tile[9]; //all manzu(red)
        Tile pinzuTiles[] = new Tile[9]; //all pinzu
        Tile pinzuTilesAka[] = new Tile[9]; //all pinzu(red)
        Tile souzuTiles[] = new Tile[9]; //all souzu
        Tile souzuTilesAka[] = new Tile[9]; //all souzu (red)
        Tile jihaiTiles[] = new Tile[7]; //all jihai

        for (int i = 0; i < 9; i++) {
            manzuTiles[i] = new Tile(ranks[i], Tile.Suit.MANZU);
            manzuTilesAka[i] = new Tile(ranks[i], Tile.Suit.MANZU, Tile.Attribute.AKADORA);
            pinzuTiles[i] = new Tile(ranks[i], Tile.Suit.PINZU);
            pinzuTilesAka[i] = new Tile(ranks[i], Tile.Suit.PINZU, Tile.Attribute.AKADORA);
            souzuTiles[i] = new Tile(ranks[i], Tile.Suit.SOUZU);
            souzuTilesAka[i] = new Tile(ranks[i], Tile.Suit.SOUZU, Tile.Attribute.AKADORA);
        }

        jihaiTiles[0] = new Tile(Tile.Rank.TON);
        jihaiTiles[1] = new Tile(Tile.Rank.NAN);
        jihaiTiles[2] = new Tile(Tile.Rank.SHA);
        jihaiTiles[3] = new Tile(Tile.Rank.PEI);
        jihaiTiles[4] = new Tile(Tile.Rank.HAKU);
        jihaiTiles[5] = new Tile(Tile.Rank.HATSU);
        jihaiTiles[6] = new Tile(Tile.Rank.CHUN);


        //numeric tile tests
        String prefix[] = {"1","2","3","4","5","6","7","8","9"};

        for (int i = 0; i < 9; i++) {
            assertEquals(prefix[i] + "-wan",manzuTiles[i].getName());
            assertEquals(prefix[i] + "-wan(Red)",manzuTilesAka[i].getName());
            assertEquals(prefix[i] + "-pin",pinzuTiles[i].getName());
            assertEquals(prefix[i] + "-pin(Red)",pinzuTilesAka[i].getName());
            assertEquals(prefix[i] + "-sou",souzuTiles[i].getName());
            assertEquals(prefix[i] + "-sou(Red)",souzuTilesAka[i].getName());
        }

        //jihai tests
        assertEquals("Ton",jihaiTiles[0].getName());
        assertEquals("Nan",jihaiTiles[1].getName());
        assertEquals("Sha",jihaiTiles[2].getName());
        assertEquals("Pei",jihaiTiles[3].getName());
        assertEquals("Haku",jihaiTiles[4].getName());
        assertEquals("Hatsu",jihaiTiles[5].getName());
        assertEquals("Chun",jihaiTiles[6].getName());

        //unknown tile test
        Tile unknown = new Tile(Tile.Rank.UNKNOWN);
        assertEquals("<??>",unknown.getName());
    }


    //Tests the one argument getName method when true (getName(true))
    //Should return the tile's name
    @Test
    public void toName_2() throws Exception {

        //create all possible tiles

        Tile.Rank ranks[] = new Tile.Rank[] {
                Tile.Rank.NUM_1, Tile.Rank.NUM_2, Tile.Rank.NUM_3, Tile.Rank.NUM_4, Tile.Rank.NUM_5,
                Tile.Rank.NUM_6, Tile.Rank.NUM_7, Tile.Rank.NUM_8, Tile.Rank.NUM_9
        };
        Tile manzuTiles[] = new Tile[9]; //all manzu
        Tile manzuTilesAka[] = new Tile[9]; //all manzu(red)
        Tile pinzuTiles[] = new Tile[9]; //all pinzu
        Tile pinzuTilesAka[] = new Tile[9]; //all pinzu(red)
        Tile souzuTiles[] = new Tile[9]; //all souzu
        Tile souzuTilesAka[] = new Tile[9]; //all souzu (red)
        Tile jihaiTiles[] = new Tile[7]; //all jihai

        for (int i = 0; i < 9; i++) {
            manzuTiles[i] = new Tile(ranks[i], Tile.Suit.MANZU);
            manzuTilesAka[i] = new Tile(ranks[i], Tile.Suit.MANZU, Tile.Attribute.AKADORA);
            pinzuTiles[i] = new Tile(ranks[i], Tile.Suit.PINZU);
            pinzuTilesAka[i] = new Tile(ranks[i], Tile.Suit.PINZU, Tile.Attribute.AKADORA);
            souzuTiles[i] = new Tile(ranks[i], Tile.Suit.SOUZU);
            souzuTilesAka[i] = new Tile(ranks[i], Tile.Suit.SOUZU, Tile.Attribute.AKADORA);
        }

        jihaiTiles[0] = new Tile(Tile.Rank.TON);
        jihaiTiles[1] = new Tile(Tile.Rank.NAN);
        jihaiTiles[2] = new Tile(Tile.Rank.SHA);
        jihaiTiles[3] = new Tile(Tile.Rank.PEI);
        jihaiTiles[4] = new Tile(Tile.Rank.HAKU);
        jihaiTiles[5] = new Tile(Tile.Rank.HATSU);
        jihaiTiles[6] = new Tile(Tile.Rank.CHUN);


        //numeric tile tests
        String prefix[] = {"Ii","Ryan","San","Suu","Uu","Rou","Chii","Paa","Kyuu"};

        for (int i = 0; i < 9; i++) {
            assertEquals(prefix[i] + "-wan",manzuTiles[i].getName(true));
            assertEquals(prefix[i] + "-wan(Red)",manzuTilesAka[i].getName(true));
            assertEquals(prefix[i] + "-pin",pinzuTiles[i].getName(true));
            assertEquals(prefix[i] + "-pin(Red)",pinzuTilesAka[i].getName(true));
            assertEquals(prefix[i] + "-sou",souzuTiles[i].getName(true));
            assertEquals(prefix[i] + "-sou(Red)",souzuTilesAka[i].getName(true));
        }

        //jihai tests
        assertEquals("Ton",jihaiTiles[0].getName(true));
        assertEquals("Nan",jihaiTiles[1].getName(true));
        assertEquals("Sha",jihaiTiles[2].getName(true));
        assertEquals("Pei",jihaiTiles[3].getName(true));
        assertEquals("Haku",jihaiTiles[4].getName(true));
        assertEquals("Hatsu",jihaiTiles[5].getName(true));
        assertEquals("Chun",jihaiTiles[6].getName(true));

        //unknown tile test
        Tile unknown = new Tile(Tile.Rank.UNKNOWN);
        assertEquals("<??>",unknown.getName(true));
    }

}