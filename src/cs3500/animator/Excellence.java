package cs3500.animator;

public class Excellence {

  public static void main (String[] args) {
    boolean inProvided = false;
    boolean viewProvided = false;
    int speed = 1;
    String inputFile;
    String outputFile = "System.out";
    String view;
    for(int i = 0; i < args.length; i+=2) {
      switch(args[i]) {
        case "-in":
          inProvided = true;
          inputFile = args[i+1];
          break;
        case "-out":
          outputFile = args[i+1];
          break;
        case "-speed":
          try{
            speed = Integer.parseInt(args[i+1]);
          } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input for speed");
          }
          break;
        case "-view":
          viewProvided = true;
          view = args[i+1];
          break;
        default:
          throw new IllegalArgumentException("Invalid input parameter");
      }
    }
    if(!inProvided || !viewProvided) {
      throw new IllegalArgumentException("Have to provide the command line arguments dummy");
    }
  }
}
