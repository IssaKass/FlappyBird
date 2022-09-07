package com.issakass.flappyBird.utils;

import static com.issakass.flappyBird.main.Game.GAME_HEIGHT;

public class Constants {
    public static final float GRAVITY = 0.05f;
    public static final float JUMP_SPEED = -1.5f;
    public static final float MAX_AIR_SPEED = 2.2f;

    public static class EntityConstants {
        public static class BirdConstants {
            public static final String BIRD_SPRITE_SHEET = "entities/bird.png";
            public static final int BIRD_WIDTH = 51;
            public static final int BIRD_HEIGHT = 36;
            public static final int BIRD_EFFECTS = 3;
            public static final int BIRD_ANIMATION_SPEED = 30;
            public static final float BIRD_START_X = 80;
            public static final float BIRD_START_Y = 50;
        }

        public static class GroundConstants {
            public static final String GROUND_IMAGE = "environments/ground.png";
            public static final int GROUND_WIDTH = 504;
            public static final int GROUND_HEIGHT = 168;
            public static final int GROUND_X = 0;
            public static final int GROUND_Y = GAME_HEIGHT - GROUND_HEIGHT;
        }

        public static class TubeConstants {
            public static final String TUBE_IMAGE = "entities/tube.png";
            public static final String TUBE_BLOCK_IMAGE = "entities/tubeBlock.png";
            public static final int TUBE_WIDTH = 72;
            public static final int TUBE_BLOCK_WIDTH = 78;
            public static final int TUBE_BLOCK_HEIGHT = 36;
            public static final int TUBE_OFFSET = (TUBE_BLOCK_WIDTH - TUBE_WIDTH) / 2;
        }
    }


    public static class Backgrounds {
        public static final String LANDSCAPE_BACKGROUND = "environments/landscape.png";
    }

    public static class UI_Constants {
        public static class TitleLabelConstants {
            public static final String TITLE_LABEL_IMAGE = "ui/title.png";
            public static final int TITLE_LABEL_WIDTH = 267;
            public static final int TITLE_LABEL_HEIGHT = 72;
        }

        public static class GameOverLabelConstants {
            public static final String GAME_OVER_LABEL_IMAGE = "ui/gameOver.png";
            public static final int GAME_OVER_LABEL_WIDTH = 288;
            public static final int GAME_OVER_LABEL_HEIGHT = 63;
        }

        public static class LeaderboardPanelConstants {
            public static final String LEADERBOARD_PANEL_IMAGE = "ui/leaderboardPanel.png";
            public static final int LEADERBOARD_PANEL_WIDTH = 339;
            public static final int LEADERBOARD_PANEL_HEIGHT = 171;
        }

        public static class ScoreNumbersConstants {
            public static final String SCORE_NUMBERS_IMAGE = "ui/scoreNumbers.png";
            public static final int SCORE_NUMBERS_COUNT = 10;
            public static final int SCORE_NUMBER_WIDTH = 21;
            public static final int SCORE_NUMBER_HEIGHT = 30;
        }

        public static class MedalConstants {
            public static final String MEDAL_IMAGE = "ui/medal.png";
            public static final int MEDAL_SIZE = 58;
            public static final int MEDALS_COUNT = 4;
            public static final int MEDAL_X = 43;
            public static final int MEDAL_Y = 67;

            public static final int BRONZE = 0;
            public static final int SILVER = 1;
            public static final int GOLD = 2;
            public static final int PLATINUM = 3;

            public static int GetMedalRank(float score) {
                if (score < 10) return -1;
                else if (score < 20) return BRONZE;
                else if (score < 30) return SILVER;
                else if (score < 40) return GOLD;
                else return PLATINUM;
            }
        }

        public static class PlayButtonConstants {
            public static final String PLAY_BUTTON_IMAGE = "ui/playbutton.png";
            public static final int PLAY_BUTTON_WIDTH = 156;
            public static final int PLAY_BUTTON_HEIGHT = 87;
        }

        public static class PauseButtonConstants {
            public static final String PAUSE_BUTTON_IMAGE_1 = "ui/pause.png";
            public static final String PAUSE_BUTTON_IMAGE_2 = "ui/continue.png";
            public static final int PAUSE_BUTTON_WIDTH = 39;
            public static final int PAUSE_BUTTON_HEIGHT = 42;
        }
    }
}
