package game.engine;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

public class Transform extends Group
{
	Vector3 position;
	Vector3 rotation;
	Vector3 scale;
    private Rotate rx;
    private Rotate ry;
    private Rotate rz;
    private Scale s;
	
	public Transform()
	{
		super();
		position = Vector3.zero();
		rotation = Vector3.zero();
		scale = Vector3.one();
		rx = new Rotate(0,Rotate.X_AXIS);
	    ry = new Rotate(0,Rotate.Y_AXIS);
	    rz = new Rotate(0,Rotate.Z_AXIS);
	    s = new Scale();
        getTransforms().addAll(rx, ry, rz, s);
	}
	
	public void setPosition(Vector3 vector)
	{
		position = vector;
		setTranslateX(position.x);
		setTranslateY(position.y);
		setTranslateZ(position.z);
	}
	
	public void setRotation(Vector3 vector)
	{
		rotation = vector;
		rx.setAngle(vector.x);
		ry.setAngle(vector.y);
		rz.setAngle(vector.z);
	}
	
	public void setScale(Vector3 vector)
	{
		scale = vector;
		s.setX(vector.x);
		s.setY(vector.y);
		s.setZ(vector.z);
	}
	
	public void translate(Vector3 vector)
	{
		position.add(vector);
		setPosition(position);
	}
	
	public void rotate(Vector3 vector)
	{
		rotation.add(vector);
		setRotation(rotation);
	}
	
	public void scale(Vector3 vector)
	{
		scale.multiply(vector);
		setScale(scale);
	}
	
	public Vector3 getPosition()
	{
		return position;
	}
	
	public Vector3 getRotation()
	{
		return rotation;
	}
	
	public Vector3 getScale()
	{
		return scale;
	}
	
	public void setParent(Transform parent, boolean keepWorldPosition)
	{
		parent.getChildren().add(this);
		
		if(keepWorldPosition)
		{
			position.sub(parent.getPosition());
			setPosition(position);
		}
	}
}