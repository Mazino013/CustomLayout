
<div style="text-align: center;">
  <h1 style="font-size: 36px; margin-bottom: 20px;">Circular Custom Layout</h1>
  
  <div style="display: flex; justify-content: center; gap: 20px;">
    <img src="https://github.com/user-attachments/assets/c8f99f05-425d-467a-9450-c2a2004efc0a" style="width: 30%; max-width: 300px;">
  </div>
</div>

## Features
- **Custom Layout Basics:**: We use the Layout composable to create a custom layout. This composable allows us to control how child elements are measured and positioned.
- **Custom Layout**: The CircularLayout composable uses the Layout composable to create a custom layout. It measures each child and then positions them in a circle.
- **DrawScope**: We use the drawBehind modifier on the outer Box to draw a background circle. This demonstrates how to use DrawScope for custom drawing.
- **Circular Positioning**: Inside the Layout composable, we calculate the position for each child using trigonometry to place them evenly around the circle.



