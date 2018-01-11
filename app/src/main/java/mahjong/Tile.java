package mahjong;


import android.util.Log;

import java.util.ArrayList;

public class Tile {

    private Rank rank;
    private Suit suit;
    private Type type;
    private boolean isRed; //is akadora or not
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

        EXPOSED_TO_NO_PLAYERS,
        EXPOSED_TO_OWNER,
        EXPOSED_TO_ALL_PLAYERS
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

            if ((suit == Suit.KAZEHAI) || (suit == Suit.SANGENPAI) || (suit == Suit.UNKNOWN)) {
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

            //iterate through attributes array
            for (Attribute a : attributes) {
                //perform any necessary handling of certain attributes
                switch (a) {
                    case AKADORA: isRed = true;
                        break;
                } //end switch-case

                temp.add(a); //add attributes to temporary array
            } //end for loop

            this.attributes = temp.toArray(new Attribute[temp.size()]); //convert and copy over

        } //end if statement


        //if tile validation failed for any reason, make the tile an unknown one
        if (!status) {
            this.rank = Rank.UNKNOWN;
            this.suit = Suit.UNKNOWN;
            this.type = Type.UNKNOWN;
            this.attributes = new Attribute[0];

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
        for (Attribute attribute : this.attributes) {
            if (attribute == a) return true;
        } //end for loop
        return false;
    } //end is method

    public boolean isRed() {
        return isRed;
    } //end is method

    /*
    public boolean isVisible() {

    }
    */

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
            case MANZU: s += "man"; break;
            case PINZU: s += "pin"; break;
            case SOUZU: s += "sou"; break;
            default: break; //unknown or no suffix; do nothing
        } //end switch-case

        if (isRed)
            s += "(Red)";

        return s;
    } //end getName method

    public String getName() {
        return getName(false);
    } //end getName method


} //end Tile class

