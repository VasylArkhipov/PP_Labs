package service;

import controller.VanLoader;
public enum ChoiceNumber implements Choiceable{
    FIRST_CHOICE{
        @Override
        public void actingUserChoice(VanLoader vanLoader) {
            vanLoader.downloadProduct();
        }
    },
    SECOND_CHOICE{
        @Override
        public void actingUserChoice(VanLoader vanLoader) {
            vanLoader.uploadProduct();
        }
    },
    THIRD_CHOICE{
        @Override
        public void actingUserChoice(VanLoader vanLoader) {
            vanLoader.outContentProduct();
        }
    },
    FOURTH_CHOICE{
        @Override
        public void actingUserChoice(VanLoader vanLoader) {
            vanLoader.sortProduct();
        }
    },
    FIFTH_CHOICE{
        @Override
        public void actingUserChoice(VanLoader vanLoader) {
            vanLoader.searchProduct();
        }
    },
    SIXTH_CHOICE{
        @Override
        public void actingUserChoice(VanLoader vanLoader) {
            vanLoader.exitProduct();
        }
    };
}
