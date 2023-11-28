import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageViewer extends Application {

    Image image1;
    Image image2;

    Image image3;

    Image image4;

    Image image5;

    int currentImageNum;

    List<Object> list = new ArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {



        FileInputStream input1 = new FileInputStream("src/godzilla54.jpg");
        image1 = new Image(input1);
        FileInputStream input2 = new FileInputStream("src/godzilla62.jpeg");
        image2 = new Image(input2);
        FileInputStream input3 = new FileInputStream("src/godzilla74.jpeg");
        image3 = new Image(input3);
        FileInputStream input4 = new FileInputStream("src/godzilla84.jpg");
        image4 = new Image(input4);
        FileInputStream input5 = new FileInputStream("src/godzilla00.jpeg");
        image5 = new Image(input5);

        list.add(image1);
        list.add(image2);
        list.add(image3);
        list.add(image4);
        list.add(image5);



        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(300);
        imageView1.setFitWidth(300);
        CheckBox checkBox1 = new CheckBox("Flip Mode");
        imageView1.setRotate(0);
        checkBox1.setOnAction(actionEvent -> {
            if (checkBox1.isSelected()) {
                        imageView1.setRotate(180);
                    }else{
                imageView1.setRotate(0);
                    }
        }
        );


        Button button1 = new Button("Next Godzilla");
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("1954");
        choiceBox.getItems().add("1962");
        choiceBox.getItems().add("1974");
        choiceBox.getItems().add("1984");
        choiceBox.getItems().add("2000");
        Button button2 = new Button("Previous Godzilla");
        choiceBox.setOnAction(actionEvent ->  {
            int selectedChoice = choiceBox.getSelectionModel().getSelectedIndex();
            imageView1.setImage((Image) list.get(selectedChoice));
            currentImageNum = selectedChoice;
        });

        button1.setOnAction(actionEvent ->  {
            if (currentImageNum < 4) {
                currentImageNum = currentImageNum + 1;
            } else {
                currentImageNum = 0;
            }
            choiceBox.getSelectionModel().select(currentImageNum);
            imageView1.setImage((Image) list.get(currentImageNum));
        });
        button2.setOnAction(actionEvent ->  {
            if (currentImageNum < 5) {
                currentImageNum = currentImageNum - 1;
            } if (currentImageNum < 0) {
                currentImageNum = 4;
            }
            choiceBox.getSelectionModel().select(currentImageNum);
            imageView1.setImage((Image) list.get(currentImageNum));
        });











        HBox hBox1 = new HBox(button1,button2, choiceBox);
        VBox vbox1 = new VBox(imageView1, hBox1, checkBox1);
        Scene scene = new Scene(vbox1, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

