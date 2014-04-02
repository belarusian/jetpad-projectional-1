/*
 * Copyright 2012-2014 JetBrains s.r.o
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.jetpad.projectional.view.spi;

import jetbrains.jetpad.geometry.Rectangle;
import jetbrains.jetpad.model.property.PropertyChangeEvent;
import jetbrains.jetpad.values.Font;
import jetbrains.jetpad.projectional.view.View;
import jetbrains.jetpad.projectional.view.ViewContainer;

public class NullViewContainerPeer implements ViewContainerPeer {
  private ViewContainer myContainer;

  @Override
  public void attach(ViewContainer container) {
    myContainer = container;
  }

  @Override
  public void detach() {
  }

  @Override
  public void repaint(View view) {
  }

  @Override
  public Rectangle visibleRect() {
    myContainer.root().validate();
    return myContainer.root().bounds().get();
  }

  @Override
  public void scrollTo(View view) {
  }

  @Override
  public void boundsChanged(View view, PropertyChangeEvent<Rectangle> change) {
  }

  @Override
  public int textHeight(Font font) {
    return 10;
  }

  @Override
  public int textBaseLine(Font font) {
    return 5;
  }

  @Override
  public int textWidth(Font font, String text) {
    return text.length() * 5;
  }

  @Override
  public void requestFocus() {
  }
}