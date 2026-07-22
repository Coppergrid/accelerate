package coppergrid.accelerate.datagen;


public class DataGen {
    public static void register() {
        GenLang.register();
        GenRecipes.register();
        GenTrackTags.register();
    }
}