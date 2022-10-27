/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package media;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/*
 * 30 Seconds of Java code library
 *
 */

public class PlayVideoSnippet extends Application {
  private Media media = null;
  private MediaPlayer mediaPlayer = null;
  private MediaView mediaView = null;
  private Scene scene = null;

  public static void main(String[] args) {
    Application.launch(PlayVideoSnippet.class, args);
  }

  @Override
  public void start(Stage stage) throws InterruptedException {
    //args will contain the media url to play. We can add File selector to show popup
    media = new Media(new File(getParameters().getRaw().get(0)).toURI().toString());
    media.setOnError(() -> Platform.exit());
    mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(true);
    mediaPlayer.setOnEndOfMedia(() -> Platform.exit());
    mediaView = new MediaView(mediaPlayer);
    scene = new Scene(new Group(), media.getWidth(), media.getHeight());
    stage.setScene(scene);
    stage.setTitle("Video Player");
    ((Group) scene.getRoot()).getChildren().add(mediaView);
    stage.show();
  }
}