package mahjong;


import java.util.ArrayList;
import java.util.Arrays;

public class Tile {

    private Rank rank;
    private Suit suit;
    private Type type;
    private Attribute[] attributes;

    public enum Rank {
        //looks ugly but NUM_ prefix is necessary since enums cannot begin with a number
        NUM_1,
        NUM_2,
        NUM_3,
        NUM_4,
        NUM_5,
        NUM_6,
        NUM_7,
        NUM_8,
        NUM_9,
        TON, //east
        NAN, //south
        SHA, //west
        PEI, //pei
        HAKU, //white dragon
        HATSU, //green dragon
        CHUN, //red dragon

        UNKNOWN
    } //end Rank enum

    public enum Suit {
        MANZU, //characters
        PINZU, //dots
        SOUZU, //bamboo
        KAZEHAI, //winds; not a true suit but here for organizational purposes
        SANGENPAI, //dragons; not a true suit but here for organizational purposes

        UNKNOWN
    } //end Suit enum

    public enum Type {
        CHUNCHANHAI, //simples (2-8)
        ROUTOUHAI, //terminals (1,9)
        JIHAI, //letter tiles

        UNKNOWN
    } //end Type enum

    public enum Attribute {
        AKADORA, //red dora

        VISIBLE_TO_NO_PLAYERS,
        VISIBLE_TO_OWNER,
        VISIBLE_TO_ALL_PLAYERS
    } //end Attribute enum


    /*
     * Constructors
     */
    public Tile() {
        //empty constructor used only to create unknown tiles
        this(Rank.UNKNOWN);
    } //end Tile constructor

    public Tile(Rank rank) {
        //constructor using only rank
        //only useful for constructing jihai tiles
        this(rank,Suit.UNKNOWN);
    } //end Tile constructor

    public Tile(Rank rank, Suit suit) {
        //constructor using only rank and suit
        this(rank, suit,new Attribute[0]);
    } //end Tile constructor

    public Tile(Rank rank, Suit suit, Attribute attribute) {
        //constructor using rank, suit and one attribute
        //uses the other constructor after converting attribute to an array of attributes
        this(rank, suit, new Attribute[] {attribute});

    } //end Tile constructor

