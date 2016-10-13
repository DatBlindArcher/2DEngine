package game.engine;

import javafx.scene.shape.Shape3D;

public class Renderer extends Component
{
	private Shape3D shape;
	
	public Renderer(Shape3D mesh)
	{
		shape = mesh;
	}
	
	public void start()
	{
		super.start();
		transform.getChildren().add(shape);
	}
}