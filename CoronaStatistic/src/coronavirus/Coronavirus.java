/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronavirus;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Coronavirus extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        BorderPane bp = new BorderPane();
        PieChart pc = new PieChart();
        pc.setTitle("WHO CoronaVirus Statistics 2020 ");
        ObservableList <PieChart.Data> ol = FXCollections.observableArrayList(
        
                new PieChart.Data("USA", 2098106),
                new PieChart.Data("Brazil", 888271),
                new PieChart.Data("Russia", 545458),
                new PieChart.Data("India", 354065),
                new PieChart.Data("United Kingdom", 296861),
                new PieChart.Data("Spain", 244109),
                new PieChart.Data("Italy", 237290),
                new PieChart.Data("Peru", 232992),
                new PieChart.Data("Iran", 192439),
                new PieChart.Data("Germany", 186839),
                new PieChart.Data("Chile", 184449),
                new PieChart.Data("Turkey", 179831)
                
        );

        pc.setData(ol);
        bp.setCenter(pc);
        pc.setLegendSide(Side.LEFT);
        
        FadeTransition f = new FadeTransition(Duration.seconds(4),pc);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
        
        for (PieChart.Data data : pc.getData()){
           
            data.nameProperty().set(data.getName()+ " : "+(int)data.getPieValue()+ " cases");
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    JOptionPane.showMessageDialog(null,"Country --> "+ data.getName()+ "\nTotal Cases -->" +(int)data.getPieValue());
                    
                }
            }
            );
        }
        Scene sc = new Scene(bp,800,500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("WHO CoronaVirus Statistics 2020");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