    public Tile(Rank rank, Suit suit, Attribute[] attributes) {
        //constructor using rank, suit and (potentially) multiple attributes

        boolean status = true; //when set to false, make the tile of unknown type


        //attempt to infer tile info for jihai tiles
        if (rank == Rank.UNKNOWN) {
            //at minimum, the rank must be known to generate a tile
            status = false;

        } else {

            if ((suit == Suit.KAZEHAI) || (suit == Suit.UNKNOWN)) {
                //attempt to infer suit and type for jihai
                switch (rank) {
                    case TON:
                        this.rank = rank;
                        this.suit = Suit.KAZEHAI;
                        this.type = Type.JIHAI;
                        break;
                    case NAN:
                        this.rank = rank;
                        this.suit = Suit.KAZEHAI;
                        this.type = Type.JIHAI;
                        break;
                    case SHA:
                        this.rank = rank;
                        this.suit = Suit.KAZEHAI;
                        this.type = Type.JIHAI;
                        break;
                    case PEI:
                        this.rank = rank;
                        this.suit = Suit.KAZEHAI;
                        this.type = Type.JIHAI;
                        break;
                    default:
                        //conflicting rank and suit
                        if (suit != Suit.UNKNOWN) status = false;
                        break;
                } //end switch-case
            } //end if statement

            if (((suit == Suit.SANGENPAI) || (suit == Suit.UNKNOWN))
                    && (this.type == null)) { //check if tile was already inferred
                //attempt to infer suit and type for jihai

                switch (rank) {
                    case HAKU:
                        this.rank = rank;
                        this.suit = Suit.SANGENPAI;
                        this.type = Type.JIHAI;
                        break;
                    case HATSU:
                        this.rank = rank;
                        this.suit = Suit.SANGENPAI;
                        this.type = Type.JIHAI;
                        break;
                    case CHUN:
                        this.rank = rank;
                        this.suit = Suit.SANGENPAI;
                        this.type = Type.JIHAI;
                        break;
                    default:
                        //conflicting rank and suit
                        status = false;
                        break;
                }//end switch-case
            } //end if statement
        } //end if statement

        //attempt to infer tile info for non-jihai tiles
        if ((status) && (this.type != Type.JIHAI)) {
            if (suit == Suit.UNKNOWN) {
                //at minimum the rank and suit must be known to generate a non-jihai
                status = false;

            } else if ((suit == Suit.MANZU) || (suit == Suit.PINZU) || (suit == Suit.SOUZU)) {
                switch (rank) {
                    case NUM_1:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.ROUTOUHAI;
                        break;
                    case NUM_2:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_3:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_4:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_5:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_6:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_7:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_8:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.CHUNCHANHAI;
                        break;
                    case NUM_9:
                        this.rank = rank;
                        this.suit = suit;
                        this.type = Type.ROUTOUHAI;
                        break;
                    default:
                        //conflicting rank and suit
                        status = false;
                } //end switch-case
            } else {
                //conflicting rank and suit inputed
                status = false;
            } //end if statement
        } //end if statement

        //add attributes to tile
        if (status) {
            ArrayList<Attribute> temp = new ArrayList<>();

            boolean hasVisibility = false;

            //iterate through array and perform any necessary handling of certain attributes
            for (Attribute a : attributes) {
                //perform any checks or necessary handling of certain attributes
                //duplicate attributes are also removed
                switch (a) {
                    case AKADORA:
                        if (this.type == Type.JIHAI) status = false; //jihai cannot be akadora
                        if (!temp.contains(Attribute.AKADORA)) temp.add(a);
                        break;
                    case VISIBLE_TO_NO_PLAYERS:
                        if (!temp.contains(Attribute.VISIBLE_TO_NO_PLAYERS)) temp.add(a);
                        break;
                    case VISIBLE_TO_OWNER:
                        if (!temp.contains(Attribute.VISIBLE_TO_OWNER)) temp.add(a);
                        break;
                    case VISIBLE_TO_ALL_PLAYERS:
                        if (!temp.contains(Attribute.VISIBLE_TO_ALL_PLAYERS)) temp.add(a);
                        break;
                } //end switch-case
            } //end for loop

            //check that only 1 visibility is given (or in the case of 0, assign the default)
            int numVisibilities = 0;
            if (temp.contains(Attribute.VISIBLE_TO_NO_PLAYERS)) numVisibilities++;
            if (temp.contains(Attribute.VISIBLE_TO_OWNER)) numVisibilities++;
            if (temp.contains(Attribute.VISIBLE_TO_ALL_PLAYERS)) numVisibilities++;

            if (numVisibilities == 0)
                temp.add(Attribute.VISIBLE_TO_NO_PLAYERS); //default visibility
            else if (numVisibilities > 1)
                status = false;

            if (status)
                this.attributes = temp.toArray(new Attribute[temp.size()]); //copy array over

        } //end if statement


        //if tile validation failed for any reason, make the tile an unknown one
        if (!status) {
            this.rank = Rank.UNKNOWN;
            this.suit = Suit.UNKNOWN;
            this.type = Type.UNKNOWN;
            this.attributes = new Attribute[] {Attribute.VISIBLE_TO_NO_PLAYERS};
        } //end if statement

    } //end Tile constructor


    /*
     * Getters for fields
     */
    public Rank getRank() {
        return this.rank;
    } //end getRank method

    public Suit getSuit() {
        return this.suit;
    } //end getSuit method

    public Type getType() {
        return this.type;
    } //end getType method


    /*
     * is() methods for enums
     */
    public boolean is(Rank r) {
        return (r == this.rank);
    } //end is method

    public boolean is(Suit s) {
        return (s == this.suit);
    } //end is method

    public boolean is(Type t) {
        return (t == this.type);
    } //end is method

