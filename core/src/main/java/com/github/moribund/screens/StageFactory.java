package com.github.moribund.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import lombok.val;

import java.util.ArrayList;
import java.util.function.Consumer;

public class StageFactory {
    public Stage createStage(Consumer<ArrayList<Actor>>... createComponents) {
        val stage = new Stage();
        val componentContainer = new ArrayList<Actor>();

        for (Consumer<ArrayList<Actor>> createComponent : createComponents) {
            createComponent.accept(componentContainer);
        }

        val menuTable = createMenuTable(componentContainer);
        stage.addActor(menuTable);
        return stage;
    }

    private Table createMenuTable(ArrayList<Actor> componentContainer) {
        val menuTable = new Table();

        for (Actor actor : componentContainer) {
            menuTable.add(actor);
            menuTable.row();
        }

        menuTable.center();
        menuTable.setFillParent(true);
        return menuTable;
    }
}
