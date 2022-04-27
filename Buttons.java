package com.example.dz_from_lection;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Buttons extends Button {
    public Buttons (double x, double y, String name){
        setPrefSize(x,y);
        setText(name);
        BindMouseEventHandler();
        ButtonCords[0]=0;
        ButtonCords[1]=0;


    }
    public void SetNewX(double x){
        ButtonCords[0]=x;
        setLayoutX(x);
    }

    public void SetNewY(double y){
        ButtonCords[1]=y;
        setLayoutY(y);
    }
    public double checksquare(){
        double x1=ButtonCords[0];
        double y1=ButtonCords[1];
        double x2=ButtonCords[0]+getWidth();
        double y2=ButtonCords[1]+getHeight();
        double x3=brother.ButtonCords[0];
        double y3=brother.ButtonCords[1];
        double x4=brother.ButtonCords[0]+brother.getWidth();
        double y4=brother.ButtonCords[1]+brother.getHeight();
        double left = Math.max(x1,x3);
        double top = Math.min(y2,y4);
        double right = Math.min(x2,x4);
        double bottom = Math.max(y1,y3);
        double widht = right-left;
        double height = top-bottom;
        if(widht<0 || height<0){
            return 0;
        }
        System.out.println(x1+" "+y1+" "+x2+" "+y2);


        return widht*height;
    }
    public void setBrother(Buttons button2){
        this.brother=button2;
    }

    public void BindMouseEventHandler (){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MouseCords1[0] = mouseEvent.getX();
                MouseCords1[1] = mouseEvent.getY();


            }

        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setLayoutX(mouseEvent.getSceneX()-MouseCords1[0]);
                setLayoutY(mouseEvent.getSceneY()-MouseCords1[1]);
                ButtonCords[0] = mouseEvent.getSceneX()-MouseCords1[0];
                ButtonCords[1] = mouseEvent.getSceneY()-MouseCords1[1];
                //System.out.println(checksquare());
                text.setText(String.valueOf(checksquare()));
                //System.out.println("dada");
                System.out.println(ButtonCords[0]+"  "+ButtonCords[1]);


            }
        });


    }
    double[] MouseCords1 = new double[2];
    double[] ButtonCords = new double[2];
    Buttons brother;
    Text text;
    public void SetField(Text text){
        this.text=text;
    }



}
