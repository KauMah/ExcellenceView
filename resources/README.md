##README

In order to implement the add keystroke and delete keystroke functionality we added methods
to the ShapeanimationModel class after first adding the methods to its interface.  The add keystroke
method puts the keystroke at time 0, if necessary, and shifts the others.  If the keystroke added is last it simply 
adds it to the end.  If it is in the middle it edits the animations before and after so the 
animation will run properly with the inserted keystroke.