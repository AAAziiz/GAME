package arwa.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.AtomScene;
import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
import net.thevpc.gaming.atom.annotations.Inject;
import net.thevpc.gaming.atom.annotations.OnSceneStarted;
import net.thevpc.gaming.atom.debug.AdjustViewController;
import net.thevpc.gaming.atom.engine.SpriteFilter;
import net.thevpc.gaming.atom.model.Point;
import net.thevpc.gaming.atom.presentation.*;
import net.thevpc.gaming.atom.presentation.components.SLabel;
import net.thevpc.gaming.atom.presentation.layers.Layers;
import java.awt.*;
import java.awt.event.MouseAdapter;
import net.thevpc.gaming.atom.engine.maintasks.MoveToPointSpriteMainTask;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.model.ModelPoint;
import net.thevpc.gaming.atom.presentation.Scene;
import net.thevpc.gaming.atom.model.Sprite;
import java.awt.event.MouseEvent;



/**
 * Created by vpc on 9/23/16.
 */
@AtomScene(
        id = "hello",
        title = "Hello World",
        tileWidth = 50,
        tileHeight = 50
        
)
@AtomSceneEngine(
        id="hello",
        columns = 10,
        rows = 10,
        fps = 25
)
public class HelloWorldScene {

    @Inject
    private Scene scene;
    @Inject
    private SceneEngine sceneEngine;

    @OnSceneStarted
    private void init() {
        
        
        
        
    
        
        
        
     SLabel livesLabel = new SLabel("Vies : 3");
     livesLabel.setLocation(Point.ratio(0.05f, 0.05f)); // Position du label
     scene.addComponent(livesLabel);
    
            
       Color customColor = Color.PINK; // Remplacez Color.RED par la couleur de votre choix
       scene.addLayer(Layers.fillBoard(customColor));
      
        
        
        
        

        scene.addLayer(Layers.debug());
        scene.addLayer(Layers.fillScreen(Color.red));
        scene.addController(new SpriteController(SpriteFilter.byName("Ball1")).setArrowKeysLayout());
        
        scene.addController(new SpriteController(SpriteFilter.byName("Ball2")).setESDFLayout());

        
         MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MoveToPointSpriteMainTask moveToPointSpriteMainTask = new MoveToPointSpriteMainTask(new ModelPoint(e.getX(), e.getY()), 0., true);
                moveToPointSpriteMainTask.nextFrame(sceneEngine, sceneEngine.getSprites().get(0));
            }
        };

        scene.toComponent().addMouseListener(adapter);
        
        
          






        scene.addController(new AdjustViewController());
        scene.addComponent(
                new SLabel("Click CTRL-D to switch debug mode, use Arrows to move the ball")
                .setLocation(Point.ratio(0.5f,0.5f))
        );
        scene.setSpriteView(SpriteFilter.byKind("Ball"), new ImageSpriteView("/ball.png", 8, 4));
        
        
        scene.setSpriteView(SpriteFilter.byKind("Ball2"), new ImageSpriteView("/ball.png", 16, 8)); 
        
        
      scene.setSpriteView(SpriteFilter.byKind("Ball2"), new DefaultSpriteView() {
    @Override
    public void draw(SpriteDrawingContext context) {
        Graphics2D g2d = context.getGraphics();
        Shape spriteShape = context.getSpriteShape();
        if (spriteShape instanceof Rectangle) {
            Rectangle rect = (Rectangle) spriteShape;
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
});
      
      
     
    }
}
   