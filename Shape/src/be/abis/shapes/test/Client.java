package be.abis.shapes.test;

import be.abis.shapes.exception.AreaTooBigException;
import be.abis.shapes.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Client {

	public static void main(String[] args)  {

		Point p = new Point();
		
		List<Shape> shapeList = new ArrayList<>();
		
		shapeList.add(new Circle(Color.RED,p,2));
		shapeList.add(new Rectangle(Color.BLUE,new Point(),10,2));
		shapeList.add(new Square(Color.YELLOW,new Point(),5.6));
		shapeList.add(new Triangle(Color.ORANGE,new Point(),5,8));
		shapeList.add(new Trapezoid(Color.BLUE,new Point(),5,8, 3));
		shapeList.add(new Circle(Color.BLACK,new Point(),10));
		shapeList.add(new Triangle(Color.YELLOW,new Point(),0.5,0.8));

		System.out.println("\n----------------EXCEPTIONS----------------------");
		for (Shape sh : shapeList){
			System.out.println(sh);
			try {
				System.out.println(sh.checkArea());
			} catch (AreaTooBigException e) {
				System.out.println(e.getMessage());
			}
		}


		System.out.println("\n----------------Comparing areas----------------------");
		Shape shape1 = shapeList.get(0);
		Shape shape2 = shapeList.get(1);
		Shape shape3 = shapeList.get(3);

		System.out.println(shape1.compareArea(shape2));
		System.out.println(shape3.compareArea(shape1));
		System.out.println(shape2.compareArea(shape3));

		System.out.println("\n----------------RESIZING SHAPES----------------------");
		for (Shape s : shapeList){
			s.doubleAreaKeepAspectRatio();
			System.out.println(s);
		}

		System.out.println("\n----------------SORTING SHAPES BY AREA----------------------");
        Collections.sort(shapeList);
		for (Shape s : shapeList){
			System.out.println(s);
		}




	}

}
