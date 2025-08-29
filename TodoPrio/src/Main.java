public class Main {
    public static void main(String[] args){
        Todo task1 = new Todo("hek","xd");
        task1.updateDescription("fsadsa");
        System.out.println(task1.toString());
        task1.updateDescription("hola");
        System.out.println(task1.toString());
        task1.updateDescription("comoestas");
        task1.doneTask();
        System.out.println(task1.toString());



        Todo task2 = new Todo("uppgift 2", "göra klar denna");
        System.out.println(task2.toString());
        task2.doneTask();
        System.out.println(task2.toString());

        Todo task3 = new Todo("uppgift 45", "göra klar denna", Priority.HIGH);
        System.out.println(task3.toString());


    }
}
