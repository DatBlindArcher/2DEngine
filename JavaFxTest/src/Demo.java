import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;
 
public class Demo extends Application 
{
    public Parent createContent()
    {
        // Box
        Box box1 = new Box(1, 1, 1);
        Box box2 = new Box(1, 1, 1);
        Box box3 = new Box(1, 1, 1);
        box1.setMaterial(new PhongMaterial(Color.RED));
        box1.setDrawMode(DrawMode.FILL);
        box1.getTransforms().addAll(new Rotate(45, Rotate.Y_AXIS));
        box2.setMaterial(new PhongMaterial(Color.RED));
        box2.setDrawMode(DrawMode.FILL);
        box2.getTransforms().addAll(new Translate(1.5, 0, 0), new Rotate(45, Rotate.Y_AXIS), new Scale(1, 0.33, 1));
        box3.setMaterial(new PhongMaterial(Color.RED));
        box3.setDrawMode(DrawMode.FILL);
        box3.getTransforms().addAll(new Translate(-1.5, 0, 0), new Rotate(45, Rotate.Y_AXIS), new Scale(1, 0.66, 1));
        
        // Create and position camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-25, Rotate.X_AXIS),
                new Translate(0, 0, -15));
        
        // Light
        PointLight light = new PointLight();
        light.setColor(Color.WHITE);
        light.getTransforms().add(new Translate(-16, -4, -16));
        AmbientLight ambientLight = new AmbientLight(Color.color(0.6, 0.6, 0.6));
        
        // Build the Scene Graph
        Group root = new Group();
        root.getChildren().add(camera);
        root.getChildren().add(box1);
        root.getChildren().add(box2);
        root.getChildren().add(box3);
        root.getChildren().add(light);
        root.getChildren().add(ambientLight);
        
        // Use a SubScene       
        SubScene subScene = new SubScene(root, 1000, 800);
        subScene.setFill(Color.ALICEBLUE);
        subScene.setCamera(camera);
        Group group = new Group();
        group.getChildren().add(subScene);
        return group;
    }

    public void start(Stage primaryStage)
    {
        primaryStage.setResizable(true);
        primaryStage.setTitle("Demo");
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}