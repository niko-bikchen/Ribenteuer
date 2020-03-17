<template>
  <div>
    <p>Hello</p>
    <div id="canvas-container"></div>
  </div>
</template>

<script>
import Konva from 'konva';

export default {
  data() {
    return {};
  },
  mounted() {
    const width = window.innerWidth;
    const height = window.innerHeight;

    const stage = new Konva.Stage({
      container: 'canvas-container',
      width,
      height
    });

    const layer = new Konva.Layer();
    const rectX = stage.width() / 2 - 50;
    const rectY = stage.height() / 2 - 25;

    const box = new Konva.Rect({
      x: rectX,
      y: rectY,
      width: 100,
      height: 50,
      fill: '#00D2FF',
      stroke: 'black',
      strokeWidth: 4,
      draggable: true
    });

    // add cursor styling
    box.on('mouseover', function mouseListener() {
      document.body.style.cursor = 'pointer';
    });
    box.on('mouseout', function mouseListener() {
      document.body.style.cursor = 'default';
    });

    layer.add(box);
    stage.add(layer);
  }
};
</script>
