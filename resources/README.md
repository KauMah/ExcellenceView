##README

For this assignment we had trouble getting all of the features to work due to a few key implementation 
details.  In the view we were given the Keystroke class which only took a single tick into the constructor 
and then later on the methods getColor, getPosition, and getDimensions were called on
the Keyframe class.  The reason we struggled ith this implementation was we could not figure out the
best way to get these values without knowing anything but the tick of the keystroke in the constructor.
We considered exposing the ShapeAnimationModel to the Keyframe class even though this would be
bad practice however without knowing the objectID or any other information about the shape we
still would not be able to determine the color, position, and dimensions in the keystroke class.
This made it impossible to implement without adding another constructor to the Keystroke class
that took in at least an objectId, or at best a color, position, and dimension for the keyfraame.

Another aspect that we struggled with was we are both in New York and lost power and wifi for almost
2 days due to the storm.

We were able to implement the views with our controller so the project could compile but failed
to generate the interactive view as was required.  What hindered us from doing this was that 
we did not have good abstraction to handle the timing of the animation originally.  This made it
difficult to implement the timer with another view as we could not reuse any of the code for our timer. 

We were able to add methods to our model interfaces and implement them so that the views were
compatible with our models.  This required reading through the new views and changed the signatures
of some methods on our models and adding new ones so the required fnctionality was implemented.  
For the ost part we had already implemented all of the necessary logic and just had to change the names of the
methods but in other cases we had to implement them. 

I believe if we were to implement this succesfully we would've had to make more drastic changes to the model
so that we could initialize a keystroke using just the tick and be able to get the color, positon, and dimensions.
What prevented us from doing this was the issue of what if 2 keystrokes for different shapes have the same tick, how would they be differentiatied.
Perhaps we could have made a map of the shapes and their corresponding keystrokes but this still doesn't
solve the problem of getting the color, dimension, and position in the keystroke class without knowing
the shapeId at least. 
