package com.lalbr.cwapp.media.general;

public enum SubGenre {



    //books - fantasy
    DarkFantasy, // eg Witcher
    HighFantasy, // eg LOTR
    LowFantasy, // eg HarryPotter
    ScienceFantasy,
    SwordandSorcery, // eg Conan der Barbar
    SteampunkFantasy,
    UrbanFantasy, //fantasy in urban settings
    EpicFantasy,
    MythicFantasy,
    GrimdarkFantasy, // eg GoT
    //books - sci fi
    HardSciFi, // realistischer
    SoftSciFi, // weniger realistisch
    Dystopia,
    Utopia,
    Cyberpunk,
    SpaceOpera, // eg star wars
    Postapokalyptisch,
    //books - abenteuer
    Exploration,
    Survival,
    Heldenreise,
    //books - sachbuch
    Informatik,
    Geschichte,
    //books - historischer Roman
    AlternativGeschichte,
    Kriegsgeschichte,

    //games - fps
    TaktischerShooter,
    ArenaShooter,
    HeroShooter,
    SurvivalShooter,
    HorrorShooter,
    LootingShooter,
    //games - platformer
    Platformer2D,
    Platformer3D,
    //games - openworld
    ActionAdventure_OpenWorld,
    Survival_OpenWorld,
    RPG_OpenWorld,
    Sandbox_OpenWorld,
    //games - RPG
    Action_RPG,
    TurnBased_RPG,
    Tactical_RPG,
    MMORPG,
    DungeonCrawler,
    Roguelike,
    //games - survival
    ZombieSurvival,
    CraftingSurvival,

    //movies - action
    Superhelden,
    HeistAction,
    MilitärAction;


    public SubGenre[] getBookFantasySubgenres(){
        return new SubGenre[]{
                DarkFantasy,
                HighFantasy,
                LowFantasy,
                ScienceFantasy,
                SwordandSorcery,
                SteampunkFantasy,
                UrbanFantasy,
                EpicFantasy,
                MythicFantasy,
                GrimdarkFantasy,
        };
    }

    public SubGenre[] getBookSciFiSubgenres(){
        return new SubGenre[]{
                HardSciFi,
                SoftSciFi,
                Dystopia,
                Utopia,
                Cyberpunk,
                SpaceOpera,
                Postapokalyptisch,
        };
    }

    public SubGenre[] getBookAbenteuerSubgenres(){
        return new SubGenre[]{
                Exploration,
                Survival,
                Heldenreise,
        };
    }

    public SubGenre[] getBookSachbuchSubgenres(){
        return new SubGenre[]{
                Informatik,
                Geschichte,
        };
    }

    public SubGenre[] getBookHistorischerRomanSubgenres(){
        return new SubGenre[]{
                AlternativGeschichte,
                Kriegsgeschichte
        };
    }
    public SubGenre[] getGamesFPSSubgenres(){
        return new SubGenre[]{
                TaktischerShooter,
                ArenaShooter,
                HeroShooter,
                SurvivalShooter,
                HorrorShooter,
                LootingShooter,
        };
    }

    public SubGenre[] getGamesPlatformerSubgenres(){
        return new SubGenre[]{
                Platformer2D,
                Platformer3D,
        };
    }

    public SubGenre[] getGamesOpenWorldSubgenres(){
        return new SubGenre[]{
                ActionAdventure_OpenWorld,
                Survival_OpenWorld,
                RPG_OpenWorld,
                Sandbox_OpenWorld,
        };
    }

    public SubGenre[] getGamesRPGSubgenres(){
        return new SubGenre[]{
                Action_RPG,
                TurnBased_RPG,
                Tactical_RPG,
                MMORPG,
                DungeonCrawler,
        };
    }
    public SubGenre[] getGamesSurvivalSubgenres(){
        return new SubGenre[]{
                ZombieSurvival,
                CraftingSurvival,
        };
    }
    public SubGenre[] getMoviesActionSubgenres(){
        return new SubGenre[]{
                Superhelden,
                HeistAction,
                MilitärAction
        };
    }

    public static String toString(SubGenre genre){
        return switch (genre) {
            case DarkFantasy -> "Dark Fantasy";
            case HighFantasy -> "High Fantasy";
            case LowFantasy -> "Low Fantasy";
            case ScienceFantasy -> "Science Fantasy";
            case SwordandSorcery -> "Sword and Sorcery";
            case SteampunkFantasy -> "Steampunk Fantasy";
            case UrbanFantasy -> "Urban Fantasy";
            case EpicFantasy -> "Epic Fantasy";
            case MythicFantasy -> "Mythic Fantasy";
            case GrimdarkFantasy -> "Grimdark Fantasy";
            case HardSciFi -> "Hard SciFi";
            case SoftSciFi -> "Soft SciFi";
            case Dystopia -> "Dystopia";
            case Utopia -> "Utopia";
            case Cyberpunk -> "Cyberpunk";
            case SpaceOpera -> "Space Opera";
            case Postapokalyptisch -> "Postapokalyptisch";
            case Exploration -> "Exploration";
            case Survival -> "Survival";
            case Heldenreise -> "Heldenreise";
            case Informatik -> "Informatik";
            case Geschichte -> "Geschichte";
            case AlternativGeschichte -> "Alternative Geschichte";
            case Kriegsgeschichte -> "Kriegsgeschichte";
            case TaktischerShooter -> "Taktischer Shooter";
            case ArenaShooter -> "Arena Shooter";
            case HeroShooter -> "Hero Shooter";
            case SurvivalShooter -> "Survival Shooter";
            case HorrorShooter -> "Horror Shooter";
            case LootingShooter -> "Looting Shooter";
            case Platformer2D -> "Platformer 2D";
            case Platformer3D -> "Platformer 3D";
            case ActionAdventure_OpenWorld -> "Action Adventure Open World";
            case Survival_OpenWorld -> "Survival Open World";
            case RPG_OpenWorld -> "RPG Open World";
            case Sandbox_OpenWorld -> "Sandbox Open World";
            case Action_RPG -> "Action RPG";
            case TurnBased_RPG -> "Turn-Based RPG";
            case Tactical_RPG -> "Tactical RPG";
            case MMORPG -> "MMORPG";
            case DungeonCrawler -> "Dungeon Crawler";
            case Roguelike -> "Roguelike";
            case ZombieSurvival -> "Zombie Survival";
            case CraftingSurvival -> "Crafting Survival";
            case Superhelden -> "Superhelden";
            case HeistAction -> "Heist Action";
            case MilitärAction -> "Militär Action";
        };
    }
}
