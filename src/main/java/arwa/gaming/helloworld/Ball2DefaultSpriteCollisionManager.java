/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arwa.gaming.helloworld;

import net.thevpc.gaming.atom.engine.collisiontasks.BorderCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollisionTask;
import net.thevpc.gaming.atom.model.DirectionTransform;

/**
 *
 * @author aziz
 */
public class Ball2DefaultSpriteCollisionManager implements SpriteCollisionTask {


    public void collideWithBorder(BorderCollision borderCollision) {
        borderCollision.adjustSpritePosition();
        borderCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }

    @Override
    public void collideWithSprite(SpriteCollision spriteCollision) {
        spriteCollision.adjustSpritePosition();
        spriteCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }

    
}
