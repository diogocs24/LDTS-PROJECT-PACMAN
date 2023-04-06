package com.aor.pman.model.wall;

import com.aor.pman.model.game.Element;


public class Wall extends Element {

    public Wall(int x, int y){
        super(x, y);
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;
        return(this == o || this.getPosition().equals(((Wall) o).getPosition()));
    }

}
