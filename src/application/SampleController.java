package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SampleController implements Initializable{
	
	@FXML
	private AnchorPane pane1,pane2,pane3,pane4,opacityPane,drawPane;
	
	@FXML
	private ImageView drawimage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		opacityPane.setVisible(false);
		
		FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),opacityPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		
		TranslateTransition transition=new TranslateTransition(Duration.seconds(0.5),drawPane);
		transition.setByX(-600);
		transition.play();
		
		pane1.setStyle("-fx-background-image:url(\"/Images/1.jpg\")");
		pane2.setStyle("-fx-background-image:url(\"/Images/2.jpg\")");
		pane3.setStyle("-fx-background-image:url(\"/Images/3.jpg\")");
		pane4.setStyle("-fx-background-image:url(\"/Images/4.jpg\")");
		
		animation();
		
		drawimage.setOnMouseClicked(e->{
			opacityPane.setVisible(true);
			
			FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),opacityPane);
			fadeTransition1.setFromValue(0);
			fadeTransition1.setToValue(0.15);
			fadeTransition1.play();
			
			TranslateTransition transition1=new TranslateTransition(Duration.seconds(0.5),drawPane);
			transition1.setByX(600);
			transition1.play();
		});
		
		opacityPane.setOnMouseClicked(e->{
			
			
			FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),opacityPane);
			fadeTransition1.setFromValue(0.15);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();
			
			fadeTransition1.setOnFinished(ev->{
				opacityPane.setVisible(false);
			});
			
			TranslateTransition transition1=new TranslateTransition(Duration.seconds(0.5),drawPane);
			transition1.setByX(-600);
			transition1.play();
		});
		
	}
	
	public void animation() {
		
		FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),pane4);
	    fadeTransition.setFromValue(1);
	    fadeTransition.setToValue(0);
	    fadeTransition.play();
	    
	    fadeTransition.setOnFinished(event1->{
	    	FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(3),pane3);
		    fadeTransition1.setFromValue(1);
		    fadeTransition1.setToValue(0);
		    fadeTransition1.play();
		    
		    fadeTransition1.setOnFinished(event2->{
		    	FadeTransition fadeTransition00=new FadeTransition(Duration.seconds(3),pane2);
			    fadeTransition00.setFromValue(1);
			    fadeTransition00.setToValue(0);
			    fadeTransition00.play();
			    
			    fadeTransition00.setOnFinished(event3->{
			    	FadeTransition fadeTransition11=new FadeTransition(Duration.seconds(3),pane2);
				    fadeTransition11.setFromValue(0);
				    fadeTransition11.setToValue(1);
				    fadeTransition11.play();
				    
				    fadeTransition11.setOnFinished(even4->{
				    	FadeTransition fadeTransition22=new FadeTransition(Duration.seconds(3),pane3);
					    fadeTransition22.setFromValue(0);
					    fadeTransition22.setToValue(1);
					    fadeTransition22.play();
					    
					    fadeTransition22.setOnFinished(event5->{
					    	FadeTransition fadeTransition33=new FadeTransition(Duration.seconds(3),pane4);
						    fadeTransition33.setFromValue(0);
						    fadeTransition33.setToValue(1);
						    fadeTransition33.play();
						    
						    fadeTransition33.setOnFinished(event6->{
						    	animation();
						    });
					    });
				    });
			    });
		    });
	    });
		
	}
	
}