    public boolean is(Attribute a) {
        //check if tile has a certain attribute in its attribute list
        for (Attribute attribute : this.attributes) {
            if (attribute == a) return true;
        } //end for loop
        return false;
    } //end is method

    /*
    public boolean isVisible() {

    }
    */

    @Override
    public boolean equals(Object object) {
        //Overrides equals() from object
        //compares tiles by checking only the rank, suit and type

        if (object == null) return false;
        if (!Tile.class.isAssignableFrom(object.getClass())) return false;

        final Tile tile = (Tile) object;

        return equals(tile,false);
    } //end equals method

    public boolean equals(Tile tile, boolean akadora) {
        //compares tiles by checking the rank, suit, type and akadora attribute
        return equals(tile, akadora, false);
    } //end equals method


    public boolean equals(Tile tile, boolean akadora, boolean allAttributes) {
        //compares tiles by checking at minimum the rank, suit and type
        //akadora boolean indicates whether to include the akadora attribute when comparing tiles
        //allAttributes boolean indicates whether to compare everything about the tile (esp. attributes)

        //compare suit, rank and type
        if (this.suit != tile.suit) return false;
        if (this.rank != tile.rank) return false;
        if (this.type != tile.type) return false;

        if (!akadora) return true; //tile is equal at least in rank, suit and type

        //compare akadora attribute
        if (this.is(Attribute.AKADORA) != tile.is(Attribute.AKADORA)) return false;

        if (!allAttributes) return true; //tile is equal in rank, suit, type and AKADORA attribute

        //compare attributes without regard to the order of the attributes in the array
        if (this.attributes.length != tile.attributes.length) return false;
        Attribute attributesArray[] = Arrays.copyOf(tile.attributes,tile.attributes.length);
        for (Attribute a : attributesArray) {
            if (!this.is(a)) return false;
        } //end for loop

        return true;
    } //end equals method




    //returns a generated name based on the tile's rank and suit
    public String getName(boolean b) {
        String s = "";

        switch (rank) {
            case NUM_1: s += (b) ? "Ii-" : "1-"; break;
            case NUM_2: s += (b) ? "Ryan-" : "2-"; break;
            case NUM_3: s += (b) ? "San-" : "3-"; break;
            case NUM_4: s += (b) ? "Suu-" : "4-"; break;
            case NUM_5: s += (b) ? "Uu-" : "5-"; break;
            case NUM_6: s += (b) ? "Rou-" : "6-"; break;
            case NUM_7: s += (b) ? "Chii-" : "7-"; break;
            case NUM_8: s += (b) ? "Paa-" : "8-"; break;
            case NUM_9: s += (b) ? "Kyuu-" : "9-"; break;
            case TON: s += "Ton"; break;
            case NAN: s += "Nan"; break;
            case SHA: s += "Sha"; break;
            case PEI: s += "Pei"; break;
            case HAKU: s += "Haku"; break;
            case HATSU: s += "Hatsu"; break;
            case CHUN: s += "Chun"; break;
            default: s += "<??>"; break;
        } //end switch-case

        switch (suit) {
            case MANZU: s += "wan"; break;
            case PINZU: s += "pin"; break;
            case SOUZU: s += "sou"; break;
            default: break; //unknown or no suffix; do nothing
        } //end switch-case

        if (this.is(Attribute.AKADORA))
            s += "(Red)";

        return s;
    } //end getName method

    public String getName() {
        return getName(false);
    } //end getName method

    public String toNotation() {
        //Returns the notation of the current tile as a string
        return null;
    } //end toNotation method

    public static String toNotation(Tile tile) {
        //Returns the notation of the tile in the parameter as a string
        return null;
    } //end toNotation method

    public static String toNotation(Tile tile[]) {
        //Returns the notation of the tiles in the parameter as a string
        return null;
    } //end toNotation method

    public static Tile toTile(String s) {
        //Returns a (new) single tile from the notation (as a string) in the parameter
        return null;
    } //end toTile method

    public static Tile[] toTileArray(String s) {
        //Returns a (new) tile array from the notation (as a string) in the parameter
        return null;
    } //end toTileArray method

} //end Tile class

