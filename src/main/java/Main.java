public class Main {
    public static void Run(){
        UserInputs inputs = new UserInputs();
        boolean finished = false;
        while (!finished){
            finished = inputs.MenuFunctionality();
        }
    }

    public static void main(String[] args) {
        Run();
    }
}
