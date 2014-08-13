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
package jetbrains.jetpad.projectional.svg.toAwt;

import jetbrains.jetpad.base.Registration;
import jetbrains.jetpad.mapper.Synchronizer;
import jetbrains.jetpad.mapper.SynchronizerContext;
import jetbrains.jetpad.model.event.EventHandler;
import jetbrains.jetpad.projectional.svg.SvgElement;
import jetbrains.jetpad.projectional.svg.event.SvgAttributeEvent;
import org.apache.batik.dom.AbstractDocument;
import org.apache.batik.dom.svg.SVGOMElement;

public class SvgElementMapper<SourceT extends SvgElement, TargetT extends SVGOMElement> extends SvgNodeMapper<SourceT, TargetT> {
  public SvgElementMapper(SourceT source, TargetT target, AbstractDocument doc) {
    super(source, target, doc);
  }

  @Override
  protected void registerSynchronizers(SynchronizersConfiguration conf) {
    super.registerSynchronizers(conf);

    conf.add(new Synchronizer() {
      private Registration myReg;
      @Override
      public void attach(SynchronizerContext ctx) {
        // FIXME: O(n^2) time
        for (String key : getSource().getAttributesKeys()) {
          getTarget().setAttribute(key, getSource().getAttr(key).get());
        }

        myReg = getSource().attributes().addHandler(new EventHandler<SvgAttributeEvent>() {
          @Override
          public void onEvent(SvgAttributeEvent event) {
            getTarget().setAttribute(event.getAttrName(), event.getNewValue());
          }
        });
      }

      @Override
      public void detach() {
        myReg.remove();
      }
    });
  }
}
