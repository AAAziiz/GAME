    // Ball2.java
    package arwa.gaming.helloworld;

    import net.thevpc.gaming.atom.annotations.AtomSprite;
    import net.thevpc.gaming.atom.annotations.Inject;
    import net.thevpc.gaming.atom.annotations.OnInit;
    import net.thevpc.gaming.atom.engine.SceneEngine;
    import net.thevpc.gaming.atom.engine.maintasks.MoveSpriteMainTask;
    import net.thevpc.gaming.atom.model.Sprite;

    @AtomSprite(
        name = "Ball2",
        kind = "Ball",
        sceneEngine = "hello",
        x = 0, // Initial x position for Ball2
        y = 9, // Initial y position for Ball2
        direction = Math.PI/2, // Opposite direction of Ball1
        speed = 0.4, // Twice as fast as Ball1
         mainTask = MoveSpriteMainTask.class,
        collisionTask = Ball2DefaultSpriteCollisionManager.class
    )
    public class Ball2 {
        @Inject
        Sprite sprite;
        @Inject
        SceneEngine sceneEngine;

        @OnInit
        private void init() {
            sprite.setLocation(0, 9);



        }
    }
