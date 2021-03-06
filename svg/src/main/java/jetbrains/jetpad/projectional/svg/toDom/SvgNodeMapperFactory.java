/*
 * Copyright 2012-2016 JetBrains s.r.o
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
package jetbrains.jetpad.projectional.svg.toDom;

import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.projectional.svg.*;
import org.vectomatic.dom.svg.*;

class SvgNodeMapperFactory implements MapperFactory<SvgNode, OMNode> {
  private SvgGwtPeer myPeer;

  public SvgNodeMapperFactory(SvgGwtPeer peer) {
    myPeer = peer;
  }

  @Override
  public Mapper<? extends SvgNode, ? extends OMNode> createMapper(SvgNode source) {
    Mapper<? extends SvgNode, ? extends OMNode> result;
    if (source instanceof SvgEllipseElement) {
      result = new SvgElementMapper<>((SvgEllipseElement) source, new OMSVGEllipseElement(), myPeer);
    } else if (source instanceof SvgCircleElement) {
      result = new SvgElementMapper<>((SvgCircleElement) source, new OMSVGCircleElement(), myPeer);
    } else if (source instanceof SvgRectElement) {
      result = new SvgElementMapper<>((SvgRectElement) source, new OMSVGRectElement(), myPeer);
    } else if (source instanceof SvgTextElement) {
      result = new SvgElementMapper<>((SvgTextElement) source, new OMSVGTextElement(), myPeer);
    } else if (source instanceof SvgPathElement) {
      result = new SvgElementMapper<>((SvgPathElement) source, new OMSVGPathElement(), myPeer);
    } else if (source instanceof SvgLineElement) {
      result = new SvgElementMapper<>((SvgLineElement) source, new OMSVGLineElement(), myPeer);
    } else if (source instanceof SvgSvgElement) {
      result = new SvgElementMapper<>((SvgSvgElement) source, new OMSVGSVGElement(), myPeer);
    } else if (source instanceof SvgGElement) {
      result = new SvgElementMapper<>((SvgGElement) source, new OMSVGGElement(), myPeer);
    } else if (source instanceof SvgStyleElement) {
      result = new SvgElementMapper<>((SvgStyleElement) source, new OMSVGStyleElement(), myPeer);
    } else if (source instanceof SvgTextNode) {
      result = new SvgTextNodeMapper((SvgTextNode) source, new OMText(null), myPeer);
    } else if (source instanceof SvgTSpanElement) {
      result = new SvgElementMapper<>((SvgTSpanElement) source, new OMSVGTSpanElement(), myPeer);
    } else if (source instanceof SvgDefsElement) {
      result = new SvgElementMapper<>((SvgDefsElement) source, new OMSVGDefsElement(), myPeer);
    } else if (source instanceof SvgClipPathElement) {
      result = new SvgElementMapper<>((SvgClipPathElement) source, new OMSVGClipPathElement(), myPeer);
    } else {
      throw new IllegalStateException("Unsupported SvgNode");
    }
    return result;
  }
}