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
package jetbrains.jetpad.cell.event;

import jetbrains.jetpad.event.*;

public class CellEventSpec<EventT extends Event> {
  public static final CellEventSpec<KeyEvent> KEY_PRESSED = new CellEventSpec<>("keyPressed");
  public static final CellEventSpec<KeyEvent> KEY_RELEASED = new CellEventSpec<>("keyReleased");
  public static final CellEventSpec<KeyEvent> KEY_TYPED = new CellEventSpec<>("keyTyped");

  public static final CellEventSpec<MouseEvent> MOUSE_PRESSED = new CellEventSpec<>("mousePressed");
  public static final CellEventSpec<MouseEvent> MOUSE_RELEASED = new CellEventSpec<>("mouseReleased");
  public static final CellEventSpec<MouseEvent> MOUSE_MOVED = new CellEventSpec<>("mouseReleased");
  public static final CellEventSpec<MouseEvent> MOUSE_DRAGGED = new CellEventSpec<>("mouseReleased");

  public static final CellEventSpec<MouseEvent> MOUSE_ENTERED = new CellEventSpec<>("mouseEntered");
  public static final CellEventSpec<MouseEvent> MOUSE_LEFT = new CellEventSpec<>("mouseLeft");

  public static final CellEventSpec<FocusEvent> FOCUS_GAINED = new CellEventSpec<>("focusGained");
  public static final CellEventSpec<FocusEvent> FOCUS_LOST = new CellEventSpec<>("focusLost");

  public static final CellEventSpec<CopyCutEvent> COPY = new CellEventSpec<>("copy");
  public static final CellEventSpec<CopyCutEvent> CUT = new CellEventSpec<>("cut");
  public static final CellEventSpec<PasteEvent> PASTE = new CellEventSpec<>("cut");

  public static final CellEventSpec<CompletionEvent> COMPLETE = new CellEventSpec<>("complete");

  private String myName;

  private CellEventSpec(String name) {
    myName = name;
  }

  @Override
  public String toString() {
    return myName;
  }
}