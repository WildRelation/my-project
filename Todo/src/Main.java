public class Main {
    public static void main(String[] args) {
        Todo uppgift1 = new Todo("Kasta sopporna", "Kasta soppor innan kl.17\n");
        uppgift1.updateDescription("Yokese");
/*        uppgift1.updateDescription("Ej utförd än");*/

        System.out.println(uppgift1.getDescription());

        System.out.println(uppgift1.toString());
        uppgift1.taskDone();

    }
}