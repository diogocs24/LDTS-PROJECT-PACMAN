package com.aor.pman.viewer.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.item.Coin;

public class CoinViewer implements ElementViewer<Coin>{

    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition(), "#FFFFFF");
    }
}