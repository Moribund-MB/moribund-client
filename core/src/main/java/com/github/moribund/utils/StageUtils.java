package com.github.moribund.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.function.Consumer;

@UtilityClass
public class StageUtils {
    public Stage createStage(Consumer<ObjectList<Actor>>... createComponents) {
        val stage = new Stage();
        val componentContainer = new ObjectArrayList<Actor>();

        for (Consumer<ObjectList<Actor>> createComponent : createComponents) {
            createComponent.accept(componentContainer);
        }

        val menuTable = createMenuTable(componentContainer);
        stage.addActor(menuTable);
        return stage;
    }

    private Table createMenuTable(ObjectList<Actor> componentContainer) {
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
