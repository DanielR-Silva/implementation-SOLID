public class Utils {
    public static void delay(int delayValue) {
        try{
            Thread.sleep(delayValue);
        }catch (Exception e){
            System.out.printf("Erro: %s\n", e.getMessage());
        }
    }
}
