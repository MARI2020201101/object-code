package chB;

import java.awt.*;

interface Displayable extends GameObject{
    Point getPosition();
    void update(Graphics graphics);
}
