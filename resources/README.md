##README

We separated each of the views into their own concrete classes because they each
needed to have different functionality.  The TextAnimationView was the easiest
to implement because we had already implemented it in the ExcellenceAnimationModel.
All we had to do was call toString on the model and it would give us the TextAnimationView.

Next we implemented the SVGAnimationView which required text formatting based on 
the list of shapes and the animations that they contained.  We printed info about the
shape and then for each animation got the parameters and printed them in the svg.
We had to separate the oval and rectangle into separate cases because the formatting
of the svg was different for each one.

Lastly we implemented the VisualAnimationView which also required the creation of the
AnimationPanel to hold the animation.  In AnimationPanel we overrode the paintComponent 
method to loop through the shapes and print the shape at its current state in the animation.
This method will be called whenever the view is refreshed so the shapes will gradually
move along their animation.  Then in the VisualAnimationView class we set the AnimationPanel
on the view and also set up a scroll pane on the view in case the user sets the bounds
of the window to larger bounds than the ones we originally set. 

We did not have to make any changes to the model in order to achieve the functionality in
this assignment. Unfortunately we ran out of time and faced some communication issues
with working remotely rather than together so we were unable to generate the output files. 
However, I am confident that these views are fully functional and will work when the output 
files are generated.