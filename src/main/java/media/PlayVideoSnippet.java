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

/**
 * PlayVideoSnippet.
 *
 */

public class PlayVideoSnippet extends Application {

  /**
   * Main method that launch the video player.
   *
   * @param args : should contain one arg, referring to path of video file to play.
   */
  public static void main(String[] args) {
    Application.launch(PlayVideoSnippet.class, args);
  }

  /**
   * Plays video.
   *
   * @param stage the primary stage for this application,
   *              onto which the application scene can be set.
   *              Applications may create other stages, if needed,
   *              but they will not be primary stages.
   */

  @Override
  public void start(Stage stage) {
    var media = new Media(new File(getParameters().getRaw().get(0)).toURI().toString());
    var mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(true);
    var mediaView = new MediaView(mediaPlayer);
    var scene = new Scene(new Group(), media.getWidth(), media.getHeight());
    stage.setScene(scene);
    ((Group) scene.getRoot()).getChildren().add(mediaView);
    stage.show();
  }
}