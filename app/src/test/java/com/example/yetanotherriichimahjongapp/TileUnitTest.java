package com.example.yetanotherriichimahjongapp;

import org.junit.Test;

import mahjong.Tile;

import static org.junit.Assert.*;

public class TileUnitTest {

    /*
     * Tests the no-argument constructor
     */
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


    /*
     * Tests the single argument constructor
     */
    //Valid input: all jihai
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


    /*
     * Tests the two argument constructor
     */
    //Valid input: any num rank + manzu, pinzu or souzu suit
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
    //should produce an unknown tile
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
    //should produce an unknown tile
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
    //should produce an unknown tile
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

    /*
     * Tests the three argument (single attribute) constructor
     */
    //Valid input: akadora attribute with non-jihai
    //produced tiles should be red
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
    //produced tiles should not be red
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
                assertEquals(false, tile.is(Tile.Attribute.AKADORA));
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
                assertEquals(false, tile.is(Tile.Attribute.AKADORA));
                assertEquals(true, tile.is(Tile.Attribute.VISIBLE_TO_ALL_PLAYERS));
            }
        }
    }

    //Invalid input: akadora attribute with jihai
    //should produce unknown tiles
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



    /*
     * Tests the three argument (multiple attributes) constructor
     */
    //Valid input: Multiple valid attributes
    //(Currently the only incompatible attributes are multiple visibilities

    @Test
    public void threeArgumentConstructor_4() throws Exception {

        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS
        };

        for (Tile.Attribute a : attributes) {
            for (Tile.Attribute b : attributes) { //test that only attributes in the array are added
                if (a != b) {

                    Tile t;
                    Tile.Attribute attributesArray[];

                    attributesArray = new Tile.Attribute[]{a, Tile.Attribute.AKADORA};
                    t = new Tile(Tile.Rank.NUM_5, Tile.Suit.PINZU, attributesArray);

                    assertEquals(true, t.is(Tile.Attribute.AKADORA));
                    assertEquals(true, t.is(a));
                    assertEquals(false, t.is(b));

                    //tests different order of attributes in array
                    attributesArray = new Tile.Attribute[]{Tile.Attribute.AKADORA, a};
                    t = new Tile(Tile.Rank.NUM_5, Tile.Suit.PINZU, attributesArray);

                    assertEquals(true, t.is(Tile.Attribute.AKADORA));
                    assertEquals(true, t.is(a));
                    assertEquals(false, t.is(b));
                }
            }
        }
    }

    //Valid input: Duplicate attributes
    //(Shouldn't be done but still valid)
    @Test
    public void threeArgumentConstructor_5() throws Exception {

        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS,
                Tile.Attribute.AKADORA
        };

        for (Tile.Attribute a : attributes) { //test using multiple instances of attribute a
            for (Tile.Attribute b : attributes) {
                if (a != b) {

                    Tile.Attribute attributesArray[] = new Tile.Attribute[]{a, a};
                    Tile t = new Tile(Tile.Rank.NUM_5, Tile.Suit.SOUZU, attributesArray);
                    assertEquals(true, t.is(a));

                    if (a == Tile.Attribute.AKADORA) {
                        assertEquals(true, t.is(Tile.Attribute.VISIBLE_TO_NO_PLAYERS));
                    } else {
                        assertEquals(false, t.is(b));
                    }

                }
            }
        }
    }

    //Invalid input: Multiple visibilities were specified
    //Should produce unknown tiles
    @Test
    public void threeArgumentConstructor_6() throws Exception {

        Tile.Attribute attributes[] = new Tile.Attribute[]{
                Tile.Attribute.VISIBLE_TO_NO_PLAYERS,
                Tile.Attribute.VISIBLE_TO_OWNER,
                Tile.Attribute.VISIBLE_TO_ALL_PLAYERS,
        };

        //2 visibilities
        for (Tile.Attribute a : attributes) {
            for (Tile.Attribute b : attributes) {
                if (a != b) {
                    Tile.Attribute attributesArray[] = new Tile.Attribute[]{a, b};

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
        for (Tile.Attribute a : attributes) {
            for (Tile.Attribute b : attributes) {
                for (Tile.Attribute c : attributes) {
                    if ((a != b) && (a != c) && (b != c)) {
                        Tile.Attribute attributesArray[] = new Tile.Attribute[]{a, b, c};

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


    /*
     * Tests the equals method
     */
    //Tests 2 tiles equal in rank, suit and type
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

    //Tests 2 tiles, one of which is an akadora and the other is not but
    //is otherwise equal in rank, suit and type.
    //should return true if the akadora boolean is false; or false if the akadora boolean is true
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

    //Tests 2 tiles both of which have the same rank, suit, type and whether the tile is
    //an akadora or not but the two tiles have different visibilities.
    //Should return true if the allAttributes boolean is false; false otherwise
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

    //Tests 2 tiles, both of which have the same rank, suit, type and attributes
    //but the attributes are not in the same order.
    //Should return true on equals() since the order is not taken into consideration
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

    //Tests 2 tiles which have different ranks
    //Should return false
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
                }
            }
        }
    }

    //Tests 2 tiles which have different suits
    //Should return false
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
                    }
                }
            }
        }
    }

    //Tests 2 tiles which have different types (jihai and nonjihai)
    //Should return false
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
                }
            }
        }
    }
}